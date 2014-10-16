package com.secondfloor.servicesRest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import com.secondfloor.messages.EncontrarOfertaRequest;
import com.secondfloor.messages.EncontrarOfertaResponse;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class AnuncioRest {
	private String urlServer;
	
	public void AnuncioRest()
	{
		//urlServer ="http://localhost:8080/web/";
		urlServer = "http://localhost:1886/Service.svc/web/";
	}
	
	public EncontrarOfertaResponse EncontrarOfertasPorNomeProduto(String nomeProduto)
	{
		final String route = "EncontrarOfertaPor";
		String http = this.urlServer + route;
		
		EncontrarOfertaResponse response = new EncontrarOfertaResponse();
		StringBuilder sb = new StringBuilder(); 
		
		EncontrarOfertaRequest request = new EncontrarOfertaRequest();
		request.setProduto(nomeProduto);
		//request.setBairro("bairro");
		//request.setTipoProduto("tipoProduto");
		
		//flexjson
		JSONSerializer jsonSerializer = new JSONSerializer();
		String requestStr = jsonSerializer.exclude("*.class").deepSerialize(request);
				
		HttpURLConnection urlConnection=null;  
		try{
			//Connexao
			URL url = new URL(http);  
		    urlConnection = (HttpURLConnection) url.openConnection();
		    urlConnection.setDoOutput(true);   
		    urlConnection.setRequestMethod("POST");  
		    urlConnection.setUseCaches(false);  
		    urlConnection.setConnectTimeout(10000);  
		    urlConnection.setReadTimeout(10000);  
		    urlConnection.setRequestProperty("Content-Type","application/json; charset=utf-8");	
		    
		    DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
		    wr.writeBytes(requestStr);
		    wr.flush();
		    wr.close();
		    
		    int HttpResult = urlConnection.getResponseCode();  
		    if(HttpResult == HttpURLConnection.HTTP_OK)
		    {
		    	InputStreamReader reader = new InputStreamReader(urlConnection.getInputStream());
		    	
		    	BufferedReader br = new BufferedReader(reader);
		    	
		    	String line = null;
		        while ((line = br.readLine()) != null) 
		        {  
		            sb.append(line + "\n");  
		        }
		        br.close();
		        
		        //flexjson
		        JSONDeserializer jsonDeserializer = new JSONDeserializer<EncontrarOfertaResponse>();
		        jsonDeserializer.deserializeInto(sb.toString(), response);
		    }
		} 
		catch(MalformedURLException e)
		{
			e.printStackTrace();  
		} 
		catch (ProtocolException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally{  
		    if(urlConnection!=null)  
		        urlConnection.disconnect();  
		}
		
		return response;
	}

}
