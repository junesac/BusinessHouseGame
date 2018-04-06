package com.db.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.db.bean.CellType;
import com.db.bean.Hotel;
import com.db.bean.Player;
import com.db.shared.BusinessHouseGameConstants;

public class BusinessHouseGame {

	/**
	 * Number of players can be determined by the size of the array.
	 */
	private Player[] players;
	private static Map<Integer, Hotel> hotels = new HashMap<>();

	public BusinessHouseGame(int numberOfplayers) {
		players = new Player[numberOfplayers];
		for (int i = 0; i < numberOfplayers; i++) {
			players[i] = new Player();
		}
	}

	public void getWorthOfEachPlayer() {

		for (int i = 0; i < players.length; i++) {
			int worth = 0;
			Player player = players[i];
			worth += player.getMoney();
			List<Hotel> hotels = player.getHotels();
			for (Hotel h : hotels) {
				worth += h.getWorth();
			}

			System.out.println("Player " + player.getId() + " has total worth "
					+ worth);
			System.out.println(player);
		}
	}

	public void startGame(String[] cells, int[] diceOutputs) {
		int playerChance = 0;
		int place = 0;
		int i = 0;
		while (i < diceOutputs.length) {
			place += diceOutputs[i++];
			place %= cells.length;
			play(players[playerChance % players.length], cells[place - 1],
					place);
			playerChance++;
		}
	}

	private void play(Player player, String cell, int place) {

		if (!canPlayerPlay(player)) {
			System.out.println("Player " + player.getId()
					+ " cannot play further as he has negative balance.");
		}

		if (cell.equalsIgnoreCase(CellType.JAIL.getKey())) {
			player.setMoney(player.getMoney()
					- BusinessHouseGameConstants.JAIL_FINE);
		} else if (cell.equalsIgnoreCase(CellType.TREASURE.getKey())) {
			player.setMoney(player.getMoney()
					+ BusinessHouseGameConstants.TREASURE_AMOUNT);
		} else if (cell.equalsIgnoreCase(CellType.HOTEL.getKey())) {
			Hotel hotel = getHotel(place);
			if (hotel.isOwned()) {
				Player owner = hotel.getOwner();
				owner.setMoney(owner.getMoney() + hotel.getRent());
				player.setMoney(player.getMoney() - hotel.getRent());
			} else {
				if (player.getMoney() > hotel.getWorth()) {
					List<Hotel> hotels = player.getHotels();
					hotels.add(hotel);
					player.buyHotel(hotel);
				}
			}

		} else {
			// Do Nothing in case of empty;
		}

	}

	private Hotel getHotel(int place) {

		Hotel hotel = hotels.get(place);
		if (hotel == null) {
			hotel = new Hotel(place);
			hotels.put(place, hotel);
		}
		return hotel;
	}

	private boolean canPlayerPlay(Player player) {
		return player.getMoney() > 0 ? true : false;
	}
}
