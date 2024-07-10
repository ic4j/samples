package org.ic4j.samples.spring.helloworld;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Test
	void postGreet() {
			try {
				mvc.perform(MockMvcRequestBuilders.post("/greet").contentType(MediaType.TEXT_PLAIN).content("Motoko"))
						.andExpect(status().isOk()).andExpect(content().string("Hello, Motoko!"));
			} catch (Exception ex) {
				Assertions.fail("Exception: " + ex.getMessage());
			}
	}

}
