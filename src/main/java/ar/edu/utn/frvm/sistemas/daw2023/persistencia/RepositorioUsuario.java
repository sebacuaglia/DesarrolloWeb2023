package ar.edu.utn.frvm.sistemas.daw2023.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frvm.sistemas.daw2023.model.Usuario;

@Repository
public interface RepositorioUsuario extends PagingAndSortingRepository<Usuario, Integer>, CrudRepository<Usuario, Integer> {

	Iterable<Usuario> findByLegajoIgnoreCase(String legajo);
	Iterable<Usuario> findByDniIgnoreCase(String dni);
	
}
