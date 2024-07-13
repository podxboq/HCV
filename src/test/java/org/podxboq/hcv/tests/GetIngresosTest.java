package org.podxboq.hcv.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.util.AssertionErrors.assertNotNull;

public class GetIngresosTest {

	@Test
	public void run() {
		String url = "http://localhost:8080/ingreso";
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<String> result = restTemplate.getForEntity(url, String.class);
		assertNotNull("No hay ingresos", result);
	}

}