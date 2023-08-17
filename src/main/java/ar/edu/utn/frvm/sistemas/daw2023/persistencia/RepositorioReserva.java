package ar.edu.utn.frvm.sistemas.daw2023.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;
import ar.edu.utn.frvm.sistemas.daw2023.model.Reserva;
import ar.edu.utn.frvm.sistemas.daw2023.model.Usuario;

@Repository
public interface RepositorioReserva extends PagingAndSortingRepository<Reserva, Integer>, CrudRepository<Reserva, Integer> {

	public Iterable<Reserva> findByEspacioFisico(EspacioFisico espacio);
	public Iterable<Reserva> findByReservante(Usuario reservante);

	
}
