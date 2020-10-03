package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Medicamento;
import pe.edu.upc.service.IMedicamentoService;

@Named
@RequestScoped
public class MedicamentoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IMedicamentoService mService;
	private Medicamento medicamento;
	List<Medicamento> listaMedicamentos;

	@PostConstruct
	public void init() {
		this.listaMedicamentos = new ArrayList<Medicamento>();
		this.medicamento = new Medicamento();
		this.listMedicamento();
	}

	public String nuevoMedicamento() {
		this.setMedicamento(new Medicamento());
		return "medicamento.xhtml";
	}

	public void insertar() {
		try {
			mService.insertar(medicamento);
			limpiarMedicamento();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listMedicamento() {
		try {
			listaMedicamentos = mService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarMedicamento() {
		this.init();
	}

	public void eliminar(Medicamento medicamento) {
		try {
			mService.eliminar(medicamento.getIdMedicamento());
			listMedicamento();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String ModifMedicamento(Medicamento _med) {
		this.setMedicamento(_med);
		return "medicamento2.xhtml";

	}

	public void modificar() {
		try {
			mService.modificar(this.medicamento);
			limpiarMedicamento();
			this.listMedicamento();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String detallesMedicamento(Medicamento _medicamento) {
		this.setMedicamento(_medicamento);
		return "detalleMedicamento.xhtml";
	}
	// get y set

	public IMedicamentoService getmService() {
		return mService;
	}

	public void setmService(IMedicamentoService mService) {
		this.mService = mService;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public List<Medicamento> getListaMedicamentos() {
		return listaMedicamentos;
	}

	public void setListaMedicamentos(List<Medicamento> listaMedicamentos) {
		this.listaMedicamentos = listaMedicamentos;
	}

}
