package com.microService.HotelService.respositories;

import com.microService.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    @Query("SELECT h FROM Hotel h WHERE h.id IN :ids")
    List<Hotel> findHotelsByIds(@Param("ids") List<Integer> ids);

}
