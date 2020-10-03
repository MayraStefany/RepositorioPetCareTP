package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Petshop;

public interface IPetshopService {

	public void insertar(Petshop petshop) throws Exception;

	public void eliminar(int idPetshop) throws Exception;

	public void modificar(Petshop petshop) throws Exception;

	public List<Petshop> listar() throws Exception;
}
