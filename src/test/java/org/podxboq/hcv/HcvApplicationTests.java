package org.podxboq.hcv;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.podxboq.hcv.tests.PostAltaIngresoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class HcvApplicationTests {


	@Test
	void contextLoads() {
		new PostAltaIngresoTest().run();
	}


}