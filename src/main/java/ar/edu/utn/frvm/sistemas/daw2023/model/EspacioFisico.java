package ar.edu.utn.frvm.sistemas.daw2023.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class EspacioFisico extends ObjetoDB {

	@NonNull
	private String nombre;
	
	private Integer capacidad;
	
	@ManyToOne
	private Ala ala;
	
	@ManyToMany
	private List<Recurso> recursos;
	
	@ManyToOne
	private Estado estado;
}
