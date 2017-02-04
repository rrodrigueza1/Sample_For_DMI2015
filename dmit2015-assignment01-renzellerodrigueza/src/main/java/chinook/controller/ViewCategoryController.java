package chinook.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import chinook.entity.Category;
import chinook.service.CategoryServices;


@Named
@RequestScoped
public class ViewCategoryController {

	@Inject
	private CategoryServices categoryService;
	
	public List<Category> getAllCategory() {
		return categoryService.findAllOrderByName();
	}
	
	 
	
}
