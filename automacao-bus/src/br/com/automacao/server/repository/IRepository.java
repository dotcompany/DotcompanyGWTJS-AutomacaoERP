package br.com.automacao.server.repository;

import java.util.Iterator;

import br.com.automacao.shared.fo.FileObjectPersist;

public interface IRepository<T extends FileObjectPersist> {
	public void put(T value);
	public Iterator<T> getItens();
	public void remove(String value);
}