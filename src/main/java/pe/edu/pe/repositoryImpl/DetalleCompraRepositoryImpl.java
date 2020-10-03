package pe.edu.pe.repositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.DetalleCompra;
import pe.edu.upc.repository.IDetalleCompraRepository;

public class DetalleCompraRepositoryImpl implements IDetalleCompraRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Transactional
	@Override
	public DetalleCompra insertar(DetalleCompra entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public DetalleCompra modificar(DetalleCompra entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<DetalleCompra> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<DetalleCompra> listar() throws Exception {
		List<DetalleCompra> detalleCompra = new ArrayList<DetalleCompra>();
		String qlString = "SELECT c FROM DetalleCompra c"; // JPQL
		TypedQuery<DetalleCompra> query = em.createQuery(qlString, DetalleCompra.class);
		detalleCompra = query.getResultList();
		return detalleCompra;
	}

	@Override
	public Optional<DetalleCompra> findById(Integer id) throws Exception {
		Optional<DetalleCompra> detalleCompra = Optional.empty();
		String qlString = "SELECT c FROM DetalleCompra c WHERE c.idDetalleCompra = ?1"; // JPQL
		TypedQuery<DetalleCompra> query = em.createQuery(qlString, DetalleCompra.class);
		query.setParameter(1, id);
		List<DetalleCompra> DetalleCompras = query.getResultList();

		if (detalleCompra != null && !DetalleCompras.isEmpty())
			detalleCompra = Optional.of(DetalleCompras.get(0));

		return detalleCompra;
	}

}
