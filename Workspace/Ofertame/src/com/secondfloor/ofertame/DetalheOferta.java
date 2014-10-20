package com.secondfloor.ofertame;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.secondfloor.model.Anuncio;
import com.secondfloor.ofertame.task.RatingOfertaTask;

public class DetalheOferta extends Activity{
	private TextView txtTitulo;
	private TextView txtData;
	private TextView txtEndereco;
	private TextView txtFornecedor;
	private TextView txtPreco;
	private RatingBar ratingAnunciante;
	private TextView txtAnunciante;
	private RatingBar ratingInteresseOferta;
	private Anuncio pAnuncio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhe_oferta);
		
		Log.i("Detalhe oferta", "Abrindo tela");
		
		txtTitulo = (TextView) findViewById(R.id.txtDetalheTitulo);
		txtData = (TextView) findViewById(R.id.txtDetalheData);
		txtEndereco = (TextView) findViewById(R.id.txtDetalheEndereco);
		txtFornecedor = (TextView) findViewById(R.id.txtDetalheFornecedor);
		txtAnunciante = (TextView) findViewById(R.id.txtDetalheAnunciante);
		txtPreco = (TextView) findViewById(R.id.txtDetalhePreco);
		
		ratingAnunciante = (RatingBar) findViewById(R.id.ratingDetalheAnunciante);
		LayerDrawable stars = (LayerDrawable) ratingAnunciante.getProgressDrawable();
		stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
		
		ratingInteresseOferta = (RatingBar) findViewById(R.id.ratingDetalheInteresseOferta);
		LayerDrawable stars2 = (LayerDrawable) ratingInteresseOferta.getProgressDrawable();
		stars2.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
		
		ratingInteresseOferta.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,boolean fromUser) {
				
				//Toast.makeText(DetalheOferta.this, "Rating: " + rating, Toast.LENGTH_SHORT).show();
				sendRating(rating);
			}
		});
		this.clearScreen();
		this.loadScreen();
	}
	
	private void loadScreen() {
		Bundle b = this.getIntent().getExtras();
		
		if(b!=null)
		{
			pAnuncio = (Anuncio)b.getSerializable("paramAnuncio");
			try {
				fillScreen(pAnuncio);
				this.sendRating(0f);
			} catch (Exception e) {
				Log.e("Erro ao preencher a tela detalhe oferta", e.getMessage());
				Toast.makeText(DetalheOferta.this, R.string.msgFalhaDetalheOferta, Toast.LENGTH_SHORT).show();
			}
		}
	}

	private void fillScreen(Anuncio anuncio)
	{
		txtTitulo.setText(anuncio.getTitulo());
		txtData.setText(anuncio.getDataOferta());
		txtEndereco.setText(anuncio.getEndereco());
		txtFornecedor.setText(anuncio.getFornecedor());
		txtAnunciante.setText(anuncio.getAnunciante());
		txtPreco.setText(String.format("R$ %.2f",anuncio.getPreco()));
		ratingAnunciante.setRating(anuncio.getClassificacaoAnunciante());
		ratingAnunciante.setEnabled(false);
		
		//ratingAnunciante.setEnabled(false);txtData.setText("20/10 - 10/11");
		//txtEndereco.setText("Av. Ang�lica, 2346 conj. 161 B    01228-200    S�o Paulo  ");
		//txtFornecedor.setText("Bauduco");
		//txtAnunciante.setText("Fulano de Tal");
		//txtPreco.setText(String.format("R$ %.2f",anuncio.getPreco()));
		//ratingAnunciante.setRating(0f);
		
		
	}
	
	private void clearScreen()
	{
		txtTitulo.setText("");
		txtData.setText("");
		txtEndereco.setText("");
		txtFornecedor.setText("");
		txtAnunciante.setText("");
		txtPreco.setText("");
		ratingAnunciante.setRating(0);
		ratingAnunciante.setEnabled(false);
	}
	private void sendRating(float rating)
	{
		try {
			String consumidorId = "";
			String produtoId = pAnuncio.getId();
			String ratingStr = String.valueOf(rating);
			RatingOfertaTask ratingOfertaTask = new RatingOfertaTask();
			ratingOfertaTask.execute(consumidorId,produtoId,ratingStr);
		} catch (Exception e) {
			Log.e("Erro ao enviar Rating", e.getMessage());
		}
	
	}
}
