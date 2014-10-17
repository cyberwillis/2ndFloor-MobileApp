package com.secondfloor.repositoryImpl;

import java.util.ArrayList;
import java.util.List;

import com.secondfloor.dto.OfertaDTO;
import com.secondfloor.messages.EncontrarOfertaResponse;
import com.secondfloor.model.Anuncio;
import com.secondfloor.repository.RepositoryAnuncio;
import com.secondfloor.servicesRest.AnuncioRest;

public class RepositoryAnuncioImpl implements RepositoryAnuncio {

	private AnuncioRest anuncioRest;

	public void RepositoryAnuncioImpl() {
		anuncioRest = new AnuncioRest();
	}

	@Override
	public List<Anuncio> pesquisarAnuncioPorTitulo(String titulo) {
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		EncontrarOfertaResponse response = anuncioRest
				.EncontrarOfertasPorNomeProduto(titulo);
		if (response.getSuccess()) {
			for (OfertaDTO oferta : response.getOfertas()) {
				Anuncio anuncio = new Anuncio();
				anuncio.setTitulo(oferta.getNomeProduto());
				anuncio.setAnunciante(oferta.getAnuncianteRazaoSocial());
				anuncio.setClassificacaoAnunciante(Float.parseFloat(oferta.getAnunciantePontuacao()));
				anuncio.setEndereco(formatarEndereco(oferta));
				anuncio.setFornecedor(oferta.getFabricante());
				anuncio.setPreco(Float.parseFloat(oferta.getValor()));
				// anuncio.setDataOferta(dataOferta);
				anuncios.add(anuncio);
			}
		}
		return anuncios;
	}

	private String formatarEndereco(OfertaDTO oferta) {
		StringBuilder sb = new StringBuilder();
		if (oferta.getLogradouro() != null && oferta.getLogradouro() != "") {
			sb.append(oferta.getLogradouro() + " ");
			sb.append("n: " + oferta.getNumero() + " ");
			if (oferta.getComplemento() != null
					&& oferta.getComplemento() != "") {
				sb.append(" - " + oferta.getComplemento() + " ");
			}
			sb.append(oferta.getBairro() + " - ");
			sb.append(oferta.getCidade() + " - ");
			if (oferta.getEstado() != null
					&& (oferta.getEstado().getSigla() != null && oferta
							.getEstado().getSigla() != "")) {
				sb.append(oferta.getEstado().getSigla() + " - ");
			}
			sb.append("CEP: " + oferta.getCep());
		}
		return sb.toString();
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
