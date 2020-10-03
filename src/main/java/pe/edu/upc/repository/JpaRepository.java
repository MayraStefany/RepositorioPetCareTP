package pe.edu.upc.repository;

import java.util.List;
import java.util.Optional;

public interface JpaRepository<T, ID> {
	T insertar(T entity) throws Exception;
	T modificar(T entity) throws Exception;
	void eliminar(ID id) throws Exception;
	List<T> listar() throws Exception;
	Optional<T> findById(ID id) throws Exception;
}
