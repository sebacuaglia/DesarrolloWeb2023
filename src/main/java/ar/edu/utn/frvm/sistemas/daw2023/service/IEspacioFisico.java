package ar.edu.utn.frvm.sistemas.daw2023.service;

import org.springframework.data.domain.Pageable;

import ar.edu.utn.frvm.sistemas.daw2023.model.EspacioFisico;

public interface IEspacioFisico {

	public EspacioFisico get(Integer id);
	
	public Iterable<EspacioFisico> getTodos();
	
	public Iterable<EspacioFisico> getTodosPaginado(Pageable p);
	
	public EspacioFisico guardar(EspacioFisico r);
	
	public EspacioFisico actualizar(EspacioFisico id);
	
	public void eliminar(Integer id);
	
	public Iterable<EspacioFisico> getByNombre(String nombre);
	
	public Iterable<EspacioFisico> getByCapacidad(Integer capacidad);
	
	public Iterable<EspacioFisico> getByNombreAndCapacidad(String nombre, Integer capacidad);

}
