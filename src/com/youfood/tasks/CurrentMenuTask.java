package com.youfood.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.youfood.activities.ChooseMenuActivity;
import com.youfood.activities.MainActivity;
import com.youfood.models.Category;
import com.youfood.models.Menu;
import com.youfood.models.Product;
import com.youfood.models.json.MenuConverter;
import com.youfood.models.json.ProductConverter;
import com.youfood.utils.Configuration;

public class CurrentMenuTask extends AsyncTask<String, Integer, Boolean> {

	private ChooseMenuActivity activity;
	
	public CurrentMenuTask(ChooseMenuActivity activity) {
		this.activity = activity;
	}
	
	@Override
	protected Boolean doInBackground(String... params) {
		
		try {
			String uri = params[0];
			
			HttpClient client = new DefaultHttpClient();
			HttpGet req = new HttpGet(uri);
			
			req.addHeader("YouFoodServer-AccessToken", Configuration.getCurrentInstance().getConnectionToken());
			req.addHeader("Accept", "*/*");
			
			HttpResponse resp = client.execute(req);
			
			JSONObject jsonMenu = new JSONObject(EntityUtils.toString(resp.getEntity()));
			
			Menu currentMenu = MenuConverter.fromJSONToObject(jsonMenu.getJSONObject("current_menu"));
			
			List<Product> products = ProductConverter.fromJSONArrayToList(jsonMenu.getJSONArray("products"));
			
			List<Category> categories = new ArrayList<Category>();
			HashMap<Category, List<Product>> productsByCategories = new HashMap<Category, List<Product>>();
			
			for(Product p : products) {
				if(categories.indexOf(p.getCategory()) < 0)
					categories.add(p.getCategory());
				
				if(!productsByCategories.containsKey(p.getCategory()))
					productsByCategories.put(p.getCategory(), new ArrayList<Product>());
				
				productsByCategories.get(p.getCategory()).add(p);
			}

			this.activity.setCurrentMenu(currentMenu);
			this.activity.setCategories(categories);
			this.activity.setProductsByCategories(productsByCategories);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	protected void onPostExecute(Boolean result) {
		if(result) {
			this.activity.makeCategoriesList();
			this.activity.makeProductsGrid();
		}
		else {
			Toast.makeText(this.activity.getApplicationContext(), "Impossible de récupérer le menu", 5000).show();
			
			Intent intent = new Intent(this.activity, MainActivity.class);
			intent.putExtra("beginFragment", "mainMenu");
			
			this.activity.startActivity(intent);
		}
	}
}
