package com.db.bean;

import java.util.ArrayList;
import java.util.List;

import com.db.shared.BusinessHouseGameConstants;

public class Player {

	private static int count = 1;

	private int id;
	private int money;
	private List<Hotel> hotels;

	public Player() {
		hotels = new ArrayList<>();
		money = BusinessHouseGameConstants.INITIAL_MONEY_OF_PLAYER;
		id = count++;
	}

	public void buyHotel(Hotel hotel) {
		hotels.add(hotel);
		hotel.setOwned(true);
		hotel.setOwner(this);
		this.money = this.money - hotel.getWorth();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", money=" + money + ", hotels=" + hotels
				+ "]";
	}

}
