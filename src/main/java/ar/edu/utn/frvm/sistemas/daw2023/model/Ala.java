package ar.edu.utn.frvm.sistemas.daw2023.model;

import java.util.Date;

import javax.persistence.Entity;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public class Ala extends ObjetoDB {

	@NonNull
	private String nombre;

}
