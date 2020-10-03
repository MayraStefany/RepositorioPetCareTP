package pe.edu.pe.repositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Reserva;
import pe.edu.upc.repository.IReservaRepository;

public class ReservaRepositoryImpl implements IReservaRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Transactional
	@Override
	public Reserva insertar(Reserva entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public Reserva modificar(Reserva entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<Reserva> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<Reserva> listar() throws Exception {
		List<Reserva> mascota = new ArrayList<Reserva>();
		String qlString = "SELECT c FROM Reserva c"; // JPQL
		TypedQuery<Reserva> query = em.createQuery(qlString, Reserva.class);
		mascota = query.getResultList();
		return mascota;
	}

	@Override
	public Optional<Reserva> findById(Integer id) throws Exception {
		Optional<Reserva> mascota = Optional.empty();
		String qlString = "SELECT c FROM Reserva c WHERE c.idReserva = ?1"; // JPQL
		TypedQuery<Reserva> query = em.createQuery(qlString, Reserva.class);
		query.setParameter(1, id);
		List<Reserva> mascotas = query.getResultList();

		if (mascota != null && !mascotas.isEmpty())
			mascota = Optional.of(mascotas.get(0));

		return mascota;
	}

}
