package com.youfood.tasks;

import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.youfood.activities.R;
import com.youfood.utils.Configuration;

@SuppressWarnings("unused")
public class ImageLoadTask extends AsyncTask<String, Integer, Boolean> {

	private Bitmap bitmap;
	
	public ImageLoadTask(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	@Override
	protected Boolean doInBackground(String... params) {
		
		String urlString = params[0];
	    boolean result = false;

	    try {
	    	URL url = new URL(urlString);

	        bitmap = BitmapFactory.decodeStream(url.openStream());
	        
	        result = true;
	    } catch (Exception e) {
	        Log.e("youfood", "Could not load Bitmap from: " + urlString);
	        
	        bitmap = BitmapFactory.decodeResource(Configuration.getCurrentInstance().getCurrentContext().getResources(), R.drawable.food); 
	        result = false;
	    }
	    
		return result;
	}
}
