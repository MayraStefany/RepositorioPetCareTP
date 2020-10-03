package pe.edu.pe.repositoryImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import pe.edu.upc.entity.Medicamento;
import pe.edu.upc.repository.IMedicamentoRepository;

public class MedicamentoRepositoryImpl implements IMedicamentoRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Transactional
	@Override
	public Medicamento insertar(Medicamento entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public Medicamento modificar(Medicamento entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<Medicamento> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<Medicamento> listar() throws Exception {
		List<Medicamento> medicamento = new ArrayList<Medicamento>();
		String qlString = "SELECT c FROM Medicamento c"; // JPQL
		TypedQuery<Medicamento> query = em.createQuery(qlString, Medicamento.class);
		medicamento = query.getResultList();
		return medicamento;
	}

	@Override
	public Optional<Medicamento> findById(Integer id) throws Exception {
		Optional<Medicamento> medicamento = Optional.empty();
		String qlString = "SELECT c FROM Medicamento c WHERE c.idMedicamento = ?1"; // JPQL
		TypedQuery<Medicamento> query = em.createQuery(qlString, Medicamento.class);
		query.setParameter(1, id);
		List<Medicamento> Medicamentos = query.getResultList();

		if (medicamento != null && !Medicamentos.isEmpty())
			medicamento = Optional.of(Medicamentos.get(0));

		return medicamento;
	}

}
