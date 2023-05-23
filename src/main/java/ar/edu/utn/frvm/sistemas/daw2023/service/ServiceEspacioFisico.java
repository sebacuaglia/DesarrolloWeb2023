package ar.edu.utn.frvm.sistemas.daw2023.service;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;
import ar.edu.utn.frvm.sistemas.daw2023.persistencia.RepositorioEspacioFisico;

@Service
public class ServiceEspacioFisico  implements IEspacioFisico{


	private final RepositorioEspacioFisico repositorioEspacioFisico;
	
	public ServiceEspacioFisico(RepositorioEspacioFisico repositorioEspacioFisico) {
		this.repositorioEspacioFisico = repositorioEspacioFisico;
	}
	
	@Override
	public EspacioFisico get(Integer id) {
		return repositorioEspacioFisico.findById(id).orElse(null);
	}

	@Override
	public Iterable<EspacioFisico> getTodos() {
		return repositorioEspacioFisico.findAll();
	}
	
	@Override
	public Iterable<EspacioFisico> getTodosPaginado(Pageable p) {
		return repositorioEspacioFisico.findAll(p);
	}
	@Override
	public EspacioFisico guardar(EspacioFisico r) {
		return repositorioEspacioFisico.save(r);
	}

	@Override
	public EspacioFisico actualizar(Integer id) {
		return repositorioEspacioFisico.save(null);
	}

	@Override
	public void eliminar(Integer id) {
		repositorioEspacioFisico.deleteById(id);
	}

	@Override
	public Iterable<EspacioFisico> getByNombre(String nombre) {
		return repositorioEspacioFisico.findAllByNombre(nombre);
	}

	@Override
	public Iterable<EspacioFisico> getByCapacidad(Integer capacidad) {
		return repositorioEspacioFisico.findAllByCapacidad(capacidad);
	}

	@Override
	public Iterable<EspacioFisico> getByNombreAndCapacidad(String nombre, Integer capacidad) {
		return repositorioEspacioFisico.findAllByNombreignoreCaseContainsAndCapacidad(nombre, capacidad);
	}

	
	
}
