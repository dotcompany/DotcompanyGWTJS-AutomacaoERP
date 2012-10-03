package br.com.dotcompany.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.faces.model.SelectItem;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.Assert;

import br.com.dotcompany.core.ServerCalledCommand;
import br.com.dotcompany.to.TransferObject;

public class ReflectionUtil {

	/**
	 * Retorna TRUE se o atributo passado como par�metro estiver presente
	 * no objeto (BEAN) e se o mesmo for uma tributo primitivo. Entende-se
	 * por atributo primitivo qualquer atributo diferente de uma Collection
	 * ou de um TrnasferObject. Qualquer  Wapper derivado de NUMBER (Long, Integer, Float,
	 * Double, Short) ou String � um atributo primitivo.
	 *
	 * @param classeName 	- Class<?> - Nome da classe a ser comparada.
	 * @param fieldName 	- String - Nome do atributo.
	 * @return boolean
	 */
	public static boolean isAtributoPrimitivo(Field field){
		try{
			Class<?> type = field.getType();
			//se for interface retorna FALSE
			if(type.isInterface()){
				return false;
			}
			//se for instancia de DBData retorna TRANSFER-OBJECT
			if(type.newInstance() instanceof TransferObject){
				return false;
			}
		}catch (Exception e) {
			return true;
		}
		return true;
	}

	/**
	 * Verifica se um determinado FIELD est� anotado com a Annotation passada como par�metro.
	 * @param field
	 * @param annotation
	 * @return
	 * @return boolean
	 */
	public static boolean isAnotado(Field field, Class<? extends Annotation> annotation){
		try{
			//se for interface retorna FALSE
			if(field.getAnnotation(annotation) != null){
				return true;
			}
		}catch (Exception e) {
			return false;
		}
		return false;
	}

	/**
	 * Retorna TRUE se o atributo passado como par�metro estiver presente
	 * no objeto (BEAN) e se o mesmo for uma tributo primitivo. Entende-se
	 * por atributo primitivo qualquer atributo diferente de uma Collection
	 * ou de um TrnasferObject. Qualquer  Wapper derivado de NUMBER (Long, Integer, Float,
	 * Double, Short) ou String � um atributo primitivo.
	 *
	 * @param bean - {@link Class<?>}
	 * @return boolean
	 */
	public static boolean isTransferObject(Field field){
		try{
			Class<?> type = field.getType();
			//se for instancia de DBData retorna TRANSFER-OBJECT
			if(type.newInstance() instanceof TransferObject){
				return true;
			}
		}catch (Exception e) {
			return false;
		}
		return false;
	}
	
	/**
	 * Retorna TRUE se o atributo passado como par�metro estiver presente
	 * no objeto (BEAN) e se o mesmo for uma tributo primitivo. Entende-se
	 * por atributo primitivo qualquer atributo diferente de uma Collection
	 * ou de um TrnasferObject. Qualquer  Wapper derivado de NUMBER (Long, Integer, Float,
	 * Double, Short) ou String � um atributo primitivo.
	 *
	 * @param classeName 	- TransferObject - Nome da classe a ser comparada.
	 * @param fieldName 	- String - Nome do atributo.
	 * @return List<String>
	 */
	public static boolean isAtributoPrimitivo(TransferObject bean, String fieldName){
		try{
			Class<?> field = PropertyUtils.getPropertyType(bean, fieldName);
			//se for interface retorna FALSE
			if(field.isInterface()){
				return false;
			}
			//se for instancia de TransferObject retorna TRANSFER-OBJECT
			if(field.newInstance() instanceof TransferObject){
				return false;
			}
		}catch (Exception e) {
			return true;
		}
		return true;
	}

