package com.sankha.user.service.UserService.controllers;

import com.sankha.user.service.UserService.entities.User;
import com.sankha.user.service.UserService.payload.ApiResponse;
import com.sankha.user.service.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.HdrHistogram.AtomicHistogram;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    private Logger logger=LoggerFactory.getLogger(UserController.class);



    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    //signle user
    @GetMapping("/{userId}")
    //@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    //@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback" )
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback" )
    public ResponseEntity<User> getUser(@PathVariable String userId){
        logger.info("Get Single User Handler: UserController");

        User user=userService.getUser(userId);
        logger.info("Get Single User Handler: UserController{}",user);

        return ResponseEntity.ok(user);
    }

    ///creating fallback method
    public ResponseEntity<User>  ratingHotelFallback(String userId,Exception ex){
        ex.printStackTrace();
        logger.info("Fallback is executed because service is down: ",ex.getMessage());
        User user = User.builder().userId("12345").email("dummy@gmail.com")
                .name("Dummy").about("Dummy User created").build();
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }
//All user
@GetMapping
public ResponseEntity<List<User>> getAllUsers(  ){
    List<User> allUsers=userService.getAllUser();
    return ResponseEntity.ok(allUsers);
}

}
