package ar.edu.utn.frvm.sistemas.daw2023.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;

@Repository
public interface RepositorioEspacioFisico extends PagingAndSortingRepository<EspacioFisico, Integer>, CrudRepository<EspacioFisico, Integer>{

	Iterable<EspacioFisico> findAllByNombreContainingIgnoreCase(String nombre);
	Iterable<EspacioFisico> findAllByNombreIgnoreCase(String nombre);
	Iterable<EspacioFisico> findAllByNombreIgnoreCaseContains(String nombre);
	Iterable<EspacioFisico> findAllByNombreIgnoreCaseContainsAndCapacidadGreaterThan(String nombre, Integer capacidad);
	Iterable<EspacioFisico> findAllByCapacidadGreaterThan(Integer capacidad);
	
}