package org.podxboq.hcv.tests;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class PostAltaMascotaTest {

	@Test
	public void run() {
		String url = "http://localhost:8080/mascota";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("especie", "Araña");
			jsonObject.put("raza", "Musaraña");
			jsonObject.put("edad", 1);
			jsonObject.put("codigo", "A1");
			jsonObject.put("responsableId", "3458666");
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