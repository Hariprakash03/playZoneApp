package com.playapp.service;

import java.util.List;
import java.util.stream.Collectors;

import com.playapp.dao.IPlayDao;
import com.playapp.dao.PlayDaoImpl;
import com.playapp.exceptions.GameNotFoundException;
import com.playapp.model.Booking;
import com.playapp.model.Game;

public class PlayServiceImpl implements IPlayService {
	IPlayDao playService=new PlayDaoImpl();

	@Override
	public void addGame(Game game) {
		playService.addGame(game);
		

	}

	@Override
	public void updateGame(int gameId, double price) {
		playService.updateGame(gameId, price);

	}

	@Override
	public Game getById(int gameId) {
		return playService.findById(gameId);
	}

	@Override
	public void deleteGame(int gameId) {
		playService.deleteGame(gameId);

	}

	@Override
	public List<Game> getAllGames() {
		return playService.findAllGames().stream()
				.sorted((c1,c2)->c1.getName().compareTo(c2.getName())).collect(Collectors.toList());
	}

	@Override
	public List<Game> getByPlace(String place) throws GameNotFoundException {
		if(playService.findByPlace(place).isEmpty()) {
			throw new GameNotFoundException("Game not found");
		}
		return playService.findByPlace(place).stream()
				.sorted((c1,c2)->c1.getPlace().compareTo(c2.getPlace())).collect(Collectors.toList());
	}

	@Override
	public List<Game> getByPlaceAndPrice(String place, double price) throws GameNotFoundException {
		if(playService.findByPlaceAndPrice(place, price).isEmpty()) {
			throw new GameNotFoundException("Game not found");
		}
		return playService.findByPlaceAndPrice(place, price).stream()
				.sorted((c1,c2)->c1.getPlace().compareTo(c2.getPlace())).collect(Collectors.toList());
	}

	@Override
	public List<Game> getByPlaceAndName(String place, String name) throws GameNotFoundException {
		if(playService.findByPlaceAndName(place, name).isEmpty()) {
			throw new GameNotFoundException("Game not found");
		}
		return playService.findByPlaceAndName(place, name).stream()
				.sorted((c1,c2)->c1.getName().compareTo(c2.getName())).collect(Collectors.toList());
	}

	@Override
	public List<Game> getByName(String name) throws GameNotFoundException {
		if(playService.findByName(name).isEmpty()) {
			throw new GameNotFoundException("Game not found");
		}
		return playService.findByName(name).stream()
				.sorted((c1,c2)->c1.getName().compareTo(c2.getName())).collect(Collectors.toList());
	}

	@Override
	public List<Game> getByPrice(double price) throws GameNotFoundException {
		if(playService.findByPrice(price).isEmpty()) {
			throw new GameNotFoundException("Game not found");
		}
		return playService.findByPrice(price);
	}

	@Override
	public void addCourt(Booking book) {
		playService.bookCourt(book);
		
	}

	@Override
	public List<Booking> getBookingDetails() throws GameNotFoundException {
		if(playService.findBookingDetails().isEmpty()) {
			throw new GameNotFoundException("Game not found");
		}
		return playService.findBookingDetails();
	}

}
