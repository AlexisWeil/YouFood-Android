package com.youfood.fragments.mainmenu;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.youfood.activities.ChooseMenuActivity;
import com.youfood.activities.R;
import com.youfood.listeners.CallWaiterListener;

public class MainMenuFragment extends Fragment implements OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_menu, container, false);
		
		if(this.getActivity().getActionBar().isShowing())
			this.getActivity().getActionBar().hide();
		
		Button callWaiterButton = (Button) view.findViewById(R.id.CallWaiterButton);
		callWaiterButton.setOnClickListener(new CallWaiterListener(this.getActivity()));
		
		Button selfCommandButton = (Button) view.findViewById(R.id.SelfCommandButton);
		selfCommandButton.setOnClickListener(this);
		
		return view;
	}

	public void onClick(View v) {
		if(v.getId() == R.id.SelfCommandButton) {
			Intent intent = new Intent(getActivity(), ChooseMenuActivity.class);
			getActivity().startActivity(intent);
		}
	}
}
