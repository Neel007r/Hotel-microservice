package com.myhotel.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myhotel.hotel.entities.Hotel;
import com.myhotel.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	public HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
		Hotel hotel1 =hotelService.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getOneHotel(@PathVariable String hotelId){
		Hotel hotel2 =hotelService.getHotel(hotelId);
		return ResponseEntity.ok(hotel2);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> showAllHotels(){
		List<Hotel> allHotels = hotelService.getAllHotel();
		return ResponseEntity.ok(allHotels);
	}
	
	@DeleteMapping("/{hotelId}")
	public void deleteHotelData(@PathVariable String hotelId) {
		hotelService.deleteHotel(hotelId);
		
	}

	
}



