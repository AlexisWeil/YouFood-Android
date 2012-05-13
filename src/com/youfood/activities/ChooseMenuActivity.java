package com.youfood.activities;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.youfood.adapters.ProductGridAdapter;
import com.youfood.listeners.CallWaiterListener;
import com.youfood.listeners.CategoryClickedListener;
import com.youfood.listeners.MenuItemListener;
import com.youfood.models.Category;
import com.youfood.models.Menu;
import com.youfood.models.Product;
import com.youfood.tasks.CurrentMenuTask;
import com.youfood.utils.Configuration;
import com.youfood.views.OrderDialog;
import com.youfood.views.ProductDialog;

public class ChooseMenuActivity extends Activity {

	private Menu currentMenu;
	private HashMap<Category, List<Product>> productsByCategories;
	private HashMap<Product, Integer> orderProducts;
	private List<Category> categories;
	private ProductDialog productDialog;
	private OrderDialog orderDialog;
	private MenuItem orderAction;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Configuration.getCurrentInstance().setCurrentContext(this);
		setContentView(R.layout.choose_menu);
		
		this.orderProducts = new HashMap<Product, Integer>();
		
		this.productDialog = new ProductDialog(this);
		this.orderDialog = new OrderDialog(this);
		
		CurrentMenuTask currentMenuTask = new CurrentMenuTask(this);
		currentMenuTask.execute(Configuration.CURRENT_MENU_URI);
	}
	
	/**
	 * Méthode permettant de construire la liste des catégories
	 */
	public void makeCategoriesList() {
		ListView categoriesList = (ListView) findViewById(R.id.CategoriesList);
		categoriesList.setAdapter(new ArrayAdapter<Category>(this, android.R.layout.simple_list_item_single_choice, this.categories));
		categoriesList.setItemChecked(0, true);
		categoriesList.setOnItemClickListener(new CategoryClickedListener(this));
	}
	
	/**
	 * Méthode permettant de construire la liste des produits
	 */
	public void makeProductsGrid() {
		GridView productsGrid = (GridView) findViewById(R.id.ProductsGrid);
		productsGrid.setAdapter(new ProductGridAdapter(this, productsByCategories.get(categories.get(0))));
		productsGrid.setOnItemClickListener(new MenuItemListener(this));
		
		this.productDialog.setProducts(productsByCategories.get(categories.get(0)));
	}
	
	/**
	 * Méthode permettant de changer les produits affichés en fonction d'une catégorie.
	 * 
	 * @param c La catégorie pour laquelle afficher les produits
	 */
	public void switchToCategory(Category c) {
		GridView productsGrid = (GridView) findViewById(R.id.ProductsGrid);
		productsGrid.setAdapter(new ProductGridAdapter(this, productsByCategories.get(c)));
		
		this.productDialog.setProducts(productsByCategories.get(c));
	}
	
	/**
	 * Méthode permettant d'ajouter un produit à la commande, ou de le retirer si
	 * la quantité est égale à 0.
	 * 
	 * @param product Le produit à ajouter à la commande
	 * @param quantity La quantité du produit à ajouter
	 */
	public void managerProductForOrder(Product product, int quantity) {
		if(quantity > 0)
			orderProducts.put(product, quantity);
		else if(orderProducts.containsKey(product))
			orderProducts.remove(product);
		
		float totalPrice = 0f;
		for(Product p : orderProducts.keySet()) {
			totalPrice += (p.getPrice() * orderProducts.get(p));
		}
		
		((TextView) orderAction.getActionView().findViewById(R.id.OrderActionTotalPrice)).setText(totalPrice + "€");
	}

	/**
	 * Méthode permettant de créer la ActionBar
	 */
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.youfood, menu);
		
		menu.findItem(R.id.CallWaiter)
			.getActionView()
			.findViewById(R.id.CallWaiterActionView)
			.setOnClickListener(new CallWaiterListener(this));
		
		this.orderAction = menu.findItem(R.id.OrderAction);
		this.orderAction.getActionView()
			.findViewById(R.id.OrderActionView)
			.setOnClickListener(new OnClickListener() {
			
				public void onClick(View v) {
					orderDialog.show();
				}
			});
		
		return true;
	}
	
	
	// GETTERS AND SETTERS

	public Menu getCurrentMenu() {
		return currentMenu;
	}

	public void setCurrentMenu(Menu currentMenu) {
		this.currentMenu = currentMenu;
	}

	public HashMap<Category, List<Product>> getProductsByCategories() {
		return productsByCategories;
	}

	public void setProductsByCategories(
			HashMap<Category, List<Product>> productsByCategories) {
		this.productsByCategories = productsByCategories;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public ProductDialog getProductDialog() {
		return productDialog;
	}

	public void setProductDialog(ProductDialog productDialog) {
		this.productDialog = productDialog;
	}

	public HashMap<Product, Integer> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(HashMap<Product, Integer> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public OrderDialog getOrderDialog() {
		return orderDialog;
	}

	public void setOrderDialog(OrderDialog orderDialog) {
		this.orderDialog = orderDialog;
	}

	public MenuItem getOrderAction() {
		return orderAction;
	}

	public void setOrderAction(MenuItem orderAction) {
		this.orderAction = orderAction;
	}
}