	/**
	 * Retorna TRUE se o atributo passado como par�metro estiver presente
	 * no objeto (BEAN) e se o mesmo for uma tributo primitivo. Entende-se
	 * por atributo primitivo qualquer atributo diferente de uma Collection
	 * ou de um TrnasferObject. Qualquer  Wapper derivado de NUMBER (Long, Integer, Float,
	 * Double, Short) ou String � um atributo primitivo.
	 *
	 * @param classeName 	- String - Nome da classe a ser comparada.
	 * @param fieldName 	- String - Nome do atributo.
	 * @return List<String>
	 */
	public static boolean isAtributoPrimitivo(String classeName, String fieldName){
		try{
			Class<?> field = getTipoAtributo(Class.forName(classeName).newInstance(), fieldName);
			//se for interface retorna FALSE
			if(field.isInterface()){
				return false;
			}
			//se for instancia de TransferObject retorna TRANSFER-OBJECT
			if(field.newInstance() instanceof TransferObject){
				return false;
			}
		}catch (Exception e) {
			return true;
		}
		return true;
	}

	/**
	 * Retorna TRUE se o atributo passado como par�metro estiver presente
	 * no objeto (BEAN) e se o mesmo for uma tributo primitivo. Entende-se
	 * por atributo primitivo qualquer atributo diferente de uma Collection
	 * ou de um TrnasferObject. Qualquer  Wapper derivado de NUMBER (Long, Integer, Float,
	 * Double, Short) ou String � um atributo primitivo.
	 *
	 * @param classeName 	- Class<?> - Nome da classe a ser comparada.
	 * @param fieldName 	- String - Nome do atributo.
	 * @return boolean
	 */
	public static boolean isAtributoPrimitivo(Class<?> bean, String fieldName){
		try{
			Class<?> field = PropertyUtils.getPropertyType(bean.newInstance(), fieldName);
			//se for interface retorna FALSE
			if(field.isInterface()){
				return false;
			}
			
			//se for instancia de TransferObject retorna TRANSFER-OBJECT
			if(field.newInstance() instanceof TransferObject){
				return false;
			}
		}catch (Exception e) {
			return true;
		}
		return true;
	}

	/**
	 * Retorna TRUE se o atributo passado como par�metro estiver presente
	 * no objeto (BEAN) e se o mesmo for uma tributo primitivo. Entende-se
	 * por atributo primitivo qualquer atributo diferente de uma Collection
	 * ou de um TrnasferObject. Qualquer  Wapper derivado de NUMBER (Long, Integer, Float,
	 * Double, Short) ou String � um atributo primitivo.
	 *
	 * @param bean - {@link Class<?>}
	 * @return boolean
	 */
	public static boolean isTransferObject(Class<?> bean, String fieldName){
		try{
			Class<?> field = PropertyUtils.getPropertyType(bean.newInstance(), fieldName);
			//se for instancia de TransferObject retorna TRANSFER-OBJECT
			if(field.newInstance() instanceof TransferObject){
				return true;
			}
		}catch (Exception e) {
			return false;
		}
		return false;
	}

	/**
	 * Retorna TRUE se o atributo passado como par�metro estiver presente
	 * no objeto (BEAN) e se o mesmo for uma tributo primitivo. Entende-se
	 * por atributo primitivo qualquer atributo diferente de uma Collection
	 * ou de um TrnasferObject. Qualquer  Wapper derivado de NUMBER (Long, Integer, Float,
	 * Double, Short) ou String � um atributo primitivo.
	 *
	 * @param bean - {Object}
	 * @return boolean
	 */
	public static boolean isTransferObject(Object bean, String fieldName){
		try{
			Class<?> field = PropertyUtils.getPropertyType(bean, fieldName);
			//se for instancia de TransferObject retorna TRANSFER-OBJECT
			if(field.newInstance() instanceof TransferObject){
				return true;
			}
		}catch (Exception e) {
			return false;
		}
		return false;
	}

