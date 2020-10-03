package serviceImpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Producto;
import pe.edu.upc.repository.IProductoRepository;
import pe.edu.upc.service.IProductoService;

@Named
@RequestScoped
public class ProductoServiceImpl implements IProductoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private IProductoRepository pR;

	@Override
	public void insertar(Producto producto) throws Exception{
		pR.insertar(producto);
	}

	@Override
	public void eliminar(int idProducto) throws Exception{
		pR.eliminar(idProducto);
	}

	@Override
	public void modificar(Producto producto) throws Exception{
		pR.modificar(producto);
	}

	@Override
	public List<Producto> listar() throws Exception{
		return pR.listar();
	}

}
