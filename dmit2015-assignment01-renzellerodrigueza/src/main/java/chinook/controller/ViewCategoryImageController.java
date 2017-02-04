package chinook.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import chinook.entity.Category;
import chinook.service.CategoryServices;

@Named
@ApplicationScoped
public class ViewCategoryImageController implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private CategoryServices categoryService;
	
	public byte[] getImage(int id) throws IOException {
		Category category = categoryService.findOneById(id);
        return category.getPicture();
    }
	
	
}
