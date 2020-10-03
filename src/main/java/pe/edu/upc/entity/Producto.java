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
@Table(name = "producto")
public class Producto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;

	@NotEmpty(message = "Ingrese los nombres del producto")
	@Column(name = "nombreProducto", nullable = false, length = 60)
	private String nombreProducto;

	@NotEmpty(message = "Ingrese la categoria a la que pertenece el producto")
	@Column(name = "categoriaProducto", nullable = false, length = 40)
	private String categoriaProducto;

	@Min(1)
	@Max(5000)
	@Column(name = "precioProducto", nullable = false)
	private int precioProducto;

	public Producto(int idProducto, @NotEmpty(message = "Ingrese los nombres del producto") String nombreProducto,
			@NotEmpty(message = "Ingrese la categoria a la que pertenece el producto") String categoriaProducto,
			@Min(1) @Max(5000) int precioProducto) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.categoriaProducto = categoriaProducto;
		this.precioProducto = precioProducto;
	}

	public Producto() {
		super();
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public int getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProducto;
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
		Producto other = (Producto) obj;
		if (idProducto != other.idProducto)
			return false;
		return true;
	}

}
