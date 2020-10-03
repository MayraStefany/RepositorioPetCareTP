package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.MedicoVeterinario;
import pe.edu.upc.entity.Veterinaria;
import pe.edu.upc.service.IMedicoVeterinarioService;
import pe.edu.upc.service.IVeterinariaService;

@Named
@RequestScoped
public class MedicoVeterinarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IMedicoVeterinarioService mService;
	@Inject
	private IVeterinariaService vService;

	private MedicoVeterinario medicoVeterinario;
	private Veterinaria veterinaria;

	List<MedicoVeterinario> listaMedicoVeterinarios;
	List<Veterinaria> listaVeterinarias;

	@PostConstruct
	public void init() {
		this.listaMedicoVeterinarios = new ArrayList<MedicoVeterinario>();
		this.listaVeterinarias = new ArrayList<Veterinaria>();

		this.medicoVeterinario = new MedicoVeterinario();
		this.veterinaria = new Veterinaria();

		this.listMedicoVeterinario();
		this.listVeterinaria();
	}

	public String nuevaMedicoVeterinario() {
		this.setMedicoVeterinario(new MedicoVeterinario());
		return "medicoVeterinario.xhtml";
	}

	public void insertar() {
		try {
			mService.insertar(medicoVeterinario);
			limpiarMedicoVeterinario();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listMedicoVeterinario() {
		try {
			listaMedicoVeterinarios = mService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listVeterinaria() {
		try {
			listaVeterinarias = vService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarMedicoVeterinario() {
		this.init();
	}

	public void eliminar(MedicoVeterinario medicoVeterinario) {
		try {
			mService.eliminar(medicoVeterinario.getIdMedicoVeterinario());
			listMedicoVeterinario();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String ModifMedicoVeterinario(MedicoVeterinario _med) {
		this.setMedicoVeterinario(_med);
		return "medicoVeterinario2.xhtml";

	}

	public void modificar() {
		try {
			mService.modificar(this.medicoVeterinario);
			limpiarMedicoVeterinario();
			this.listMedicoVeterinario();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String detallesMedicoVeterinario(MedicoVeterinario _MedicoVeterinario) {
		this.setMedicoVeterinario(_MedicoVeterinario);
		return "detalleMedicoVeterinario.xhtml";
	}

	public IMedicoVeterinarioService getmService() {
		return mService;
	}

	public void setmService(IMedicoVeterinarioService mService) {
		this.mService = mService;
	}

	public IVeterinariaService getvService() {
		return vService;
	}

	public void setvService(IVeterinariaService vService) {
		this.vService = vService;
	}

	public MedicoVeterinario getMedicoVeterinario() {
		return medicoVeterinario;
	}

	public void setMedicoVeterinario(MedicoVeterinario medicoVeterinario) {
		this.medicoVeterinario = medicoVeterinario;
	}

	public Veterinaria getVeterinaria() {
		return veterinaria;
	}

	public void setVeterinaria(Veterinaria veterinaria) {
		this.veterinaria = veterinaria;
	}

	public List<MedicoVeterinario> getListaMedicoVeterinarios() {
		return listaMedicoVeterinarios;
	}

	public void setListaMedicoVeterinarios(List<MedicoVeterinario> listaMedicoVeterinarios) {
		this.listaMedicoVeterinarios = listaMedicoVeterinarios;
	}

	public List<Veterinaria> getListaVeterinarias() {
		return listaVeterinarias;
	}

	public void setListaVeterinarias(List<Veterinaria> listaVeterinarias) {
		this.listaVeterinarias = listaVeterinarias;
	}

}
