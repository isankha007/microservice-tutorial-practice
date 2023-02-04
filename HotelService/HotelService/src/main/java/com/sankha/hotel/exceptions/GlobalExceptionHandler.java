package com.sankha.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GlobalExceptionHandler {
    public ResponseEntity<Map<String, Object>> notFoundException(ResourceNotFoundException ex){
        Map<String,Object> hm=new HashMap<>();
        hm.put("message",ex.getMessage());
        hm.put("success",false);
        hm.put("status", HttpStatus.NOT_FOUND);
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(hm);
    }
}
