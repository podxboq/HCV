package org.podxboq.hcv.tests;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class DeleteBajaIngresoTest {

	@Test
	public void run() {
		String url = "http://localhost:8080/ingreso/1";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
	}

}