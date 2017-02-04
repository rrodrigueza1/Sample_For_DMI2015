package chinook.controller;

import java.io.Serializable;

import javax.ejb.EJBTransactionRolledbackException;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.Box.Filler;

import org.omnifaces.util.Messages;
import org.primefaces.model.UploadedFile;

import chinook.entity.Category;
import chinook.service.CategoryServices;

@Named
@ViewScoped
public class EditCategoryController implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoryServices categoryService;
	private int categoryId;
	private Category currentCategory;
	private UploadedFile uploadedFile;
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	public void upload()
	{
	   
		 if(uploadedFile != null) {
	            Messages.addFlashGlobalInfo("File Uploaded");
	        }
		 else
		 {
			 Messages.addGlobalError("Upload Failed");
		 }

	}

	
	public void findCategoryById() {
		if (categoryId <= 0) {
			Messages.addGlobalError("Bad request. Please use a link within the system");
			return;
		}
		
		Category queryResult = categoryService.findOneById(categoryId);
		if ( queryResult == null ) {
			Messages.addGlobalError("Bad request. Unknown category id {0}", categoryId);
			return;
		}
		
		currentCategory = queryResult;		
		
	}
	
	public String updateCategory() {
		
		
		categoryService.update(currentCategory);
		currentCategory = null;
		Messages.addFlashGlobalInfo("Updated was successful.");

		return "/public/viewCategories?faces-redirect=true";
	}
	
	public String removeCategory() {
		String outcome = "/public/viewCategories?faces-redirect=true";
		try {
			categoryService.delete(currentCategory);
			currentCategory = null;
			Messages.addFlashGlobalInfo("Delete was successful.");
		} catch (EJBTransactionRolledbackException e) {
			Messages.addGlobalError("This category cannot be deleted.");
			outcome = null;
		} catch (Exception e) {
			Messages.addGlobalError("Delete was not successful.");
			outcome = null;
		}
		return outcome;
	}
	
	public String cancel() {
		currentCategory = null;
		return "/public/viewCategories?faces-redirect=true";
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}


}
