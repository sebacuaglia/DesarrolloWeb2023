package ar.edu.utn.frvm.sistemas.daw2023.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frvm.sistemas.daw2023.model.Usuario;
import ar.edu.utn.frvm.sistemas.daw2023.service.IUsuario;

@RestController
@RequestMapping("/Usuario")
public class ControladorUsuario {

	private final IUsuario servicio;
	
	public ControladorUsuario(IUsuario servicio) {
		this.servicio = servicio;
	}
	
	@GetMapping(value = "/search", params = {"legajo"} )
	public Iterable<Usuario> getPorLegajo(@RequestParam(name = "legajo", required = true) String legajo){
		return servicio.getPorLegajo(legajo);
		
	}
	
	@GetMapping(value = "/search", params = {"dni"} )
	public Iterable<Usuario> getPorDni(@RequestParam(name = "dni", required = true) String dni){
		return servicio.getPorDni(dni);
		
	}
	
	@GetMapping(value = "/searchAll")
	public Iterable<Usuario> getTodos() {
		return servicio.getTodos();
	}
	
	@PostMapping("/guardar")
	public Usuario guardar(@RequestBody Usuario r) {
		return this.servicio.guardar(r);
	}
	
	@PutMapping("/actualizar")
	public Usuario actualizar(@RequestBody Usuario r) {
		return this.servicio.actualizar(r);
	}
	
	@DeleteMapping(value = "/delete", params = {"id"} )
	public void delete(@RequestParam(name = "id", required = true) Integer id) {
		this.servicio.deleteUsuario(id);
	}
}
