package ar.edu.utn.frvm.sistemas.daw2023.service;

import org.springframework.stereotype.Service;

import ar.edu.utn.frvm.sistemas.daw2023.model.Usuario;
import ar.edu.utn.frvm.sistemas.daw2023.persistencia.RepositorioUsuario;

@Service
public class ServicioUsuario implements IUsuario {

	private final RepositorioUsuario repositorioUsuario;
	
	public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}
	
	@Override
	public Usuario get(Integer id) {
		return repositorioUsuario.findById(id).orElse(null);
	}

	@Override
	public Iterable<Usuario> getTodos() {
		return repositorioUsuario.findAll();
	}

	@Override
	public Usuario guardar(Usuario u) {
		return repositorioUsuario.save(u);
	}
	
	@Override
	public Usuario actualizar(Usuario u) {
		return repositorioUsuario.save(u);
	}

	@Override
	public Iterable<Usuario> getPorLegajo(String legajo) {
		return repositorioUsuario.findByLegajoIgnoreCase(legajo);
	}

	@Override
	public Iterable<Usuario> getPorDni(String dni) {
		return repositorioUsuario.findByDniIgnoreCase(dni);
	}

	@Override
	public void deleteUsuario(Integer id) {
		repositorioUsuario.deleteById(id);
	}

}
