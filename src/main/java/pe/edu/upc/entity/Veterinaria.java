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
import javax.validation.constraints.Size;

@Entity
@Table(name = "veterinaria")
public class Veterinaria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVeterinaria;

	@NotEmpty(message = "Ingresar el nombre comercial de la Veterinaria")
	@Column(name = "nombreVeterinaria", nullable = false, length = 50)
	private String nombreVeterinaria;

	@Size(min = 11, max = 11)
	@NotEmpty(message = "Ingrese el RUC de la Veterinaria")
	@Column(name = "rucVeterinaria", nullable = false, length = 11)
	private String rucVeterinaria;

	@Min(1)
	@Max(100)
	@Column(name = "tiempoVeterinaria", nullable = false)
	private int tiempoVeterinaria;

	@NotEmpty(message = "Ingresar el horario de atencion de la Veterinaria")
	@Column(name = "horarioVeterinaria", nullable = false, length = 50)
	private String horarioVeterinaria;

	@NotEmpty(message = "Ingresar el estado de la Veterinaria")
	@Column(name = "estadoVeterinaria", nullable = false, length = 30)
	private String estadoVeterinaria;

	@Size(min = 9, max = 9)
	@NotEmpty(message = "Ingrese el numero de celular de contacto de la veterinaria")
	@Column(name = "celularVeterinaria", nullable = false, length = 9)
	private String celularVeterinaria;

	@NotEmpty(message = "Ingresar la direccion de la Veterinaria")
	@Column(name = "direccionVeterinaria", nullable = false, length = 70)
	private String direccionVeterinaria;

	@NotEmpty(message = "Ingresar el distrito en el que esta ubicada la Veterinaria")
	@Column(name = "distritoVeterinaria", nullable = false, length = 40)
	private String distritoVeterinaria;

	public Veterinaria(int idVeterinaria, String nombreVeterinaria, String rucVeterinaria, int tiempoVeterinaria,
			String horarioVeterinaria, String estadoVeterinaria, String celularVeterinaria, String direccionVeterinaria,
			String distritoVeterinaria) {
		super();
		this.idVeterinaria = idVeterinaria;
		this.nombreVeterinaria = nombreVeterinaria;
		this.rucVeterinaria = rucVeterinaria;
		this.tiempoVeterinaria = tiempoVeterinaria;
		this.horarioVeterinaria = horarioVeterinaria;
		this.estadoVeterinaria = estadoVeterinaria;
		this.celularVeterinaria = celularVeterinaria;
		this.direccionVeterinaria = direccionVeterinaria;
		this.distritoVeterinaria = distritoVeterinaria;
	}

	public Veterinaria() {
		super();
	}

	public int getIdVeterinaria() {
		return idVeterinaria;
	}

	public void setIdVeterinaria(int idVeterinaria) {
		this.idVeterinaria = idVeterinaria;
	}

	public String getNombreVeterinaria() {
		return nombreVeterinaria;
	}

	public void setNombreVeterinaria(String nombreVeterinaria) {
		this.nombreVeterinaria = nombreVeterinaria;
	}

	public String getRucVeterinaria() {
		return rucVeterinaria;
	}

	public void setRucVeterinaria(String rucVeterinaria) {
		this.rucVeterinaria = rucVeterinaria;
	}

	public int getTiempoVeterinaria() {
		return tiempoVeterinaria;
	}

	public void setTiempoVeterinaria(int tiempoVeterinaria) {
		this.tiempoVeterinaria = tiempoVeterinaria;
	}

	public String getHorarioVeterinaria() {
		return horarioVeterinaria;
	}

	public void setHorarioVeterinaria(String horarioVeterinaria) {
		this.horarioVeterinaria = horarioVeterinaria;
	}

	public String getEstadoVeterinaria() {
		return estadoVeterinaria;
	}

	public void setEstadoVeterinaria(String estadoVeterinaria) {
		this.estadoVeterinaria = estadoVeterinaria;
	}

	public String getCelularVeterinaria() {
		return celularVeterinaria;
	}

	public void setCelularVeterinaria(String celularVeterinaria) {
		this.celularVeterinaria = celularVeterinaria;
	}

	public String getDireccionVeterinaria() {
		return direccionVeterinaria;
	}

	public void setDireccionVeterinaria(String direccionVeterinaria) {
		this.direccionVeterinaria = direccionVeterinaria;
	}

	public String getDistritoVeterinaria() {
		return distritoVeterinaria;
	}

	public void setDistritoVeterinaria(String distritoVeterinaria) {
		this.distritoVeterinaria = distritoVeterinaria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idVeterinaria;
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
		Veterinaria other = (Veterinaria) obj;
		if (idVeterinaria != other.idVeterinaria)
			return false;
		return true;
	}

}
