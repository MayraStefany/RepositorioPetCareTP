package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Atencion;

public interface IAtencionService {

	public void insertar(Atencion atencion) throws Exception;

	public void eliminar(int idAtencion) throws Exception;

	public void modificar(Atencion atencion) throws Exception;

	public List<Atencion> listar() throws Exception;

}
