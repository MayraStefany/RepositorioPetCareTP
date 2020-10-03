package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.MedicoVeterinario;
import pe.edu.upc.repository.IMedicoVeterinarioRepository;
import pe.edu.upc.service.IMedicoVeterinarioService;

@Named
@RequestScoped
public class MedicoVeterinarioServiceImpl implements IMedicoVeterinarioService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IMedicoVeterinarioRepository mRepo;

	@Override
	public void insertar(MedicoVeterinario medicoveterinario) throws Exception {
		mRepo.insertar(medicoveterinario);
	}

	@Override
	public void eliminar(int idMedicoVeterinario) throws Exception {
		mRepo.eliminar(idMedicoVeterinario);
	}

	@Override
	public void modificar(MedicoVeterinario medicoveterinario) throws Exception {
		mRepo.modificar(medicoveterinario);

	}

	@Override
	public List<MedicoVeterinario> listar() throws Exception {
		return mRepo.listar();
	}

}
