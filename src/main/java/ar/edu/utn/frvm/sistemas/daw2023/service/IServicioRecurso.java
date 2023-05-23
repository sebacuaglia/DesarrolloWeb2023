package ar.edu.utn.frvm.sistemas.daw2023.service;

import java.util.List;

import ar.edu.utn.frvm.sistemas.daw2023.model.Recurso;

public interface IServicioRecurso {

	public Recurso get(Integer id);
	
	Iterable<Recurso> getTodos();
	
	Recurso guardar(Recurso r);
}
