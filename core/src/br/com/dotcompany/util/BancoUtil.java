package br.com.dotcompany.util;

import java.util.List;

/**
 * Classe de utilitarios de banco
 * 
 * @author sergio
 *
 */
public class BancoUtil {

	/**
	 * Pega uma consulta e a faz projetada
	 * 
	 * @param hql
	 * 		Hql da consulta
	 * @param fields
	 * 		Campos que serão projetados
	 * @return
	 */
	public static final String createFieldsHql(String hql, List<String> fields) {
		StringBuffer sb = new StringBuffer();
		int size = fields.size();
		int cont = 0;
		sb.append("select ");
		for(String field : fields){
			sb.append(field).append(" as ").append(field);
			if(cont + 1 < size){
				sb.append(" ,");
				cont++;
			}
		}
		sb.append(hql);
		
		return sb.toString();
	}
	
	/**
	 * Pega uma consulta e a faz projetada e concatena com like
	 * 
	 * @param hql
	 * 		Hql da consulta
	 * @param fields
	 * 		Campos que serão projetados
	 * @return
	 */
	public static final String createFieldsHqlLike(String hql, String[] fields, String attr, String type, String value) {
		StringBuffer sb = new StringBuffer();
		int size = fields.length;
		int cont = 0;
		sb.append("select ");
		for(String f : fields){
			sb.append(f).append(" as ").append(f);
			if(cont + 1 < size){
				sb.append(", ");
				cont++;
			}
		}
		
		String line = mountHqlByType(attr, type, value);
		sb.append(" ");
		String[] part;
		if(hql.contains(" where")){
			part = hql.split(" where");
			sb.append(part[0]).append(" ");
			sb.append(line);
			sb.append(" ").append(hql);
		} else if(hql.contains(" order by")){
			part = hql.split(" order by");
			sb.append(part[0]).append(" ");
			sb.append(" where ");
			sb.append(line);
			sb.append(" ").append(hql);
		} else {
			sb.append(hql);
			sb.append(" where ");			
			sb.append(line);
		}
			
		
		return sb.toString();
	}
	
	
	
	/**
	 * Pega uma consulta e a faz sob demanda e concatena com like. Usado para count.
	 * 
	 * @param hql
	 * 		Hql da consulta
	 * @param fields
	 * 		Campos que serão projetados
	 * @return
	 */
	public static final String createCountHqlLike(String hql, String[] like) {
		StringBuffer sb = new StringBuffer();
//		String[] part;
//		if(hql.contains(" where ")){
//			part = hql.split(" where ");
//			sb.append(part[0]).append(" ");
//			sb.append(attr).append(" like '").append(value).append("'");
//		}
		sb.append("select count(id) ");
		String line = mountHqlByType(like, "and");
		sb.append(" ");
		String[] aux;
		if(hql.contains(" where")){
			aux = hql.split(" where");
			sb.append(aux[0]).append(" ");
			sb.append(line);
			sb.append(" ").append(hql);
		} else if(hql.contains(" order by")){
			aux = hql.split(" order by");
			sb.append(aux[0]).append(" ");
			sb.append(" where ");
			sb.append(line);
			sb.append(" ").append(hql);
		} else {
			sb.append(hql);
			sb.append(" where ");			
			sb.append(line);
		}
			
		
		return sb.toString();
	}
	
	
	public static final String createCountHqlFilterAll(String hql, String[] nomeColunas, String[] tipoColunas, String value) {
		StringBuffer sb = new StringBuffer();
		sb.append("select count(id) ");
		String line = mountHqlByTypeString(nomeColunas, tipoColunas, value);
		sb.append(" ");
		String[] part;
		if(hql.contains(" where")){
			part = hql.split(" where");
			sb.append(part[0]).append(" ");
			sb.append(line);
			sb.append(" ").append(hql);
		} else if(hql.contains(" order by")){
			part = hql.split(" order by");
			sb.append(part[0]).append(" ");
			sb.append(" where ");
			sb.append(line);
			sb.append(" ").append(hql);
		} else {
			sb.append(hql);
			sb.append(" where ");			
			sb.append(line);
		}
		
		return sb.toString();
	}
	