	/**
	 * Retorna o TYPE (Class) do atributo passado como parametro.
	 *
	 * @param bean - {@link TransferObject}
	 * @param fieldName - {@link String}
	 * @return Class<?>
	 */
	public static Class<?> getTipoAtributo(Object bean, String fieldName){
		try{
			return PropertyUtils.getPropertyType(bean, fieldName);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retorna o TYPE (Class) do atributo passado como parametro.
	 *
	 * @param bean - {@link TransferObject}
	 * @param fieldName - {@link String}
	 * @return Class<?>
	 */
	public static Class<?> getTipoAtributo(String className, String fieldName){
		try{
			return PropertyUtils.getPropertyType(Class.forName(className).newInstance(), fieldName);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retorna o valor de um atributo
	 *
	 * @param bean - {@link TransferObject}
	 * @param fieldName - {@link String}
	 * @return Object
	 */
	public static Object getValorAtributo(TransferObject bean, String fieldName){
		try {
			return PropertyUtils.getNestedProperty(bean, fieldName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retorna o valor de um atributo
	 *
	 * @param bean - {@link TransferObject}
	 * @param fieldName - {@link String}
	 * @return Object
	 */
	public static Object getValorAtributo(Object bean, String fieldName){
		try{
			return PropertyUtils.getNestedProperty(bean, fieldName);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Retorna a anota��o passada como par�metro localizada no FILDNAME do objeto.
	 *
	 * @param bean - {@link TransferObject}
	 * @param fieldName - {@link String}
	 * @return Object
	 */
	public static Annotation getAnotacao(TransferObject bean, String fieldName, Class<? extends java.lang.annotation.Annotation> annotation){
		try{
			Field campo = bean.getClass().getField(fieldName);
			return campo.getAnnotation(annotation);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retorna o valor de um atributo
	 *
	 * @param bean - {@link TransferObject}
	 * @param fieldName - {@link String}
	 */
	public static void setValorAtributo(TransferObject bean, String caminhoPropriedade, Object fieldValue){
		try {
			if (caminhoPropriedade.indexOf('.') == -1) {
				PropertyUtils.setNestedProperty(bean, caminhoPropriedade, fieldValue);
			} else {
				String first = caminhoPropriedade.substring(0, caminhoPropriedade.indexOf("."));
				Object valor = getValorAtributo(bean, first);
				if (valor == null) {
					Class<?> type = getTipoAtributo(bean, first);
					Object property = instanciarEPopularAtributo(type.newInstance(), caminhoPropriedade.substring(caminhoPropriedade.indexOf(".")+1, caminhoPropriedade.length()), fieldValue);
					PropertyUtils.setNestedProperty(bean, first, property);
				} else {
					Object property = instanciarEPopularAtributo(valor, caminhoPropriedade.substring(caminhoPropriedade.indexOf(".")+1, caminhoPropriedade.length()), fieldValue);
					PropertyUtils.setNestedProperty(bean, first, property);					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Seta o valor de uma propriedade, REPARE QUE O DIVIDOR � UM "_" E N�O UM "."
	 * caso algum objeto no caminho estiver null ele � instanciado e setado no objeto para o caminho continuar a ser seguido
	 * 
	 * O ultima propridade do caminho � a que vai receber o "valor" passado como parametro, se ela for um objeto, o construtor
	 * que aceita uma String desse objeto � invocado para a cria��o da nova instancia.
	 */
	public static void setNestedValuePropertyPath(Object obj, String propertyPath, Object valor) throws Exception{
		if (propertyPath.contains("_")) {
			setNestedValueDefault(obj, propertyPath, valor, "_");
		} else {
			//Se a propriedade for a unica do caminho, seta o valor passado como parametro
			//Seta a instancia criada no objeto
			PropertyUtils.setProperty(obj, propertyPath, valor);
		}
	}
	
	/**
	 * Seta o valor de uma propriedade (Ex.: cliente.id), caso algum objeto no caminho estiver null
	 * ele � instanciado e setado no objeto para o caminho continuar a ser seguido
	 * 
	 * O ultima propridade do caminho � a que vai receber o "valor" passado como parametro, se ela for um objeto, o construtor
	 * que aceita uma String desse objeto � invocado para a cria��o da nova instancia.
	 * 
	 * @param dividor - � o que divide o caminho das propriedades Ex.: "departamento.autor", o que est� dividindo � um "."
	 */
	public static void setNestedValueDefault(Object obj, String propertyPath, Object valor, String divisor) throws Exception{
		//Divide o "Caminho de Propriedades" em um Array de String
		String[] props = propertyPath.split(divisor);
		Object objNow = obj;
		//Percorre o caminho de propriedades um a um.
		for (int j = 0; j < props.length; j++) {
			//Verifica se a propriedade atual � a ultima do caminho
			if (j < (props.length - 1)) {
				//Faz um "getPropriedade" para verificar se o caminho � null
				//Se for cria uma instancia do Objeto e seta na propriedade
				if (PropertyUtils.getProperty(objNow, props[j]) == null) {
					Class<?> classe = PropertyUtils.getPropertyType(objNow, props[j]);
					PropertyUtils.setProperty(objNow, props[j], classe.newInstance());
				} 
				//Pega a proxima propriedade do caminho
				objNow = PropertyUtils.getProperty(objNow, props[j]);
			} else {
				//Se a propriedade for a ultima do caminho, seta o valor passado como parametro
				//Seta a instancia criada no objeto
				PropertyUtils.setProperty(objNow, props[j], valor);
			}
		}
	}
	
	
	/**
	 * Seta o valor de uma propriedade (Ex.: documento.autor.departamento.id), caso algum objeto no caminho estiver null
	 * ele � instanciado e setado no objeto para o caminho continuar a ser seguido
	 * 
	 * O ultima propridade do caminho � a que vai receber o "valor" passado como parametro, se ela for um objeto, o construtor
	 * que aceita uma String desse objeto � invocado para a cria��o da nova instancia.
	 * 
	 * 
	 */
	public static void setNestedValorAtributo(Object obj, String propriedade, String valor) throws Exception{
		if(propriedade.contains(".")){
		   int indice = 0;
		   //Divide o "Caminho de Propriedades" em um Array de String
		   String[] props = propriedade.split("\\.");
		   Object objNow = obj;
		   //Percorre o caminho de propriedades um a um.
		   for(int j = 0; j < props.length; j++){
			   //Verifica se a propriedade atual � a ultima do caminho
			   if(j < (props.length - 1)){
				  //Faz um "getPropriedade" para verificar se o caminho � null
				  //Se for cria uma instancia do Objeto e seta na propriedade
				  if(PropertyUtils.getProperty(objNow, props[j]) == null){
					 Class<?> clas = PropertyUtils.getPropertyType(objNow, props[j]);
					 PropertyUtils.setProperty(objNow, props[j], clas.newInstance());
				  } 
				  //Pega a proxima propriedade do caminho
				  objNow = PropertyUtils.getProperty(objNow, props[j]);
				}else{
					//Se a propriedade for a ultima do caminho, seta o valor passado como parametro
					setLastNestedProperty(objNow, props[j], valor);
				}
		   }
		   indice++;
		}else{
		   //Se a propriedade for a unica do caminho, seta o valor passado como parametro
		   setLastNestedProperty(obj, propriedade, valor);
		}
	}
	
	private static void setLastNestedProperty(Object obj, String propriedade, String valor) throws Exception{
		  //Pega o Class do Objeto da ultima propriedade	
		  Class<?> clas = PropertyUtils.getPropertyType(obj, propriedade);
		  //Pega o construtor que aceita uma String e cria uma nova instancia do objeto
		  Object objValue = clas.getDeclaredConstructor(String.class).newInstance(valor);
		  //Seta a instancia criada no objeto
		  PropertyUtils.setProperty(obj, propriedade, objValue);
	}
	
	
	/**
	 * Retorna o valor de um atributo
	 *
	 * @param bean - {@link TransferObject}
	 * @param fieldName - {@link String}
	 */
	@SuppressWarnings("unchecked")
	public static Object instanciarEPopularAtributo(Object obj, String caminhoPropriedade, Object fieldValue){
		try{
			if(caminhoPropriedade.indexOf('.') == -1){
				PropertyUtils.setNestedProperty(obj, caminhoPropriedade, fieldValue);
			}else{
				String first = caminhoPropriedade.substring(0, caminhoPropriedade.indexOf("."));
				Object valor = getValorAtributo(obj, first);
				if(valor == null){
					Class type = getTipoAtributo(obj, first);
					Object property = instanciarEPopularAtributo(type.newInstance(), caminhoPropriedade.substring(caminhoPropriedade.indexOf(".")+1, caminhoPropriedade.length()), fieldValue);
					PropertyUtils.setNestedProperty(obj, first, property);
				}else{
					Object property = instanciarEPopularAtributo(valor, caminhoPropriedade.substring(caminhoPropriedade.indexOf(".")+1, caminhoPropriedade.length()), fieldValue);
					PropertyUtils.setNestedProperty(obj, first, property);					
				}
			}
			return obj;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Retorna o valor de um atributo
	 *
	 * @param bean - {@link TransferObject}
	 * @param fieldName - {@link String}
	 */
	@SuppressWarnings("unchecked")
	public static void setValorAtributo(TransferObject bean, String fieldName, String fieldValue, String fieldType){
		try{
			Class classlong = Class.forName(fieldType);
			//este tratamento de erro n�o esta elegante, ele foi criado para driblar quando uma propriedade  do tipo
			//TransferObject tiver que ser instanciada pela aplica��o a ser executada.
			try{
				Object obj = classlong.getDeclaredConstructor(String.class).newInstance(fieldValue);
				PropertyUtils.setNestedProperty(bean, fieldName, obj);				
			}catch (NoSuchMethodException e) {
				Object obj = classlong.getDeclaredConstructor(Long.class).newInstance(Long.valueOf(fieldValue));
				PropertyUtils.setNestedProperty(bean, fieldName, obj);				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna a lista de atributos do objeto passado como par�metro.
	 *
	 * @param bean - {@link Object}
	 * @return List<String>
	 */
	public static List<String> buscarAtributosObjeto(Object bean){
		List<String> lista = new ArrayList<String>();
		Field[] fields = bean.getClass().getDeclaredFields();
		for(Field field : fields){
			lista.add(field.getName());
		}
		return lista;
	}
	
	/**
	 * Retorna a lista de atributos do objeto passado como par�metro.
	 *
	 * @param bean - {@link Object}
	 * @return List<String>
	 */
	public static List<Field> listarAtributosByAnnotations(Object bean, Class<? extends Annotation> annotation){
		List<Field> lista = new ArrayList<Field>();
		Field[] fields = bean.getClass().getDeclaredFields();
		for(Field field : fields){
			if(field.isAnnotationPresent(annotation)){
				lista.add(field);				
			}
		}
		return lista;
	}

	/**
	 * Retorna a lista de atributos do objeto passado como par�metro.
	 *
	 * @param bean - {@link Object}
	 * @return List<String>
	 */
	public static List<Field> listarAtributos(Object bean){
		List<Field> lista = new ArrayList<Field>();
		Field[] fields = bean.getClass().getDeclaredFields();
		for(Field field : fields){
			lista.add(field);				
		}
		return lista;
	}

	/**
	 * Retorna a lista de atributos de um objeto com base no NOME.
	 * @param nomeObjeto - {@link String}
	 * @return List<String>
	 */
	public static List<String> buscarAtributosObjeto(String nomeObjeto){
		Object bean = instanciar(nomeObjeto);
		return buscarAtributosObjeto(bean);
	}
	
	/**
	 * Constroi uma lista de SelectItem com as propriedades do objeto instanciado
	 * a partir do par�metro STRING passado ao m�todo.
	 *
	 * @param nomeObjeto
	 * @return - 
	 * @return List<SelectItem>
	 */
	public static List<SelectItem> criarListaSelectItemPropriedadesObjeto(String nomeObjeto){
		List<SelectItem> listaItem= new ArrayList<SelectItem>();
		List<String> lista = buscarAtributosObjeto(nomeObjeto);
		for(String prop : lista){
			listaItem.add(new SelectItem(prop, prop));
		}
		return listaItem;
	}
	
	/**
	 * 
	 * Cria uma List<SelectItem> com todas as propriedades de uma classe 
	 * e da arvore de SuperClasse at� a ultima que � instanceof de TransferObject
	 *
	 * @return - 
	 * @return List<SelectItem>
	 */
	@SuppressWarnings("unchecked")
	public static List<SelectItem> criarListaSelectItemPropriedade(Class classe){
		List<SelectItem> retorno = new ArrayList<SelectItem>();
		try {
			do{
			   Field[] fields = classe.getDeclaredFields();
			   // constroi os objeto SelectItem com o nome das propriedades
			   for(int i = 0; i < fields.length; i++) {
				   Field field = fields[i];
				   retorno.add(new SelectItem(field.getName(), field.getName()));
			   }
			   classe = classe.getSuperclass();
			}while(herdaTransferObject(classe.getSuperclass()));
		}catch(Exception e){
            e.printStackTrace();
		}
		return retorno;
	}

	/**
	 * Sobe na heran�a de classes para encontrar um TransferObject,
	 * e retorna true ou false, de acordo com o resultado da busca
	 */
    @SuppressWarnings("unchecked")
	public static boolean herdaTransferObject(Class classe) throws ClassNotFoundException{
    	while((classe = classe.getSuperclass()) != null){
    		  if(classe.isAssignableFrom(Class.forName(TransferObject.class.getName())) && !(classe.getClass().getName().equals(TransferObject.class.getName()))){
    		     return true;
    		  }
    	}
    	return false;
    }

	/**
	 * Retorna a instancia de um objeto com base no NOME
	 * @param nomeObjeto - String - Nome do TransferObject a ser instanciado
	 * @return TransferObject
	 */
	public static <T> TransferObject instanciarTransferObject(String nomeObjeto){
		try{
			return (TransferObject)Class.forName(nomeObjeto).newInstance();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retorna a instancia de um objeto com base no NOME
	 *
	 * @param nomeObjeto - String
	 * @return Object
	 */
	public static Object instanciar(String nomeObjeto){
		try{
			return Class.forName(nomeObjeto).newInstance();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<String> getAtributosPorClasse(String className){
		try {
			return getAtributosPorClasse(Class.forName(className));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<String> getAtributosPorClasse(Class<?> clazz){
		Field[] fields = clazz.getDeclaredFields();
		List<String> nomes = new ArrayList<String>();
		for(Field field : fields) {
			field.setAccessible(true);
			String nome = field.getName();
			if(ReflectionUtil.getClasseAnotacao(field.getType()) != null){
				continue;
			}
			if(!nome.startsWith("id") && !nome.equals("serialVersionUID"))
				nomes.add(nome);
		}
		return nomes;
	}
	
	/**
	 * Popula 
	 * 
	 * @param clazz
	 * @param ids
	 * @param values
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static final List<Object> populaObjeto(Class<?> clazz, String[] ids, Object[] values) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		return populaObjeto(clazz, Arrays.asList(ids), Arrays.asList(values));
	}
	
	public static final List<Object> populaObjeto(Class<?> clazz, List<String> ids, List<Object> values) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		List<Object> lista = new ArrayList<Object>();
		
		for(int contValue = 0; contValue < values.size();){
			Object ob = clazz.newInstance();
			for(String id : ids)
				PropertyUtils.setNestedProperty(ob, id, values.get(contValue++));
			
			lista.add(ob);
		}
		
		return lista;
	}
	
	public static Field getDeclaredField(final Object bean, final String fieldName) throws NoSuchFieldException { 
		return getDeclaredField(bean.getClass(), fieldName);
	}

	public static Field getDeclaredField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
		Assert.notNull(clazz);
		Assert.hasText(fieldName);
		for (Class<?> superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) { continue; }
		}
		throw new NoSuchFieldException("No such field: " + clazz.getName() + '.' + fieldName);
	}
	
	public static void makeAccessible(final Field field) {
		if (!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
			field.setAccessible(true);
		}
	}
	
	public static void invokeSetterMethod(Object bean, String propertyName, Object value) {
		invokeSetterMethod(bean, propertyName, value, null);
	}

	public static void invokeSetterMethod(Object bean, String propertyName, Object value, Class<?> propertyType) {
		Class<?> type;
		try {
			type = propertyType != null ? propertyType : (bean.getClass().getDeclaredField(propertyName)).getType();
		} catch (Exception e) {
			type = value.getClass();
		}
		String setterMethodName = "set" + StringUtils.capitalize(propertyName);
		invokeMethod(bean, setterMethodName, new Class[] { type }, new Object[] { value });
	}

	public static Object invokeMethod(final Object bean, final String methodName, Class<?>[] parameterTypes, final Object... parameters) {
		Method method = getDeclaredMethod(bean, methodName, parameterTypes);
		if (method == null) {
			throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + bean + "]");
		}
		method.setAccessible(true);
		try {
			return method.invoke(bean, parameters);
		} catch (Exception e) {
			return new RuntimeException(e);
		}
	}
	
	protected static Method getDeclaredMethod(Object bean, String methodName, Class<?>[] parameterTypes) {
		Assert.notNull(bean, "");
		for (Class<?> superClass = bean.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				return superClass.getDeclaredMethod(methodName, parameterTypes);
			} catch (NoSuchMethodException e) {//NOSONAR
				e.printStackTrace();
			}
			
		}
		return null;
	}

	public static Object invokeGetterMethod(Object bean, String propertyName) {
		String getterMethodName = "get" + StringUtils.capitalize(propertyName);
		return invokeMethod(bean, getterMethodName, new Class[] {}, new Object[] {});
	}

	
	/**
	 * retorna classe do atribudo "propertyName" desejado detro do bean 
	 */
	public static Class<?> getClazzAttribute(Class<?> clazz, String propertyPath){
		try{
			String[] paths = propertyPath.split("\\.");
			Class<?> classeAtual = clazz;
			for(String path : paths){
				Field f;
				try {
					f = classeAtual.getDeclaredField(path);
				} catch (NoSuchFieldException e) {
					f = classeAtual.getSuperclass().getDeclaredField(path);
				}
				classeAtual = f.getType();
			}
			return classeAtual;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Class<?> getClasseAnotacao(Class classeAnotada){
		
		ServerCalledCommand annotation = (ServerCalledCommand) 
			classeAnotada.getAnnotation(ServerCalledCommand.class);
		
		return (Class<?>) (annotation == null ? annotation : annotation.value());
	}

	@SuppressWarnings("unchecked")
	public static boolean isMirror(Class classeAnotada){
		
		ServerCalledCommand annotation = (ServerCalledCommand) 
				classeAnotada.getAnnotation(ServerCalledCommand.class);
		
		return annotation != null;
	}
	
	public static Class<?> getClass(String nameClass){
		try {
			return Class.forName(nameClass);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("\n CAUSA: N�o foi possivel recuperar a classe: "+nameClass+"\n");
		}
	}
	
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public static List<String> getFieldsNonCollections(Class<?> clazz)  {
		List<String> proj = new ArrayList<String>();
		// Recebe os atributos que a classe from possui
		Field fields[] = clazz.getDeclaredFields();
		// Percorre os atributos para pegar os dados pertencentes no objOld e setar no objNovo 
		for(Field field : fields){
			try {
				Class<?> classType = field.getType();
				if (classType == Set.class || classType == Collection.class || classType == List.class)
					continue;
				proj.add(field.getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return proj;
	}
	
	public static Class<?>[] getTypesParameters(Object[] params){
		Class<?>[] types = new Class<?>[params.length];
		
		int cont = 0; 
		for(Object param : params){
			types[cont++] = param.getClass();
		}
			
		return types;
	}
	
	public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException,
    IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		String s = "select telefone from cliente";
		s = s.substring("select".length());
		s = s.substring(0, s.indexOf("from"));
		String[] col = null;
		if(s.contains(","))
			col = s.replaceAll(" ", "").split(",");
		else 
			col = new String[]{s.replaceAll(" ", "")};
		
		for(String m : col){
			System.out.println(m);
		}
	}
}