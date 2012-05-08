package com.youfood.fragments.connection;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.youfood.activities.R;
import com.youfood.listeners.ConnectionAndTableListener;

public class ConnectionFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.connection, container, false);
		
		Button connectionButton = (Button) view.findViewById(R.id.ConnectionButton);
		connectionButton.setOnClickListener(new ConnectionAndTableListener(getActivity()));
		
		return view;
	}

}
