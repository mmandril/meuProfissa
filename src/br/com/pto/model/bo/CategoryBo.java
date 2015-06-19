package br.com.pto.model.bo;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.criterion.Order;

import br.com.pto.model.dao.CategoryDao;
import br.com.pto.model.entity.Category;
import br.com.pto.model.exception.DaoException;
import br.com.pto.model.exception.ServiceException;

@RequestScoped
public class CategoryBo {

	@Inject
	private CategoryDao categoryDao;
	
	public CategoryBo() {
		
	}

	public List<Category> listAll() throws ServiceException {
		try {
			List<Order> orders = new ArrayList<Order>();
			orders.add(Order.asc("name"));
			
			return categoryDao.listAll(null, orders);
		}catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}