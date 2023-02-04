package com.sankha.user.service.UserService;

import com.sankha.user.service.UserService.entities.Rating;
import com.sankha.user.service.UserService.external.RatingService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceApplicationTests {

	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RatingService ratingServie;
	@Test
	void contextLoads() {
	}

	@Test
	void createRating(){
		Rating rating= Rating.builder().userId(" ").hotelId(" ")
				.feedback("using feign").build();
		Rating Savedrating = ratingServie.createRating(rating);
		logger.info("Ratings created-> {}",rating);
	}



}
