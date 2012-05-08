package com.youfood.models.json;

import org.json.JSONException;
import org.json.JSONObject;

import com.youfood.models.Category;

public class CategoryConverter {

	/**
	 * M�thode permettant de convertir un object JSON en Category.
	 * 
	 * @param json L'objet JSON � convertir.
	 * 
	 * @return La Category r�sultant de la conversion.
	 */
	public static Category fromJSONToObject(JSONObject json) {
		Category category = new Category();
		
		try {
			category.setId(json.getInt("id"));
			category.setName(json.getString("name"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return category;
	}
	
	
	/**
	 * M�thode permettant de convertir une Category en object JSON.
	 * 
	 * @param category La Category � convertir.
	 * 
	 * @return L'objet JSON r�sultant de la conversion.
	 */
	public static JSONObject fromObjectToJSON(Category category) {
		JSONObject json = new JSONObject();
		
		try {
			json.put("id", category.getId());
			json.put("name", category.getName());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return json;
	}
}
