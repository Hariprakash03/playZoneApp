package com.playapp.model;

public class Game {
	String name;
	String place;
	int level;
	int gameId;
	double price;
	public Game(String name, String place,int level, double price) {
		super();
		this.name = name;
		this.place = place;
		this.level = level;
		this.price = price;
	}
	public Game() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Game [name=" + name + ", place=" + place + ", level=" + level + ", gameId=" + gameId + ", price="
				+ price + "]";
	}
	
}