	public static final String createFieldsHqlLike(String hql, String[] fields, String[] like) {
		return createFieldsHqlLike(hql, fields, like, "and");
	}
	
	/**
	 * Pega uma consulta e a faz sob demanda e concatena com like. Usado para count.
	 * 
	 * @param hql
	 * 		Hql da consulta
	 * @param fields
	 * 		Campos que serão projetados
	 * @return
	 */
	public static final String createFieldsHqlLike(String hql, String[] fields, String[] like, String mode) {
		StringBuffer sb = new StringBuffer();
		int size = fields.length;
		int cont = 0;
		sb.append("select ");
		for(String f : fields){
			sb.append(f).append(" as ").append(f);
			if(cont + 1 < size){
				sb.append(", ");
				cont++;
			}
		}
		
		String line = mountHqlByType(like, mode);
		sb.append(" ");
		String[] part;
		if(hql.contains(" where")){
			part = hql.split(" where");
			sb.append(part[0]).append(" ");
			sb.append(line);
			sb.append(" ").append(hql);
		} else if(hql.contains(" order by")){
			part = hql.split(" order by");
			sb.append(part[0]).append(" ");
			sb.append(" where ");
			sb.append(line);
			sb.append(" ").append(hql);
		} else {
			sb.append(hql);
			sb.append(" where ");			
			sb.append(line);
		}
		
		return sb.toString();
	}
	
	private static String mountHqlByType(String[] like, String mode) {
		StringBuffer sb = new StringBuffer();
		int size = like.length;
		int cont = 0; 
		
		String attr;
		String type;
		String value;
		
		for(; cont < size;){
			if(cont > 0){
				sb.append(" ");
				sb.append(mode);
				sb.append(" ");
			}
			attr = like[cont++];
			type = like[cont++];
			value = like[cont++];
			sb.append(mountHqlByType(attr, type, value));
		}
		
		return sb.toString();
	}

	public static final String mountHqlByType(String attr, String type, String value){
		String line = null;
		if(type.toLowerCase().equals("date")){
			//Voltar aqui
		} else if(type.toLowerCase().equals("string")){
			line = String.format("%s like '%s'", attr, "%"+value+"%");
		} else if(type.toLowerCase().equals("boolean")){
			line = String.format("%s = %s", attr, value);
		} else if(type.toLowerCase().equals("list")){
			//Voltar aqui
		} else if(type.toLowerCase().equals("numeric") || type.toLowerCase().equals("long") || type.toLowerCase().equals("integer")){
			line = String.format("cast(%s as string) like '%s'", attr, "%"+value+"%");
			//Voltar aqui
		}
		
		return line;
	}

	public static String createFieldsHqlFilterAll(String hql, String value, String[] nomeColunas, String[] tipoColunas) {
		StringBuffer sb = new StringBuffer();
		int size = nomeColunas.length - 1;
		int cont = 0;
		sb.append("select ");
		for(String f : nomeColunas){
			if(!f.startsWith("id")){
				sb.append(f).append(" as ").append(f);
				if(cont + 1 < size){
					sb.append(", ");
					cont++;
				}
			} 
		}
		
		String line = mountHqlByTypeString(nomeColunas, tipoColunas, value);
		sb.append(" ");
		String[] part;
		if(hql.contains(" where")){
			part = hql.split(" where");
			sb.append(part[0]).append(" ");
			sb.append(line);
			sb.append(" ").append(hql);
		} else if(hql.contains(" order by")){
			part = hql.split(" order by");
			sb.append(part[0]).append(" ");
			sb.append(" where ");
			sb.append(line);
			sb.append(" ").append(hql);
		} else {
			sb.append(hql);
			sb.append(" where ");			
			sb.append(line);
		}
		
		return sb.toString();
	}

	private static String mountHqlByTypeString(String[] nomeColunas, String[] tipoColunas, String value) {
		StringBuffer line = new StringBuffer();
		int cont = 0;
		int contString = 0;
		for(String type : tipoColunas){
			if(!nomeColunas[cont].startsWith("id")){
				if(type.toLowerCase().equals("string")){
					if(contString > 0)
						line.append(" or ");
					line.append(String.format("%s like '%s'", nomeColunas[cont], "%"+value+"%"));
					contString++;
				}
			}
			cont++;
		}
		return line.toString();
	}
}