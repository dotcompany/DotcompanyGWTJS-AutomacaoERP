package br.com.dotcompany.to;

import java.io.Serializable;

/**
 * TO base
 * 
 * @author sergio
 * 
 */
@SuppressWarnings("serial")
public abstract class TransferObject implements Serializable {

	public abstract Serializable getKey(); 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getKey() == null) ? 0 : getKey().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransferObject other = (TransferObject) obj;
		if (getKey() == null) {
			if (other.getKey() != null)
				return false;
		} else if (!getKey().equals(other.getKey()))
			return false;
		return true;
	}

}