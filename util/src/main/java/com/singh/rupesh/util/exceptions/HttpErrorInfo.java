package com.singh.rupesh.util.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

//@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class HttpErrorInfo {

    private final ZonedDateTime timeStamp = ZonedDateTime.now();
    private final String path;
    private final HttpStatus httpStatus;
    private final String message;
}
