package com.microService.HotelService.service;

import com.microService.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

    //create

    Hotel addHotel(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel getHotelById(int id);

}
