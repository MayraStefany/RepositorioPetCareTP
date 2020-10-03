package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Medicamento;

public interface IMedicamentoService {

	public void insertar(Medicamento medicamento) throws Exception;

	public void eliminar(int idMedicamento) throws Exception;

	public void modificar(Medicamento medicamento) throws Exception;

	public List<Medicamento> listar() throws Exception;

}
