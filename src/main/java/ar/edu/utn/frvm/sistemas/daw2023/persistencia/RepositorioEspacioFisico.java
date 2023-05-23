package ar.edu.utn.frvm.sistemas.daw2023.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;

@Repository
public interface RepositorioEspacioFisico extends PagingAndSortingRepository<EspacioFisico, Integer>, CrudRepository<EspacioFisico, Integer>{

	Iterable<EspacioFisico> findAllByNombre(String nombre);
	Iterable<EspacioFisico> findAllByNombreignoreCase(String nombre);
	Iterable<EspacioFisico> findAllByNombreignoreCaseContains(String nombre);
	Iterable<EspacioFisico> findAllByNombreignoreCaseContainsAndCapacidad(String nombre, Integer capacidad);
	Iterable<EspacioFisico> findAllByCapacidad(Integer capacidad);
	
}