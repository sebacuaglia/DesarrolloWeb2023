package ar.edu.utn.frvm.sistemas.daw2023.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceHelloWord implements IHolaMundoService {

	@Override
	public String saludar() {
		return "hello";
	}

	@Override
	public String despedir() {
		return "bye";
	}

}
