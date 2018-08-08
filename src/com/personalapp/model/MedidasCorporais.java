package com.personalapp.model;

import org.apache.tomcat.util.http.fileupload.FileUpload;

@SuppressWarnings("serial")
public class MedidasCorporais extends AbstractEntity {
	
	private String metodoDeAvaliacao;
	private float peso;
	private float gorduraCorporal;
	private float bracoDireito;
	private float bracoEsquerdo;
	private float antebracoDireito;
	private float antebracoEsquerdo;
	private float larguraDosOmbros;
	private float peitoral;
	private float cintura;
	private float quadril;
	private float coxaDireita;
	private float coxaEsquerda;
	private FileUpload file;
	
	
	public FileUpload getFile() {
		return file;
	}
	public void setFile(FileUpload file) {
		this.file = file;
	}
	public String getMetodoDeAvaliacao() {
		return metodoDeAvaliacao;
	}
	public void setMetodoDeAvaliacao(String metodoDeAvaliacao) {
		this.metodoDeAvaliacao = metodoDeAvaliacao;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getGorduraCorporal() {
		return gorduraCorporal;
	}
	public void setGorduraCorporal(float gorduraCorporal) {
		this.gorduraCorporal = gorduraCorporal;
	}
	public float getBracoDireito() {
		return bracoDireito;
	}
	public void setBracoDireito(float bracoDireito) {
		this.bracoDireito = bracoDireito;
	}
	public float getBracoEsquerdo() {
		return bracoEsquerdo;
	}
	public void setBracoEsquerdo(float bracoEsquerdo) {
		this.bracoEsquerdo = bracoEsquerdo;
	}
	public float getAntebracoDireito() {
		return antebracoDireito;
	}
	public void setAntebracoDireito(float antebracoDireito) {
		this.antebracoDireito = antebracoDireito;
	}
	public float getAntebracoEsquerdo() {
		return antebracoEsquerdo;
	}
	public void setAntebracoEsquerdo(float antebracoEsquerdo) {
		this.antebracoEsquerdo = antebracoEsquerdo;
	}
	public float getLarguraDosOmbros() {
		return larguraDosOmbros;
	}
	public void setLarguraDosOmbros(float larguraDosOmbros) {
		this.larguraDosOmbros = larguraDosOmbros;
	}
	public float getPeitoral() {
		return peitoral;
	}
	public void setPeitoral(float peitoral) {
		this.peitoral = peitoral;
	}
	public float getCintura() {
		return cintura;
	}
	public void setCintura(float cintura) {
		this.cintura = cintura;
	}
	public float getQuadril() {
		return quadril;
	}
	public void setQuadril(float quadril) {
		this.quadril = quadril;
	}
	public float getCoxaDireita() {
		return coxaDireita;
	}
	public void setCoxaDireita(float coxaDireita) {
		this.coxaDireita = coxaDireita;
	}
	public float getCoxaEsquerda() {
		return coxaEsquerda;
	}
	public void setCoxaEsquerda(float coxaEsquerda) {
		this.coxaEsquerda = coxaEsquerda;
	}

}
