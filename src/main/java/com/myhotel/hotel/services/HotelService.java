package com.myhotel.hotel.services;

import java.util.List;

import com.myhotel.hotel.entities.Hotel;

public interface HotelService {
	
	public Hotel saveHotel(Hotel hotel);
	
	public Hotel getHotel(String hotelId);
	
	public List<Hotel> getAllHotel();
	
	public void deleteHotel(String hotelId);
	

}
