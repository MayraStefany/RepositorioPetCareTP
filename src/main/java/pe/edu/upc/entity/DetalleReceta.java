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

@Entity
@Table(name = "detallereceta")
public class DetalleReceta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleReceta;

	@ManyToOne
	@JoinColumn(name = "idAtencion")
	private Atencion atencionReceta;

	@ManyToOne
	@JoinColumn(name = "idMedicamento")
	private Medicamento medicamentoReceta;

	@Min(1)
	@Max(90000)
	@Column(name = "precioDetalleReceta", nullable = false)
	private int precioDetalleReceta;

	@Min(1)
	@Max(900)
	@Column(name = "unidadesDetalleReceta", nullable = false)
	private int unidadesDetalleReceta;

	public DetalleReceta(int idDetalleReceta, Atencion atencionReceta, Medicamento medicamentoReceta,
			int precioDetalleReceta, int unidadesDetalleReceta) {
		super();
		this.idDetalleReceta = idDetalleReceta;
		this.atencionReceta = atencionReceta;
		this.medicamentoReceta = medicamentoReceta;
		this.precioDetalleReceta = precioDetalleReceta;
		this.unidadesDetalleReceta = unidadesDetalleReceta;
	}

	public DetalleReceta() {
		super();
	}

	public int getIdDetalleReceta() {
		return idDetalleReceta;
	}

	public void setIdDetalleReceta(int idDetalleReceta) {
		this.idDetalleReceta = idDetalleReceta;
	}

	public Atencion getAtencionReceta() {
		return atencionReceta;
	}

	public void setAtencionReceta(Atencion atencionReceta) {
		this.atencionReceta = atencionReceta;
	}

	public Medicamento getMedicamentoReceta() {
		return medicamentoReceta;
	}

	public void setMedicamentoReceta(Medicamento medicamentoReceta) {
		this.medicamentoReceta = medicamentoReceta;
	}

	public int getPrecioDetalleReceta() {
		return precioDetalleReceta;
	}

	public void setPrecioDetalleReceta(int precioDetalleReceta) {
		this.precioDetalleReceta = precioDetalleReceta;
	}

	public int getUnidadesDetalleReceta() {
		return unidadesDetalleReceta;
	}

	public void setUnidadesDetalleReceta(int unidadesDetalleReceta) {
		this.unidadesDetalleReceta = unidadesDetalleReceta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDetalleReceta;
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
		DetalleReceta other = (DetalleReceta) obj;
		if (idDetalleReceta != other.idDetalleReceta)
			return false;
		return true;
	}

}
