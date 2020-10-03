package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Veterinaria;
import pe.edu.upc.service.IVeterinariaService;

@Named
@RequestScoped
public class VeterinariaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IVeterinariaService vService;
	private Veterinaria veterinaria;
	List<Veterinaria> listaVeterinarias;

	@PostConstruct
	public void init() {
		this.listaVeterinarias = new ArrayList<Veterinaria>();
		this.veterinaria = new Veterinaria();
		this.listVeterinaria();
	}

	public String nuevaVeterinaria() {
		this.setVeterinaria(new Veterinaria());
		return "veterinaria.xhtml";
	}

	public void insertar() {
		try {
			vService.insertar(veterinaria);
			limpiarVeterinaria();
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

	public void limpiarVeterinaria() {
		this.init();
	}

	public void eliminar(Veterinaria veterinaria) {
		try {
			vService.eliminar(veterinaria.getIdVeterinaria());
			listVeterinaria();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String ModifVeterinaria(Veterinaria _vet) {
		this.setVeterinaria(_vet);
		return "veterinaria2.xhtml";

	}

	public void modificar() {
		try {
			vService.modificar(this.veterinaria);
			limpiarVeterinaria();
			this.listVeterinaria();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String detallesVeterinaria(Veterinaria _Veterinaria) {
		this.setVeterinaria(_Veterinaria);
		return "detalleVeterinaria.xhtml";
	}
	// get y set

	public IVeterinariaService getvService() {
		return vService;
	}

	public void setvService(IVeterinariaService vService) {
		this.vService = vService;
	}

	public Veterinaria getVeterinaria() {
		return veterinaria;
	}

	public void setVeterinaria(Veterinaria veterinaria) {
		this.veterinaria = veterinaria;
	}

	public List<Veterinaria> getListaVeterinarias() {
		return listaVeterinarias;
	}

	public void setListaVeterinarias(List<Veterinaria> listaVeterinarias) {
		this.listaVeterinarias = listaVeterinarias;
	}

}
