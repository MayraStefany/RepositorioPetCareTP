package pe.edu.pe.repositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Veterinaria;
import pe.edu.upc.repository.IVeterinariaRepository;

public class VeterinariaRepositoryImpl implements IVeterinariaRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Transactional
	@Override
	public Veterinaria insertar(Veterinaria entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public Veterinaria modificar(Veterinaria entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<Veterinaria> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<Veterinaria> listar() throws Exception {
		List<Veterinaria> mascota = new ArrayList<Veterinaria>();
		String qlString = "SELECT c FROM Veterinaria c"; // JPQL
		TypedQuery<Veterinaria> query = em.createQuery(qlString, Veterinaria.class);
		mascota = query.getResultList();
		return mascota;
	}

	@Override
	public Optional<Veterinaria> findById(Integer id) throws Exception {
		Optional<Veterinaria> mascota = Optional.empty();
		String qlString = "SELECT c FROM Veterinaria c WHERE c.idVeterinaria = ?1"; // JPQL
		TypedQuery<Veterinaria> query = em.createQuery(qlString, Veterinaria.class);
		query.setParameter(1, id);
		List<Veterinaria> mascotas = query.getResultList();

		if (mascota != null && !mascotas.isEmpty())
			mascota = Optional.of(mascotas.get(0));

		return mascota;
	}

}
