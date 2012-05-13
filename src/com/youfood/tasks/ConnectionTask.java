package com.youfood.tasks;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.youfood.activities.MainActivity;
import com.youfood.utils.Configuration;

@SuppressWarnings("unused")
public class ConnectionTask extends AsyncTask<String, Integer, Boolean> {
	
	private String email;
	private String password;
	private MainActivity connectionActivity;
	private String respString;
	private JSONObject respJson;

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
	    	
	    	req.addHeader("Content-Type", "application/x-www-form-urlencoded");
	    	req.addHeader("Accept", "*/*");
	    	
	    	HttpResponse resp = client.execute(req);
	    	
	    	this.respString = EntityUtils.toString(resp.getEntity());
	    	
	    	this.respJson = new JSONObject(this.respString);
		}
		catch(Exception ex) {
			Log.d("youfood", "Oh god an error !");
			
			return false;
		}
		
		return true;
	}

	@Override
	protected void onPostExecute(Boolean result) {
		if(result) {			
			try {
				Configuration.getCurrentInstance().setConnectionToken(this.respJson.getString("youfoodserver_access_token"));
				
				this.connectionActivity.goChooseTable();
			} catch (JSONException e) {
				Toast.makeText(this.connectionActivity, "Connexion impossible : " + this.respString, 10000).show();
			}
		}
		else {
			Toast.makeText(this.connectionActivity, this.respString, 10000).show();
		}
	}

}
