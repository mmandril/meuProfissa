package br.com.meuprofissa.model.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.enterprise.context.Dependent;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import br.com.meuprofissa.model.dao.GenericDao;
import br.com.meuprofissa.model.exception.DaoException;


@Dependent
public class GenericDaoImpl<T> implements GenericDao<T>{

	private Class<T> type;
	private Session session;
	
	public GenericDaoImpl() {
		
	}

	@SuppressWarnings("unchecked")
	public GenericDaoImpl(Session session) {
		this.session = session;
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass() ).getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll() throws DaoException {
		Criteria crit = session.createCriteria(type);
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll(List<Criterion> criterions, List<Order> orders) throws DaoException {
		Criteria crit = session.createCriteria(type);

		if(criterions != null) {
			for(Criterion criterion : criterions) {
				crit.add(criterion);
			}
		}

		if(orders != null) {
			for(Order order : orders) {
				crit.addOrder(order);
			}
		}

		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Integer id) throws DaoException {
		return (T) session.get(type, id);
	}

	@Override
	public void delete(T entity) throws DaoException {
		session.delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T merge(T entity) throws DaoException {
		return (T) session.merge(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T save(T entity) throws DaoException {
		return (T) session.save(entity);
	}

	@Override
	public T update(T entity) throws DaoException {
		session.update(entity);
		return entity;
	}
	
	/* (non-Javadoc)
	 * @see br.com.viajaclub.modelo.dao.DaoGenerico#listAllPaginado(java.util.List, java.util.List, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAllPaginado(List<Criterion> criterions, List<Order> orders, int pagina) throws DaoException {
		Criteria crit = session.createCriteria(type);

		if(criterions != null) {
			for(Criterion criterion : criterions) {
				crit.add(criterion);
			}
		}

		if(orders != null) {
			for(Order order : orders) {
				crit.addOrder(order);
			}
		}
		
		crit.setMaxResults(10);
		crit.setFirstResult(pagina * 10);

		return crit.list();
	}
	
	public Session getSession() {
		return session;
	}
}