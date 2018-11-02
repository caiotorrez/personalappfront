package com.personalapp.model.treino;

import com.personalapp.model.BaseEntity;
import com.personalapp.model.Imagem;


@SuppressWarnings("serial")
public class Exercicio extends BaseEntity {
	

	private String titulo;
	private String regiao;
	private String descricao;
	private String urlVideo;
	private String urlDetalhes;
	private Imagem imagem;
	
	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}

	public Imagem getImagem() {
		return imagem;
	}

//	@JsonIgnore
//	public DefaultStreamedContent getPicture() {
//		byte[] img = this.imagem;
//		return new DefaultStreamedContent(new ByteArrayInputStream(img));
//	}
//	
//	public void setImagem(byte[] imagem) {
//		this.imagem = imagem;
//	}

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
