package com.singh.rupesh.api.core;

import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author RUPESH
 * @apiNote API to expose reviews of products
 */
public interface ReviewService {

    /**
     * Sample usage: curl $HOST:$PORT/review?productId=1
     * @param productId
     * @return reviews for a product id
     */
    @GetMapping(
            value = "/review",
            produces = "application/json")
    List<Review> getReviews(@RequestParam(value = "productId", required = true) int productId);

    /**
     * @param body
     * @return
     */
    @PostMapping(
            value = "/review",
            consumes = "application/json",
            produces = "application/json"
    )
    Review createReview(@RequestBody Review body);

    /**
     * @param productId
     */
    @DeleteMapping(value = "/review")
    void deleteReviews(@RequestParam(value = "productId, required = true") int productId);
}