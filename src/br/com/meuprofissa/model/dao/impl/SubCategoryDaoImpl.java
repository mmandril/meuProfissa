package br.com.meuprofissa.model.dao.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;

import br.com.meuprofissa.model.dao.SubCategoryDao;
import br.com.meuprofissa.model.entity.SubCategory;

@RequestScoped
public class SubCategoryDaoImpl extends GenericDaoImpl<SubCategory> implements SubCategoryDao {

	public SubCategoryDaoImpl() {

	}

	@Inject
	public SubCategoryDaoImpl(Session session) {
		super(session);
	}

}