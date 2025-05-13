package com.microService.Ratingservice.controllers;

import com.microService.Ratingservice.entities.Rating;
import com.microService.Ratingservice.services.Ratingservice;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@RequiredArgsConstructor
public class RatingController {

    private final Ratingservice ratingService;

    //create rating
    @PostMapping("/add-ratings")
    public Rating addRating(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }

    //get all
    @GetMapping("/getAllRatings")
    public List<Rating> getRatings() {
        return ratingService.getRatings();
    }

    //get all of user

    @GetMapping("/getRatings/userId/{userId}")
    public List<Rating> getRatingsByUserId(@PathVariable int userId) {
        return ratingService.getRatingByUserId(userId);
    }

    //get all of hotels
    @GetMapping("/getRatings/hotelId/{hotelId}")
    public List<Rating> getRatingsByHotelId(@PathVariable int hotelId) {
        return ratingService.getRatingByHotelId(hotelId);
    }
}
