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
@Table(name = "compra")
public class Compra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCompra;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	private Cliente clienteCompra;

	@ManyToOne
	@JoinColumn(name = "idPetshop")
	private Petshop petshopCompra;

	@Min(1)
	@Max(90000)
	@Column(name = "igvCompra", nullable = false)
	private int igvCompra;

	@Min(1)
	@Max(90000)
	@Column(name = "totalCompra", nullable = false)
	private int totalCompra;

	public Compra(int idCompra, Cliente clienteCompra, Petshop petshopCompra, int igvCompra, int totalCompra) {
		super();
		this.idCompra = idCompra;
		this.clienteCompra = clienteCompra;
		this.petshopCompra = petshopCompra;
		this.igvCompra = igvCompra;
		this.totalCompra = totalCompra;
	}

	public Compra() {
		super();
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public Cliente getClienteCompra() {
		return clienteCompra;
	}

	public void setClienteCompra(Cliente clienteCompra) {
		this.clienteCompra = clienteCompra;
	}

	public Petshop getPetshopCompra() {
		return petshopCompra;
	}

	public void setPetshopCompra(Petshop petshopCompra) {
		this.petshopCompra = petshopCompra;
	}

	public int getIgvCompra() {
		return igvCompra;
	}

	public void setIgvCompra(int igvCompra) {
		this.igvCompra = igvCompra;
	}

	public int getTotalCompra() {
		return totalCompra;
	}

	public void setTotalCompra(int totalCompra) {
		this.totalCompra = totalCompra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCompra;
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
		Compra other = (Compra) obj;
		if (idCompra != other.idCompra)
			return false;
		return true;
	}

}
