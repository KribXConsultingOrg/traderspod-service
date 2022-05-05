package com.traderspod.listing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

//@RunWith(SpringJUnit4ClassRunner.class)

@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//@AutoConfigureMockMvc
@ContextConfiguration(classes = { TestConfig.class })
@ActiveProfiles("test")
public class ServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
