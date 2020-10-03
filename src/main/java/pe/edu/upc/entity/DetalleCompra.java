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
@Table(name = "detallecompra")
public class DetalleCompra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleCompra;

	@ManyToOne
	@JoinColumn(name = "idCompra")
	private Compra compraDetalleCompra;

	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto productoDetalleCompra;

	@Min(1)
	@Max(90000)
	@Column(name = "precioDetalleCompra", nullable = false)
	private int precioDetalleCompra;

	@Min(1)
	@Max(900)
	@Column(name = "unidadeDetalleCompra", nullable = false)
	private int unidadeDetalleCompra;

	public DetalleCompra(int idDetalleCompra, Compra compraDetalleCompra, Producto productoDetalleCompra,
			@Min(1) @Max(90000) int precioDetalleCompra, @Min(1) @Max(900) int unidadeDetalleCompra) {
		super();
		this.idDetalleCompra = idDetalleCompra;
		this.compraDetalleCompra = compraDetalleCompra;
		this.productoDetalleCompra = productoDetalleCompra;
		this.precioDetalleCompra = precioDetalleCompra;
		this.unidadeDetalleCompra = unidadeDetalleCompra;
	}

	public DetalleCompra() {
		super();
	}

	public int getIdDetalleCompra() {
		return idDetalleCompra;
	}

	public void setIdDetalleCompra(int idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}

	public Compra getCompraDetalleCompra() {
		return compraDetalleCompra;
	}

	public void setCompraDetalleCompra(Compra compraDetalleCompra) {
		this.compraDetalleCompra = compraDetalleCompra;
	}

	public Producto getProductoDetalleCompra() {
		return productoDetalleCompra;
	}

	public void setProductoDetalleCompra(Producto productoDetalleCompra) {
		this.productoDetalleCompra = productoDetalleCompra;
	}

	public int getPrecioDetalleCompra() {
		return precioDetalleCompra;
	}

	public void setPrecioDetalleCompra(int precioDetalleCompra) {
		this.precioDetalleCompra = precioDetalleCompra;
	}

	public int getUnidadeDetalleCompra() {
		return unidadeDetalleCompra;
	}

	public void setUnidadeDetalleCompra(int unidadeDetalleCompra) {
		this.unidadeDetalleCompra = unidadeDetalleCompra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDetalleCompra;
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
		DetalleCompra other = (DetalleCompra) obj;
		if (idDetalleCompra != other.idDetalleCompra)
			return false;
		return true;
	}

}
