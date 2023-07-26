package ups.edu.ec.BDan1.datos;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import ups.edu.ec.BDan1.modelo.Persona;

@Stateless
public class personaDao implements Serializable{
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public void update(Persona persona) {
		em.merge(persona);
	}
	
	public Persona readInt(int id) {
		Persona p = em.find(Persona.class, id);
		return p;
	}
	
	public Persona readString(String id) {
		Persona p = em.find(Persona.class, id);
		return p;
	}
	
	public Persona read(String id) {
		Persona p = em.find(Persona.class, id);
		return p;
	}
	
	public void deleteString(Persona p) {
		Persona persona = em.find(Persona.class, p.getId());
		if(persona != null) {
			em.remove(persona);
		}else {
			throw new IllegalArgumentException("No se encontro id" + p.getId());
		}
		
	}
	
	public void delete(int codigo) {
		Persona p = em.find(Persona.class, codigo);
		em.remove(p);
	}
	
	public List<Persona> getAll(){
		String jpql = "SELECT p FROM Persona p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}






