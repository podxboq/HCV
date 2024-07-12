package org.podxboq.hcv.repositories;

import org.podxboq.hcv.models.Mascota;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotasRepository extends CrudRepository<Mascota, Long> {

}