package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Atencion;
import pe.edu.upc.repository.IAtencionRepository;
import pe.edu.upc.service.IAtencionService;

@Named
@RequestScoped
public class AtencionServiceImpl implements IAtencionService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IAtencionRepository aRepo;

	@Override
	public void insertar(Atencion atencion) throws Exception {
		aRepo.insertar(atencion);
	}

	@Override
	public void eliminar(int idAtencion) throws Exception {
		aRepo.eliminar(idAtencion);
	}

	@Override
	public void modificar(Atencion atencion) throws Exception {
		aRepo.modificar(atencion);
	}

	@Override
	public List<Atencion> listar() throws Exception {
		return aRepo.listar();
	}

}
