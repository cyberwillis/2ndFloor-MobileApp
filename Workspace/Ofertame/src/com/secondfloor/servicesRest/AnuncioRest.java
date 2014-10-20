package com.secondfloor.servicesRest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import android.util.Log;

import com.secondfloor.messages.AtribuirRatingOfertaResponse;
import com.secondfloor.messages.EncontrarOfertaRequest;
import com.secondfloor.messages.EncontrarOfertaResponse;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

public class AnuncioRest {
	private String urlServerBase;
	
	public AnuncioRest()
	{
		urlServerBase ="http://10.0.2.2:8080/web/";
		//urlServerBase = "http://localhost:1886/Service.svc/web/";
	}
	
	public EncontrarOfertaResponse EncontrarOfertasPorNomeProduto(String nomeProduto)
	{
		final String route = "EncontrarOfertaPor";
		String uri = this.urlServerBase + route;
		
		EncontrarOfertaResponse response = new EncontrarOfertaResponse();
		StringBuilder sb = new StringBuilder(); 
		
		EncontrarOfertaRequest request = new EncontrarOfertaRequest();
		request.setProduto(nomeProduto);
		//request.setBairro("bairro");
		//request.setTipoProduto("tipoProduto");
		
		JSONSerializer jsonSerializer = new JSONSerializer();
		String requestJson = jsonSerializer.exclude("*.class").deepSerialize(request);
		
		Log.i("uri", uri );
		Log.i("jsonRequest", requestJson );
				
		HttpURLConnection urlConnection = null;  
		try{
			//Conex�o
			RestHelper restHelper = new RestHelper();
			urlConnection = restHelper.sendPost(uri, requestJson);

		    int HttpResult = urlConnection.getResponseCode();
		    Log.i("HttpResult", String.valueOf(HttpResult));
		    
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
		        JSONDeserializer<EncontrarOfertaResponse> jsonDeserializer = new JSONDeserializer<EncontrarOfertaResponse>();
		        jsonDeserializer.deserializeInto(sb.toString(), response);
		        Log.i("responseJson", sb.toString());
		    }
		}
		catch (Exception e) 
		{
			Log.e("IOException", e.getMessage() );
			e.printStackTrace();
		}
		finally{  
		    if(urlConnection!=null)  
		        urlConnection.disconnect();  
		}
		
		return response;
	}
	
	public AtribuirRatingOfertaResponse AtribuirRatingPara(String consumidorId,String produtoId, Float rating){
		AtribuirRatingOfertaResponse response = new AtribuirRatingOfertaResponse();
		
		
		
		return response;
	}

}
