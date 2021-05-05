package com.singh.rupesh.api.compositeProduct;

import org.springframework.web.bind.annotation.*;

/**
 * @author RUPESH
 * @apiNote API to expose products info
 */
public interface ProductCompositeService {

    /**
     * Sample usage: curl $HOST:$PORT/product-composite/1
     * @param productId
     * @return the composite product info, if found, else null
     */
    @GetMapping(
            value = "/product-composite/{productId}",
            produces = "application/json")
    ProductAggregate getCompositeProduct(@PathVariable int productId);

    @PostMapping(
            value= "/product-composite",
            consumes = "application/json")
    void createCompositeProduct(@RequestBody ProductAggregate body);

    @DeleteMapping(value = "/product-composite/{productId}")
    void deleteCompositeProduct(@PathVariable int productId);
}
