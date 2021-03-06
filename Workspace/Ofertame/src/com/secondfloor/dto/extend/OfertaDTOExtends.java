package com.secondfloor.dto.extend;

import java.util.ArrayList;
import java.util.List;

import android.util.Log;

import com.secondfloor.dto.OfertaDTO;
import com.secondfloor.model.Anuncio;
import com.secondfloor.ofertame.util.StringUtil;

public class OfertaDTOExtends {
	
	public List<Anuncio> OfertaDtoToAnuncios(OfertaDTO[] ofertas) {
		Log.i("OfertaDTOExtends", "OfertaDtoToAnuncios");
		
		List<Anuncio> anuncios = new ArrayList<Anuncio>();
		try {
			for (OfertaDTO oferta : ofertas) {
				Anuncio anuncio = new Anuncio();
				anuncio.setId(oferta.getOfertaId());
				anuncio.setTitulo(oferta.getNomeProduto());
				anuncio.setAnunciante(oferta.getAnuncianteRazaoSocial());
				
				if(!StringUtil.isNullOrWhiteSpace(oferta.getAnunciantePontuacao()))
					anuncio.setClassificacaoAnunciante(Float.parseFloat(oferta.getAnunciantePontuacao()));
				else
					anuncio.setClassificacaoAnunciante(0f);
				
				anuncio.setEndereco(formatarEndereco(oferta));
				anuncio.setFornecedor(oferta.getFabricante());
				
				if(!StringUtil.isNullOrWhiteSpace(oferta.getValor()))
					anuncio.setPreco(Float.parseFloat(oferta.getValor().replace(',', '.')));
				else
					anuncio.setPreco(0f);
				
				anuncio.setDataOferta(oferta.getDataInicio() + " " + oferta.getDataFim());
				anuncios.add(anuncio);
			}
		} catch (Exception e) {
			Log.e("OfertaDTOExtends.OfertaDtoToAnuncios", e.getMessage());
		}
		return anuncios;
	}

	private String formatarEndereco(OfertaDTO oferta) 
	{
		StringBuilder sb = new StringBuilder();
		if (oferta.getLogradouro() != null && oferta.getLogradouro() != "") 
		{
			sb.append(oferta.getLogradouro() + " ");
			sb.append("n: " + oferta.getNumero() + " ");
			if (!StringUtil.isNullOrWhiteSpace(oferta.getComplemento())) 
			{
				sb.append(" - " + oferta.getComplemento() + " ");
			}
			sb.append(oferta.getBairro() + " - ");
			//sb.append(oferta.getCidade() + " - ");
			if (oferta.getEstado() != null && !StringUtil.isNullOrWhiteSpace(oferta.getEstado().getSigla())) 
			{
				sb.append(oferta.getEstado().getSigla() + " - ");
			}
			//sb.append("CEP: " + oferta.getCep());
		}
		return sb.toString();
	}
}
