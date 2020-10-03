package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.DetalleReceta;

public interface IDetalleRecetaService {

	public void insertar(DetalleReceta detallereceta) throws Exception;

	public void eliminar(int idDetalleReceta) throws Exception;

	public void modificar(DetalleReceta detallereceta) throws Exception;

	public List<DetalleReceta> listar() throws Exception;

}
