package com.secondfloor.ofertame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Entrar extends Activity{
	private TextView txtEmail;
	private TextView txtSenha;
	private Button btnLogar;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);
        
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtSenha = (TextView) findViewById(R.id.txtSenha);
        btnLogar = (Button) findViewById(R.id.btnLogar);
        btnLogar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//
				
			}
		});
	}
}
