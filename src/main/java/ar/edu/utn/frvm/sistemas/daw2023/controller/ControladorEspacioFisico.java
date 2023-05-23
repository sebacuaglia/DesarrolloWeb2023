package ar.edu.utn.frvm.sistemas.daw2023.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;
import ar.edu.utn.frvm.sistemas.daw2023.service.IEspacioFisico;

@RestController
@RequestMapping("/EspacioFisico")
public class ControladorEspacioFisico {

	private final IEspacioFisico servicio;
	
	public ControladorEspacioFisico(IEspacioFisico servicio) {
		this.servicio = servicio;
	}
	
	@GetMapping(params = {"page"} )
	public Iterable<EspacioFisico> getTodosPaginados(Pageable p){
		return servicio.getTodosPaginado(p);
		
	}
	
	@GetMapping(value = "/search", params = {"nombre"} )
	public Iterable<EspacioFisico> getFiltroNombre(@RequestParam(name = "nombre", required = true) String nombre){
		return servicio.getByNombre(nombre);
		
	}
	
	@GetMapping(value = "/search", params = {"capacidad"} )
	public Iterable<EspacioFisico> getFiltroCapacidad(@RequestParam(name = "capacidad", required = true) Integer capacidad){
		return servicio.getByCapacidad(capacidad);
		
	}
	
	@GetMapping(value = "/search", params = {"nombre","capacidad"} )
	public Iterable<EspacioFisico> getFiltroNombreAndCapacidad(@RequestParam(name = "nombre", required = true) String nombre, @RequestParam(name = "capacidad", required = true) Integer capacidad){
		return servicio.getByNombreAndCapacidad(nombre,capacidad);
		
	}
	
	
}
