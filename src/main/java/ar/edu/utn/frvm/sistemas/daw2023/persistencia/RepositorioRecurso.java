package ar.edu.utn.frvm.sistemas.daw2023.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frvm.sistemas.daw2023.model.Recurso;

@Repository
public interface RepositorioRecurso extends CrudRepository<Recurso, Integer> {

}
