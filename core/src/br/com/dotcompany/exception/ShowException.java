package br.com.dotcompany.exception;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;

import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.ObjectDeletedException;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.PersistentObjectException;
import org.hibernate.PropertyValueException;
import org.hibernate.QueryException;
import org.hibernate.StaleObjectStateException;
import org.hibernate.StaleStateException;
import org.hibernate.TransientObjectException;
import org.hibernate.UnresolvableObjectException;
import org.hibernate.WrongClassException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.JDBCConnectionException;
import org.hibernate.exception.LockAcquisitionException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.HibernateSystemException;

import br.com.dotcompany.context.FacesCtxHolder;
import br.com.dotcompany.type.MsgType;

/**
 * <b>Projeto:</b> core <br>
 * <b>Pacote:</b> br.com.dotcompany.exception <br>
 * <b>Título:</b> ShowException.java <br>
 * <b>Descrição:</b> <br>
 * <b>Company:</b> DotCompany TI LTDA. <br>
 * 
 *    Copyright (c) 2011 DotCompany - Todos os direitos reservados.
 * 
 * <b>Autor:</b> Danylo
 * <b>Criação:</b> 18/08/2011, 09:44:37
 */
@SuppressWarnings("serial")
public class ShowException extends Throwable {
	
	public ShowException() { }
	
	/**
	 * Tratamento de exceções para filtrar as mensagens emitidas ao usuário
	 * @param e - {@link Exception}
	 */
	public static String aspect(Exception e){
		String msg = "";
		String[] param = null;
		
		// Busca a origem de exceções não declaradas
		if(e.getCause() instanceof ObjectNotFoundException){
			e = (Exception)e.getCause();
		}else if(e instanceof UndeclaredThrowableException){
			e = getException(e);
		}else if(e instanceof InvocationTargetException){
			e = getException(e);
		}
	
		//exceções customizadas
		if (e instanceof NegocioException) {
			e.printStackTrace();
			msg = ((NegocioException)e).getMessage();
		}else if (e instanceof DataAccessException){
			e.printStackTrace();
			msg = ((DataAccessException)e).getMessage();
		}else if(e instanceof DataIntegrityViolationException){
			e.printStackTrace();
			msg = ((DataIntegrityViolationException)e).getMessage();
		}else if (e instanceof JDBCConnectionException) {
			e.printStackTrace();
			msg = ((JDBCConnectionException)e).getMessage();
		} else if (e instanceof ConstraintViolationException) {
			e.printStackTrace();
			msg = ((ConstraintViolationException)e).getMessage();
		} else if (e instanceof LockAcquisitionException) {
			e.printStackTrace();
			msg = ((LockAcquisitionException)e).getMessage();
		} else if (e instanceof JDBCException) {
			e.printStackTrace();
			msg = ((JDBCException)e).getMessage();
		} else if (e instanceof PropertyValueException) {
			e.printStackTrace();
			msg = ((PropertyValueException)e).getMessage();
		} else if (e instanceof PersistentObjectException) {
			e.printStackTrace();
			msg = ((PersistentObjectException)e).getMessage();
		} else if (e instanceof TransientObjectException) {
			e.printStackTrace();
			msg = ((TransientObjectException)e).getMessage();
		} else if (e instanceof ObjectDeletedException) {
			e.printStackTrace();
			msg = ((ObjectDeletedException)e).getMessage();
		} else if (e instanceof QueryException) {
			e.printStackTrace();
			msg = ((QueryException)e).getMessage();
		} else if (e instanceof UnresolvableObjectException) {
			e.printStackTrace();
			msg = ((UnresolvableObjectException)e).getMessage();
		} else if (e instanceof WrongClassException) {
			e.printStackTrace();
			msg = ((WrongClassException)e).getMessage();
		} else if (e instanceof NonUniqueResultException) {
			e.printStackTrace();
			msg = ((NonUniqueResultException)e).getMessage();
		} else if (e instanceof StaleObjectStateException) {
			e.printStackTrace();
			msg = ((StaleObjectStateException)e).getMessage();
		} else if (e instanceof StaleStateException) {
			e.printStackTrace();
			msg = ((StaleStateException)e).getMessage();
		}else if(e instanceof DataIntegrityViolationException ) {
			e.printStackTrace();
			msg = ((DataIntegrityViolationException)e).getMessage();
		}else if(e instanceof NullPointerException){
			e.printStackTrace();
			msg = ((NullPointerException)e).getMessage();
		}else if(e instanceof ObjectNotFoundException){
			e.printStackTrace();
			msg = ((ObjectNotFoundException)e).getMessage();
		}/*else if (e instanceof BadCredentialsException){
        	BadCredentialsException bce = (BadCredentialsException) e;
        	boolean isUserEmpty = bce.getAuthentication().getName().isEmpty();
        	boolean isPswEmpty = bce.getAuthentication().getCredentials().toString().isEmpty();
        	if (!isPswEmpty && bce.getExtraInformation() != null) {
				int cont = ((UsuarioTO)bce.getExtraInformation()).getContTentativa();
				String bundleName = cont > 2 ? "login.regra.bloqueado.autenticacao" : "login.regra.tentativa.autenticacao";
				msg = bundleName;
				param = new String[]{String.valueOf(cont)};
			}
			if (!isUserEmpty && bce.getExtraInformation() == null) {
				msg = "login.regra.username.not.find";
				param = new String[]{bce.getAuthentication().getName()};
			}
        }else if (e instanceof LockedException) {
        	String nome = ((LockedException) e).getAuthentication().getName();
        	msg = "login.regra.conta.bloqueado";
    		param = new String[]{nome};
		} else if (e instanceof DisabledException) {
			String nome = ((DisabledException) e).getAuthentication().getName();
			msg = "login.regra.conta.inativa";
			param = new String[]{nome};
		} else if (e instanceof AccountExpiredException) {
			String nome = ((AccountExpiredException) e).getAuthentication().getName();
			msg = "login.regra.conta.expirada";
			param = new String[]{nome};
		}else if (e instanceof CredentialsExpiredException) {
			String nome = ((CredentialsExpiredException) e).getAuthentication().getName();
			FacesCtxHolder.showMessage("login.regra.credencial.expirada",new String[]{nome}, MsgType.MSG_ERRO);
		}else if (e instanceof SessionAuthenticationException) {
			msg = "O usuario já esta logado em outra estação de trabalho";
		}*/else {
			msg = e.getMessage();			
		}
		
		if (msg != null && !msg.isEmpty()) {
			FacesCtxHolder.showMessage(msg, param, MsgType.ERRO);
		}
		
		e.printStackTrace();
		return null;
	}

