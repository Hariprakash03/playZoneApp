package com.playapp.service;

import java.util.List;

import com.playapp.exceptions.GameNotFoundException;
import com.playapp.model.Booking;
import com.playapp.model.Game;

public interface IPlayService {
	void addGame(Game game);
	void updateGame(int gameId,double price);
	Game getById(int gameId);
	void deleteGame(int gameId);
	List<Game>getAllGames();
	
	List<Game>getByPlace(String place)throws GameNotFoundException;
	List<Game>getByPlaceAndPrice(String place,double price)throws GameNotFoundException;
	List<Game>getByPlaceAndName(String place,String name)throws GameNotFoundException;
	List<Game>getByName(String name)throws GameNotFoundException;
	List<Game>getByPrice(double price)throws GameNotFoundException;
	void addCourt(Booking book);
	List<Booking>getBookingDetails()throws GameNotFoundException;

}
