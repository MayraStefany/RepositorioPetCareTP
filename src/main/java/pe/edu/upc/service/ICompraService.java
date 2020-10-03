package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Compra;

public interface ICompraService {

	public void insertar(Compra compra) throws Exception;

	public void eliminar(int idCompra) throws Exception;

	public void modificar(Compra compra) throws Exception;

	public List<Compra> listar() throws Exception;
}
