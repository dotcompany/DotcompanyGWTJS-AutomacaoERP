package br.com.dotcompany.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Package {

	public static final Serializable receive(InputStream is) {
		ObjectInputStream ois = null;
		Serializable s = null;
		try{
			ois = new ObjectInputStream(is);
			s = (Serializable) ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			forceClose(is);
			forceClose(ois);
		}
		return s;
	}

	public static final <T extends Serializable> void send(OutputStream os, T bean) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(os);
			oos.writeObject(bean);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			forceClose(os);
			forceClose(oos);
		}
	}
	
	static void forceClose(InputStream is){
		try {
			if(is != null)
				is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void forceClose(OutputStream os){
		try {
			if(os != null){
				os.flush();
				os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}