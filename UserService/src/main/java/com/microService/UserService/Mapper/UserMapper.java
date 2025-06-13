package com.microService.UserService.Mapper;

import com.microService.UserService.entities.Rating;
import com.microService.UserService.entities.User;
import lombok.Builder;

import java.util.List;
import java.util.stream.Collectors;


@Builder
public class UserMapper {

    private User user;
//    private Rating ratings;
    private List<Rating> ratings;

    public User map() {
        List<Rating> mappedRatings = null;

        if (ratings != null){
            mappedRatings =  ratings.stream()
                    .map(rating -> Rating.builder()
                            .userId(user.getUserId())
                            .ratingId(rating.getRatingId())
                            .hotelId(rating.getHotelId())
                            .rating(rating.getRating())
                            .feedback(rating.getFeedback())
                            .hotel(rating.getHotel())
                            .build()
                    ).collect(Collectors.toList());
        }

        if (user != null) {

            user = User.builder()
                    .name(user.getName())
                    .userId(user.getUserId())
                    .email(user.getEmail())
                    .about(user.getAbout())
                    .ratings(mappedRatings)
                    .build();
//            if (user.getRating() != null) {
//                user.setRating(Rating.builder()
//                        .userId(user.getUserId())
//                        .hotelId(user.getHotel().getId())
//                        .rating(user.getRating().getRating())
//                        .feedback(user.getRating().getFeedback())
//                        .build());
//            }
        }


        return user;
    }
}
