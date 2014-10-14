package com.secondfloor.ofertame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class BuscaOfertas extends Activity {
	private Button btnPesquisar;
	private ListView lstViewOfertas;
	private TextView filtroTitulo;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_ofertas);
        
        filtroTitulo = (TextView) findViewById(R.id.txtFiltroTitulo);
        lstViewOfertas = (ListView) findViewById(R.id.lstViewOfertas);
        btnPesquisar = (Button) findViewById(R.id.btnPesquisar);
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// implementar aqui a rotina de pesquisa e preenchimento o listView
				
			}
		});
    }


 
}
