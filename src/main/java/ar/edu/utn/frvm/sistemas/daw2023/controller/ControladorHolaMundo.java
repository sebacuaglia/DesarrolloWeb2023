package ar.edu.utn.frvm.sistemas.daw2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frvm.sistemas.daw2023.service.IHolaMundoService;

@RestController
public class ControladorHolaMundo {

	@Autowired
	private IHolaMundoService servicio;
	
	/*@GetMapping("/")
	public String hola() {
		return "Hola DAW 2023";
	}
	
	@GetMapping("/hola")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping(path = "/hola", params = {"name"})
	public String hola(@RequestParam("name") String namqe) {
		return servicioHolaMundo.hello(namqe);
	}
	
	@GetMapping(path = "/hola/{nombre}", params = {"name"})
	public String hola2(@PathVariable("nombre") String nombre) {
		return "Hola DAW 2023. 2 Soy " + nombre;
	}
	*/
	
	@GetMapping(path = "/hola")
	public String hola3() {
		return servicio.saludar();
	}
	
}
