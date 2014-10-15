package com.secondfloor.repository;

import java.util.List;

import com.secondfloor.model.Anuncio;

public interface RepositoryAnuncio {

	List<Anuncio> pesquisarAnuncioPorTitulo(String titulo);

	Anuncio pesquisarAnuncioPorId(int id);

	void publicarInteresseOferta(int idAnuncio, float interesse);

}