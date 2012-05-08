package com.youfood.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.youfood.fragments.connection.ChooseTableFragment;
import com.youfood.fragments.connection.ConnectionFragment;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ActionBar actionBar = getActionBar();
        actionBar.hide();
        
        FragmentManager fm = getFragmentManager();
        
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.MainFragmentContainer, new ConnectionFragment());
        transaction.commit();
    }
    
    
    /**
     * Méthode permettant d'afficher le fragment de sélection du numéro de la table.
     */
    public void goChooseTable() {
    	FragmentManager fm = getFragmentManager();
    	
    	FragmentTransaction transaction = fm.beginTransaction();
    	transaction.replace(R.id.MainFragmentContainer, new ChooseTableFragment());
    	transaction.commit();
    }
}