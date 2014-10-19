package com.secondfloor.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.secondfloor.dto.OfertaDTO;
import com.secondfloor.dto.extend.OfertaDTOExtends;
import com.secondfloor.messages.EncontrarOfertaResponse;
import com.secondfloor.model.Anuncio;
import com.secondfloor.repository.RepositoryAnuncio;
import com.secondfloor.servicesRest.AnuncioRest;

public class RepositoryAnuncioImpl implements RepositoryAnuncio {

	@Override
	public List<Anuncio> pesquisarAnuncioPorTitulo(String titulo) {
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		try {
			EncontrarOfertaResponse response = new AnuncioRest().EncontrarOfertasPorNomeProduto(titulo);
			if (response.getSuccess()) {
				anuncios = new OfertaDTOExtends().OfertaDtoToAnuncios(response.getOfertas());
			}
		} catch (Exception e) {
			Log.i("Exception", e.getMessage());
		}
		return anuncios;
	}

	@Override
	public void publicarInteresseOferta(int idAnuncio, float interesse) {
		// TODO Auto-generated method stub

	}

}

/*
 * Propriedades do de OfertaDTO ofertaId referencia nomeProduto descricao
 * fabricante valor logradouro numero complemento bairro cidade estado cep
 * anuncianteId anuncianteRazaoSocial anunciantePontuacao
 */
