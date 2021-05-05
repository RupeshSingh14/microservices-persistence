package com.singh.rupesh.api.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Getter
@Setter
//@Component
@NoArgsConstructor
public class Product {
    private  Integer productId;
    private  String name;
    private  Integer weight;
    private String serviceAddress;
}
