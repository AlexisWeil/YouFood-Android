package com.youfood.listeners;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.view.View.OnClickListener;


public class CallWaiterListener implements OnClickListener {

	public Activity activity;
	
	public CallWaiterListener(Activity activity) {
		this.activity = activity;
	}
	
	/**
	 * Appelée lors du clique sur un bouton pour appeler un serveur.
	 * Va afficher une dialog pour demander à l'utilisateur d'attendre.
	 */
	public void onClick(View v) {
		ProgressDialog dialog = ProgressDialog.show(this.activity, "", "Veuillez patienter, un serveur va arriver ...", true, true);
		dialog.show();
	}

}
