package ar.edu.utn.frvm.sistemas.daw2023.service;

import java.util.Date;

import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;
import ar.edu.utn.frvm.sistemas.daw2023.model.Reserva;
import ar.edu.utn.frvm.sistemas.daw2023.model.Usuario;

public interface IReserva {

	public Reserva get(Integer id);
	
	Iterable<Reserva> getTodos();
	
	Reserva guardar(Reserva u);

	Reserva actualizar(Reserva u);
	
	void delete(Integer id);
	
	Iterable<Reserva> getPorReservante(String reservante);
	
	Iterable<Reserva> getPorEspacio(EspacioFisico espacio);
	Iterable<Reserva> getPorEspacio(String espacio);
	
	Iterable<Reserva> getPorEspacioYFechas(EspacioFisico espacio, Date inicio, Date fin);


	


}
