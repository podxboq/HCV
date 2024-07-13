package org.podxboq.hcv.controllers;


import org.json.JSONObject;
import org.podxboq.hcv.models.Ingreso;
import org.podxboq.hcv.models.Mascota;
import org.podxboq.hcv.repositories.IngresosRepository;
import org.podxboq.hcv.repositories.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

	@PostMapping("/ingreso")
	public Ingreso ingreso(@RequestBody String json) {
		JSONObject jsonObject = (new JSONObject(json));
		int id_mascota = jsonObject.getInt("id_mascota");
		String f_alta = jsonObject.getString("f_alta");
		Ingreso ingreso = new Ingreso();
		Optional<Mascota> mascota = mascotasRepository.findById((long) id_mascota);
		mascota.ifPresent(ingreso::setIdMascota);
		ingreso.setFAlta(LocalDate.parse(f_alta));

		return ingresosRepository.save(ingreso);
	}

	@GetMapping("/mascota/{idMascota}")
	public Optional<Mascota> mascota(@PathVariable Long idMascota) {
		return mascotasRepository.findById(idMascota);
	}
}