package org.podxboq.hcv.tests;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class DeleteBajaMascotaTest {

	@Test
	public void run() {
		String url = "http://localhost:8080/mascota/1";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	}

}