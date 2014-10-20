package com.secondfloor.servicesRest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import android.util.Log;

public class RestHelper {
	
	public HttpURLConnection sendPost(String uri, String requestJson)
	{
		HttpURLConnection urlConnection=null;
		try
		{
			URL url = new URL(uri);  
		    urlConnection = (HttpURLConnection) url.openConnection();
		    urlConnection.setDoOutput(true);   
		    urlConnection.setRequestMethod("POST");  
		    urlConnection.setUseCaches(false);  
		    urlConnection.setConnectTimeout(10000);  
		    urlConnection.setReadTimeout(10000);  
		    urlConnection.setRequestProperty("Content-Type","application/json; charset=utf-8");	
		    
		    DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
		    wr.writeBytes(requestJson);
		    wr.flush();
		    wr.close();
		}
		catch(MalformedURLException e)
		{
			Log.e("MalformedURLException", e.getMessage() );
			e.printStackTrace();  
		} 
		catch (ProtocolException e) 
		{
			Log.e("ProtocolException", e.getMessage() );
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			Log.e("IOException", e.getMessage() );
			e.printStackTrace();
		}
		
		return urlConnection;
	}
}
