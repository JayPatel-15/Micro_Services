package com.microService.UserService.entities;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rating {
    private int ratingId;
    private int userId;
    private int hotelId;
    private  int rating;
    private  String feedback;
    private Hotel hotel;
}