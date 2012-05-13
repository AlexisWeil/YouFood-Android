package com.youfood.views;

import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.youfood.activities.ChooseMenuActivity;
import com.youfood.activities.R;
import com.youfood.listeners.ChooseProductListener;
import com.youfood.models.Product;

public class ProductDialog extends Dialog {

	private ChooseMenuActivity activity;
	private Product currentProduct;
	private List<Product> products;
	
	public ProductDialog(Context context) {
		super(context);
		this.activity = (ChooseMenuActivity) context;
		this.setContentView(R.layout.product_dialog);
		
		Spinner quantitiesSpinner = (Spinner) findViewById(R.id.DetailProductQuantity);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this.activity, R.array.quantities, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    quantitiesSpinner.setAdapter(adapter);
		
		Button buttonCancel = (Button) findViewById(R.id.DetailProductCancel);
		buttonCancel.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				hide();
				((Spinner) findViewById(R.id.DetailProductQuantity)).setSelection(0);
			}
		});
		
		Button buttonValid = (Button) findViewById(R.id.DetailProductValid);
		buttonValid.setOnClickListener(new ChooseProductListener(this, this.activity));
	}

	
	// GETTERS AND SETTERS 
	
	@Override
	public void show() {
		if(products != null && products.size() > 0) {			
			this.setTitle(currentProduct.getName());
			
			ImageView img = (ImageView) findViewById(R.id.DetailProductImage);
			img.setImageBitmap(currentProduct.getPhotoBitmap());
			
			TextView description = (TextView) findViewById(R.id.DetailProductDescription);
			description.setText(currentProduct.getDescription());
			
			TextView price = (TextView) findViewById(R.id.DetailProductPrice);
			price.setText(currentProduct.getPrice() + "€");
		}
		super.show();
	}


	public ChooseMenuActivity getActivity() {
		return activity;
	}

	public void setActivity(ChooseMenuActivity activity) {
		this.activity = activity;
	}

	public Product getCurrentProduct() {
		return currentProduct;
	}


	public void setCurrentProduct(Product currentProduct) {
		this.currentProduct = currentProduct;
	}


	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
