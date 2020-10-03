package pe.edu.pe.repositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Producto;
import pe.edu.upc.repository.IProductoRepository;

public class ProductoRepositoryImpl implements IProductoRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Transactional
	@Override
	public Producto insertar(Producto entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public Producto modificar(Producto entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<Producto> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<Producto> listar() throws Exception {
		List<Producto> Productos = new ArrayList<Producto>();
		String qlString = "SELECT c FROM Producto c"; // JPQL
		TypedQuery<Producto> query = em.createQuery(qlString, Producto.class);
		Productos = query.getResultList();
		return Productos;
	}

	@Override
	public Optional<Producto> findById(Integer id) throws Exception {
		Optional<Producto> Productos = Optional.empty();
		String qlString = "SELECT c FROM Producto c WHERE c.idProducto = ?1"; // JPQL
		TypedQuery<Producto> query = em.createQuery(qlString, Producto.class);
		query.setParameter(1, id);
		List<Producto> Productoss = query.getResultList();

		if (Productos != null && !Productoss.isEmpty())
			Productos = Optional.of(Productoss.get(0));

		return Productos;
	}

}
