package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.service.IClienteService;

@Named
@RequestScoped
public class ClienteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IClienteService cService;
	private Cliente cliente;
	List<Cliente> listaClientes;

	@PostConstruct
	public void init() {
		this.listaClientes = new ArrayList<Cliente>();
		this.cliente = new Cliente();
		this.listCliente();
	}

	public String nuevoCliente() {
		this.setCliente(new Cliente());
		return "cliente.xhtml";
	}

	public void insertar() {
		try {
			cService.insertar(cliente);
			limpiarCliente();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void listCliente() {
		try {
			listaClientes = cService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarCliente() {
		this.init();
	}

	public void eliminar(Cliente cliente) {
		try {
			cService.eliminar(cliente.getIdCliente());
			listCliente();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String ModifCliente(Cliente _cli) {
		this.setCliente(_cli);
		return "cliente2.xhtml";

	}

	public void modificar() {
		try {
			cService.modificar(this.cliente);
			limpiarCliente();
			this.listCliente();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String detalleCliente(Cliente _cliente) {
		this.setCliente(_cliente);
		return "detalleCliente.xhtml";
	}

	// get y set

	public IClienteService getcService() {
		return cService;
	}

	public void setcService(IClienteService cService) {
		this.cService = cService;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

}
