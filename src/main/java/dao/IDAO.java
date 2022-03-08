package dao;

import java.util.List;

import entity.Product;

public interface IDAO<K, O> {
	List<O> getAll();

	boolean add(O object);

	boolean edit(K id, O object);

	boolean delete(K id);
	
	Product find_by_id(K id);
}
