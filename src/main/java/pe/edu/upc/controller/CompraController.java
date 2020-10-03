package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.Compra;
import pe.edu.upc.entity.Petshop;
import pe.edu.upc.service.IClienteService;
import pe.edu.upc.service.ICompraService;
import pe.edu.upc.service.IPetshopService;

@Named
@RequestScoped
public class CompraController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ICompraService cService;
	@Inject
	private IClienteService clService;
	@Inject
	private IPetshopService pService;

	private Compra compra;
	private Cliente cliente;
	private Petshop petshop;

	List<Compra> listaCompras;
	List<Cliente> listaClientes;
	List<Petshop> listaPetshops;

	@PostConstruct
	public void init() {
		this.listaCompras = new ArrayList<Compra>();
		this.listaClientes = new ArrayList<Cliente>();
		this.listaPetshops = new ArrayList<Petshop>();

		this.compra = new Compra();
		this.cliente = new Cliente();
		this.petshop = new Petshop();

		this.listCompra();
		this.listCliente();
		this.listPetshop();
	}

	public String nuevaCompra() {
		this.setCompra(new Compra());
		return "compra.xhtml";
	}

	public void insertar() {
		try {
			cService.insertar(compra);
			limpiarCompra();
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

	public void listCliente() {
		try {
			listaClientes = clService.listar();
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

	public void limpiarCompra() {
		this.init();
	}

	public void eliminar(Compra compra) {
		try {
			cService.eliminar(compra.getIdCompra());
			listCompra();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String ModifCompra(Compra _com) {
		this.setCompra(_com);
		return "compra2.xhtml";

	}

	public void modificar() {
		try {
			cService.modificar(this.compra);
			limpiarCompra();
			this.listCompra();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String detallesCompra(Compra _compra) {
		this.setCompra(_compra);
		return "detalleCompra.xhtml";
	}

	// get y set

	public ICompraService getcService() {
		return cService;
	}

	public void setcService(ICompraService cService) {
		this.cService = cService;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public List<Compra> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(List<Compra> listaCompras) {
		this.listaCompras = listaCompras;
	}

	public IClienteService getClService() {
		return clService;
	}

	public void setClService(IClienteService clService) {
		this.clService = clService;
	}

	public IPetshopService getpService() {
		return pService;
	}

	public void setpService(IPetshopService pService) {
		this.pService = pService;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Petshop getPetshop() {
		return petshop;
	}

	public void setPetshop(Petshop petshop) {
		this.petshop = petshop;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Petshop> getListaPetshops() {
		return listaPetshops;
	}

	public void setListaPetshops(List<Petshop> listaPetshops) {
		this.listaPetshops = listaPetshops;
	}

}
