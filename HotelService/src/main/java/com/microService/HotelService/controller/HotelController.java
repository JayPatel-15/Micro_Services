package com.microService.HotelService.controller;


import com.microService.HotelService.entities.Hotel;
import com.microService.HotelService.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;

    //create
    @PostMapping("/add-Hotel")
    public Hotel createHotel(@RequestBody Hotel hotel) {
       Hotel savedHotel = hotelService.addHotel(hotel);
        return savedHotel;
    }

    //get single
    @GetMapping("/getHotel/{hotelId}")
    public Optional<Hotel> getHotelById(@PathVariable int hotelId) {
        return hotelService.getHotelById(hotelId);
    }

    //get multiple id
    @GetMapping("/getHotels/{hotelIds}")
    public Optional<List<Hotel>> getHotelByIds(@PathVariable List<Integer> hotelIds) {
        return hotelService.getHotelByIds(hotelIds);
    }

    //get all
    @GetMapping("/getAllHotel")
    public List<Hotel> getAll(){
        return hotelService.getAll();
    }


}