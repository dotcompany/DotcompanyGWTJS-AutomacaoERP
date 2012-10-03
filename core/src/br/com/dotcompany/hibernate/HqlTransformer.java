package br.com.dotcompany.hibernate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.transform.ResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.dotcompany.exception.DaoException;
import br.com.dotcompany.to.TransferObject;
import br.com.dotcompany.util.ReflectionUtil;
import br.com.dotcompany.util.UtilObjeto;

/**
 * <b>Projeto:</b> core <br>
 * <b>Pacote:</b> br.com.dotcompany.hibernate <br>
 * <b>Título:</b> BeanTransformer.java <br>
 * <b>Descrição:</b> <br>
 * 
 * <b>Autor:</b> danylomacelai <b>Email:</b> danylomacelai@gmail.com
 * <b>Criação:</b> 30/04/2011, 16:01:49
 */
@SuppressWarnings("serial")
public class HqlTransformer implements ResultTransformer {

	protected static Logger logger = LoggerFactory
			.getLogger(HqlTransformer.class);

	private String hql;
	private String[] arrayAlias;
	private Object[] arrayValue;
	private String separator;
	private String forClazz;

	private final Class<?> clazz;
	// Indica se o resultado devera ter somente elementos distintos.
	private boolean distinct;
	// Armazena todas as instancias dos beans que são distintas.
	private Map<Object, Object> mapTupleBean = new HashMap<Object, Object>();
	// Armazena toda as propriedades que fazem join com resultClass para a
	// execução de
	// cada linha do consulta "tuple" que será convertida no transformTuple
	private static Map<String, Object> mapInnerBean = new HashMap<String, Object>();
	// Usar os métodos que são acessores GET e SET das propriedades do bean.
	private static boolean acessores;

	public HqlTransformer(Class<?> clazz) {
		this(clazz, false, true);
	}

	public HqlTransformer(String hql) {
		this(hql, null);
	}

	public HqlTransformer(String hql, String forClazz) {
		this(clazzForHql(hql), hql.toLowerCase().contains("distinct"), true);
		this.forClazz = forClazz;
		this.hql = hql;
		this.arrayAlias = mountPathProjection();
		this.separator = ".";
	}

