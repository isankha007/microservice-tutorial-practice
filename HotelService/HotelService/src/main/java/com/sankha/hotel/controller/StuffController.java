package com.sankha.hotel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
public class StuffController {

    @GetMapping
    public ResponseEntity<List<String>> getDtaffs(){
        List<String> list= Arrays.asList("Sankha","Nemo","Dakkar");
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }
}
