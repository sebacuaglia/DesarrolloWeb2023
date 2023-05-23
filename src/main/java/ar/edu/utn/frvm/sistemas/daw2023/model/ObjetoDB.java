package ar.edu.utn.frvm.sistemas.daw2023.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@MappedSuperclass
@Data
public class ObjetoDB {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
}
