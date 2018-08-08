package com.personalapp.model.treino;

import com.personalapp.model.AbstractEntity;


@SuppressWarnings("serial")
public class Exercicio extends AbstractEntity {
	

	private String titulo;
	private String regiao;
	private String descricao;
	private String urlVideo;
	private String urlDetalhes;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public String getUrlDetalhes() {
		return urlDetalhes;
	}

	public void setUrlDetalhes(String urlDetalhes) {
		this.urlDetalhes = urlDetalhes;
	}
}
