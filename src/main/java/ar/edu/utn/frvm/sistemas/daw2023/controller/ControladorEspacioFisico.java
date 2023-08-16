package ar.edu.utn.frvm.sistemas.daw2023.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;
import ar.edu.utn.frvm.sistemas.daw2023.service.IEspacioFisico;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/EspacioFisico")
public class ControladorEspacioFisico {

	private final IEspacioFisico servicio;
	
	public ControladorEspacioFisico(IEspacioFisico servicio) {
		this.servicio = servicio;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/searchAll")
	public Iterable<EspacioFisico> getTodos() {
		return servicio.getTodos();
	}

	@GetMapping(params = {"page"} )
	public Iterable<EspacioFisico> getTodosPaginados(Pageable p){
		return servicio.getTodosPaginado(p);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/search", params = {"nombre"} )
	public Iterable<EspacioFisico> getFiltroNombre(@RequestParam(name = "nombre", required = true) String nombre){
		return servicio.getByNombre(nombre);
		
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/search", params = {"capacidad"} )
	public Iterable<EspacioFisico> getFiltroCapacidad(@RequestParam(name = "capacidad", required = true) Integer capacidad){
		return servicio.getByCapacidad(capacidad);
	}
	
	@GetMapping(value = "/search", params = {"nombre","capacidad"} )
	public Iterable<EspacioFisico> getFiltroNombreAndCapacidad(@RequestParam(name = "nombre", required = true) String nombre, @RequestParam(name = "capacidad", required = true) Integer capacidad){
		return servicio.getByNombreAndCapacidad(nombre,capacidad);
		
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/guardar")
	public EspacioFisico guardar(@RequestBody EspacioFisico r) {
		return this.servicio.guardar(r);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/actualizar")
	public EspacioFisico actualizar(@RequestBody EspacioFisico r) {
		return this.servicio.actualizar(r);
	}
	

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value = "/delete", params = {"id"} )
	public void delete(@RequestParam(name = "id", required = true) Integer id) {
		this.servicio.eliminar(id);
	}
	
}
