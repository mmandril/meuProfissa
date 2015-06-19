package br.com.pto.model.dao.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;

import br.com.pto.model.dao.CategoryDao;
import br.com.pto.model.entity.Category;

@RequestScoped
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {

	public CategoryDaoImpl() {

	}

	@Inject
	public CategoryDaoImpl(Session session) {
		super(session);
	}

}