package br.com.meuprofissa.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.meuprofissa.model.bo.CategoryBo;
import br.com.meuprofissa.model.exception.ServiceException;

@Controller
@Path(value={"api/category"})
public class CategoryController {
	
	@Inject
	private Result result;

	@Inject
	private CategoryBo categoryBo;
	
	public CategoryController() {
		
	}
	
	@Get("listAll")
	public void listAll() throws ServiceException {
		result.use(Results.json()).withoutRoot().from(categoryBo.listAll()).serialize();
	}
}