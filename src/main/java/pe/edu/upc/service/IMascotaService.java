package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Mascota;

public interface IMascotaService {

	public void insertar(Mascota mascota) throws Exception;

	public void eliminar(int idMascota) throws Exception;

	public void modificar(Mascota mascota) throws Exception;

	public List<Mascota> listar() throws Exception;
}