    /**
     * Retorna a exceção original na pilha de métodos.
     * @param e - {@link Throwable}
     */
    private static Exception getException(Throwable e){
    	Exception ex = new Exception(e);
    	try{
	    	if(e instanceof NegocioException){
	    		ex = (Exception)e;
	    	}else if(e.getCause() instanceof NegocioException ){
	    		ex = (Exception)e.getCause();
	    	}else if(e.getCause().getCause() instanceof NegocioException 
	    					|| e.getCause().getCause() instanceof PropertyValueException
	    						|| e.getCause().getCause() instanceof DataIntegrityViolationException
	    							|| e.getCause().getCause() instanceof IndexOutOfBoundsException
	    								|| e.getCause().getCause() instanceof HibernateSystemException
	    									|| e.getCause().getCause() instanceof NullPointerException
	    										|| e.getCause().getCause() instanceof HibernateException){
	    		
	    		ex = (Exception)e.getCause().getCause();   
	    		
	    	}else if(e.getCause().getCause().getCause() instanceof NegocioException 
	    					|| e.getCause().getCause().getCause() instanceof PropertyValueException
	    						|| e.getCause().getCause().getCause() instanceof DataIntegrityViolationException
	    							|| e.getCause().getCause().getCause() instanceof IndexOutOfBoundsException
	    								|| e.getCause().getCause().getCause() instanceof HibernateSystemException
	    									|| e.getCause().getCause().getCause() instanceof NullPointerException
	    										|| e.getCause().getCause().getCause() instanceof HibernateException){
	    		
	    		ex = (Exception)e.getCause().getCause().getCause();  
	    		
	    	}else if(e.getCause().getCause().getCause().getCause() instanceof NegocioException 
	    					|| e.getCause().getCause().getCause().getCause() instanceof PropertyValueException
	    						|| e.getCause().getCause().getCause().getCause() instanceof DataIntegrityViolationException
	    							|| e.getCause().getCause().getCause().getCause() instanceof IndexOutOfBoundsException
	    								|| e.getCause().getCause().getCause().getCause() instanceof HibernateSystemException
	    									|| e.getCause().getCause().getCause().getCause() instanceof NullPointerException
	    										|| e.getCause().getCause().getCause().getCause() instanceof HibernateException){
	    		
	    		ex = (Exception)e.getCause().getCause().getCause().getCause();    		
	    	}
    	}catch (Exception exc) {
    		exc.printStackTrace();
		}
    	return ex;
    }
    
    
    
/*    
  exception lançadas pela classe CriptoUtis
	
		} catch (InvalidKeySpecException e) {
		} catch (NoSuchAlgorithmException e) {
		} catch (NoSuchPaddingException e) {
		} catch (UnsupportedEncodingException e) {}
		} catch (InvalidKeyException e) {
		} catch (IllegalBlockSizeException e) {
		} catch (BadPaddingException e) {
		} catch (IOException e) {}
*/    
}