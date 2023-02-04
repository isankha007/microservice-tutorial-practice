package com.sankha.user.service.UserService.external;

import com.sankha.user.service.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    @PostMapping("/ratings")
    Rating createRating(Rating values);

    @PutMapping("/ratings/{ratingId}")
    Rating updateRating(@PathVariable String ratingId,Rating values);

    @DeleteMapping("/ratings/{ratingId}")
    Rating deleteRating(@PathVariable String ratingId);
}
