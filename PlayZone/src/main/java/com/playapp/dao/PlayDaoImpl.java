package com.playapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.playapp.exceptions.GameNotFoundException;
import com.playapp.model.Booking;
import com.playapp.model.Game;
import com.playapp.util.Queries;

public class PlayDaoImpl implements IPlayDao {

	@Override
	public void addGame(Game game) {
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.INSERTQUERY);){
			statement.setString(1,game.getName());
			statement.setString(2,game.getPlace());
			statement.setInt(3, game.getLevel());
			statement.setDouble(4,game.getPrice());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateGame(int gameId, double price) {
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.UPDATEQUERY);){
			statement.setInt(2, gameId);
			statement.setDouble(1, price);
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Game findById(int gameId) {
		Game game=new Game();
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYID);){
			statement.setInt(1, gameId);
			ResultSet result=statement.executeQuery();
			
			game.setGameId(result.getInt(4));
			game.setLevel(result.getInt(3));
			game.setName(result.getString(1));
			game.setPlace(result.getString(2));
			game.setPrice(result.getDouble(5));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return game;
	}

	@Override
	public void deleteGame(int gameId) {
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.DELETEQUERY);){
			statement.setInt(1, gameId);
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public List<Game> findAllGames() {
		List<Game>games=new ArrayList<>();
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYALL);){
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				Game game=new Game();
				game.setGameId(result.getInt(4));
				game.setLevel(result.getInt(3));
				game.setName(result.getString(1));
				game.setPlace(result.getString(2));
				game.setPrice(result.getDouble(5));
				games.add(game);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return games;
	}

	@Override
	public List<Game> findByPlace(String place) throws GameNotFoundException {
		List<Game>games=new ArrayList<>();
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYPLACE);){
			statement.setString(1, place);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				Game game=new Game();
				game.setGameId(result.getInt(4));
				game.setLevel(result.getInt(3));
				game.setName(result.getString(1));
				game.setPlace(result.getString(2));
				game.setPrice(result.getDouble(5));
				games.add(game);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return games;
			
		}

	@Override
	public List<Game> findByPlaceAndPrice(String place, double price) throws GameNotFoundException {
		List<Game>games=new ArrayList<>();
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYPLACEANDPRICE);){
			statement.setString(1, place);
			statement.setDouble(2, price);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				Game game=new Game();
				game.setGameId(result.getInt(4));
				game.setLevel(result.getInt(3));
				game.setName(result.getString(1));
				game.setPlace(result.getString(2));
				game.setPrice(result.getDouble(5));
				games.add(game);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return games;
			
		}

	@Override
	public List<Game> findByPlaceAndName(String place, String name) throws GameNotFoundException {
		List<Game>games=new ArrayList<>();
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYPLACEANDNAME);){
			statement.setString(1, place);
			statement.setString(2,name);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				Game game=new Game();
				game.setGameId(result.getInt(4));
				game.setLevel(result.getInt(3));
				game.setName(result.getString(1));
				game.setPlace(result.getString(2));
				game.setPrice(result.getDouble(5));
				games.add(game);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return games;
			
		}

	@Override
	public List<Game> findByName(String name) throws GameNotFoundException {
		List<Game>games=new ArrayList<>();
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYNAME);){
			statement.setString(1, name);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				Game game=new Game();
				game.setGameId(result.getInt(4));
				game.setLevel(result.getInt(3));
				game.setName(result.getString(1));
				game.setPlace(result.getString(2));
				game.setPrice(result.getDouble(5));
				games.add(game);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return games;
		
	}

	@Override
	public List<Game> findByPrice(double price) throws GameNotFoundException {
		List<Game>games=new ArrayList<>();
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.QUERYBYPRICE);){
			statement.setDouble(1, price);
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				Game game=new Game();
				game.setGameId(result.getInt(4));
				game.setLevel(result.getInt(3));
				game.setName(result.getString(1));
				game.setPlace(result.getString(2));
				game.setPrice(result.getDouble(5));
				games.add(game);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return games;
	}

	@Override
	public void bookCourt(Booking book) {
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.BOOKINGCOURT);){
			statement.setString(1,book.getName());
			statement.setString(2,book.getPlace());
			statement.setInt(4, book.getLevel());
			statement.setInt(3, book.getGameId());
			statement.setDouble(5,book.getPrice());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Booking> findBookingDetails() {
		List<Booking>games=new ArrayList<>();
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement1=connection.prepareStatement(Queries.COURTS);){
			ResultSet result=statement1.executeQuery();
			while(result.next()) {
				Booking game=new Booking();
				game.setGameId(result.getInt(4));
				game.setLevel(result.getInt(3));
				game.setName(result.getString(1));
				game.setPlace(result.getString(2));
				game.setPrice(result.getDouble(5));
				games.add(game);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return games;
	}	}

