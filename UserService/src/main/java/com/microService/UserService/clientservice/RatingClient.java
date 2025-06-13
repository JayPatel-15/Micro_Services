package com.microService.UserService.clientservice;

import com.microService.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@FeignClient(name = "RATING-SERVICE")
public interface RatingClient {
    @PostMapping("/ratings/add-ratings")
    Rating saveRating(@RequestBody Rating rating);

    @GetMapping("/ratings/getRatings/userId/{userId}")
    Optional<List<Rating>> getRatings(@PathVariable int userId);
}