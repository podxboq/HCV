package org.podxboq.hcv.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

	@PutMapping("/ingreso")
	public Ingreso ingreso(@RequestBody int id_mascota, @RequestBody int id_ingreso, @RequestBody String json) {
		JSONObject jsonObject = (new JSONObject(json));
		String f_baja = jsonObject.getString("f_baja");
		Optional<Ingreso> opIngreso = ingresosRepository.findById((long) id_ingreso);
		if (opIngreso.isPresent()) {
			Ingreso ingreso = opIngreso.get();
			ingreso.setFBaja(LocalDate.parse(f_baja));
			if (ingreso.getIdMascota().getId() == id_mascota) {
				return ingresosRepository.save(ingreso);
			}
		}
		return null;
	}

	@DeleteMapping("/ingreso")
	public Ingreso ingreso(@RequestBody int id_ingreso) {
		Optional<Ingreso> opIngreso = ingresosRepository.findById((long) id_ingreso);
		if (opIngreso.isPresent()) {
			Ingreso ingreso = opIngreso.get();
			ingreso.setFBaja(LocalDate.now());
			return ingresosRepository.save(ingreso);
		}
		return null;
	}

	@GetMapping("/mascota/{idMascota}")
	public Optional<Mascota> mascota(@PathVariable Long idMascota) {
		return mascotasRepository.findById(idMascota);
	}

	@GetMapping("/mascota/{idMascota}/ingreso")
	public Iterable<Ingreso> mascotaIngresos(@PathVariable Long idMascota) {
		return ingresosRepository.findAllByMascota(idMascota);
	}

	@PostMapping("/mascota")
	public Mascota createMascota(@RequestBody String json) {
		Mascota mascota = null;
		try {
			mascota = new ObjectMapper().readValue(json, Mascota.class);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}

		return mascotasRepository.save(mascota);
	}

	@DeleteMapping("/mascota/{idMascota}")
	public Optional<Mascota> deleteMascota(@PathVariable Long idMascota) {
		Optional<Mascota> mascota = mascotasRepository.findById(idMascota);
		mascota.ifPresent(value -> value.setFBaja(LocalDate.now()));
		return mascotasRepository.findById(idMascota);
	}
}