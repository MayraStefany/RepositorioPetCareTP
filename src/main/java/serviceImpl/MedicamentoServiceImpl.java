package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Medicamento;
import pe.edu.upc.repository.IMedicamentoRepository;
import pe.edu.upc.service.IMedicamentoService;

@Named
@RequestScoped
public class MedicamentoServiceImpl implements IMedicamentoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IMedicamentoRepository mRepo;

	@Override
	public void insertar(Medicamento medicamento) throws Exception {
		mRepo.insertar(medicamento);
	}

	@Override
	public void eliminar(int idMedicamento) throws Exception {
		mRepo.eliminar(idMedicamento);
	}

	@Override
	public void modificar(Medicamento medicamento) throws Exception {
		mRepo.modificar(medicamento);
	}

	@Override
	public List<Medicamento> listar() throws Exception {
		return mRepo.listar();
	}

}
