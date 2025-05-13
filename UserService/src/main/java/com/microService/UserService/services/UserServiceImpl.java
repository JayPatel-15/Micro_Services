package com.microService.UserService.services;

import com.microService.UserService.Mapper.UserMapper;
import com.microService.UserService.clientservice.HotelClient;
import com.microService.UserService.clientservice.RatingClient;
import com.microService.UserService.entities.Hotel;
import com.microService.UserService.entities.Rating;
import com.microService.UserService.entities.User;
import com.microService.UserService.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RatingClient ratingClient;
    private final HotelClient hotelClient;

    private final RestTemplate restTemplate;

    @Override
    @Transactional
    public User saveUser(User user) {
        User  savedUser =  userRepository.save(user);
        Rating rating = user.getRatings();
        rating.setUserId(savedUser.getUserId());
        if (user.getRatings() != null) {

            Optional<Hotel> hotel = hotelClient.getHotelById(user.getRatings().getHotelId());

            if(!hotel.isEmpty()){
                Rating savedRating =  ratingClient.saveRating(rating);
//                savedUser.setRatings(savedRating);
                rating.setRatingId(savedRating.getRatingId());
            } else {
                System.out.println("Hotel with id "+ user.getRatings().getHotelId() + " does not exist. Rolling back.");
            }


        }



        User userMap = UserMapper.builder()
                .user(savedUser)
                .ratings(rating)
                .build()
                .map();
        return userMap;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).get();
    }
}
