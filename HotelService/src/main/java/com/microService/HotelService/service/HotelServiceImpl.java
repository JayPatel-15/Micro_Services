package com.microService.HotelService.service;


import com.microService.HotelService.entities.Hotel;
import com.microService.HotelService.respositories.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> getHotelById(int id) {
        Optional<Hotel> User = hotelRepository.findById(id);

        if (User.isPresent()) {
            return User;
        } else {
            return Optional.empty();
        }
    }
}
