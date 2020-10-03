package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Producto;

public interface IProductoService {

	public void insertar(Producto producto) throws Exception;

	public void eliminar(int idProducto) throws Exception;

	public void modificar(Producto producto) throws Exception;

	public List<Producto> listar() throws Exception;
}
