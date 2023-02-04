package com.sankha.rating.services;

import com.sankha.rating.entities.Rating;

import java.util.List;

public interface RatingServie {
    Rating createRating(Rating rating);
    List<Rating> getRatings();
    List<Rating> getRatingsByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
