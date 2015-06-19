package br.com.meuprofissa.model.bo;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.criterion.Order;

import br.com.meuprofissa.model.dao.CategoryDao;
import br.com.meuprofissa.model.entity.Category;
import br.com.meuprofissa.model.exception.DaoException;
import br.com.meuprofissa.model.exception.ServiceException;

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