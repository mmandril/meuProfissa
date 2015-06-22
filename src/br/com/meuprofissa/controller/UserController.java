package br.com.meuprofissa.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.meuprofissa.model.bo.UserBo;
import br.com.meuprofissa.model.entity.User;
import br.com.meuprofissa.util.MenuUtil;
import br.com.meuprofissa.util.SessionVariables;

@Controller
@Path(value={"api/user"})
public class UserController {

	@Inject
	private Result result;
	
	@Inject
	private UserBo userBo;
	
	@Inject
	private SessionVariables sessionVariables;
	
	public UserController() {
		
	}
	
	@Consumes(value = "application/json")
	@Post(value="signup")
	public void signup(User user) {
		try {
			userBo.signup(user);
			result.use(Results.status()).ok();
		}catch(Exception e) {
			result.use(Results.status()).badRequest(e.getMessage());
		}
	}
	
	@Consumes(value = "application/json")
	@Post(value="login")
	public void login(User user) {
		try {
			user = userBo.login(user);
			result.use(Results.json()).withoutRoot().from(user).include("profile").exclude("password").serialize();
		}catch(Exception e) {
			result.use(Results.status()).badRequest(e.getMessage());
		}
	}
	
	@Consumes(value = "application/json")
	@Get(value="getMenu/{token}")
	public void getMenu(String token) {
		try {
			result.use(Results.json()).withoutRoot().from(MenuUtil.getMenu(token, sessionVariables.getUser())).serialize();
		}catch(Exception e) {
			result.use(Results.status()).badRequest(e.getMessage());
		}
	}
}