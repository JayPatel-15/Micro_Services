package com.microService.UserService.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rating {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int ratingId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int userId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int hotelId;
    private  int rating;
    private  String feedback;
    private Hotel hotel;
}