package ar.edu.utn.frvm.sistemas.daw2023.service;

import org.springframework.stereotype.Service;

import ar.edu.utn.frvm.sistemas.daw2023.model.Ala;
import ar.edu.utn.frvm.sistemas.daw2023.model.Recurso;
import ar.edu.utn.frvm.sistemas.daw2023.persistencia.RepositorioAla;

@Service
public class ServicioAla implements IAla{


	private final RepositorioAla repositorioAla;
	
	public ServicioAla(RepositorioAla repositorioAla) {
		this.repositorioAla = repositorioAla;
	}
	
	@Override
	public Iterable<Ala> getTodos() {
		return repositorioAla.findAll();
	}

}
