package org.podxboq.hcv.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.podxboq.hcv.models.Ingreso;
import org.podxboq.hcv.models.Mascota;
import org.podxboq.hcv.repositories.IngresosRepository;
import org.podxboq.hcv.repositories.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
		Long id_mascota = jsonObject.getLong("id_mascota");
		String f_alta = jsonObject.getString("f_alta");
		Optional<Mascota> optMascota = mascotasRepository.findById(id_mascota);
		if (optMascota.isPresent()) {
			Mascota mascota = optMascota.get();
			Ingreso ingreso = new Ingreso();
			ingreso.setIdMascota(id_mascota);
			ingreso.setFAlta(LocalDate.parse(f_alta));
			ingreso.setResponsableId(mascota.getResponsableId());
			return ingresosRepository.save(ingreso);
		}
		return null;
	}

	@PutMapping("/ingreso/{id_mascota}/{id_ingreso}")
	public ResponseEntity<String> ingreso(@PathVariable Long id_mascota, @PathVariable Long id_ingreso, @RequestBody String json) {
		JSONObject jsonObject = (new JSONObject(json));
		String f_baja = jsonObject.getString("f_baja");
		Optional<Ingreso> opIngreso = ingresosRepository.findById(id_ingreso);
		if (opIngreso.isPresent()) {
			Ingreso ingreso = opIngreso.get();
			ingreso.setFBaja(LocalDate.parse(f_baja));
			if (ingreso.getIdMascota().equals(id_mascota)) {
				ingresosRepository.save(ingreso);
				return ResponseEntity.ok(new JSONObject(ingreso).toString());
			} else {
				return ResponseEntity.badRequest().build();
			}
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/ingreso/{id_ingreso}")
	public ResponseEntity<String> ingreso(@PathVariable Long id_ingreso) {
		Optional<Ingreso> opIngreso = ingresosRepository.findById(id_ingreso);
		if (opIngreso.isPresent()) {
			Ingreso ingreso = opIngreso.get();
			ingreso.setFAnula(LocalDate.now());
			ingresosRepository.save(ingreso);
			return ResponseEntity.ok(new JSONObject(ingreso).toString());
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/mascota/{id_mascota}")
	public Optional<Mascota> mascota(@PathVariable Long id_mascota) {
		return mascotasRepository.findById(id_mascota);
	}

	@GetMapping("/mascota/{id_mascota}/ingreso")
	public Iterable<Ingreso> mascotaIngresos(@PathVariable Long id_mascota) {
		return ingresosRepository.findAllByIdMascota(id_mascota);
	}

	@PostMapping("/mascota")
	public ResponseEntity<String> createMascota(@RequestBody String json) {
		Mascota mascota = null;
		try {
			mascota = new ObjectMapper().readValue(json, Mascota.class);
		} catch (JsonProcessingException e) {
			return ResponseEntity.badRequest().build();
		}
		mascotasRepository.save(mascota);
		return ResponseEntity.ok(new JSONObject(mascota).toString());
	}

	@DeleteMapping("/mascota/{idMascota}")
	public ResponseEntity<String> deleteMascota(@PathVariable Long idMascota) {
		Optional<Mascota> optMascota = mascotasRepository.findById(idMascota);
		if (optMascota.isPresent()) {
			Mascota mascota = optMascota.get();
			mascota.setFBaja(LocalDate.now());
			mascotasRepository.save(mascota);
			return ResponseEntity.ok(new JSONObject(mascota).toString());
		}
		return ResponseEntity.notFound().build();
	}
}