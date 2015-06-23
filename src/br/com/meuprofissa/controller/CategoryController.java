package br.com.meuprofissa.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.meuprofissa.model.bo.CategoryBo;
import br.com.meuprofissa.model.entity.Category;
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
	
	@Consumes(value="application/json")
	@Post("save")
	public void save(Category category) {
		try {
			category = categoryBo.save(category);
			result.use(Results.json()).withoutRoot().from(category).serialize();
		}catch(Exception e) {
			
		}
	}
}