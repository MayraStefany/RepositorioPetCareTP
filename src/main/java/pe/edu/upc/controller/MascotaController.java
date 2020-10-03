package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Mascota;
import pe.edu.upc.service.IMascotaService;

@Named
@RequestScoped
public class MascotaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IMascotaService mService;

	private Mascota mascota;

	List<Mascota> listaMascotas;

	@PostConstruct
	public void init() {
		mascota = new Mascota();

		listaMascotas = new ArrayList<Mascota>();

		this.listMascota();
	}

	public String nuevaMascota() {
		this.setMascota(mascota);
		return "mascota.xhtml";
	}

	public void insertar() {
		try {
			mService.insertar(mascota);
			limpiarMascota();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listMascota() {
		try {
			listaMascotas = mService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarMascota() {
		this.init();
	}

	public void eliminar(Mascota mascota) {
		try {
			mService.eliminar(mascota.getIdMascota());
			listMascota();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String ModifMascota(Mascota _mas) {
		this.setMascota(_mas);
		return "mascota2.xhtml";

	}

	public void modificar() {
		try {
			mService.modificar(this.mascota);
			limpiarMascota();
			this.listMascota();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String detallesMascota(Mascota _mascota) {
		this.setMascota(_mascota);
		return "detalleMascota.xhtml";
	}

	// get y set

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public List<Mascota> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<Mascota> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}

	public IMascotaService getmService() {
		return mService;
	}

	public void setmService(IMascotaService mService) {
		this.mService = mService;
	}

}
