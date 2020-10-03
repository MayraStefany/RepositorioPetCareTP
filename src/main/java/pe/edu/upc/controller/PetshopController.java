package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Petshop;
import pe.edu.upc.service.IPetshopService;

@Named
@RequestScoped
public class PetshopController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IPetshopService pService;
	private Petshop petshop;
	List<Petshop> listaPetshops;

	@PostConstruct
	public void init() {
		this.listaPetshops = new ArrayList<Petshop>();
		this.petshop = new Petshop();
		this.listPetshop();
	}

	public String nuevoPetshop() {
		this.setPetshop(new Petshop());
		return "petshop.xhtml";
	}

	public void insertar() {
		try {
			pService.insertar(petshop);
			limpiarPetshop();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listPetshop() {
		try {
			listaPetshops = pService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarPetshop() {
		this.init();
	}

	public void eliminar(Petshop petshop) {
		try {
			pService.eliminar(petshop.getIdPetshop());
			listPetshop();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String ModifPetshop(Petshop _pet) {
		this.setPetshop(_pet);
		return "petshop2.xhtml";

	}

	public void modificar() {
		try {
			pService.modificar(this.petshop);
			limpiarPetshop();
			this.listPetshop();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String detallesPetshop(Petshop _Petshop) {
		this.setPetshop(_Petshop);
		return "detallePetshop.xhtml";
	}
	// get y set

	public IPetshopService getpService() {
		return pService;
	}

	public void setpService(IPetshopService pService) {
		this.pService = pService;
	}

	public Petshop getPetshop() {
		return petshop;
	}

	public void setPetshop(Petshop petshop) {
		this.petshop = petshop;
	}

	public List<Petshop> getListaPetshops() {
		return listaPetshops;
	}

	public void setListaPetshops(List<Petshop> listaPetshops) {
		this.listaPetshops = listaPetshops;
	}

}
