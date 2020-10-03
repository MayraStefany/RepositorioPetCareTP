package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Cliente;
import pe.edu.upc.entity.Mascota;
import pe.edu.upc.entity.Reserva;
import pe.edu.upc.entity.Veterinaria;
import pe.edu.upc.service.IClienteService;
import pe.edu.upc.service.IMascotaService;
import pe.edu.upc.service.IReservaService;
import pe.edu.upc.service.IVeterinariaService;

@Named
@RequestScoped
public class ReservaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IReservaService rService;
	@Inject
	private IClienteService cService;
	@Inject
	private IVeterinariaService vService;
	@Inject
	private IMascotaService mService;

	private Reserva reserva;
	private Cliente cliente;
	private Veterinaria veterinaria;
	private Mascota mascota;

	List<Reserva> listaReservas;
	List<Cliente> listaClientes;
	List<Veterinaria> listaVeterinarias;
	List<Mascota> listaMascotas;

	@PostConstruct
	public void init() {
		this.listaReservas = new ArrayList<Reserva>();
		this.listaClientes = new ArrayList<Cliente>();
		this.listaVeterinarias = new ArrayList<Veterinaria>();
		this.listaMascotas = new ArrayList<Mascota>();

		this.reserva = new Reserva();
		this.cliente = new Cliente();
		this.veterinaria = new Veterinaria();
		this.mascota = new Mascota();

		this.listReserva();
		this.listCliente();
		this.listVeterinaria();
		this.listMascota();
	}

	public String nuevaReserva() {
		this.setReserva(new Reserva());
		return "reserva.xhtml";
	}

	public void insertar() {
		try {
			rService.insertar(reserva);
			limpiarReserva();
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

	public void listCliente() {
		try {
			listaClientes = cService.listar();
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

	public void listMascota() {
		try {
			listaMascotas = mService.listar();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void limpiarReserva() {
		this.init();
	}

	public void eliminar(Reserva reserva) {
		try {
			rService.eliminar(reserva.getIdReserva());
			listReserva();
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public String ModifReserva(Reserva _res) {
		this.setReserva(_res);
		return "reserva2.xhtml";

	}

	public void modificar() {
		try {
			rService.modificar(this.reserva);
			limpiarReserva();
			this.listReserva();

		} catch (Exception e) {
			e.getMessage();
		}

	}

	public String detallesReserva(Reserva _Reserva) {
		this.setReserva(_Reserva);
		return "detalleReserva.xhtml";
	}

	// get y set

	public IReservaService getrService() {
		return rService;
	}

	public void setrService(IReservaService rService) {
		this.rService = rService;
	}

	public IClienteService getcService() {
		return cService;
	}

	public void setcService(IClienteService cService) {
		this.cService = cService;
	}

	public IVeterinariaService getvService() {
		return vService;
	}

	public void setvService(IVeterinariaService vService) {
		this.vService = vService;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Veterinaria getVeterinaria() {
		return veterinaria;
	}

	public void setVeterinaria(Veterinaria veterinaria) {
		this.veterinaria = veterinaria;
	}

	public List<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(List<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public List<Veterinaria> getListaVeterinarias() {
		return listaVeterinarias;
	}

	public void setListaVeterinarias(List<Veterinaria> listaVeterinarias) {
		this.listaVeterinarias = listaVeterinarias;
	}

	public IMascotaService getmService() {
		return mService;
	}

	public void setmService(IMascotaService mService) {
		this.mService = mService;
	}

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

}
