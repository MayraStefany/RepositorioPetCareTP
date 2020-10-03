package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Atencion;
import pe.edu.upc.entity.Receta;
import pe.edu.upc.service.IAtencionService;
import pe.edu.upc.service.IRecetaService;

@Named
@RequestScoped
public class RecetaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IRecetaService rService;
	@Inject
	private IAtencionService alService;

	private Receta receta;
	private Atencion atencion;

	List<Receta> listaRecetas;
	List<Atencion> listaAtencions;

	@PostConstruct
	public void init() {
		this.listaRecetas = new ArrayList<Receta>();
		this.listaAtencions = new ArrayList<Atencion>();

		this.receta = new Receta();
		this.atencion = new Atencion();

		this.listReceta();
		this.listAtencion();
	}

	public String nuevaReceta() {
		this.setReceta(new Receta());
		return "receta.xhtml";
	}

	public void insertar() {
		try {
			rService.insertar(receta);
			limpiarReceta();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listReceta() {
		try {
			listaRecetas = rService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listAtencion() {
		try {
			listaAtencions = alService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarReceta() {
		this.init();
	}

	
	
	
	public void eliminar(Receta receta) {
		try {
			rService.eliminar(receta.getIdReceta());
			listReceta();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String ModifReceta(Receta _rec) {
		this.setReceta(_rec);
		return "receta2.xhtml";

	}

	public void modificar() {
		try {
			rService.modificar(this.receta);
			limpiarReceta();
			this.listReceta();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String detallesReceta(Receta _Receta) {
		this.setReceta(_Receta);
		return "detalleRecetas.xhtml";
	}
	// get y set

	public IRecetaService getrService() {
		return rService;
	}

	public void setrService(IRecetaService rService) {
		this.rService = rService;
	}

	public IAtencionService getAlService() {
		return alService;
	}

	public void setAlService(IAtencionService alService) {
		this.alService = alService;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public Atencion getAtencion() {
		return atencion;
	}

	public void setAtencion(Atencion atencion) {
		this.atencion = atencion;
	}

	public List<Receta> getListaRecetas() {
		return listaRecetas;
	}

	public void setListaRecetas(List<Receta> listaRecetas) {
		this.listaRecetas = listaRecetas;
	}

	public List<Atencion> getListaAtencions() {
		return listaAtencions;
	}

	public void setListaAtencions(List<Atencion> listaAtencions) {
		this.listaAtencions = listaAtencions;
	}

}
