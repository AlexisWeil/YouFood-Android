package com.youfood.listeners;

import android.view.View;
import android.view.View.OnClickListener;

import com.youfood.adapters.OrderListAdapter;
import com.youfood.models.Product;

public class RemoveProductFromOrderListener implements OnClickListener {

	private Product product;
	private OrderListAdapter adapter;
	
	public RemoveProductFromOrderListener(Product product, OrderListAdapter orderListAdapter) {
		this.product = product;
		this.adapter = orderListAdapter;
	}

	public void onClick(View v) {
		adapter.getActivity().managerProductForOrder(product, 0);
		adapter.notifyDataSetChanged();
		
		adapter.getActivity().getOrderDialog().updateTotalPrice();
	}

}
