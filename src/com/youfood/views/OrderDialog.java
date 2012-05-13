package com.youfood.views;

import android.app.Dialog;
import android.content.Context;
import android.widget.ListView;
import android.widget.TextView;

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

	@Override
	public void show() {
		super.show();
		updateTotalPrice();
	}
	
	public void updateTotalPrice() {
		TextView totalPrice = (TextView) findViewById(R.id.OrderTotalPrice);
		TextView actionTotalPrice = (TextView) activity.getOrderAction().getActionView().findViewById(R.id.OrderActionTotalPrice);
		totalPrice.setText(actionTotalPrice.getText());
	}
}
