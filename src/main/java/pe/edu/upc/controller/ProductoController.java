package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Producto;
import pe.edu.upc.service.IProductoService;

@Named
@RequestScoped
public class ProductoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IProductoService pService;

	private Producto producto;

	List<Producto> listaProductos;

	@PostConstruct
	public void init() {
		producto = new Producto();

		listaProductos = new ArrayList<Producto>();

		this.listProducto();
	}

	public String nuevoProducto() {
		this.setProducto(producto);
		return "producto.xhtml";
	}

	public void insertar() {
		try {
			pService.insertar(producto);
			limpiarProducto();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listProducto() {
		try {
			listaProductos = pService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarProducto() {
		this.init();
	}

	public void eliminar(Producto producto) {
		try {
			pService.eliminar(producto.getIdProducto());
			listProducto();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String detallesProducto(Producto _producto) {
		this.setProducto(_producto);
		return "detalleProducto.xhtml";
	}

	public void modificar() {
		try {
			pService.modificar(this.producto);
			limpiarProducto();
			this.listProducto();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String ModifProducto(Producto _pro) {
		this.setProducto(_pro);
		return "producto2.xhtml";

	}



	
	// get y set

	public void setpService(IProductoService pService) {
		this.pService = pService;
	}

	public IProductoService getpService() {
		return pService;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

}
