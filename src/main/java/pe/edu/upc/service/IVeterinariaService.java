package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Veterinaria;

public interface IVeterinariaService {

	public void insertar(Veterinaria veterinaria) throws Exception;

	public void eliminar(int idVeterinaria) throws Exception;

	public void modificar(Veterinaria veterinaria) throws Exception;

	public List<Veterinaria> listar() throws Exception;
}
