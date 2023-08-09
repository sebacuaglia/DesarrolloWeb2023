package ar.edu.utn.frvm.sistemas.daw2023.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;
import ar.edu.utn.frvm.sistemas.daw2023.model.Reserva;
import ar.edu.utn.frvm.sistemas.daw2023.model.Usuario;
import ar.edu.utn.frvm.sistemas.daw2023.persistencia.RepositorioReserva;

@Service
public class ServicioReserva implements IReserva {

	private final RepositorioReserva repositorioReserva;
	
	
	public ServicioReserva(RepositorioReserva repositorioReserva) {
		this.repositorioReserva = repositorioReserva;
	}

	@Override
	public Reserva get(Integer id) {
		return repositorioReserva.findById(id).orElse(null);
	}

	@Override
	public Iterable<Reserva> getTodos() {
		return repositorioReserva.findAll();
	}

	@Override
	public Reserva guardar(Reserva u) {
		
		ArrayList<Reserva> reservasEncontradas = getPorEspacioYFechas(u.getEspacioFisico(),u.getFechaReserva(),u.getFechaFinReserva());
		if (reservasEncontradas.size()>0) {
			new Exception("YA EXISTE UNA RESERVA PARA ESA FECHA");
		}
		u.setFechaAltaReserva(new Date(System.currentTimeMillis()));
		
		return repositorioReserva.save(u);
	}

	@Override
	public void delete(Integer id) {
		repositorioReserva.deleteById(id);
	}

	@Override
	public Iterable<Reserva> getPorReservante(Usuario reservante) {
		return repositorioReserva.findByReservante(reservante);
	}

	@Override
	public Iterable<Reserva> getPorEspacio(EspacioFisico espacio) {
		return repositorioReserva.findByEspacioFisico(espacio);
	}

	@Override
	public ArrayList<Reserva> getPorEspacioYFechas(EspacioFisico espacio, Date inicio, Date fin) {
		ArrayList<Reserva> reservasfiltradas = new ArrayList<Reserva>();
		Iterable<Reserva> reservas = getPorEspacio(espacio);
		for (Reserva reserva : reservas) {
			if(inicio.equals(reserva.getFechaReserva()) || fin.equals(reserva.getFechaFinReserva()) ||
					inicio.after(reserva.getFechaReserva()) && inicio.before(reserva.getFechaFinReserva()) ||
					fin.after(reserva.getFechaReserva()) && fin.before(reserva.getFechaFinReserva()) ) {
				
				reservasfiltradas.add(reserva);
						
			}
		}
		
		return reservasfiltradas;
	}

	
}
