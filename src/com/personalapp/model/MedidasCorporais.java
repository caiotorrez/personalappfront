package com.personalapp.model;

import java.util.Date;

@SuppressWarnings("serial")
public class MedidasCorporais extends AbstractEntity {
	
	
	private String metodoDeAvaliacao;
	private String peso;
	private String gorduraCorporal;
	private String larguraDosOmbros;
	private String peitoral;
	private String cintura;
	private String quadril;
	private String bracoDireito;
	private String bracoEsquerdo;
	private String antebracoDireito;
	private String antebracoEsquerdo;
	private String pernaDireita;
	private String pernaEsquerda;
	private String panturrilhaDireita;
	private String panturrilhaEsquerda;
	private Imagem frontal;
	private Imagem posterior;
	private Date dataDaAvaliacao;
	
	
	public Date getDataDaAvaliacao() {
		return dataDaAvaliacao;
	}
	public void setDataDaAvaliacao(Date dataDaAvaliacao) {
		this.dataDaAvaliacao = dataDaAvaliacao;
	}
	
	public Imagem getFrontal() {
		return frontal;
	}
	public void setFrontal(Imagem frontal) {
		this.frontal = frontal;
	}
	public Imagem getPosterior() {
		return posterior;
	}
	public void setPosterior(Imagem posterior) {
		this.posterior = posterior;
	}
	public String getMetodoDeAvaliacao() {
		return metodoDeAvaliacao;
	}
	public void setMetodoDeAvaliacao(String metodoDeAvaliacao) {
		this.metodoDeAvaliacao = metodoDeAvaliacao;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getGorduraCorporal() {
		return gorduraCorporal;
	}
	public void setGorduraCorporal(String gorduraCorporal) {
		this.gorduraCorporal = gorduraCorporal;
	}
	public String getLarguraDosOmbros() {
		return larguraDosOmbros;
	}
	public void setLarguraDosOmbros(String larguraDosOmbros) {
		this.larguraDosOmbros = larguraDosOmbros;
	}
	public String getPeitoral() {
		return peitoral;
	}
	public void setPeitoral(String peitoral) {
		this.peitoral = peitoral;
	}
	public String getCintura() {
		return cintura;
	}
	public void setCintura(String cintura) {
		this.cintura = cintura;
	}
	public String getQuadril() {
		return quadril;
	}
	public void setQuadril(String quadril) {
		this.quadril = quadril;
	}
	public String getBracoDireito() {
		return bracoDireito;
	}
	public void setBracoDireito(String bracoDireito) {
		this.bracoDireito = bracoDireito;
	}
	public String getBracoEsquerdo() {
		return bracoEsquerdo;
	}
	public void setBracoEsquerdo(String bracoEsquerdo) {
		this.bracoEsquerdo = bracoEsquerdo;
	}
	public String getAntebracoDireito() {
		return antebracoDireito;
	}
	public void setAntebracoDireito(String antebracoDireito) {
		this.antebracoDireito = antebracoDireito;
	}
	public String getAntebracoEsquerdo() {
		return antebracoEsquerdo;
	}
	public void setAntebracoEsquerdo(String antebracoEsquerdo) {
		this.antebracoEsquerdo = antebracoEsquerdo;
	}
	public String getPernaDireita() {
		return pernaDireita;
	}
	public void setPernaDireita(String pernaDireita) {
		this.pernaDireita = pernaDireita;
	}
	public String getPernaEsquerda() {
		return pernaEsquerda;
	}
	public void setPernaEsquerda(String pernaEsquerda) {
		this.pernaEsquerda = pernaEsquerda;
	}
	public String getPanturrilhaDireita() {
		return panturrilhaDireita;
	}
	public void setPanturrilhaDireita(String panturrilhaDireita) {
		this.panturrilhaDireita = panturrilhaDireita;
	}
	public String getPanturrilhaEsquerda() {
		return panturrilhaEsquerda;
	}
	public void setPanturrilhaEsquerda(String panturrilhaEsquerda) {
		this.panturrilhaEsquerda = panturrilhaEsquerda;
	}

}
