package com.sankha.hotel.services;


import com.sankha.hotel.entities.Hotel;

import java.util.List;

public interface HotelServices {
    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel get(String id);
}
