package com.microService.UserService.Mapper;

import com.microService.UserService.entities.Rating;
import com.microService.UserService.entities.User;
import lombok.Builder;


@Builder
public class UserMapper {

    private User user;
    private Rating ratings;

    public User map() {

        if (user != null) {

            user = User.builder()
                    .name(user.getName())
                    .userId(user.getUserId())
                    .email(user.getEmail())
                    .about(user.getAbout())
                    .ratings(
                            user.getRatings() != null ?
                                    Rating.builder()
                                            .userId(user.getUserId())
                                            .ratingId(ratings.getRatingId())
                                            .hotelId(user.getRatings() != null ? user.getRatings().getHotelId() : 0)
                                            .rating(ratings.getRating())
                                            .feedback(ratings.getFeedback())
                                            .build()
                                    : null
                    )
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
