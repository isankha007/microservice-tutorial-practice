package com.sankha.rating.controller;

import com.sankha.rating.entities.Rating;
import com.sankha.rating.services.RatingServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingServie ratingServie;
    //create rating

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return  ResponseEntity.status(HttpStatus.CREATED).body(ratingServie.createRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings( ){
        return  ResponseEntity.ok(ratingServie.getRatings());
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return  ResponseEntity.ok(ratingServie.getRatingsByUserId(userId));
    }

    @GetMapping("hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return  ResponseEntity.ok(ratingServie.getRatingByHotelId(hotelId));
    }

}
