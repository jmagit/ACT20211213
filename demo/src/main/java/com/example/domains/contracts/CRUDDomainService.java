package com.example.domains.contracts;

import java.util.List;

import com.example.domains.entities.Entidad;

public interface CRUDDomainService<E extends Entidad<E>, K> {
	List<E> getAll();
	E getOne(K id);
	
	void add(E item);
	void modify(E item);
	void delete(E item);
	void deleteById(K id);
	
	default boolean isValid(E item) { return item.isValid(); }
	default boolean isInvalid(E item) { return item.isInvalid(); }
}
