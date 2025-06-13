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

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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

        List<Rating> ratings = user.getRatings();
        if (ratings != null && !ratings.isEmpty()) {
        ratings.forEach(r -> r.setUserId(savedUser.getUserId()));

            // Check hotel existence for each rating
            for (Rating r : ratings){
                Optional<Hotel> hotel = hotelClient.getHotelById(r.getHotelId());
                if (hotel.isEmpty()) {
                    throw new IllegalArgumentException("Hotel with id " + r.getHotelId() + " does not exist. Rolling back.");
                } else {
                   Rating savedRating = ratingClient.saveRating(r);
//                savedUser.setRatings(savedRating);
                    ratings.forEach(rating -> rating.setRatingId(savedRating.getRatingId()));
                }
            }
        }



        User userMap = UserMapper.builder()
                .user(savedUser)
                .ratings(ratings)
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

        User userDetails = userRepository.findById(userId).orElse(null);

        List<Rating> ratingDetails = ratingClient.getRatings(userId).orElse(null);

        List<Integer> hotelIds = ratingDetails.stream().map(r -> r.getHotelId()).collect(Collectors.toList());

        List<Hotel> hotelList = hotelClient.getHotelByIds(hotelIds).orElse(Collections.emptyList());

        Map<Integer,Hotel> hotelMap = hotelList.stream().collect(Collectors.toMap(Hotel::getId, Function.identity())); // <- Make sure you're using getId(), not getHotelId()


        for (Rating r : ratingDetails){
            Hotel hotel = hotelMap.get(r.getHotelId());
            if (hotel != null){
                r.setHotel(hotel);
            }
        }

        User user = UserMapper.builder()
                .user(userDetails)
                .ratings(ratingDetails)
                .build()
                .map();

        return user;
    }
}
