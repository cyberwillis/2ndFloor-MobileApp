package com.secondfloor.repositoryFake;

import java.util.ArrayList;
import java.util.List;

import com.secondfloor.model.Anuncio;
import com.secondfloor.repository.RepositoryAnuncio;

public class RepositoryAnuncioFake implements RepositoryAnuncio{

	@Override
	public List<Anuncio> pesquisarAnuncioPorTitulo(String titulo) {
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		
		return anuncios;
	}


	@Override
	public void publicarInteresseOferta(int idAnuncio, float interesse) {
		// TODO Auto-generated method stub
		
	}

}
