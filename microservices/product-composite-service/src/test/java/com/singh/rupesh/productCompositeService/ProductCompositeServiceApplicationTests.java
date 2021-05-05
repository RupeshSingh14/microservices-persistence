//package com.singh.rupesh.productCompositeService;
//
//import com.singh.rupesh.api.core.Product;
//import com.singh.rupesh.api.core.Recommendation;
//import com.singh.rupesh.api.core.Review;
//import com.singh.rupesh.productCompositeService.services.ProductCompositeIntegration;
//import com.singh.rupesh.util.customExceptions.InvalidInputException;
//import com.singh.rupesh.util.customExceptions.NotFoundException;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.reactive.server.WebTestClient;
//
//import java.util.Collections;
//
//import static java.util.Collections.singletonList;
//import static org.mockito.Mockito.when;
//import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
//import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
//
///**
// * @author RUPESH
// *<p>To test product-composite service</p>
// */
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@SpringBootTest(webEnvironment = RANDOM_PORT)
//class ProductCompositeServiceApplicationTests {
//
//	private static final int PRODUCT_ID_OK = 1;
//	private static final int PRODUCT_ID_NOT_FOUND = 2;
//	private static final int PRODUCT_ID_INVALID = 3;
//
//	@Autowired
//	private WebTestClient client;
//
//	@MockBean
//	private ProductCompositeIntegration compositeIntegration;
//
//	@BeforeAll
//	public void setup(){
//		when(compositeIntegration.getProduct(PRODUCT_ID_OK)).
//				thenReturn(new Product(PRODUCT_ID_OK, "name", 1, "mockAddress"));
//		when(compositeIntegration.getRecommendations(PRODUCT_ID_OK)).
//				thenReturn(singletonList(new Recommendation
//						(PRODUCT_ID_OK, 1, "author", 1, "content", "mockAddress")));
//		when(compositeIntegration.getReviews(PRODUCT_ID_OK)).
//				thenReturn(singletonList(new Review
//						(PRODUCT_ID_OK, 1, "author", "subject", "content", "mockAddress")));
//		when(compositeIntegration.getProduct(PRODUCT_ID_NOT_FOUND)).thenThrow(new NotFoundException("No product found for productId: " + PRODUCT_ID_NOT_FOUND));
//		when(compositeIntegration.getProduct(PRODUCT_ID_INVALID)).thenThrow(new InvalidInputException("Invalid productId: " + PRODUCT_ID_INVALID));
//	}
//
//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	public void getProductById(){
//		client.get()
//				.uri("/product-composite/" + PRODUCT_ID_OK)
//				.accept(MediaType.APPLICATION_JSON)
//				.exchange()
//				.expectStatus().isOk()
//				.expectHeader().contentType(MediaType.APPLICATION_JSON)
//				.expectBody()
//				.jsonPath("$.productId").isEqualTo(PRODUCT_ID_OK)
//				.jsonPath("$.recommendations.length()").isEqualTo(1)
//				.jsonPath("$.reviews.length()").isEqualTo(1);
//	}
//
//	@Test
//	public void getProductNotFound(){
//		client.get()
//				.uri("/product-composite/" + PRODUCT_ID_NOT_FOUND)
//				.accept(MediaType.APPLICATION_JSON)
//				.exchange()
//				.expectStatus().isNotFound()
//				.expectHeader().contentType(MediaType.APPLICATION_JSON)
//				.expectBody()
//				.jsonPath("$.path").isEqualTo("/product-composite/" + PRODUCT_ID_NOT_FOUND)
//				.jsonPath("$.message").isEqualTo("No product found for productId: " + PRODUCT_ID_NOT_FOUND);
//	}
//
//	public void getProductInvalidInput(){
//		client.get()
//				.uri("/product-composite/" + PRODUCT_ID_INVALID)
//				.accept(MediaType.APPLICATION_JSON)
//				.exchange()
//				.expectStatus().isEqualTo(UNPROCESSABLE_ENTITY)
//				.expectHeader().contentType(MediaType.APPLICATION_JSON)
//				.expectBody()
//				.jsonPath("$.path").isEqualTo("/product-composite" + PRODUCT_ID_INVALID)
//				.jsonPath("$.message").isEqualTo("INVALID:" + PRODUCT_ID_INVALID);
//
//
//	}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
