package com.singh.rupesh.recommendationService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment =RANDOM_PORT)
class RecommendationServiceApplicationTests {

	@Autowired
	private WebTestClient client;

//	@Test
//	public void getRecommendationByProductId(){
//		int productId = 1;
//
//		client.get()
//				.uri("/recommendation?productId=" + productId)
//				.accept(MediaType.APPLICATION_JSON)
//				.exchange()
//				.expectStatus().isOk()
//				.expectHeader().contentType(MediaType.APPLICATION_JSON)
//				.expectBody()
//				.jsonPath("$.length()").isEqualTo(3)
//				.jsonPath("$.[0].productId").isEqualTo(productId);
//	}

	@Test
	public void getRecommendationMissingParameter(){
		client.get()
				.uri("/recommendation")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isEqualTo(HttpStatus.BAD_REQUEST)
				.expectHeader().contentType(MediaType.APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.path").isEqualTo("/recommendation")
				.jsonPath("$.message").isEqualTo("Required int parameter 'productId' is not present");
	}



	@Test
	void contextLoads() {
	}

}
