package com.youfood.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.youfood.activities.R;
import com.youfood.models.Product;

public class ProductGridAdapter extends BaseAdapter {
	
	private Context context;
	private List<Product> products;
	
	public ProductGridAdapter(Context context, List<Product> products) {
		this.context = context;
		this.products = products;
	}

	public int getCount() {
		return products.size();
	}

	public Object getItem(int position) {
		return this.products.get(position);
	}

	public long getItemId(int position) {
		return this.products.get(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Product p = this.products.get(position);
		LayoutInflater inflater = LayoutInflater.from(context);
		
		View view = inflater.inflate(R.layout.menu_item, parent, false);
		
		TextView name = (TextView) view.findViewById(R.id.ProductName);
		name.setText(p.getName());
		
		TextView price = (TextView) view.findViewById(R.id.ProductPrice);
		price.setText(p.getPrice() + "€");
		
		return view;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
