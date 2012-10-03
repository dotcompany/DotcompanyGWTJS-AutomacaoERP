package br.com.automacao.service.servlet;

import java.util.List;

import org.dozer.DozerBeanMapperSingletonWrapper;

import br.com.automacao.ctr.BusinessFactory;
import br.com.automacao.shared.util.Mirror;
import br.com.dotcompany.to.TransferObject;
import br.com.dotcompany.util.ReflectionUtil;
import br.com.dotcompany.util.UtilObjeto;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class BaseService extends RemoteServiceServlet {

	
	/* Converte um Mirror em To */
	@SuppressWarnings("unchecked")
	protected static <T extends TransferObject> T converterTo(Mirror mirror){
		try {
			Class<?> clazzTo = ReflectionUtil.getClasseAnotacao(mirror.getClass());
			return (T) convert(mirror, clazzTo);
		} catch (Exception e) {
			throw new RuntimeException("\n CAUSA: Não foi possivel converter o objeto: "+mirror.getClass().getSimpleName()+" para um TransferObject  \n");
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T crud(Class<T> clazz) {
		return (T) ReflectionUtil.invokeGetterMethod(BusinessFactory.getInstance(), clazz.getSimpleName()); 
	}
	
	/* Converte um To em Mirror */
	@SuppressWarnings("unchecked")
	protected static <T extends Mirror> T converterMirror(TransferObject to){
		try {
			String nTO = to.getClass().getSimpleName();
			String clazz = "br.com.automacao.shared.mirror." + nTO.substring(0, nTO.length()-2) + "Mirror";
			Class<?> clazzMirror = Class.forName(clazz);
			return (T) convert(to, clazzMirror);
		} catch (Exception e) {
			throw new RuntimeException("\n CAUSA: Não foi possivel converter o objeto: "+to.getClass().getSimpleName()+" para um Mirror \n");
		}
	}
	
	private static final Object convert(Object obj, Class<?> clazz) {
		return DozerBeanMapperSingletonWrapper.getInstance().map(obj, clazz);
	}

	@SuppressWarnings("unchecked")
	public static void copyList(List listOld, List listNew){
		if (UtilObjeto.isEmpty(listOld)) { return;}
		try {
			Object toObj = null;
			for (Object fromObj : listOld) {
				if(fromObj instanceof TransferObject)
					toObj = converterMirror((TransferObject) fromObj);
				else 
					toObj = converterTo((Mirror) fromObj);
				
				listNew.add(toObj);
			}
		} catch (Exception e) {}
	}
}