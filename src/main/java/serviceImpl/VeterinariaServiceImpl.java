package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Veterinaria;
import pe.edu.upc.repository.IVeterinariaRepository;
import pe.edu.upc.service.IVeterinariaService;

@Named
@RequestScoped
public class VeterinariaServiceImpl implements IVeterinariaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IVeterinariaRepository vRepo;

	@Override
	public void insertar(Veterinaria veterinaria) throws Exception {
		vRepo.insertar(veterinaria);
	}

	@Override
	public void eliminar(int idVeterinaria) throws Exception {
		vRepo.eliminar(idVeterinaria);
	}

	@Override
	public void modificar(Veterinaria veterinaria) throws Exception {
		vRepo.modificar(veterinaria);
	}

	@Override
	public List<Veterinaria> listar() throws Exception {
		return vRepo.listar();
	}

}
