package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Receta;

public interface IRecetaService {

	public void insertar(Receta receta) throws Exception;

	public void eliminar(int idReceta) throws Exception;

	public void modificar(Receta receta) throws Exception;

	public List<Receta> listar() throws Exception;
}
