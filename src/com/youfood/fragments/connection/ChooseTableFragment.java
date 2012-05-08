package com.youfood.fragments.connection;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

import com.youfood.activities.R;
import com.youfood.listeners.ConnectionAndTableListener;

public class ChooseTableFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.choose_table, container, false);
		
		NumberPicker np = (NumberPicker) view.findViewById(R.id.TableNumberPicker);
		String[] nums = new String[20];
	    for(int i=0; i<nums.length; i++)
	           nums[i] = Integer.toString(i);

	    np.setMinValue(1);
	    np.setMaxValue(20);
	    np.setWrapSelectorWheel(true);
	    np.setValue(1);
	    
	    Button chooseTableButton = (Button) view.findViewById(R.id.ChooseTableButton);
	    chooseTableButton.setOnClickListener(new ConnectionAndTableListener(getActivity()));
		
		return view;
	}

}
