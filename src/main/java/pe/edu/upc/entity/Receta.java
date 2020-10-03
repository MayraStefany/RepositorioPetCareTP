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
@Table(name = "receta")
public class Receta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReceta;

	@ManyToOne
	@JoinColumn(name = "idAtencion")
	private Atencion atencionReceta;

	@NotEmpty(message = "Ingresar una descripcion detallada de la receta")
	@Column(name = "descripcionReceta", nullable = false, length = 100)
	private String descripcionReceta;

	@Min(1)
	@Max(90000)
	@Column(name = "igvReceta", nullable = false)
	private int igvReceta;

	@Min(1)
	@Max(90000)
	@Column(name = "totalReceta", nullable = false)
	private int totalReceta;

	public Receta(int idReceta, Atencion atencionReceta, String descripcionReceta, int igvReceta, int totalReceta) {
		super();
		this.idReceta = idReceta;
		this.atencionReceta = atencionReceta;
		this.descripcionReceta = descripcionReceta;
		this.igvReceta = igvReceta;
		this.totalReceta = totalReceta;
	}

	public Receta() {
		super();
	}

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public Atencion getAtencionReceta() {
		return atencionReceta;
	}

	public void setAtencionReceta(Atencion atencionReceta) {
		this.atencionReceta = atencionReceta;
	}

	public String getDescripcionReceta() {
		return descripcionReceta;
	}

	public void setDescripcionReceta(String descripcionReceta) {
		this.descripcionReceta = descripcionReceta;
	}

	public int getIgvReceta() {
		return igvReceta;
	}

	public void setIgvReceta(int igvReceta) {
		this.igvReceta = igvReceta;
	}

	public int getTotalReceta() {
		return totalReceta;
	}

	public void setTotalReceta(int totalReceta) {
		this.totalReceta = totalReceta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idReceta;
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
		Receta other = (Receta) obj;
		if (idReceta != other.idReceta)
			return false;
		return true;
	}

}
