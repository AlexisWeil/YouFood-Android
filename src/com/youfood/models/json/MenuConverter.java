package com.youfood.models.json;

import org.json.JSONException;
import org.json.JSONObject;

import com.youfood.models.Menu;

public class MenuConverter {

	/**
	 * Méthode permettant de convertir un object JSON en Menu.
	 * 
	 * @param json L'objet JSON à convertir.
	 * 
	 * @return Le Menu résultant de la conversion.
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
	 * Méthode permettant de convertir un Menu en object JSON.
	 * 
	 * @param menu Le Menu à convertir.
	 * 
	 * @return L'objet JSON résultant de la conversion.
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
