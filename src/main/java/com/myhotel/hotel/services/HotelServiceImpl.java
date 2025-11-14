package com.myhotel.hotel.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhotel.hotel.Exceptions.ResourceNotFoundException;
import com.myhotel.hotel.entities.Hotel;
import com.myhotel.hotel.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		String randomHotelId = UUID.randomUUID().toString();
		hotel.setId(randomHotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotel(String hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id is not found on server: "+ hotelId));
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	@Override
	public void deleteHotel(String hotelId) {
		hotelRepository.deleteById(hotelId);		
	}

}
