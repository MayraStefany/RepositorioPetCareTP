package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Reserva;
import pe.edu.upc.repository.IReservaRepository;
import pe.edu.upc.service.IReservaService;

@Named
@RequestScoped
public class ReservaServiceImpl implements IReservaService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IReservaRepository rRepo;

	@Override
	public void insertar(Reserva reserva) throws Exception {
		rRepo.insertar(reserva);
	}

	@Override
	public void eliminar(int idReserva) throws Exception {
		rRepo.eliminar(idReserva);
	}

	@Override
	public void modificar(Reserva reserva) throws Exception {
		rRepo.modificar(reserva);
	}

	@Override
	public List<Reserva> listar() throws Exception {
		return rRepo.listar();
	}

}
