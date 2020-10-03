package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Atencion;
import pe.edu.upc.entity.Reserva;
import pe.edu.upc.service.IAtencionService;
import pe.edu.upc.service.IReservaService;

@Named
@RequestScoped
public class AtencionController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IAtencionService aService;
	@Inject
	private IReservaService rService;

	private Atencion atencion;
	private Reserva reserva;

	List<Atencion> listaAtencions;
	List<Reserva> listaReservas;

	@PostConstruct
	public void init() {
		this.listaAtencions = new ArrayList<Atencion>();
		this.listaReservas = new ArrayList<Reserva>();

		this.atencion = new Atencion();
		this.reserva = new Reserva();

		this.listAtencion();
		this.listReserva();
	}

	public String nuevaAtencion() {
		this.setAtencion(new Atencion());
		return "atencion.xhtml";
	}

	public void insertar() {
		try {
			aService.insertar(atencion);
			limpiarAtencion();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listAtencion() {
		try {
			listaAtencions = aService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listReserva() {
		try {
			listaReservas = rService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarAtencion() {
		this.init();
	}

	public void eliminar(Atencion atencion) {
		try {
			aService.eliminar(atencion.getIdAtencion());
			listAtencion();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String ModifAtencion(Atencion _aten) {
		this.setAtencion(_aten);
		return "atencion2.xhtml";

	}

	public void modificar() {
		try {
			aService.modificar(this.atencion);
			limpiarAtencion();
			this.listAtencion();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String detallesAtencion(Atencion _atencion) {
		this.setAtencion(_atencion);
		return "detalleAtencion.xhtml";
	}

	// get y set

	public IAtencionService getaService() {
		return aService;
	}

	public void setaService(IAtencionService aService) {
		this.aService = aService;
	}

	public IReservaService getrService() {
		return rService;
	}

	public void setrService(IReservaService rService) {
		this.rService = rService;
	}

	public Atencion getAtencion() {
		return atencion;
	}

	public void setAtencion(Atencion atencion) {
		this.atencion = atencion;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Atencion> getListaAtencions() {
		return listaAtencions;
	}

	public void setListaAtencions(List<Atencion> listaAtencions) {
		this.listaAtencions = listaAtencions;
	}

	public List<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(List<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

}
