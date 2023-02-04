package com.sankha.user.service.UserService.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;

    private int rating;

    private String feedback;

    private Hotel hotel;

}