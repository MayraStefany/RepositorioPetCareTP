package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Mascota;
import pe.edu.upc.repository.IMascotaRepository;
import pe.edu.upc.service.IMascotaService;

@Named
@RequestScoped
public class MascotaServiceImpl implements IMascotaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IMascotaRepository mR;

	@Override
	public void insertar(Mascota mascota) throws Exception {
		mR.insertar(mascota);
	}

	@Override
	public void eliminar(int idMascota) throws Exception {
		mR.eliminar(idMascota);
	}

	@Override
	public void modificar(Mascota mascota) throws Exception {
		mR.modificar(mascota);
	}

	@Override
	public List<Mascota> listar() throws Exception {
		return mR.listar();
	}

}
