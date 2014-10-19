package com.secondfloor.ofertame;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.secondfloor.contracts.ServiceAnuncio;
import com.secondfloor.model.Anuncio;
import com.secondfloor.ofertame.task.BuscaOfertasTask;
import com.secondfloor.repository.RepositoryAnuncio;
import com.secondfloor.repositoryFake.RepositoryAnuncioFake;
import com.secondfloor.repositoryImpl.RepositoryAnuncioImpl;
import com.secondfloor.services.ServiceAnuncioImpl;

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
				BuscaOfertasTask buscaOfertasTask = new BuscaOfertasTask(BuscaOfertas.this,lstViewOfertas);
				buscaOfertasTask.execute(filtroTitulo.getText().toString());
				
				//AnuncioAdapter listaAnunciosAdapter = new AnuncioAdapter(BuscaOfertas.this, listaAnuncios);
				//ArrayList<Anuncio> arrayAnuncios = new ArrayList<Anuncio>(listaAnuncios);
				//Esta dando erro aqui
				//lstViewOfertas.setAdapter(listaAnunciosAdapter);
				
				
					
				
			}
		});
        //http://www.codelearn.org/android-tutorial/android-listview
        //https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView
        //Preenchendo o listview
        
        
    }


 
}
