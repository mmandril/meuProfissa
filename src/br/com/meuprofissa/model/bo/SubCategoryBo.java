package br.com.meuprofissa.model.bo;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.meuprofissa.model.dao.SubCategoryDao;
import br.com.meuprofissa.model.entity.SubCategory;

@RequestScoped
public class SubCategoryBo {

	@Inject
	private SubCategoryDao subCategoryDao;
	
	public SubCategoryBo() {
		
	}

	public List<SubCategory> list(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}
}
