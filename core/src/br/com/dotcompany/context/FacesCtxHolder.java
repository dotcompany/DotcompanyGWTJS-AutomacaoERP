package  br.com.dotcompany.context;
 
import java.util.Map;

import javax.el.ELContext;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.dotcompany.type.MsgType;
import br.com.dotcompany.util.PropertiesUtil;
import br.com.dotcompany.util.UtilObjeto;

/**
 * <b>Projeto:</b> core <br>
 * <b>Pacote:</b> br.com.dotcompany.faces <br>
 * <b>Título:</b> FacesCtxHolder.java <br>
 * <b>Descrição:</b> <br>
 * <b>Company:</b> DotCompany TI LTDA. <br>
 * 
 *    Copyright (c) 2011 DotCompany - Todos os direitos reservados.
 * 
 * <b>Autor:</b> Danylo
 * <b>Criação:</b> 18/08/2011, 09:44:44
 */
public class FacesCtxHolder extends javax.faces.context.FacesContextFactory {
	
	private static FacesContextFactory		delegate;
	
	public FacesCtxHolder(FacesContextFactory facesContextFactory) {
		delegate = facesContextFactory;
	}

	@Override
	public FacesContext getFacesContext(Object context, Object request, Object response, Lifecycle lifecycle) throws FacesException {
		return delegate.getFacesContext(context, request, response, lifecycle);
	}

	public static FacesContext facesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	public static ELContext elContext() {
		return facesContext().getELContext();
	}
	
	public static ExternalContext externalContext() {
		return facesContext().getExternalContext();
	}
	
	public static String getRealPath() {
		return servletContext().getRealPath("");
	}
	
    public static HttpSession session() {
    	return (HttpSession) externalContext().getSession(true);
    }
	
	public static HttpServletRequest servletRequest() {
		return (HttpServletRequest) externalContext().getRequest();
	}
	
    public static ServletContext servletContext() {
    	return (ServletContext) externalContext().getContext();
    }

    public static HttpServletResponse servletResponse() {
    	return (HttpServletResponse) externalContext().getResponse();
    }
    
	public static Map<String, Object> sessionMap() {
    	return externalContext().getSessionMap();
    }
	
	public static Map<String,String> requestMap() {
    	return externalContext().getRequestParameterMap();
    }
    
    public static String requestMapParam(String name) {
    	return (String)requestMap().get(name);
    }
	
	public static <T> T getBean(Class<T> clazz) {
    	String beanAlias = UtilObjeto.beanAlias(clazz);
    	return getBean(beanAlias);
    }

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanAlias) {
		return (T) facesContext().getApplication().getELResolver().getValue(elContext(), null, beanAlias);
	}

	public static <T> T getAttBean(Class<T> clazz, String attribute) {
		String beanAlias = UtilObjeto.beanAlias(clazz);
		return getAttBean(beanAlias, attribute);
	}
    
	@SuppressWarnings("unchecked")
	public static <T> T getAttBean(String beanAlias, String attribute) {
		return (T) facesContext().getApplication().getELResolver().getValue(elContext(), beanAlias, attribute);
	}
	
	public static void setAttBean(Class<?> clazz, String attribute, Object value) {
    	String beanAlias = UtilObjeto.beanAlias(clazz);
    	setAttBean(beanAlias, attribute, value);
    }

	public static void setAttBean(String beanAlias, String attribute, Object newValue) {
    	facesContext().getApplication().getELResolver().setValue(elContext(), beanAlias, attribute, newValue);
    }

	public static void setAttSession(String alias, Object object) {
		session().setAttribute(alias, object);
	}
	
	public static Object getAttSession(String alias) {
		return session().getAttribute(alias);
	}
	
	public static void removeAttSession(String alias) {
		session().removeAttribute(alias);
	}  
    
	public static void setAttRequest(String alias, Object object) {
		servletRequest().setAttribute(alias, object);
	}

	public static Object getAttRequest(String key) {
		return servletRequest().getAttribute(key);
	}  
   
	public static void showMessage(String key, MsgType type) {
		showMessage(key, null, type);
	}
	
	public static void showMessage(String key, String[] parametros, MsgType type) {
		setAttRequest(MsgType.MODAL.name(), Boolean.TRUE);
		setAttRequest(MsgType.TIPO.name(), type);
		FacesMessage msgs = new FacesMessage(PropertiesUtil.getMessageResourceString(key, parametros));
		facesContext().addMessage(null, msgs);
	}
}