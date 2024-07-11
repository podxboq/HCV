package org.podxboq.hcv.controllers;


import org.podxboq.hcv.models.Ingreso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
	boolean x;

	@GetMapping("/ingreso")
	public Ingreso ingreso() {
		return new Ingreso();
	}
}