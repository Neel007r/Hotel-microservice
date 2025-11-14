package com.myhotel.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myhotel.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
