package com.youfood.listeners;

import com.youfood.activities.R;
import com.youfood.fragments.mainmenu.MainMenuFragment;
import com.youfood.tasks.ConnectionTask;
import com.youfood.utils.Configuration;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.NumberPicker;

public class ConnectionAndTableListener implements OnClickListener {

	private Activity activity;
	
	public ConnectionAndTableListener(Activity activity) {
		this.activity = activity;
	}
	
	
	public void onClick(View v) {
		
		/* Si c'est le bouton de connexion */
		if(v.getId() == R.id.ConnectionButton) {
			Log.d("youfood", "Click connexion !");
	    	
	    	String connectionUri = Configuration.CONNECTION_URI;

	    	String email = ((EditText) this.activity.findViewById(R.id.Email)).getText().toString();
	    	String password = ((EditText) this.activity.findViewById(R.id.Password)).getText().toString();
	    	
	    	ConnectionTask connectionTask = new ConnectionTask(email, password, this.activity);
	    	connectionTask.execute(connectionUri);
		}
		
		/* Si c'est le bouton de validation de choix de la table */
		else if(v.getId() == R.id.ChooseTableButton) {
			Log.d("youfood", "Table chosen !");
			NumberPicker np = (NumberPicker) this.activity.findViewById(R.id.TableNumberPicker);
	    	
	    	Configuration.getCurrentInstance().setTableNumber(np.getValue());
	    	
	    	FragmentManager fm = this.activity.getFragmentManager();
			
			FragmentTransaction transaction = fm.beginTransaction();
			transaction.replace(R.id.MainFragmentContainer, new MainMenuFragment());
			transaction.commit();
		}
	}

}
