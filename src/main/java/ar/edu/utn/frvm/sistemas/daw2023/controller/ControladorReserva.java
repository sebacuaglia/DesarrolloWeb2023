package ar.edu.utn.frvm.sistemas.daw2023.controller;

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
import ar.edu.utn.frvm.sistemas.daw2023.model.Reserva;
import ar.edu.utn.frvm.sistemas.daw2023.model.Usuario;
import ar.edu.utn.frvm.sistemas.daw2023.service.IReserva;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/Reserva")
public class ControladorReserva {

	private final IReserva servicio;
	
	public ControladorReserva(IReserva servicio) {
		this.servicio = servicio;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/guardar")
	public Reserva guardar(@RequestBody Reserva r) {
		return this.servicio.guardar(r);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/search", params = {"reservante"} )
	public Iterable<Reserva> getPorReservante(@RequestParam(name = "reservante", required = true) String reservante){
		return servicio.getPorReservante(reservante);

	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/search", params = {"espacio"} )
	public Iterable<Reserva> getPorDni(@RequestParam(name = "espacio", required = true) String espacio){
		return servicio.getPorEspacio(espacio);

	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(value = "/searchAll")
	public Iterable<Reserva> getTodos() {
		return servicio.getTodos();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/actualizar")
	public Reserva actualizar(@RequestBody Reserva u) {
		return this.servicio.actualizar(u);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping(value = "/delete", params = {"id"} )
	public void delete(@RequestParam(name = "id", required = true) Integer id) {
		this.servicio.delete(id);
	}
}
