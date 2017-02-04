package chinook.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import chinook.entity.Shipper;

@Stateful
public class ShipperServices {

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	public void add(Shipper newShipper) {
		entityManager.persist(newShipper);
	}
	
	public Shipper findOneById(int shipperId) {
		return entityManager.find(Shipper.class, shipperId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Shipper> findAllOrderByName() {
		return entityManager.createQuery("SELECT a FROM Shipper a ORDER by a.companyName").getResultList();
	}
	
	public void update(Shipper currentShipper) {
		entityManager.merge(currentShipper);
		entityManager.flush();
	}
	
	public void delete(Shipper currentShipper) {
		entityManager.remove(currentShipper);
	}
	
	public void delete(int shipperId) {
		Shipper currentShipper = findOneById(shipperId);
		delete(currentShipper);
	}
	
	
}
