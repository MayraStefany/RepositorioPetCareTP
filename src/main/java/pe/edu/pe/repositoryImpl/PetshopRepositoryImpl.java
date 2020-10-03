package pe.edu.pe.repositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Petshop;
import pe.edu.upc.repository.IPetshopRepository;

public class PetshopRepositoryImpl implements IPetshopRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Transactional
	@Override
	public Petshop insertar(Petshop entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public Petshop modificar(Petshop entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<Petshop> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<Petshop> listar() throws Exception {
		List<Petshop> Petshops = new ArrayList<Petshop>();
		String qlString = "SELECT c FROM Petshop c"; // JPQL
		TypedQuery<Petshop> query = em.createQuery(qlString, Petshop.class);
		Petshops = query.getResultList();
		return Petshops;
	}

	@Override
	public Optional<Petshop> findById(Integer id) throws Exception {
		Optional<Petshop> Petshopss = Optional.empty();
		String qlString = "SELECT c FROM Petshop c WHERE c.idPetshop = ?1"; // JPQL
		TypedQuery<Petshop> query = em.createQuery(qlString, Petshop.class);
		query.setParameter(1, id);
		List<Petshop> Petshops = query.getResultList();

		if (Petshopss != null && !Petshops.isEmpty())
			Petshopss = Optional.of(Petshops.get(0));

		return Petshopss;
	}

}
