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

import pe.edu.upc.entity.Mascota;
import pe.edu.upc.repository.IMascotaRepository;

@Named
@ApplicationScoped
public class MascotaRepositoryImpl implements IMascotaRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Transactional
	@Override
	public Mascota insertar(Mascota entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public Mascota modificar(Mascota entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<Mascota> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<Mascota> listar() throws Exception {
		List<Mascota> mascota = new ArrayList<Mascota>();
		String qlString = "SELECT c FROM Mascota c"; // JPQL
		TypedQuery<Mascota> query = em.createQuery(qlString, Mascota.class);
		mascota = query.getResultList();
		return mascota;
	}

	@Override
	public Optional<Mascota> findById(Integer id) throws Exception {
		Optional<Mascota> mascota = Optional.empty();
		String qlString = "SELECT c FROM Mascota c WHERE c.idMascota = ?1"; // JPQL
		TypedQuery<Mascota> query = em.createQuery(qlString, Mascota.class);
		query.setParameter(1, id);
		List<Mascota> mascotas = query.getResultList();

		if (mascota != null && !mascotas.isEmpty())
			mascota = Optional.of(mascotas.get(0));

		return mascota;
	}

}
