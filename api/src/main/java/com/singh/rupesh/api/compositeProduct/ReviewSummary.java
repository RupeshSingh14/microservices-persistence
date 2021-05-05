package com.singh.rupesh.api.compositeProduct;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReviewSummary {

    private final int reviewId;
    private final String author;
    private final String subject;
    private final String content;


    public ReviewSummary() {
        reviewId = 0;
        author = null;
        subject = null;
        content = null;
    }
}