package com.sankha.user.service.UserService.services;

import com.sankha.user.service.UserService.entities.Hotel;
import com.sankha.user.service.UserService.entities.Rating;
import com.sankha.user.service.UserService.entities.User;
import com.sankha.user.service.UserService.exceptions.ResourceNotFoundException;
import com.sankha.user.service.UserService.external.HotelService;
import com.sankha.user.service.UserService.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public User saveUser(User user) {
        String randomId= UUID.randomUUID().toString();
        user.setUserId(randomId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
         User user=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User with given Id not found in server "+userId));

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/44cfd94c-7118-4bd2-9ad2-c4c7a482288f/",
                Rating[].class);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        logger.info("Ratings "+ratingsOfUser);
        ratings.stream().map(rating->{
   //localhost:8082/hotels/df01c718-a836-40a6-88af-9dfda64417fc
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel= hotelService.getHotel(rating.getHotelId()); //forEntity.getBody();
          //  logger.info("Response Status code {}",forEntity.getStatusCode());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());


        user.setRatings(ratings);
         return user;


    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
