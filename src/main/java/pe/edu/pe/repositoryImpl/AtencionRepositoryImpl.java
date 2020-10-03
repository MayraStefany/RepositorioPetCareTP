package pe.edu.pe.repositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Atencion;
import pe.edu.upc.repository.IAtencionRepository;

@Named
@ApplicationScoped
public class AtencionRepositoryImpl implements IAtencionRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Override
	public List<Atencion> listar() throws Exception {
		List<Atencion> atencion = new ArrayList<Atencion>();
		String qlString = "SELECT c FROM Atencion c"; // JPQL
		TypedQuery<Atencion> query = em.createQuery(qlString, Atencion.class);
		atencion = query.getResultList();
		return atencion;
	}

	@Transactional
	@Override
	public Atencion insertar(Atencion entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public Atencion modificar(Atencion entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<Atencion> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public Optional<Atencion> findById(Integer id) throws Exception {
		Optional<Atencion> atencion = Optional.empty();
		String qlString = "SELECT c FROM Atencion c WHERE c.idAtencion = ?1"; // JPQL
		TypedQuery<Atencion> query = em.createQuery(qlString, Atencion.class);
		query.setParameter(1, id);
		List<Atencion> atencions = query.getResultList();

		if (atencion != null && !atencions.isEmpty())
			atencion = Optional.of(atencions.get(0));

		return atencion;
	}

}
