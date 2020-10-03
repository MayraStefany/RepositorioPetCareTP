package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "reserva")
public class Reserva implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserva;

	@ManyToOne
	@JoinColumn(name = "idVeterinaria")
	private Veterinaria veterinariaReserva;

	@ManyToOne
	@JoinColumn(name = "idMascota")
	private Mascota mascotaReserva;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente clienteReserva;

	@NotEmpty(message = "Ingresar el nestardo de la reserva")
	@Column(name = "estadoReserva", nullable = false, length = 60)
	private String estadoReserva;

	@NotEmpty(message = "Ingresar La descripcion de la reserva")
	@Column(name = "descripcionReserva", nullable = false, length = 60)
	private String descripcionReserva;

	private String fechaReserva;

	public Reserva(int idReserva, Veterinaria veterinariaReserva, Mascota mascotaReserva, Cliente clienteReserva,
			String estadoReserva, String descripcionReserva, String fechaReserva) {
		super();
		this.idReserva = idReserva;
		this.veterinariaReserva = veterinariaReserva;
		this.mascotaReserva = mascotaReserva;
		this.clienteReserva = clienteReserva;
		this.estadoReserva = estadoReserva;
		this.descripcionReserva = descripcionReserva;
		this.fechaReserva = fechaReserva;
	}

	public Reserva() {
		super();
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public Veterinaria getVeterinariaReserva() {
		return veterinariaReserva;
	}

	public void setVeterinariaReserva(Veterinaria veterinariaReserva) {
		this.veterinariaReserva = veterinariaReserva;
	}

	public Mascota getMascotaReserva() {
		return mascotaReserva;
	}

	public void setMascotaReserva(Mascota mascotaReserva) {
		this.mascotaReserva = mascotaReserva;
	}

	public Cliente getClienteReserva() {
		return clienteReserva;
	}

	public void setClienteReserva(Cliente clienteReserva) {
		this.clienteReserva = clienteReserva;
	}

	public String getEstadoReserva() {
		return estadoReserva;
	}

	public void setEstadoReserva(String estadoReserva) {
		this.estadoReserva = estadoReserva;
	}

	public String getDescripcionReserva() {
		return descripcionReserva;
	}

	public void setDescripcionReserva(String descripcionReserva) {
		this.descripcionReserva = descripcionReserva;
	}

	public String getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(String fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idReserva;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (idReserva != other.idReserva)
			return false;
		return true;
	}

}
