package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.DetalleCompra;

public interface IDetalleCompraService {

	public void insertar(DetalleCompra detallecompra) throws Exception;

	public void eliminar(int idDetalleCompra) throws Exception;

	public void modificar(DetalleCompra detallecompra) throws Exception;

	public List<DetalleCompra> listar() throws Exception;
}
