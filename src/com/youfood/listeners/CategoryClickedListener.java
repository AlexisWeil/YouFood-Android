package com.youfood.listeners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.youfood.activities.ChooseMenuActivity;
import com.youfood.models.Category;

public class CategoryClickedListener implements OnItemClickListener {

	private ChooseMenuActivity activity;
	
	public CategoryClickedListener(ChooseMenuActivity activity) {
		this.activity = activity;
	}

	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Category c = (Category) ((ListView) parent).getAdapter().getItem(position);
		
		this.activity.switchToCategory(c);
	}
}
