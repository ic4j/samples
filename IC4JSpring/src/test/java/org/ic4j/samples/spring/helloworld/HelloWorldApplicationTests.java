package org.ic4j.samples.spring.helloworld;

import java.util.concurrent.CompletableFuture;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldApplicationTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private HelloWorldService helloWorldService;

	@Test
	void postGreet() {
			when(helloWorldService.greet("Motoko")).thenReturn(CompletableFuture.completedFuture("Hello, Motoko!"));
			try {
				mvc.perform(MockMvcRequestBuilders.post("/greet").contentType(MediaType.TEXT_PLAIN).content("Motoko"))
						.andExpect(status().isOk()).andExpect(content().string("Hello, Motoko!"));
				Assertions.assertThat(true).isTrue();
			} catch (Exception ex) {
				Assertions.fail("Exception: " + ex.getMessage());
			}
	}

}
