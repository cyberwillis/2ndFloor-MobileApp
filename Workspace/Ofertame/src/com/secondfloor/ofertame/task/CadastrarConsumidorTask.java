package com.secondfloor.ofertame.task;

import com.secondfloor.messages.CadastrarConsumidorResponse;
import com.secondfloor.services.SegurancaService;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

public class CadastrarConsumidorTask extends AsyncTask<String,Double,CadastrarConsumidorResponse> {

	private Activity context;
	
	public CadastrarConsumidorTask(Activity context){
		this.context = context;
		
	}
	@Override
	protected CadastrarConsumidorResponse doInBackground(String... params) {
		CadastrarConsumidorResponse response = null;
		
		Log.i("CadastrarConsumidor", "Inicia thread" );
		try {
			String email = params[0];
			String nome = params[1];
			String tipoAcesso = params[2];
			
			response = new SegurancaService().CadastrarConsumidor(email, nome, tipoAcesso);
		} catch (Exception e) {
			Log.e("CadastrarConsumidorTask.doInBackground.Exception", e.getMessage());
		}
		Log.i("CadastrarConsumidorTask.CadastrarConsumidor.Success", String.valueOf(response.getSuccess()));
		return response;
	}

}
