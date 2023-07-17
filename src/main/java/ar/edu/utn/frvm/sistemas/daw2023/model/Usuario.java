package ar.edu.utn.frvm.sistemas.daw2023.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Usuario extends ObjetoDB {

	@NonNull
	private String nombre;
	@NonNull
	private String apellido;
	@NonNull
	private String legajo;
	@NonNull
	private String dni;
	private String email;
	private String telefono;
	
	@ManyToMany
	private Rol rol;

}
