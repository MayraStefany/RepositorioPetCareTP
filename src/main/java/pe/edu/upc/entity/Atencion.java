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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "atencion")
public class Atencion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAtencion;

	@ManyToOne
	@JoinColumn(name = "idReseva")
	private Reserva reservaAtencion;

	@NotEmpty(message = "Ingresar los detalles de la atencion")
	@Column(name = "descripcionAtencion", nullable = false, length = 60)
	private String descripcionAtencion;

	@Min(1)
	@Max(5)
	@Column(name = "clasificacionAtencion", nullable = false)
	private int clasificacionAtencion;

	public Atencion(int idAtencion, Reserva reservaAtencion, String descripcionAtencion, int clasificacionAtencion) {
		super();
		this.idAtencion = idAtencion;
		this.reservaAtencion = reservaAtencion;
		this.descripcionAtencion = descripcionAtencion;
		this.clasificacionAtencion = clasificacionAtencion;
	}

	public Atencion() {
		super();
	}

	public int getIdAtencion() {
		return idAtencion;
	}

	public void setIdAtencion(int idAtencion) {
		this.idAtencion = idAtencion;
	}

	public Reserva getReservaAtencion() {
		return reservaAtencion;
	}

	public void setReservaAtencion(Reserva reservaAtencion) {
		this.reservaAtencion = reservaAtencion;
	}

	public String getDescripcionAtencion() {
		return descripcionAtencion;
	}

	public void setDescripcionAtencion(String descripcionAtencion) {
		this.descripcionAtencion = descripcionAtencion;
	}

	public int getClasificacionAtencion() {
		return clasificacionAtencion;
	}

	public void setClasificacionAtencion(int clasificacionAtencion) {
		this.clasificacionAtencion = clasificacionAtencion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAtencion;
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
		Atencion other = (Atencion) obj;
		if (idAtencion != other.idAtencion)
			return false;
		return true;
	}

}
