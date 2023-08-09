package ar.edu.utn.frvm.sistemas.daw2023.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Reserva extends ObjetoDB {
	
	@NotNull
	private Date fechaReserva;
	@NotNull
	private Date fechaFinReserva;
	@NotNull
	private Date fechaAltaReserva;
	
	private String motivoReserva;
	
	@NotNull
	private Integer capacidadRequerida;
	
	@ManyToOne
	private Estado estado;
	
	@ManyToOne
	private EspacioFisico espacioFisico;
	
	@ManyToOne
	private Usuario reservante;
	
}
