package com.sankha.rating.repositories;

import com.sankha.rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {
//custom finder method
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
