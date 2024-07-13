package org.podxboq.hcv.tests;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class PostAltaIngresoTest {

	@Test
	public void run() {
		String url = "http://localhost:8080/ingreso";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("id_mascota", 1);
			jsonObject.put("f_alta", "2024-01-01");
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
		HttpEntity<String> request =
			new HttpEntity<String>(jsonObject.toString(), httpHeaders);
		String result =
			restTemplate.postForObject(url, request, String.class);

		assertNotNull("s", result);
	}

}