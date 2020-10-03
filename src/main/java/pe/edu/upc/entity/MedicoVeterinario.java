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
import javax.validation.constraints.Size;

@Entity
@Table(name = "medicoveterinario")
public class MedicoVeterinario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedicoVeterinario;

	@ManyToOne
	@JoinColumn(name = "idVeterinaria")
	private Veterinaria veterinariaMedico;

	@NotEmpty(message = "Ingresar el nombre del medico")
	@Column(name = "nombreMedico", nullable = false, length = 50)
	private String nombreMedico;

	@Size(min = 8, max = 8)
	@NotEmpty(message = "Ingrese el DNI del medico")
	@Column(name = "dniMedico", nullable = false, length = 8)
	private String dniMedico;

	@Min(1)
	@Max(100)
	@Column(name = "edadMedico", nullable = false)
	private int edadMedico;

	@NotEmpty(message = "Ingresar la direccion del medico")
	@Column(name = "direccionMedico", nullable = false, length = 70)
	private String direccionMedico;

	@NotEmpty(message = "Ingresar el nombre de la institucion de la que egresa el medico")
	@Column(name = "institucionMedico", nullable = false, length = 70)
	private String institucionMedico;

	@NotEmpty(message = "Ingresar el estado de la licencia del medico")
	@Column(name = "estadoMedico", nullable = false, length = 40)
	private String estadoMedico;

	public MedicoVeterinario(int idMedicoVeterinario, Veterinaria veterinariaMedico, String nombreMedico,
			String dniMedico, int edadMedico, String direccionMedico, String institucionMedico, String estadoMedico) {
		super();
		this.idMedicoVeterinario = idMedicoVeterinario;
		this.veterinariaMedico = veterinariaMedico;
		this.nombreMedico = nombreMedico;
		this.dniMedico = dniMedico;
		this.edadMedico = edadMedico;
		this.direccionMedico = direccionMedico;
		this.institucionMedico = institucionMedico;
		this.estadoMedico = estadoMedico;
	}

	public MedicoVeterinario() {
		super();
	}

	public int getIdMedicoVeterinario() {
		return idMedicoVeterinario;
	}

	public void setIdMedicoVeterinario(int idMedicoVeterinario) {
		this.idMedicoVeterinario = idMedicoVeterinario;
	}

	public Veterinaria getVeterinariaMedico() {
		return veterinariaMedico;
	}

	public void setVeterinariaMedico(Veterinaria veterinariaMedico) {
		this.veterinariaMedico = veterinariaMedico;
	}

	public String getNombreMedico() {
		return nombreMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	public String getDniMedico() {
		return dniMedico;
	}

	public void setDniMedico(String dniMedico) {
		this.dniMedico = dniMedico;
	}

	public int getEdadMedico() {
		return edadMedico;
	}

	public void setEdadMedico(int edadMedico) {
		this.edadMedico = edadMedico;
	}

	public String getDireccionMedico() {
		return direccionMedico;
	}

	public void setDireccionMedico(String direccionMedico) {
		this.direccionMedico = direccionMedico;
	}

	public String getInstitucionMedico() {
		return institucionMedico;
	}

	public void setInstitucionMedico(String institucionMedico) {
		this.institucionMedico = institucionMedico;
	}

	public String getEstadoMedico() {
		return estadoMedico;
	}

	public void setEstadoMedico(String estadoMedico) {
		this.estadoMedico = estadoMedico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMedicoVeterinario;
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
		MedicoVeterinario other = (MedicoVeterinario) obj;
		if (idMedicoVeterinario != other.idMedicoVeterinario)
			return false;
		return true;
	}

}
