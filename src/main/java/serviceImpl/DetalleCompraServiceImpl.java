package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.DetalleCompra;
import pe.edu.upc.repository.IDetalleCompraRepository;
import pe.edu.upc.service.IDetalleCompraService;

@Named
@RequestScoped
public class DetalleCompraServiceImpl implements IDetalleCompraService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IDetalleCompraRepository dcRepo;

	@Override
	public void insertar(DetalleCompra detallecompra) throws Exception {
		dcRepo.insertar(detallecompra);
	}

	@Override
	public void eliminar(int idDetalleCompra) throws Exception {
		dcRepo.eliminar(idDetalleCompra);
	}

	@Override
	public void modificar(DetalleCompra detallecompra) throws Exception {
		dcRepo.modificar(detallecompra);
	}

	@Override
	public List<DetalleCompra> listar() throws Exception {
		return dcRepo.listar();
	}

}
