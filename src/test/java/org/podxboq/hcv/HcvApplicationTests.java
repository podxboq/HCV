package org.podxboq.hcv;

import org.junit.jupiter.api.Test;
import org.podxboq.hcv.tests.*;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class HcvApplicationTests {


	@Test
	void contextLoads() {
		new DeleteBajaIngresoTest().run();
		new DeleteBajaMascotaTest().run();
		new GetIngresosByMascotaTest().run();
		new GetIngresosTest().run();
		new GetMascotaByIdTest().run();
		new PostAltaIngresoTest().run();
		new PostAltaMascotaTest().run();
		new PutBajaIngresoTest().run();
	}

}