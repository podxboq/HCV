package org.podxboq.hcv.tests;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class DeleteBajaMascotaTest {

	@Test
	public void run() {
		String url = "http://localhost:8080/mascota/1";
		ResponseEntity<String> response = new RestTemplate().exchange(url, HttpMethod.DELETE, null, String.class);
		assertEquals("Error", response.getStatusCode(), HttpStatus.OK);
	}

}