package ar.edu.utn.frvm.sistemas.daw2023.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frvm.sistemas.daw2023.model.Ala;

@Repository
public interface RepositorioAla extends PagingAndSortingRepository<Ala, Integer>, CrudRepository<Ala, Integer> {

}
