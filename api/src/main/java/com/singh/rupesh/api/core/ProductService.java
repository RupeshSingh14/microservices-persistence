package com.singh.rupesh.api.core;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author RUPESH
 *
 * @apiNote API to expose products
 */
//@Service
public interface ProductService {

    /**
     * <p>Sample usage: curl $HOST:$PORT/product/1</p>
     *
     * @param productId
     * @return the product, if found, else null
     */
    @GetMapping(
            value= "/product/{productId}",
            produces = "application/json")
    Product getProduct(@PathVariable Integer productId);


    /**
     * @param body
     * @return
     */
    @PostMapping(
            value = "/product",
            consumes = "application/json",
            produces = "application/json")
    Product createProduct(@RequestBody Product body);


    /**
     * sample usage: curl -X DELETE $HOST:$PORT/product/1
     * @param productId
     */
    @DeleteMapping(value = "product/{productId}")
    void deleteProduct(@PathVariable int productId);

}
