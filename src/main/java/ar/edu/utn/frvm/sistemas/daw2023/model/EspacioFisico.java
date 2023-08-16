package ar.edu.utn.frvm.sistemas.daw2023.model;

import javax.persistence.Entity;
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
	
	private String recursos;
	
    @ManyToOne
	private Estado estado;
}
