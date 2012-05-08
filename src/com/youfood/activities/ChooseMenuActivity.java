package com.youfood.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.youfood.models.Category;
import com.youfood.models.Menu;
import com.youfood.models.Product;
import com.youfood.models.json.MenuConverter;
import com.youfood.models.json.ProductConverter;

public class ChooseMenuActivity extends Activity {

	private Menu currentMenu;
	private HashMap<Category, List<Product>> productsByCategories;
	private List<Category> categories;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.choose_menu);
		
		String currentMenuStr = "{\"current_menu\" : {\"id\" : 3,\"name\" : \"Menu Alsacien\",\"description\" : \"Revivez les joies de la flammekeuche chez YouFood !\"},\"products\" : [{\"id\": 1,\"name\": \"Choucroute\",\"abbreviation\" : \"chouc\",\"description\": \"Hummm... La bonne choucroute traditionnelle !\",\"photo_url\" : \"http://images.youfoud.com/products/choucroute.png\",\"price\" : 13,\"category\" : {\"id\" : 2,\"name\" : \"Tradition\"},\"is_permanent\" : false}, {\"id\": 2,\"name\": \"Pizza Reine\",\"abbreviation\" : \"p.reine\",\"description\": \"Hummm... La bonne pizza reine traditionnelle !\",\"photo_url\" : \"http://images.youfoud.com/products/pizzas/reine.png\",\"price\" : 8.50,\"category\" : {\"id\" : 18,\"name\" : \"Pizza\"},\"is_permanent\" : true}]}";
		
		try {
			JSONObject jsonMenu = new JSONObject(currentMenuStr);
			
			this.currentMenu = MenuConverter.fromJSONToObject(jsonMenu.getJSONObject("current_menu"));
			
			List<Product> products = ProductConverter.fromJSONArrayToList(jsonMenu.getJSONArray("products"));
			
			this.categories = new ArrayList<Category>();
			this.productsByCategories = new HashMap<Category, List<Product>>();
			
			for(Product p : products) {
				if(this.categories.indexOf(p.getCategory()) < 0)
					this.categories.add(p.getCategory());
				
				if(!this.productsByCategories.containsKey(p.getCategory()))
					this.productsByCategories.put(p.getCategory(), new ArrayList<Product>());
				
				this.productsByCategories.get(p.getCategory()).add(p);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		ListView categoriesList = (ListView) findViewById(R.id.CategoriesList);
		categoriesList.setAdapter(new ArrayAdapter<Category>(this, android.R.layout.simple_list_item_1, this.categories));
		categoriesList.setSelection(0);
	}
}
