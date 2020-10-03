package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.MedicoVeterinario;

public interface IMedicoVeterinarioService {

	public void insertar(MedicoVeterinario medicoveterinario) throws Exception;

	public void eliminar(int idMedicoVeterinario) throws Exception;

	public void modificar(MedicoVeterinario medicoveterinario) throws Exception;

	public List<MedicoVeterinario> listar() throws Exception;
}
