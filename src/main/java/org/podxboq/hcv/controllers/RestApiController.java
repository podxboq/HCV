package org.podxboq.hcv.controllers;


import org.podxboq.hcv.models.Ingreso;
import org.podxboq.hcv.models.Mascota;
import org.podxboq.hcv.repositories.IngresosRepository;
import org.podxboq.hcv.repositories.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RestApiController {
	@Autowired
	private IngresosRepository ingresosRepository;
	@Autowired
	private MascotasRepository mascotasRepository;

	@GetMapping("/ingreso")
	public Iterable<Ingreso> ingreso() {
		return ingresosRepository.findAll();
	}

	@PostMapping(value = "/ingreso", consumes = "application/json")
	public Ingreso ingresoAlta(@RequestBody Ingreso ingreso) {

		return ingresosRepository.save(ingreso);
	}

	@GetMapping("/mascota/{idMascota}")
	public Optional<Mascota> mascota(@PathVariable Long idMascota) {
		return mascotasRepository.findById(idMascota);
	}
}