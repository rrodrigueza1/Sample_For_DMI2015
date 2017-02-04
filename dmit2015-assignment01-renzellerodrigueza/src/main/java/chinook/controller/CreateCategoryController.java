package chinook.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.model.UploadedFile;

import chinook.entity.Category;
import chinook.service.CategoryServices;


@Named
@ViewScoped
public class CreateCategoryController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoryServices categoryService;
	
	private Category currentCategory = new Category();
	
	private UploadedFile uploadedFile;
	
	public void upload()
	{
		currentCategory.setPicture(uploadedFile.getContents());
	}
	
	public void createCategory() {
		categoryService.add(currentCategory);
		currentCategory = new Category();
		Messages.addGlobalInfo("Successfully created new Category");
	}

	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	

}
