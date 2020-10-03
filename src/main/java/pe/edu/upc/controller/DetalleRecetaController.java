package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Atencion;
import pe.edu.upc.entity.DetalleReceta;
import pe.edu.upc.entity.Receta;
import pe.edu.upc.service.IAtencionService;
import pe.edu.upc.service.IDetalleRecetaService;
import pe.edu.upc.service.IRecetaService;

@Named
@RequestScoped
public class DetalleRecetaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IDetalleRecetaService drService;
	@Inject
	private IRecetaService rService;
	@Inject
	private IAtencionService aService;

	private Receta receta;
	private Atencion atencion;
	private DetalleReceta detalleReceta;

	List<DetalleReceta> listaDetalleRecetas;
	List<Receta> listaRecetas;
	List<Atencion> listaAtencions;

	@PostConstruct
	public void init() {
		this.listaRecetas = new ArrayList<Receta>();
		this.listaAtencions = new ArrayList<Atencion>();
		this.listaDetalleRecetas = new ArrayList<DetalleReceta>();

		this.receta = new Receta();
		this.detalleReceta = new DetalleReceta();
		this.atencion = new Atencion();

		this.listReceta();
		this.listDetalleReceta();
		this.listAtencion();
	}

	public String nuevaDetalleReceta() {
		this.setReceta(new Receta());
		return "detallereceta.xhtml";
	}

	public void insertar() {
		try {
			drService.insertar(detalleReceta);
			limpiarDetalleReceta();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listDetalleReceta() {
		try {
			listaDetalleRecetas = drService.listar();
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
			listaAtencions = aService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarDetalleReceta() {
		this.init();
	}

	public void eliminar(DetalleReceta detalleReceta) {
		try {
			drService.eliminar(detalleReceta.getIdDetalleReceta());
			listReceta();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String ModifReceta(DetalleReceta _DetalleReceta) {
		this.setDetalleReceta(_DetalleReceta);
		return "receta2.xhtml";

	}

	public void modificar() {
		try {
			drService.modificar(this.detalleReceta);
			limpiarDetalleReceta();
			this.listDetalleReceta();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String detallesDetalleReceta(DetalleReceta _DetalleReceta) {
		this.setDetalleReceta(_DetalleReceta);
		return "detalleDetalleReceta.xhtml";
	}

	// get y set

	public IRecetaService getrService() {
		return rService;
	}

	public void setrService(IRecetaService rService) {
		this.rService = rService;
	}

	public IAtencionService getaService() {
		return aService;
	}

	public void setaService(IAtencionService aService) {
		this.aService = aService;
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

	public IDetalleRecetaService getDrService() {
		return drService;
	}

	public void setDrService(IDetalleRecetaService drService) {
		this.drService = drService;
	}

	public DetalleReceta getDetalleReceta() {
		return detalleReceta;
	}

	public void setDetalleReceta(DetalleReceta detalleReceta) {
		this.detalleReceta = detalleReceta;
	}

	public List<DetalleReceta> getListaDetalleRecetas() {
		return listaDetalleRecetas;
	}

	public void setListaDetalleRecetas(List<DetalleReceta> listaDetalleRecetas) {
		this.listaDetalleRecetas = listaDetalleRecetas;
	}

}
