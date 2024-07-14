package org.podxboq.hcv;

import org.junit.jupiter.api.Test;
import org.podxboq.hcv.tests.GetIngresosTest;
import org.podxboq.hcv.tests.GetMascotaByIdTest;
import org.podxboq.hcv.tests.PostAltaIngresoTest;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class HcvApplicationTests {


	@Test
	void contextLoads() {
		new GetIngresosTest().run();
		new PostAltaIngresoTest().run();
		new GetMascotaByIdTest().run();
	}

}