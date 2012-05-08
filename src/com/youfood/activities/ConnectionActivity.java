package com.youfood.activities;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

import com.youfood.utils.Configuration;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ConnectionActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ActionBar actionBar = getActionBar();
        actionBar.hide();
    }
    
    public void connection(View view) throws ClientProtocolException, IOException {
    	HttpClient client = new DefaultHttpClient();
    	HttpPost req = new HttpPost(Configuration.URI_SERVER + "/api/auth/request_token");
    	
    	EditText email = (EditText) this.findViewById(R.id.email);
    	EditText password = (EditText) this.findViewById(R.id.password);
    	
    	req.setEntity(new StringEntity("email=" + email.getText() + "&password=" + password.getText()));
    	
    	HttpResponse resp = client.execute(req);
    	
    	Toast.makeText(this, resp.getEntity().toString(), 10000).show();
    }
}