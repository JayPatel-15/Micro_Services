package com.microService.HotelService.service;

import com.microService.HotelService.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    //create

    Hotel addHotel(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
     Optional<Hotel> getHotelById(int id);

    //get multiple
     Optional<List<Hotel>> getHotelByIds(List<Integer> ids);

}
