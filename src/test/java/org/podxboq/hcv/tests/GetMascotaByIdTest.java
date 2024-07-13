package org.podxboq.hcv.tests;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class GetMascotaByIdTest {

	@Test
	public void run() {
		String url = "http://localhost:8080/mascota/1";
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> result = restTemplate.getForEntity(url, String.class);
		assertNotNull("No está la mascota", result);
	}

}