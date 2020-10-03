package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "petshop")
public class Petshop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPetshop;

	@NotEmpty(message = "Ingrese los nombres del Petshop")
	@Column(name = "nombrePetshop", nullable = false, length = 50)
	private String nombrePetshop;

	@NotEmpty(message = "Ingrese la descripcion del Petshop")
	@Column(name = "descripcionPetshop", nullable = false, length = 70)
	private String descripcionPetshop;

	@NotEmpty(message = "Ingrese la ubicación del Petshop")
	@Column(name = "ubicacionPetshop", nullable = false, length = 70)
	private String ubicacionPetshop;

	@Size(min = 9, max = 9)
	@NotEmpty(message = "Ingrese el numero de celular de contacto del Petshop")
	@Column(name = "celularPetshop", nullable = false, length = 9)
	private String celularPetshop;

	@NotEmpty(message = "Ingrese la direccion web del Petshop")
	@Column(name = "webPetshop", nullable = false, length = 70)
	private String webPetshop;

	@NotEmpty(message = "Ingrese el distrito en el que se encuentra el Petshop")
	@Column(name = "distritoPetshop", nullable = false, length = 40)
	private String distritoPetshop;

	public Petshop(int idPetshop, String nombrePetshop, String descripcionPetshop, String ubicacionPetshop,
			String celularPetshop, String webPetshop, String distritoPetshop) {
		super();
		this.idPetshop = idPetshop;
		this.nombrePetshop = nombrePetshop;
		this.descripcionPetshop = descripcionPetshop;
		this.ubicacionPetshop = ubicacionPetshop;
		this.celularPetshop = celularPetshop;
		this.webPetshop = webPetshop;
		this.distritoPetshop = distritoPetshop;
	}

	public Petshop() {
		super();
	}

	public int getIdPetshop() {
		return idPetshop;
	}

	public void setIdPetshop(int idPetshop) {
		this.idPetshop = idPetshop;
	}

	public String getNombrePetshop() {
		return nombrePetshop;
	}

	public void setNombrePetshop(String nombrePetshop) {
		this.nombrePetshop = nombrePetshop;
	}

	public String getDescripcionPetshop() {
		return descripcionPetshop;
	}

	public void setDescripcionPetshop(String descripcionPetshop) {
		this.descripcionPetshop = descripcionPetshop;
	}

	public String getUbicacionPetshop() {
		return ubicacionPetshop;
	}

	public void setUbicacionPetshop(String ubicacionPetshop) {
		this.ubicacionPetshop = ubicacionPetshop;
	}

	public String getCelularPetshop() {
		return celularPetshop;
	}

	public void setCelularPetshop(String celularPetshop) {
		this.celularPetshop = celularPetshop;
	}

	public String getWebPetshop() {
		return webPetshop;
	}

	public void setWebPetshop(String webPetshop) {
		this.webPetshop = webPetshop;
	}

	public String getDistritoPetshop() {
		return distritoPetshop;
	}

	public void setDistritoPetshop(String distritoPetshop) {
		this.distritoPetshop = distritoPetshop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPetshop;
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
		Petshop other = (Petshop) obj;
		if (idPetshop != other.idPetshop)
			return false;
		return true;
	}

}
