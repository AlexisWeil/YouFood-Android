package com.youfood.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import com.youfood.fragments.connection.ChooseTableFragment;
import com.youfood.fragments.connection.ConnectionFragment;
import com.youfood.fragments.mainmenu.MainMenuFragment;
import com.youfood.utils.Configuration;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getCurrentInstance().setCurrentContext(this);
        setContentView(R.layout.main);
        
        ActionBar actionBar = getActionBar();
        actionBar.hide();
        
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        
        Intent intent = getIntent();
        String beginFragment = intent.getStringExtra("beginFragment");
        
        if(beginFragment != null && beginFragment.equals("mainMenu")) {
        	transaction.add(R.id.MainFragmentContainer, new MainMenuFragment());
	        transaction.commit();
        }
        else {
	        transaction.add(R.id.MainFragmentContainer, new ConnectionFragment());
	        transaction.commit();
        }
    }
    
    
    /**
     * M�thode permettant d'afficher le fragment de s�lection du num�ro de la table.
     */
    public void goChooseTable() {
    	FragmentManager fm = getFragmentManager();
    	
    	FragmentTransaction transaction = fm.beginTransaction();
    	transaction.replace(R.id.MainFragmentContainer, new ChooseTableFragment());
    	transaction.commit();
    }
}