package br.com.pto.model.dao.impl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;

import br.com.pto.model.dao.UserDao;
import br.com.pto.model.entity.User;

@RequestScoped
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {

	}

	@Inject
	public UserDaoImpl(Session session) {
		super(session);
	}

}