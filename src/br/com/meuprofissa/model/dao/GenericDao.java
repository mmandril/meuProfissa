package br.com.meuprofissa.model.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import br.com.meuprofissa.model.exception.DaoException;

public interface GenericDao <T> {

	public List<T> listAll() throws DaoException;
	
	public List<T> listAll(List<Criterion> criterions, List<Order> orders) throws DaoException;
	
	public T getById(Integer id) throws DaoException;

	public void delete(T entity) throws DaoException;
	
	public T merge(T entity) throws DaoException;
	
	public T save(T entity) throws DaoException;
	
	public T update(T entity) throws DaoException;
	
	public List<T> listAllPaginado(List<Criterion> criterions, List<Order> orders, int pagina) throws DaoException;
}
