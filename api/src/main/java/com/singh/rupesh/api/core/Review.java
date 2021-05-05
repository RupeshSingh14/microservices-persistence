package com.singh.rupesh.api.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Review {
    private  int productId;
    private  int reviewId;
    private  String author;
    private  String subject;
    private  String content;
    private  String serviceAddress;
}
