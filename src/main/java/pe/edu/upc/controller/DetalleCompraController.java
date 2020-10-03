package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Compra;
import pe.edu.upc.entity.DetalleCompra;
import pe.edu.upc.entity.Producto;
import pe.edu.upc.service.ICompraService;
import pe.edu.upc.service.IDetalleCompraService;
import pe.edu.upc.service.IProductoService;

@Named
@RequestScoped
public class DetalleCompraController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IDetalleCompraService dcService;
	@Inject
	private ICompraService cService;
	@Inject
	private IProductoService pService;

	private DetalleCompra detalleCompra;
	private Compra compra;
	private Producto producto;

	List<DetalleCompra> listaDetalleCompras;
	List<Compra> listaCompras;
	List<Producto> listaProductos;

	@PostConstruct
	public void init() {
		this.listaDetalleCompras = new ArrayList<DetalleCompra>();
		this.listaCompras = new ArrayList<Compra>();
		this.listaProductos = new ArrayList<Producto>();

		this.detalleCompra = new DetalleCompra();
		this.compra = new Compra();
		this.producto = new Producto();

		this.listDetalleCompra();
		this.listCompra();
		this.listProducto();
	}

	public String nuevoDetalleCompra() {
		this.setDetalleCompra(new DetalleCompra());
		return "detallecompra.xhtml";
	}

	public void insertar() {
		try {
			dcService.insertar(detalleCompra);
			limpiarDetalleCompra();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listDetalleCompra() {
		try {
			listaDetalleCompras = dcService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listCompra() {
		try {
			listaCompras = cService.listar();
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

	public void limpiarDetalleCompra() {
		this.init();
	}

	public void eliminar(DetalleCompra detalleCompra) {
		try {
			dcService.eliminar(detalleCompra.getIdDetalleCompra());
			listDetalleCompra();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String ModifDetalleCompra(DetalleCompra _detcom) {
		this.setDetalleCompra(_detcom);
		return "detalleCompra2.xhtml";

	}

	public void modificar() {
		try {
			dcService.modificar(this.detalleCompra);
			limpiarDetalleCompra();
			this.listDetalleCompra();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String detallesDetalleCompra(DetalleCompra _detalleCompra) {
		this.setDetalleCompra(_detalleCompra);
		return "detalleDetalleCompra.xhtml";
	}

	// get y set

	public IDetalleCompraService getDcService() {
		return dcService;
	}

	public void setDcService(IDetalleCompraService dcService) {
		this.dcService = dcService;
	}

	public ICompraService getcService() {
		return cService;
	}

	public void setcService(ICompraService cService) {
		this.cService = cService;
	}

	public IProductoService getpService() {
		return pService;
	}

	public void setpService(IProductoService pService) {
		this.pService = pService;
	}

	public DetalleCompra getDetalleCompra() {
		return detalleCompra;
	}

	public void setDetalleCompra(DetalleCompra detalleCompra) {
		this.detalleCompra = detalleCompra;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<DetalleCompra> getListaDetalleCompras() {
		return listaDetalleCompras;
	}

	public void setListaDetalleCompras(List<DetalleCompra> listaDetalleCompras) {
		this.listaDetalleCompras = listaDetalleCompras;
	}

	public List<Compra> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(List<Compra> listaCompras) {
		this.listaCompras = listaCompras;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

}
