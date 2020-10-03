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
@Table(name = "cliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;

	@NotEmpty(message = "Ingresar el nombre del Cliente")
	@Column(name = "nombreCliente", nullable = false, length = 40)
	private String nombreCliente;

	@NotEmpty(message = "Ingresar el apellido del Cliente")
	@Column(name = "apellidoCliente", nullable = false, length = 40)
	private String apellidoCliente;

	@NotEmpty(message = "Ingresar la direccion del Cliente")
	@Column(name = "direccionCliente", nullable = false, length = 70)
	private String direccionCliente;

	@Size(min = 9, max = 9)
	@NotEmpty(message = "Ingrese el numero de celular del Cliente")
	@Column(name = "celularCliente", nullable = false, length = 9)
	private String celularCliente;

	@Size(min = 8, max = 8)
	@NotEmpty(message = "Ingrese el DNI del Cliente")
	@Column(name = "dniCliente", nullable = false, length = 8)
	private String dniCliente;

	@Size(min = 1, max = 2)
	@NotEmpty(message = "Ingrese la edad del empleado")
	@Column(name = "edadCliente", nullable = false, length = 2)
	private String edadCliente;

	@NotEmpty(message = "Ingresar el genero del Cliente")
	@Column(name = "generoCliente", nullable = false, length = 20)
	private String generoCliente;

	@NotEmpty(message = "Ingresar el correo del Cliente")
	@Column(name = "correoCliente", nullable = false, length = 70)
	private String correoCliente;

	public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String direccionCliente,
			String celularCliente, String dniCliente, String edadCliente, String generoCliente, String correoCliente) {
		super();
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.direccionCliente = direccionCliente;
		this.celularCliente = celularCliente;
		this.dniCliente = dniCliente;
		this.edadCliente = edadCliente;
		this.generoCliente = generoCliente;
		this.correoCliente = correoCliente;
	}

	public Cliente() {
		super();
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getCelularCliente() {
		return celularCliente;
	}

	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getEdadCliente() {
		return edadCliente;
	}

	public void setEdadCliente(String edadCliente) {
		this.edadCliente = edadCliente;
	}

	public String getGeneroCliente() {
		return generoCliente;
	}

	public void setGeneroCliente(String generoCliente) {
		this.generoCliente = generoCliente;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCliente;
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
		Cliente other = (Cliente) obj;
		if (idCliente != other.idCliente)
			return false;
		return true;
	}

}
