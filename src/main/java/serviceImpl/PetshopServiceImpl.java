package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Petshop;
import pe.edu.upc.repository.IPetshopRepository;
import pe.edu.upc.service.IPetshopService;

@Named
@RequestScoped
public class PetshopServiceImpl implements IPetshopService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IPetshopRepository pRepo;

	@Override
	public void insertar(Petshop petshop) throws Exception {
		pRepo.insertar(petshop);
	}

	@Override
	public void eliminar(int idPetshop) throws Exception{
		pRepo.eliminar(idPetshop);
	}

	@Override
	public void modificar(Petshop petshop) throws Exception{
		pRepo.modificar(petshop);
	}

	@Override
	public List<Petshop> listar() throws Exception{
		return pRepo.listar();
	}

}
