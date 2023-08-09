package ar.edu.utn.frvm.sistemas.daw2023.persistencia;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;
import ar.edu.utn.frvm.sistemas.daw2023.model.Reserva;
import ar.edu.utn.frvm.sistemas.daw2023.model.Usuario;

public interface RepositorioReserva extends PagingAndSortingRepository<Reserva, Integer>, CrudRepository<Reserva, Integer> {

	public Iterable<Reserva> findByEspacioFisico(EspacioFisico espacioFisico);
	public Iterable<Reserva> findByReservante(Usuario reservante);
	public Iterable<Reserva> findAllByEspacioFisicoAndFechaInicioReservaBetweenOrFechaFReservaBetween(EspacioFisico espacio, Date from, Date to);
	
}
