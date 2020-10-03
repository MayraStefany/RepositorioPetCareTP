package pe.edu.pe.repositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.DetalleReceta;
import pe.edu.upc.repository.IDetalleRecetaRepository;

public class DetalleRecetaRepositoryImpl implements IDetalleRecetaRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Transactional
	@Override
	public DetalleReceta insertar(DetalleReceta entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public DetalleReceta modificar(DetalleReceta entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<DetalleReceta> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<DetalleReceta> listar() throws Exception {
		List<DetalleReceta> detalleReceta = new ArrayList<DetalleReceta>();
		String qlString = "SELECT c FROM DetalleReceta c"; // JPQL
		TypedQuery<DetalleReceta> query = em.createQuery(qlString, DetalleReceta.class);
		detalleReceta = query.getResultList();
		return detalleReceta;
	}

	@Override
	public Optional<DetalleReceta> findById(Integer id) throws Exception {
		Optional<DetalleReceta> detalleReceta = Optional.empty();
		String qlString = "SELECT c FROM DetalleReceta c WHERE c.idDetalleReceta = ?1"; // JPQL
		TypedQuery<DetalleReceta> query = em.createQuery(qlString, DetalleReceta.class);
		query.setParameter(1, id);
		List<DetalleReceta> DetalleRecetas = query.getResultList();

		if (detalleReceta != null && !DetalleRecetas.isEmpty())
			detalleReceta = Optional.of(DetalleRecetas.get(0));

		return detalleReceta;
	}

}
