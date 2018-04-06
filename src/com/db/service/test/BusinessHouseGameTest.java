package com.db.service.test;

import java.util.ArrayList;
import java.util.List;

import com.db.bean.Hotel;
import com.db.bean.Player;
import com.db.service.BusinessHouseGame;

public class BusinessHouseGameTest {

	private BusinessHouseGame businessHouseGame;

	public void setUp() {
		businessHouseGame = new BusinessHouseGame(2);

	}

	private Player[] getPlayers() {

		List<Player> players = new ArrayList<>();
		Player p1 = new Player();
		p1.setMoney(12);
		Hotel h1 = new Hotel(12);
		Hotel h2 = new Hotel(23);

		List<Hotel> hotels = new ArrayList<>();
		hotels.add(h1);
		hotels.add(h2);

		p1.setHotels(hotels);

		// Added 2 players
		players.add(p1);
		players.add(new Player());

		return players.toArray(new Player[players.size()]);
	}

	public void getWorthOfEachPlayerTest() {

	}

}
