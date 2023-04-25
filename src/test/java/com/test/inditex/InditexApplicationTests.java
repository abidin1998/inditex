package com.test.inditex;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.MOCK,
		classes = InditexApplication.class)
@AutoConfigureMockMvc
class InditexApplicationTests {

	@Autowired
	private MockMvc mockMvc;


	@Test
	void firstTest() throws Exception {
		mockMvc.perform(get("/{date}/{productId}/{brandId}",
				"2020-06-14-10.00.00","35455","1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].price").value(35.5));
	}


	@Test
	void secondTest() throws Exception {
		mockMvc.perform(get("/{date}/{productId}/{brandId}",
						"2020-06-14-16.00.00","35455","1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].price").value(35.5))
						.andExpect(jsonPath("$[1].price").value(25.45));
	}

	@Test
	void thirdTest() throws Exception {
		mockMvc.perform(get("/{date}/{productId}/{brandId}",
						"2020-06-14-21.00.00","35455","1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].price").value(35.5));
	}

	@Test
	void fourthTest() throws Exception {
		mockMvc.perform(get("/{date}/{productId}/{brandId}",
						"2020-06-15-10.00.00","35455","1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].price").value(35.5))
				.andExpect(jsonPath("$[1].price").value(30.5));
	}

	@Test
	void fifthTest() throws Exception {
		mockMvc.perform(get("/{date}/{productId}/{brandId}",
						"2020-06-16-21.00.00","35455","1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].price").value(35.5))
				.andExpect(jsonPath("$[1].price").value(38.95));
	}
}
