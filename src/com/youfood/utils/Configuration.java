package com.youfood.utils;

public class Configuration {
	
	public static final String URI_SERVER = "http://youfoodserver.herokuapp.com";
	
	private static Configuration currentInstance;
	
	private String connectionToken;
	private int tableNumber;
	
	private Configuration() { }
	
	public static Configuration getCurrentInstance() {
		if(currentInstance == null)
			currentInstance = new Configuration();
		
		return currentInstance;
	}

	public String getConnectionToken() {
		return connectionToken;
	}

	public void setConnectionToken(String connectionToken) {
		this.connectionToken = connectionToken;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
}
