package com.youfood.listeners;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Spinner;

import com.youfood.activities.ChooseMenuActivity;
import com.youfood.activities.R;
import com.youfood.models.Product;
import com.youfood.views.ProductDialog;

public class ChooseProductListener implements OnClickListener {

	private Spinner quantitySpinner;
	private ProductDialog productDialog;
	private ChooseMenuActivity activity;
	
	public ChooseProductListener(ProductDialog productDialog, ChooseMenuActivity activity) {
		this.productDialog = productDialog;
		this.activity = activity;
		this.quantitySpinner = (Spinner) productDialog.findViewById(R.id.DetailProductQuantity);
	}

	public void onClick(View v) {
		Product p = productDialog.getCurrentProduct();
		int quantity = Integer.valueOf((String) quantitySpinner.getSelectedItem());
		
		activity.managerProductForOrder(p, quantity);
		
		productDialog.hide();
		quantitySpinner.setSelection(0);
	}

}
