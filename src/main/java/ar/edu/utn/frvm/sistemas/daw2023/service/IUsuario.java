package ar.edu.utn.frvm.sistemas.daw2023.service;

import ar.edu.utn.frvm.sistemas.daw2023.model.Usuario;

public interface IUsuario {

	public Usuario get(Integer id);
	
	Iterable<Usuario> getTodos();
	
	Usuario guardar(Usuario u);
	
	Usuario actualizar(Usuario u);
	
	Iterable<Usuario> getPorLegajo(String legajo);
	
	Iterable<Usuario> getPorDni(String dni);
	
	void deleteUsuario(Integer id);
	
}
