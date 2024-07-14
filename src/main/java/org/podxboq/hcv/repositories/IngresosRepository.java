package org.podxboq.hcv.repositories;

import org.podxboq.hcv.models.Ingreso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngresosRepository extends CrudRepository<Ingreso, Long> {

	public List<Ingreso> findAllByMascota(Long idMascota);
}