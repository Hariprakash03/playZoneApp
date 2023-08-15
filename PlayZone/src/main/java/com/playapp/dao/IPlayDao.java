package com.playapp.dao;

import java.util.List;

import com.playapp.exceptions.GameNotFoundException;
import com.playapp.model.Booking;
import com.playapp.model.Game;

public interface IPlayDao {
	void addGame(Game game);
	void updateGame(int gameId,double price);
	Game findById(int gameId);
	void deleteGame(int gameId);
	List<Game>findAllGames();
	
	List<Game>findByPlace(String place)throws GameNotFoundException;
	List<Game>findByPlaceAndPrice(String place,double price)throws GameNotFoundException;
	List<Game>findByPlaceAndName(String place,String name)throws GameNotFoundException;
	List<Game>findByName(String name)throws GameNotFoundException;
	List<Game>findByPrice(double price)throws GameNotFoundException;
	void bookCourt(Booking book);
	List<Booking>findBookingDetails();


}
