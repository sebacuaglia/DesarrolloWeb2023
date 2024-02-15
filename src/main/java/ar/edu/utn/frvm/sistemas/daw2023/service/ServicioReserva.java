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
    ArrayList<Reserva> reservasEncontradas = getPorEspacioYFechas(u.getEspacioFisico(), u.getFechaReserva(), u.getFechaFinReserva());
    if (!reservasEncontradas.isEmpty()) {
        throw new IllegalArgumentException("YA EXISTE UNA RESERVA PARA ESA FECHA");
    }

    u.setFechaAltaReserva(u.getFechaAltaReserva());
    u.setFechaReserva(u.getFechaReserva()); // Establecer la fecha de reserva proporcionada desde el frontend
    u.setFechaFinReserva(u.getFechaFinReserva()); // Establecer la fecha fin de reserva proporcionada desde el frontend

    return repositorioReserva.save(u);
	}

	@Override
	public Reserva actualizar(Reserva u) {
		ArrayList<Reserva> reservasEncontradas = getPorEspacioYFechas(u.getEspacioFisico(), u.getFechaReserva(), u.getFechaFinReserva());

		if (!reservasEncontradas.isEmpty()) {
			for (Reserva reservaEncontrada : reservasEncontradas) {
				if (!reservaEncontrada.getId().equals(u.getId())) {
					throw new IllegalArgumentException("YA EXISTE UNA RESERVA PARA ESA FECHA");
				}
			}
		}

		Reserva reservaExistente = repositorioReserva.findById(u.getId()).orElse(null);
		if (reservaExistente != null) {
			if (u.getFechaReserva().equals(reservaExistente.getFechaReserva())) {
				u.setFechaReserva(reservaExistente.getFechaReserva());
			}
			if (u.getFechaFinReserva().equals(reservaExistente.getFechaFinReserva())) {
				u.setFechaFinReserva(reservaExistente.getFechaFinReserva());
			}
		}

		return repositorioReserva.save(u);
	}



	@Override
	public void delete(Integer id) {
		repositorioReserva.deleteById(id);
	}

	@Override
	public Iterable<Reserva> getPorReservante(String reservante) {
		return repositorioReserva.findByReservanteNombreContainingIgnoreCaseOrReservanteApellidoContainingIgnoreCase(reservante,reservante);
	}

	@Override
	public Iterable<Reserva> getPorEspacio(EspacioFisico espacio) {
		return repositorioReserva.findByEspacioFisico(espacio);
	}

	@Override
	public Iterable<Reserva> getPorEspacio(String espacio) {
		return repositorioReserva.findByEspacioFisicoNombreContainingIgnoreCase(espacio);
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
