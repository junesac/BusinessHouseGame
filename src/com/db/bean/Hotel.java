package com.db.bean;

import com.db.shared.BusinessHouseGameConstants;

public class Hotel {

	private String id;
	private int worth;
	private int rent;
	private boolean isOwned;
	private Player owner;

	public Hotel(int place) {

		this.id = "H" + place;
		worth = BusinessHouseGameConstants.HOTEL_WORTH;
		rent = BusinessHouseGameConstants.HOTEL_RENT;
		isOwned = false;
		this.owner = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public int getWorth() {
		return worth;
	}

	public void setWorth(int worth) {
		this.worth = worth;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	public boolean isOwned() {
		return isOwned;
	}

	public void setOwned(boolean isOwned) {
		this.isOwned = isOwned;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", worth=" + worth + ", rent=" + rent
				+ ", isOwned=" + isOwned + "]";
	}

}
