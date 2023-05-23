package ar.edu.utn.frvm.sistemas.daw2023.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.edu.utn.frvm.sistemas.daw2023.model.Recurso;
import ar.edu.utn.frvm.sistemas.daw2023.persistencia.RepositorioRecurso;

@Service
public class ServicioRecurso implements IServicioRecurso {

	private final RepositorioRecurso repositorioRecurso;
	
	public ServicioRecurso(RepositorioRecurso repositorioRecurso) {
		this.repositorioRecurso = repositorioRecurso;
	}

	@Override
	public Recurso get(Integer id) {
		return repositorioRecurso.findById(id).orElse(null);
		/*
		Optional<Recurso> buscado = repositorioRecurso.findById(id);
		if (buscado.isPresent()) {
			return buscado.get();
		} else {
			return null;
		}*/
	}

	@Override
	public Iterable<Recurso> getTodos() {
		
		return repositorioRecurso.findAll();
	}

	@Override
	public Recurso guardar(Recurso r) {
		
		return repositorioRecurso.save(r);
	}

	
}
