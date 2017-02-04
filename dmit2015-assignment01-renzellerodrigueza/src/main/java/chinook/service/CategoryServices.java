package chinook.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import chinook.entity.Category;

@Stateful
public class CategoryServices {

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	public void add(Category newCategory) {
		entityManager.persist(newCategory);
	}
	
	public Category findOneById(int categoryId) {
		return entityManager.find(Category.class, categoryId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Category> findAllOrderByName() {
		return entityManager.createQuery("SELECT c FROM Category c ORDER by c.categoryName").getResultList();
	}
	
	public void update(Category currentCategory) {
		entityManager.merge(currentCategory);
		entityManager.flush();
	}
	
	public void delete(Category currentCategory) {
		entityManager.remove(currentCategory);
	}
	
	public void delete(int categoryId) {
		Category currentCategory = findOneById(categoryId);
		delete(currentCategory);
	}
	
	
}
