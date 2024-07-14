package org.podxboq.hcv.tests;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class GetIngresosByMascotaTest {

	@Test
	public void run() {
		String url = "http://localhost:8080/mascota/1/ingreso";
		HttpEntity<String> result = new RestTemplate().getForEntity(url, String.class);
		assertNotNull("No hay ingresos", result);
	}

}