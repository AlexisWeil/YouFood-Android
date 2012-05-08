package com.youfood.tasks.connection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.youfood.activities.MainActivity;

public class ConnectionTask extends AsyncTask<String, Integer, Boolean> {
	
	private String email;
	private String password;
	private MainActivity connectionActivity;
	private String response;

	public ConnectionTask(String email, String password, Activity connectionActivity) {
		super();
		
		this.email = email;
		this.password = password;
		this.connectionActivity = (MainActivity) connectionActivity;
	}

	@Override
	protected Boolean doInBackground(String... params) {

		Log.d("youfood", "Begin connexion !");
		try {
			String uri = params[0];
			
			HttpClient client = new DefaultHttpClient();
	    	HttpPost req = new HttpPost(uri);
	    	
//	    	req.setEntity(new StringEntity("email=" + this.email + "&password=" + this.password));
	    	req.setEntity(new StringEntity("email=restaurant.manager@youfood.com&pass=password"));
	    	
	    	HttpResponse resp = client.execute(req);
	    	
	    	this.response = EntityUtils.toString(resp.getEntity());
	    	
	    	Log.d("youfood", this.response);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			Log.d("youfood", "Oh god an error !");
			
			return false;
		}
		
		return true;
	}

	@Override
	protected void onPostExecute(Boolean result) {
		if(result) {
			Toast.makeText(this.connectionActivity, this.response, 10000).show();
			
			this.connectionActivity.goChooseTable();
		}
	}

}
