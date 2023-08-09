package ar.edu.utn.frvm.sistemas.daw2023.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frvm.sistemas.daw2023.model.Recurso;
import ar.edu.utn.frvm.sistemas.daw2023.service.IServicioRecurso;

@RestController
@RequestMapping("/Recursos")
public class ControladorRecurso {

	private final IServicioRecurso servicio;
	
	public ControladorRecurso(IServicioRecurso servicio) {
		this.servicio = servicio;
	}


	@GetMapping("/{ID}")
	public Recurso get(@PathVariable("ID") Integer id) {
		//return new Recurso(id,"Proyector");
		return servicio.get(id);
	}
	
	@GetMapping("/rec")
	public Iterable<Recurso> getTodos() {
		return servicio.getTodos();
	}
	
	@PostMapping("/guardar")
	public Recurso guardar(@RequestBody Recurso r) {
		return this.servicio.guardar(r);
	}
}
