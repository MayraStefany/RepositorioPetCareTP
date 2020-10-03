package pe.edu.pe.repositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.MedicoVeterinario;
import pe.edu.upc.repository.IMedicoVeterinarioRepository;

public class MedicoVeterinarioRepositoryImpl implements IMedicoVeterinarioRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Transactional
	@Override
	public MedicoVeterinario insertar(MedicoVeterinario entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public MedicoVeterinario modificar(MedicoVeterinario entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<MedicoVeterinario> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<MedicoVeterinario> listar() throws Exception {
		List<MedicoVeterinario> medicoVeterinario = new ArrayList<MedicoVeterinario>();
		String qlString = "SELECT c FROM MedicoVeterinario c"; // JPQL
		TypedQuery<MedicoVeterinario> query = em.createQuery(qlString, MedicoVeterinario.class);
		medicoVeterinario = query.getResultList();
		return medicoVeterinario;
	}

	@Override
	public Optional<MedicoVeterinario> findById(Integer id) throws Exception {
		Optional<MedicoVeterinario> medicoVeterinario = Optional.empty();
		String qlString = "SELECT c FROM MedicoVeterinario c WHERE c.idMedicoVeterinario = ?1"; // JPQL
		TypedQuery<MedicoVeterinario> query = em.createQuery(qlString, MedicoVeterinario.class);
		query.setParameter(1, id);
		List<MedicoVeterinario> MedicoVeterinarios = query.getResultList();

		if (medicoVeterinario != null && !MedicoVeterinarios.isEmpty())
			medicoVeterinario = Optional.of(MedicoVeterinarios.get(0));

		return medicoVeterinario;
	}

}
