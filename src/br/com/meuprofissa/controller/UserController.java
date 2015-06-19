package br.com.meuprofissa.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.meuprofissa.model.bo.UserBo;
import br.com.meuprofissa.model.entity.User;

@Controller
@Path(value={"api/user"})
public class UserController {

	@Inject
	private Result result;
	
	@Inject
	private UserBo userBo;
	
	public UserController() {
		
	}
	
	@Consumes(value = "application/json")
	@Post(value="signup")
	public void signup(User user) {
		try {
			userBo.signup(user);
			result.use(Results.status()).ok();
		}catch(Exception e) {
			result.use(Results.status()).badRequest(e.getLocalizedMessage());
		}
	}
}