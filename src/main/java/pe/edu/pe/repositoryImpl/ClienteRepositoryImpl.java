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

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.repository.IClienteRepository;

@Named
@ApplicationScoped
public class ClienteRepositoryImpl implements IClienteRepository, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "ProyectoAlarcon")
	private EntityManager em;

	@Transactional
	@Override
	public Cliente insertar(Cliente entity) throws Exception {
		em.persist(entity);
		return entity;
	}

	@Transactional
	@Override
	public Cliente modificar(Cliente entity) throws Exception {
		em.merge(entity);
		return entity;
	}

	@Transactional
	@Override
	public void eliminar(Integer id) throws Exception {
		Optional<Cliente> optional = findById(id);
		if (optional.isPresent())
			em.remove(optional.get());
	}

	@Override
	public List<Cliente> listar() throws Exception {
		List<Cliente> cliente = new ArrayList<Cliente>();
		String qlString = "SELECT c FROM Cliente c"; // JPQL
		TypedQuery<Cliente> query = em.createQuery(qlString, Cliente.class);
		cliente = query.getResultList();
		return cliente;
	}

	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		Optional<Cliente> cliente = Optional.empty();
		String qlString = "SELECT c FROM Cliente c WHERE c.idCliente = ?1"; // JPQL
		TypedQuery<Cliente> query = em.createQuery(qlString, Cliente.class);
		query.setParameter(1, id);
		List<Cliente> Clientes = query.getResultList();

		if (cliente != null && !Clientes.isEmpty())
			cliente = Optional.of(Clientes.get(0));

		return cliente;
	}

}
