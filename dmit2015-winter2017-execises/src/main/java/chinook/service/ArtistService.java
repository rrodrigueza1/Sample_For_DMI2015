package chinook.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import chinook.entity.Artist;

@Stateful // mark this POJO as an stateful EJB. stateful is use if you want to use the object more than once
public class ArtistService {

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	// Entity manager automatically detect what entity is been handled
	private EntityManager entityManager;
	
	public void createArtist(Artist currentArtist)
	{
		// persist method is use for inserting a new record
		entityManager.persist(currentArtist);
	}
	
	public void update(Artist curentArtist)
	{
		//update the artist
		entityManager.merge(curentArtist);
		entityManager.flush();
	}
	
	public void delete(Artist currentArtist)
	{
		// remove artist
		entityManager.remove(currentArtist);
	}
	
	public Artist findOneById(int artistId)
	{
		// find a single artist by id, first parameter is the entity class to find, second argument is the artistId
		return entityManager.find(Artist.class, artistId);
	}
	
	@SuppressWarnings("unchecked")
	public List<Artist> findAll()
	{
		return entityManager.createQuery("SELECT a FROM Artist a").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Artist> findAllOrderByName()
	{
		return entityManager.createQuery("SELECT a FROM Artist a ORDER BY a.name").getResultList();
	}
	
}
