package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Cliente;

public interface IClienteService {

	public void insertar(Cliente cliente) throws Exception;

	public void eliminar(int idCliente) throws Exception;

	public void modificar(Cliente cliente) throws Exception;

	public List<Cliente> listar() throws Exception;
}
