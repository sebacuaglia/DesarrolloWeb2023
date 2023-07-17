package ar.edu.utn.frvm.sistemas.daw2023.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Estado extends ObjetoDB {

	@NonNull
	private String nombre;
	private String descripcion;
}
