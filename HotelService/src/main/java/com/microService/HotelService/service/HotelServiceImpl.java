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
        Optional<Hotel> hotel = hotelRepository.findById(id);

        if (hotel.isPresent()) {
            return hotel;
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<Hotel>> getHotelByIds(List<Integer> ids) {
        Optional<List<Hotel>> hotels = Optional.of(hotelRepository.findHotelsByIds(ids));
        return hotels;
    }
}
