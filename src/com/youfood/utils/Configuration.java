package com.youfood.utils;

public class Configuration {
	
	public static final String URI_SERVER = "http://youfoodserver.herokuapp.com";
	
	private static Configuration currentInstance;
	
	private static String connectionToken;
	
	private Configuration() { }
	
	public static Configuration getCurrentInstance() {
		if(currentInstance == null)
			currentInstance = new Configuration();
		
		return currentInstance;
	}

	public static String getConnectionToken() {
		return connectionToken;
	}

	public static void setConnectionToken(String connectionToken) {
		Configuration.connectionToken = connectionToken;
	}
}
