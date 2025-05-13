package com.microService.UserService.clientservice;

import com.microService.UserService.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "RATING-SERVICE")
public interface RatingClient {
    @PostMapping("/ratings/add-ratings")
    Rating saveRating(@RequestBody Rating rating);
}