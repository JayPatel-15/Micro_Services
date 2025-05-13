package com.microService.UserService.clientservice;

import com.microService.UserService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelClient {
    @PostMapping("/hotel")
    Hotel saveHotel(@RequestBody Hotel hotel);

    @GetMapping("/hotel/getHotel/{hotelId}")
    Optional<Hotel> getHotelById(@PathVariable int hotelId);
}

