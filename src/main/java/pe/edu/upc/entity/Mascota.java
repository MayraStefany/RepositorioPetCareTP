package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "mascota")
public class Mascota implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMascota;

	@NotEmpty(message = "Ingresar el nombre de la Mascota")
	@Column(name = "nombreMascota", nullable = false, length = 30)
	private String nombreMascota;

	@Min(1)
	@Max(50)
	@Column(name = "edadMascota", nullable = false)
	private int edadMascota;

	@NotEmpty(message = "Ingresar la raza de la Mascota")
	@Column(name = "razaMascota", nullable = false, length = 30)
	private String razaMascota;

	public Mascota(int idMascota, String nombreMascota, int edadMascota, String razaMascota) {
		super();
		this.idMascota = idMascota;
		this.nombreMascota = nombreMascota;
		this.edadMascota = edadMascota;
		this.razaMascota = razaMascota;
	}

	public Mascota() {
		super();
	}

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public int getEdadMascota() {
		return edadMascota;
	}

	public void setEdadMascota(int edadMascota) {
		this.edadMascota = edadMascota;
	}

	public String getRazaMascota() {
		return razaMascota;
	}

	public void setRazaMascota(String razaMascota) {
		this.razaMascota = razaMascota;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMascota;
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
		Mascota other = (Mascota) obj;
		if (idMascota != other.idMascota)
			return false;
		return true;
	}

}
