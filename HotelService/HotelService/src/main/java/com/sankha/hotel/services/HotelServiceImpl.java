package com.sankha.hotel.services;

import com.sankha.hotel.entities.Hotel;
import com.sankha.hotel.exceptions.ResourceNotFoundException;

import com.sankha.hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelServices {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
         String randomId= UUID.randomUUID().toString();
         hotel.setId(randomId);
         return hotelRepository.save(hotel);
    }



    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with this Id not found"));
    }
}
