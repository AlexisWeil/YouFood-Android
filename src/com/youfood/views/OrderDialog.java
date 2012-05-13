package com.youfood.views;

import android.app.Dialog;
import android.content.Context;
import android.widget.ListView;

import com.youfood.activities.ChooseMenuActivity;
import com.youfood.activities.R;
import com.youfood.adapters.OrderListAdapter;

public class OrderDialog extends Dialog {

	private ChooseMenuActivity activity;
	
	public OrderDialog(Context context) {
		super(context);
		this.activity = (ChooseMenuActivity) context;
		
		setContentView(R.layout.customer_order);
		this.setTitle("Votre commande");
		
		ListView orderList = (ListView) findViewById(R.id.OrderList);
		orderList.setAdapter(new OrderListAdapter(activity.getOrderProducts(), activity));
		
	}

}
