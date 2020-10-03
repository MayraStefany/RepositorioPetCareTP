package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.repository.IClienteRepository;
import pe.edu.upc.service.IClienteService;

@Named
@RequestScoped
public class ClienteServiceImpl implements IClienteService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IClienteRepository cRepo;

	@Override
	public void insertar(Cliente cliente) throws Exception {
		cRepo.insertar(cliente);
	}

	@Override
	public void eliminar(int idCliente) throws Exception {
		cRepo.eliminar(idCliente);
	}

	@Override
	public void modificar(Cliente cliente) throws Exception {
		cRepo.modificar(cliente);
	}

	@Override
	public List<Cliente> listar() throws Exception {
		return cRepo.listar();
	}

}
