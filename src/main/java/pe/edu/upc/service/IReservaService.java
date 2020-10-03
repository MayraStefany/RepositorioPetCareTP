package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Reserva;

public interface IReservaService {

	public void insertar(Reserva reserva) throws Exception;

	public void eliminar(int idReserva) throws Exception;

	public void modificar(Reserva reserva) throws Exception;

	public List<Reserva> listar() throws Exception;

}
