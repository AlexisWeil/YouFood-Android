package com.youfood.models.json;

import org.json.JSONException;
import org.json.JSONObject;

import com.youfood.models.Menu;

public class MenuConverter {

	/**
	 * M�thode permettant de convertir un object JSON en Menu.
	 * 
	 * @param json L'objet JSON � convertir.
	 * 
	 * @return Le Menu r�sultant de la conversion.
	 */
	public static Menu fromJSONToObject(JSONObject json) {
		Menu menu = new Menu();
		
		try {
			menu.setId(json.getInt("id"));
			menu.setName(json.getString("name"));
			menu.setDescription(json.getString("description"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return menu;
	}
	
	
	/**
	 * M�thode permettant de convertir un Menu en object JSON.
	 * 
	 * @param menu Le Menu � convertir.
	 * 
	 * @return L'objet JSON r�sultant de la conversion.
	 */
	public static JSONObject fromObjectToJSON(Menu menu) {
		JSONObject json = new JSONObject();
		
		try {
			json.put("id", menu.getId());
			json.put("name", menu.getName());
			json.put("description", menu.getDescription());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return json;
	}
}
