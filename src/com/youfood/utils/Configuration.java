package com.youfood.utils;

import android.content.Context;

public class Configuration {
	
	public static final String URI_SERVER = "http://youfoodserver.herokuapp.com";
	public static final String CONNECTION_URI = URI_SERVER + "/api/auth/request_token";
	public static final String CURRENT_MENU_URI = URI_SERVER + "/api/current_menu";
	
	private static Configuration currentInstance;
	
	private String connectionToken;
	private int tableNumber;
	private Context currentContext;
	
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

	public Context getCurrentContext() {
		return currentContext;
	}

	public void setCurrentContext(Context currentContext) {
		this.currentContext = currentContext;
	}
}
