package com.secondfloor.services;

import java.util.List;

import com.secondfloor.contracts.ServiceAnuncio;
import com.secondfloor.model.Anuncio;
import com.secondfloor.repository.RepositoryAnuncio;

public class ServiceAnuncioImpl implements ServiceAnuncio{

	private RepositoryAnuncio repositorioAnuncio;

	@Override
	public List<Anuncio> pesquisarAnuncioPorTitulo(String titulo) {
		return repositorioAnuncio.pesquisarAnuncioPorTitulo(titulo);
	}

	@Override
	public Anuncio pesquisarAnuncioPorId(int id) {
		return repositorioAnuncio.pesquisarAnuncioPorId(id);
	}

	@Override
	public void publicarInteresseOferta(int idAnuncio, float interesse) {
		repositorioAnuncio.publicarInteresseOferta(idAnuncio,interesse);
	}

	public ServiceAnuncioImpl(RepositoryAnuncio repositorioAnuncio) {
		this.repositorioAnuncio = repositorioAnuncio;
	}
	
}