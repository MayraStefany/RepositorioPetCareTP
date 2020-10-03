package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Compra;
import pe.edu.upc.repository.ICompraRepository;
import pe.edu.upc.service.ICompraService;

@Named
@RequestScoped
public class CompraServiceImpl implements ICompraService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ICompraRepository cRepo;

	@Override
	public void insertar(Compra compra) throws Exception {
		cRepo.insertar(compra);
	}

	@Override
	public void eliminar(int idCompra) throws Exception {
		cRepo.eliminar(idCompra);
	}

	@Override
	public void modificar(Compra compra) throws Exception {
		cRepo.modificar(compra);
	}

	@Override
	public List<Compra> listar() throws Exception {
		return cRepo.listar();
	}

}
