package br.com.meuprofissa.model.bo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import br.com.meuprofissa.model.dao.UserDao;
import br.com.meuprofissa.model.entity.Profile;
import br.com.meuprofissa.model.entity.User;
import br.com.meuprofissa.model.exception.DaoException;
import br.com.meuprofissa.model.exception.ServiceException;
import br.com.meuprofissa.util.CryptPassword;
import br.com.meuprofissa.util.InitializeAndUnproxy;
import br.com.meuprofissa.util.SessionVariables;
import br.com.meuprofissa.util.TokenGenerator;
import br.com.meuprofissa.util.Transactional;

@RequestScoped
public class UserBo {

	@Inject
	private UserDao userDao;
	
	@Inject
	private SessionVariables sessionVariables;
	
	public UserBo() {
		
	}

	@Transactional
	public void signup(User user) throws ServiceException {
		try {
			user.setPassword(CryptPassword.crypt(user.getPassword()));
			Profile profile = new Profile();
			profile.setId(2);
			user.setProfile(profile);
			user.setCreated(new Date());
			user.setInactived(new Date());
			
			userDao.merge(user);
		}catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	public User login(User user) throws ServiceException {
		try {
			user.setPassword(CryptPassword.crypt(user.getPassword()));
			List<Criterion> criterions = Arrays.asList(new Criterion[]{Restrictions.eq("login", user.getLogin()), Restrictions.eq("password", user.getPassword())});
			user = userDao.findOne(criterions);
			
			if(user != null) {
				String loginToken = TokenGenerator.generate();
				user.setLoginToken(loginToken);
				user.setProfile(InitializeAndUnproxy.initializeAndUnproxy(user.getProfile()));
				sessionVariables.setUser(user);
				
				return user;
			}
			
			throw new ServiceException("usuario_invalido");
			
		}catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}