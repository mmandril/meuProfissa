package br.com.meuprofissa.model.bo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.meuprofissa.model.dao.UserDao;
import br.com.meuprofissa.model.entity.Profile;
import br.com.meuprofissa.model.entity.User;
import br.com.meuprofissa.model.exception.DaoException;
import br.com.meuprofissa.model.exception.ServiceException;
import br.com.meuprofissa.util.CryptPassword;
import br.com.meuprofissa.util.Transactional;

@RequestScoped
public class UserBo {

	@Inject
	private UserDao userDao;
	
	public UserBo() {
		
	}

	@Transactional
	public void signup(User user) throws ServiceException {
		try {
			user.setPassword(CryptPassword.crypt(user.getPassword()));
			Profile profile = new Profile();
			profile.setId(2);
			user.setProfile(profile);
			
			userDao.merge(user);
		}catch(DaoException e) {
			throw new ServiceException(e);
		}
	}
}