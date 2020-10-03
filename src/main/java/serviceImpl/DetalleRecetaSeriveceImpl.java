package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.DetalleReceta;
import pe.edu.upc.repository.IDetalleRecetaRepository;
import pe.edu.upc.service.IDetalleRecetaService;

@Named
@RequestScoped
public class DetalleRecetaSeriveceImpl implements IDetalleRecetaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IDetalleRecetaRepository drRepo;

	@Override
	public void insertar(DetalleReceta detallereceta) throws Exception {
		drRepo.insertar(detallereceta);
	}

	@Override
	public void eliminar(int idDetalleReceta) throws Exception {
		drRepo.eliminar(idDetalleReceta);
	}

	@Override
	public void modificar(DetalleReceta detallereceta) throws Exception {
		drRepo.modificar(detallereceta);
	}

	@Override
	public List<DetalleReceta> listar() throws Exception {
		return drRepo.listar();
	}

}
