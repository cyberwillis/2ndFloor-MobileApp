package com.secondfloor.contracts;

import java.util.List;

import com.secondfloor.model.Anuncio;

public interface ServiceAnuncio {
	public List<Anuncio> pesquisarAnuncioPorTitulo(String titulo);
	public void publicarInteresseOferta(int idAnuncio, float interesse);
}
