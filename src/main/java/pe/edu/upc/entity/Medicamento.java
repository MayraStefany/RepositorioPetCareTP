package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "auditor")
public class Medicamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMedicamento;

	@NotEmpty(message = "Ingresar el nombre del medicamento")
	@Column(name = "nombreMedicamento", nullable = false, length = 50)
	private String nombreMedicamento;

	@NotEmpty(message = "Ingresar el tipo del medicamento")
	@Column(name = "tipoMedicamento", nullable = false, length = 50)
	private String tipoMedicamento;

	@NotEmpty(message = "Ingresar el laboratorio que desarrollo el medicamento")
	@Column(name = "laboratorioMedicamento", nullable = false, length = 60)
	private String laboratorioMedicamento;

	private String fechaMedicamento;

	public Medicamento(int idMedicamento, String nombreMedicamento, String tipoMedicamento,
			String laboratorioMedicamento, String fechaMedicamento) {
		super();
		this.idMedicamento = idMedicamento;
		this.nombreMedicamento = nombreMedicamento;
		this.tipoMedicamento = tipoMedicamento;
		this.laboratorioMedicamento = laboratorioMedicamento;
		this.fechaMedicamento = fechaMedicamento;
	}

	public Medicamento() {
		super();
	}

	public int getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}

	public String getTipoMedicamento() {
		return tipoMedicamento;
	}

	public void setTipoMedicamento(String tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}

	public String getLaboratorioMedicamento() {
		return laboratorioMedicamento;
	}

	public void setLaboratorioMedicamento(String laboratorioMedicamento) {
		this.laboratorioMedicamento = laboratorioMedicamento;
	}

	public String getFechaMedicamento() {
		return fechaMedicamento;
	}

	public void setFechaMedicamento(String fechaMedicamento) {
		this.fechaMedicamento = fechaMedicamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idMedicamento;
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
		Medicamento other = (Medicamento) obj;
		if (idMedicamento != other.idMedicamento)
			return false;
		return true;
	}
}
