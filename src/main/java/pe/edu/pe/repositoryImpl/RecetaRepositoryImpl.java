package pe.edu.pe.repositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Receta;
import pe.edu.upc.repository.IRecetaRepository;

public class RecetaRepositoryImpl implements IRecetaRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Transactional
	@Override
	public Receta insertar(Receta entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public Receta modificar(Receta entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<Receta> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<Receta> listar() throws Exception {
		List<Receta> Recetas = new ArrayList<Receta>();
		String qlString = "SELECT c FROM Receta c"; // JPQL
		TypedQuery<Receta> query = em.createQuery(qlString, Receta.class);
		Recetas = query.getResultList();
		return Recetas;
	}

	@Override
	public Optional<Receta> findById(Integer id) throws Exception {
		Optional<Receta> Recetas = Optional.empty();
		String qlString = "SELECT c FROM Receta c WHERE c.idReceta = ?1"; // JPQL
		TypedQuery<Receta> query = em.createQuery(qlString, Receta.class);
		query.setParameter(1, id);
		List<Receta> Recetass = query.getResultList();

		if (Recetas != null && !Recetass.isEmpty())
			Recetas = Optional.of(Recetass.get(0));

		return Recetas;
	}

}
