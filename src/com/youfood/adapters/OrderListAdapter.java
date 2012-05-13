package com.youfood.adapters;

import java.util.HashMap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.youfood.activities.ChooseMenuActivity;
import com.youfood.activities.R;
import com.youfood.models.Product;

public class OrderListAdapter extends BaseAdapter {
	
	private HashMap<Product, Integer> orderProducts;
	private ChooseMenuActivity activity;
	
	public OrderListAdapter(HashMap<Product, Integer> orderProducts, ChooseMenuActivity activity) {
		this.orderProducts = orderProducts;
		this.activity = activity;
	}

	public int getCount() {
		return orderProducts.size();
	}

	public Object getItem(int position) {
		return orderProducts.keySet().toArray()[position];
	}

	public long getItemId(int position) {
		return ((Product) orderProducts.keySet().toArray()[position]).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(activity);
		View view = inflater.inflate(R.layout.order_item, parent, false);
		
		Product p = (Product) getItem(position);
		
		ImageView image = (ImageView) view.findViewById(R.id.OrderProductImage);
		image.setImageBitmap(p.getPhotoBitmap());
		
		TextView name = (TextView) view.findViewById(R.id.OrderProductName);
		name.setText(p.getName());
		
		Integer quantity = orderProducts.get(p);
		
		Spinner quantitiesSpinner = (Spinner) view.findViewById(R.id.OrderProductQuantity);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
	            this.activity, R.array.quantities, android.R.layout.simple_spinner_item);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    quantitiesSpinner.setAdapter(adapter);
	    
	    TextView totalPrice = (TextView) view.findViewById(R.id.OrderProductTotalPrice);
	    totalPrice.setText(String.valueOf(quantity * p.getPrice()));
		
		return view;
	}

}
