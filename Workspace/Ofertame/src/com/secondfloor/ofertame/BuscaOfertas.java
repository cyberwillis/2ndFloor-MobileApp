package com.secondfloor.ofertame;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.secondfloor.contracts.ServiceAnuncio;
import com.secondfloor.model.Anuncio;
import com.secondfloor.repository.RepositoryAnuncio;
import com.secondfloor.repositoryFake.RepositoryAnuncioFake;
import com.secondfloor.services.ServiceAnuncioImpl;

public class BuscaOfertas extends Activity {
	private RepositoryAnuncio repositorio = new RepositoryAnuncioFake();
	private ServiceAnuncio servicoAnuncio = new ServiceAnuncioImpl(repositorio);
	
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
				List<Anuncio> listaAnuncios = servicoAnuncio.pesquisarAnuncioPorTitulo(filtroTitulo.getText().toString());
				// implementar aqui a rotina de pesquisa e preenchimento o listView
				
			}
		});
        //http://www.codelearn.org/android-tutorial/android-listview
        //Preenchendo o listview
        
        
    }


 
}