	@SuppressWarnings("static-access")
	public HqlTransformer(Class<?> clazz, boolean distinct, boolean acessores) {
		super();
		this.distinct = distinct;
		this.clazz = clazz;
		this.acessores = acessores;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List transformList(List collection) {
		if (distinct) {
			int size = collection.size();
			if (size > 1) {
				collection = new ArrayList(new HashSet(collection));
			}
		}
		return collection;
	}

	@Override
	public Object transformTuple(Object[] values, String[] aliases) {
		Object bean = null;
		try {
			this.arrayValue = values;
			if (this.arrayAlias == null) {
				this.arrayAlias = aliases;
				this.separator = "_";
			}
			bean = this.newInstanceBean(values, this.arrayAlias);
			mapInnerBean.clear();
			for (int i = 0; i < values.length; i++) {
				if (null == values[i]) {
					continue;
				}
				String alias = this.arrayAlias[i];
				String[] aliasArray = alias.split("\\" + this.separator);
				if (alias != null) {
					processResult(bean, aliasArray, values[i]);
				}
			}
		} catch (Exception e) {
			logger.error("Não foi possível converter a tuple ", e);
		}
		return bean;
	}

	private void processResult(Object bean, String[] aliasArray, Object value) {
		try {
			int layerLength = aliasArray.length;
			if (1 == layerLength) {
				setValueTarget(bean, aliasArray[0], value);
			} else {
				Object innerBean = currentInstanceInnerBean(bean, aliasArray[0]);
				processResult(innerBean,
						(String[]) ArrayUtils.remove(aliasArray, 0), value);
			}
		} catch (Exception e) {
			logger.error("Erro ao tentar processar o resultado ", e);
		}
	}

	private Object currentInstanceInnerBean(Object bean, String fieldName) {
		Object innerBean = mapInnerBean.get(fieldName);
		if (null == innerBean) {
			innerBean = newIntanceInnerBean(bean, fieldName);
		}
		return innerBean;
	}

	@SuppressWarnings("unchecked")
	public Object newIntanceInnerBean(Object bean, String fieldName) {
		Object innerBean = null;
		try {
			Field field = ReflectionUtil.getDeclaredField(bean, fieldName);
			ReflectionUtil.makeAccessible(field);
			innerBean = field.get(bean);
			if (innerBean == null) {
				// Cria um instância do inner bean.
				if (field.getType() == Set.class) {
					innerBean = new HashSet();
				} else if (field.getType() == List.class) {
					innerBean = new ArrayList();
				} else {
					innerBean = field.getType().newInstance();
				}
				// Seta a instância do inner no bean.
				if (innerBean instanceof Collection) {

					ReflectionUtil.setValorAtributo((TransferObject) bean,
							fieldName, innerBean);

					// seta a coleção antes no bean sem usar os metodos
					// acessores do bean!
					/*
					 * ReflectionUtil.setNestedValueDefault(bean, fieldName,
					 * innerBean, separator);
					 */
					// Cria um item pra coleção que será um DTO
					innerBean = newItemCollection(bean, field);
				} else {
					// seta no bean objeto que faz join.
					setValueTarget(bean, fieldName, innerBean);
				}
			} else {
				if (innerBean instanceof Collection) {
					// Cria um item pra coleção.
					innerBean = newItemCollection(bean, field);
				}
			}
			// Armazena a instância do innerBean
			mapInnerBean.put(fieldName, innerBean);

		} catch (Exception e) {
		}
		return innerBean;
	}

	private Object newInstanceBean(Object[] tuple, String[] aliases)
			throws Exception {
		if (!distinct) {
			return this.targetClazz().newInstance();
		}
		Object ID = serialID(tuple, aliases);
		Object objeto = this.mapTupleBean.get(ID);
		if (objeto == null) {
			objeto = targetClazz().newInstance();
			this.mapTupleBean.put(ID, objeto);
		}
		return objeto;
	}

	public Class<?> targetClazz() throws Exception {
		if (StringUtils.isNotEmpty(forClazz)) {
			return ReflectionUtil.getClazzAttribute(clazz, forClazz);
		}
		return clazz;
	}

	private Object serialID(Object[] tuple, String[] aliases) {
		for (int i = 0; i < aliases.length; i++) {
			String[] aliasArray = aliases[i].split("_");
			if (1 == aliasArray.length
					&& "id".equals(aliasArray[0].toLowerCase())) {
				return tuple[i];
			}
		}
		return tuple[0];
	}

	private static void setValueTarget(Object target, String propertyName,
			Object value) throws Exception {
		if (acessores) {
			ReflectionUtil.invokeSetterMethod(target, propertyName, value);
		} else {
			ReflectionUtil.setNestedValueDefault(target, propertyName, value,
					".");
		}
	}

	@SuppressWarnings("unchecked")
	private static Object newItemCollection(Object bean, Field field)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException {
		// cria um object do tipo que a colecao eh.
		Class<?> innerBeanClass = ((Class) ((ParameterizedType) field
				.getGenericType()).getActualTypeArguments()[0]);
		Object target = innerBeanClass.newInstance();
		// salva este objeto dentro da coleção
		((Collection) PropertyUtils
				.getPropertyDescriptor(bean, field.getName()).getReadMethod()
				.invoke(bean, (Object[]) null)).add(target);
		return target;
	}

	private String[] mountPathProjection() {
		String aliasClazz = aliasForClazz(hql);
		String[] projecoes = projecoes();
		String pathTmp = "";
		Map<String, String> mapJoins = mapJoins();
		for (int i = 0; i < projecoes.length; i++) {
			pathTmp = propertyPath(projecoes[i], aliasClazz, mapJoins);
			if (UtilObjeto.isNotEmpty(forClazz)) {
				int pos = position(pathTmp, forClazz + ".", true);
				pathTmp = pathTmp.substring(pos);
			}
			projecoes[i] = pathTmp;
		}
		return projecoes;
	}

	private String[] projecoes() {
		int start = 0;
		if (UtilObjeto.isTrue(distinct)) {
			start = position(hql, "distinct", true);
		} else {
			start = position(hql, "select", true);
		}
		int stop = position(hql, "from", false);
		String intervalo = hql.substring(start, stop).trim();
		return intervalo.replace(" ", "").replace("\t", "").split(",");
	}

	private Map<String, String> mapJoins() {
		Map<String, String> mapJoins = new HashMap<String, String>();
		String[] joinClazz = joinCalzz(hql);
		for (String jc : joinClazz) {
			String[] aux = jc.split("\\s");
			mapJoins.put(aux[aux.length - 1], aux[0]);
		}
		return mapJoins;
	}

	private static String[] joinCalzz(String hql) {
		int start = position(hql, "join", true);
		if (start == -1) {
			return new String[] {};
		}
		int stop = position(hql, "where", false);
		if (stop == -1) {
			stop = position(hql, "order", false);
			if (stop == -1) {
				stop = hql.length();
			}
		}
		String joinProjection = hql.substring(start, stop).trim();
		joinProjection = replaceAllCase(joinProjection, 0, new String[] {
				"inner", "left", "join" }, new String[] { "", "", ";" });
		return joinProjection.split("\\;");
	}

	private String propertyPath(String projection, String aliasBean,
			Map<String, String> mapJoins) {
		String[] path = projection.split("\\.");
		if (path.length > 1 && mapJoins.containsKey(path[0])) {
			String more = "";
			more += mapJoins.get(path[0]);
			more += ".";
			more += projection.replace(path[0] + ".", "");
			return propertyPath(more, aliasBean, mapJoins);
		}
		if (projection.contains(aliasBean)) {
			return projection.replace(aliasBean + ".", "");
		}
		return projection;
	}

	public static String replaceAllCase(String txt, int start, String[] value,
			String[] newValue) {
		int pos = position(txt, value[start], false);
		if (pos != -1) {
			StringBuilder sb = new StringBuilder();
			sb.append(txt.substring(0, pos).trim())
					.append(newValue[start])
					.append(txt.substring(pos + value[start].length(),
							txt.length()).trim());
			return replaceAllCase(sb.toString(), start, value, newValue);
		}
		if (start != value.length - 1) {
			return replaceAllCase(txt, start + 1, value, newValue);
		}
		return txt;
	}

	public static int position(String hql, String regex, boolean isMore) {
		int more = (isMore ? regex.length() : 0);
		int pos = hql.toLowerCase().indexOf(regex.toLowerCase());
		return pos == -1 ? (-1) : (pos + more);
	}

	public static Class<?> clazzForHql(String hql) {
		try {
			int index = hql.toLowerCase().lastIndexOf("from");
			String clazz = hql.substring(index + 4).trim();
			clazz = (clazz.split("\\s")[0]).trim();
			return Class.forName(clazz);
		} catch (Exception e) {
			throw new DaoException("Não foi possível extrair a classe do hql: "
					+ hql + " (" + e.getClass().getSimpleName() + ": "
					+ e.getMessage() + ")", e);
		}
	}

	public static String aliasForClazz(String hql) {
		int start = position(hql, clazzForHql(hql).getName(), true);
		return ((hql.substring(start)).trim().split("\\s"))[0];
	}

	public static String aliasForJoin(String hql, String propertyPath) {
		String[] joinClazz = joinCalzz(hql);
		String property[] = propertyPath.split("\\.");
		String realPath = "";
		for (int p = property.length - 2; p >= 0; p--) {
			String path = property[p];
			for (String jc : joinClazz) {
				String[] join = jc.split("\\s");
				if (join[0].contains(path)) {
					return join[join.length - 1]
							+ (UtilObjeto.isNotEmpty(realPath) ? ("." + realPath
									.substring(0, realPath.length() - 1)) : "");
				}
			}
			realPath = path + "." + realPath;
		}
		return aliasForClazz(hql) + "."
				+ realPath.substring(0, realPath.length() - 1);
	}

	public String getForClazz() {
		return forClazz;
	}

	public Object[] getArrayValue() {
		return arrayValue;
	}
}