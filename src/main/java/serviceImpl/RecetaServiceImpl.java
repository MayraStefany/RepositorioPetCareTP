package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Receta;
import pe.edu.upc.repository.IRecetaRepository;
import pe.edu.upc.service.IRecetaService;

@Named
@RequestScoped
public class RecetaServiceImpl implements IRecetaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IRecetaRepository rRepo;

	@Override
	public void insertar(Receta receta) throws Exception {
		rRepo.insertar(receta);
	}

	@Override
	public void eliminar(int idReceta) throws Exception {
		rRepo.eliminar(idReceta);
	}

	@Override
	public void modificar(Receta receta) throws Exception {
		rRepo.modificar(receta);
	}

	@Override
	public List<Receta> listar() throws Exception {
		return rRepo.listar();
	}

}
