package com.personalapp.model;

import java.io.ByteArrayInputStream;

import org.primefaces.model.DefaultStreamedContent;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
public class Imagem extends BaseEntity {
	
	//return new DefaultStreamedContent(new ByteArrayInputStream(img));
	private String titulo;
	private Long tamanho;
	private byte[] dados;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Long getTamanho() {
		return tamanho;
	}
	public void setTamanho(Long tamanho) {
		this.tamanho = tamanho;
	}
	public byte[] getDados() {
		return dados;
	}
	public void setDados(byte[] dados) {
		this.dados = dados;
	}
	
	@JsonIgnore
	public DefaultStreamedContent getPicture() {
		return new DefaultStreamedContent(new ByteArrayInputStream(this.dados));
	}
}
