package br.com.meuprofissa.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.meuprofissa.model.bo.SubCategoryBo;

@Controller
@Path(value={"api/subCategory"})
public class SubCategoryController {

	@Inject
	private SubCategoryBo subCategoryBo;
	
	@Inject
	private Result result;
	
	public SubCategoryController() {
		
	}
	
	@Consumes(value="application/json")
	@Get(value={"listAll/{categoryId}"})
	public void list(String categoryId) {
		try {
			result.use(Results.json()).withoutRoot().from(subCategoryBo.list(categoryId)).serialize();
		}catch(Exception e) {
			
		}
	}
}
