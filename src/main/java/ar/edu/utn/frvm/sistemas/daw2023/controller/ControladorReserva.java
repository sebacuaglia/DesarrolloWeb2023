package ar.edu.utn.frvm.sistemas.daw2023.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;
import ar.edu.utn.frvm.sistemas.daw2023.model.Reserva;
import ar.edu.utn.frvm.sistemas.daw2023.model.Usuario;
import ar.edu.utn.frvm.sistemas.daw2023.service.IReserva;

public class ControladorReserva {

	private final IReserva servicio;
	
	public ControladorReserva(IReserva servicio) {
		this.servicio = servicio;
	}
	
	@PostMapping("/guardar")
	public Reserva guardar(@RequestBody Reserva r) {
		return this.servicio.guardar(r);
	}
	
	@GetMapping(value = "/search", params = {"reservante"} )
	public Iterable<Reserva> getPorReservante(@RequestParam(name = "reservante", required = true) Usuario reservante){
		return servicio.getPorReservante(reservante);
		
	}
	
	@GetMapping(value = "/search", params = {"espacio"} )
	public Iterable<Reserva> getPorDni(@RequestParam(name = "espacio", required = true) EspacioFisico espacio){
		return servicio.getPorEspacio(espacio);
		
	}
	
	@GetMapping(value = "/searchAll")
	public Iterable<Reserva> getTodos() {
		return servicio.getTodos();
	}
	
	@PutMapping("/actualizar")
	public Reserva actualizar(@RequestBody Reserva r) {
		return this.servicio.guardar(r);
	}
	
	@DeleteMapping(value = "/delete", params = {"id"} )
	public void delete(@RequestParam(name = "id", required = true) Integer id) {
		this.servicio.delete(id);
	}
}
