package com.youfood.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.youfood.activities.ChooseMenuActivity;
import com.youfood.models.Product;

public class MenuItemListener implements OnItemClickListener {
	
	private ChooseMenuActivity activity;

	public MenuItemListener(ChooseMenuActivity activity) {
		this.activity = activity;
	}

	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		this.activity.getProductDialog().setCurrentProduct((Product) ((GridView) parent).getAdapter().getItem(position));
		this.activity.getProductDialog().show();
	}

}
