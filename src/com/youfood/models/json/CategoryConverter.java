package com.youfood.models.json;

import org.json.JSONException;
import org.json.JSONObject;

import com.youfood.models.Category;

public class CategoryConverter {

	/**
	 * Méthode permettant de convertir un object JSON en Category.
	 * 
	 * @param json L'objet JSON à convertir.
	 * 
	 * @return La Category résultant de la conversion.
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
	 * Méthode permettant de convertir une Category en object JSON.
	 * 
	 * @param category La Category à convertir.
	 * 
	 * @return L'objet JSON résultant de la conversion.
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
