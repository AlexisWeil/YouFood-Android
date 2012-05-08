package com.youfood.models.json;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.youfood.models.Product;

public class ProductConverter {
	
	/**
	 * Méthode permettant de convertir un object JSON en Product.
	 * 
	 * @param json L'objet JSON à convertir.
	 * 
	 * @return Le Product résultant de la conversion.
	 */
	public static Product fromJSONToObject(JSONObject json) {
		Product product = new Product();
		
		try {
			product.setId(json.getInt("id"));
			product.setName(json.getString("name"));
			product.setAbbreviation(json.getString("abbreviation"));
			product.setDescription(json.getString("description"));
			product.setPhotoUrl(json.getString("photo_url"));
			product.setPrice((float)json.getDouble("price"));
			product.setCategory(CategoryConverter.fromJSONToObject(json.getJSONObject("category")));
			product.setPermanent(json.getBoolean("is_permanent"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	
	/**
	 * Méthode permettant de convertir un Menu en object JSON.
	 * 
	 * @param product Le Product à convertir.
	 * 
	 * @return L'objet JSON résultant de la conversion.
	 */
	public static JSONObject fromObjectToJSON(Product product) {
		JSONObject json = new JSONObject();
		
		try {
			json.put("id", product.getId());
			json.put("name", product.getName());
			json.put("abbreviation", product.getAbbreviation());
			json.put("description", product.getDescription());
			json.put("photo_url", product.getPhotoUrl());
			json.put("price", product.getPrice());
			json.put("category", CategoryConverter.fromObjectToJSON(product.getCategory()));
			json.put("is_permanent", product.isPermanent());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
	public static List<Product> fromJSONArrayToList(JSONArray jsonArray) {
		List<Product> products = new ArrayList<Product>();

		try {
			for(int i = 0 ; i < jsonArray.length() ; i++) {
				products.add(fromJSONToObject(jsonArray.getJSONObject(i)));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return products;
	}
}
