package com.singh.rupesh.api.core;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author RUPESH
 * @apiNote API to expose recommendations for products
 */
public interface RecommendationService {

    /**
     * <p>Sample usage: curl $HOST:$PORT/recommendation/1</p>
     * @param productId
     * @return recommendations for a product id
     */
    @GetMapping(
            value = "/recommendation",
            produces = "application/json")
    List<Recommendation> getRecommendations(@RequestParam(value = "productId", required = true) int productId);

    /**
     * @param body
     * @return
     */
    @PostMapping(
            value = "/recommendation",
            consumes = "application/json",
            produces = "application/json")
    Recommendation createRecommendation(@RequestBody Recommendation body);

    /**
     * @param productId
     */
    @DeleteMapping(value = "/recommendation")
    void deleteRecommendations(@RequestParam(value = "productId", required = true) int productId);







}
