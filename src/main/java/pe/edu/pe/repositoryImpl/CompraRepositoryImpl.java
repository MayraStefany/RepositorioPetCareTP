package pe.edu.pe.repositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Compra;
import pe.edu.upc.repository.ICompraRepository;

public class CompraRepositoryImpl implements ICompraRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Transactional
	@Override
	public Compra insertar(Compra entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public Compra modificar(Compra entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<Compra> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<Compra> listar() throws Exception {
		List<Compra> compra = new ArrayList<Compra>();
		String qlString = "SELECT c FROM Compra c"; // JPQL
		TypedQuery<Compra> query = em.createQuery(qlString, Compra.class);
		compra = query.getResultList();
		return compra;
	}

	@Override
	public Optional<Compra> findById(Integer id) throws Exception {
		Optional<Compra> compra = Optional.empty();
		String qlString = "SELECT c FROM Compra c WHERE c.idCompra = ?1"; // JPQL
		TypedQuery<Compra> query = em.createQuery(qlString, Compra.class);
		query.setParameter(1, id);
		List<Compra> Compras = query.getResultList();

		if (compra != null && !Compras.isEmpty())
			compra = Optional.of(Compras.get(0));

		return compra;
	}

}
