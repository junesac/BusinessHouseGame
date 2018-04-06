package com.db.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.db.service.BusinessHouseGame;

public class AppMain {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Number of players : ");
		int numberOfPlayers = Integer.parseInt(bf.readLine());

		System.out.println("Cell Position & Types : ");
		String[] cells = bf.readLine().split(",");

		System.out.println("Dice Outputs : ");
		int[] diceOutputs = getDiceOutputs(bf.readLine().split(","));
		// Arrays.stream(diceOutputs).mapToInt(Integer::parseInt).toArray();

		BusinessHouseGame businessHouseGameService = new BusinessHouseGame(
				numberOfPlayers);
		businessHouseGameService.startGame(cells, diceOutputs);
		businessHouseGameService.getWorthOfEachPlayer();

	}

	private static int[] getDiceOutputs(String[] s) {

		int[] diceOutputs = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			diceOutputs[i] = Integer.parseInt(s[i]);
		}
		return diceOutputs;
	}
}
