package com.db.bean;

public enum CellType {

	EMPTY("E"), JAIL("J"), TREASURE("T"), HOTEL("H");

	private final String key;

	CellType(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

}
