package ar.edu.utn.frvm.sistemas.daw2023.service;

import org.springframework.stereotype.Service;

//@Service
public class ServicioHolaMundo implements IHolaMundoService{

	@Override
	public String saludar() {
		return "Hola DAW 2023";
	}

	@Override
	public String despedir() {
		return "chau";
	}
}
