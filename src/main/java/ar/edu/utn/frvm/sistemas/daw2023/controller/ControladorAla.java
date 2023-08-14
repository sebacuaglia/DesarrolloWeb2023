package ar.edu.utn.frvm.sistemas.daw2023.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frvm.sistemas.daw2023.model.Ala;
import ar.edu.utn.frvm.sistemas.daw2023.model.Usuario;
import ar.edu.utn.frvm.sistemas.daw2023.service.IAla;
import ar.edu.utn.frvm.sistemas.daw2023.service.IUsuario;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Ala")
public class ControladorAla {


	private final IAla servicio;
	
	public ControladorAla(IAla servicio) {
		this.servicio = servicio;
	}
	
	@GetMapping(value = "/searchAll")
	public Iterable<Ala> getTodos() {
		return servicio.getTodos();
	}
}
