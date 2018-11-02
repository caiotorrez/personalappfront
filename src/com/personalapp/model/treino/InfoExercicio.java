package com.personalapp.model.treino;

import com.personalapp.model.BaseEntity;

@SuppressWarnings("serial")
public class InfoExercicio extends BaseEntity {
	
	private int seriesI;
	private int seriesF;
	private int repsI;
	private int repsF;
	private int cargaI;
	private int cargaF;
	private int ajuste;
	private int intervaloI;
	private int intervaloF;
	private int cadencia;
	private String metodo;
	
	public int getSeriesI() {
		return seriesI;
	}
	public void setSeriesI(int seriesI) {
		this.seriesI = seriesI;
	}
	public int getSeriesF() {
		return seriesF;
	}
	public void setSeriesF(int seriesF) {
		this.seriesF = seriesF;
	}
	public int getRepsI() {
		return repsI;
	}
	public void setRepsI(int repsI) {
		this.repsI = repsI;
	}
	public int getRepsF() {
		return repsF;
	}
	public void setRepsF(int repsF) {
		this.repsF = repsF;
	}
	public int getCargaI() {
		return cargaI;
	}
	public void setCargaI(int cargaI) {
		this.cargaI = cargaI;
	}
	public int getCargaF() {
		return cargaF;
	}
	public void setCargaF(int cargaF) {
		this.cargaF = cargaF;
	}
	public int getAjuste() {
		return ajuste;
	}
	public void setAjuste(int ajuste) {
		this.ajuste = ajuste;
	}
	public int getIntervaloI() {
		return intervaloI;
	}
	public void setIntervaloI(int intervaloI) {
		this.intervaloI = intervaloI;
	}
	public int getIntervaloF() {
		return intervaloF;
	}
	public void setIntervaloF(int intervaloF) {
		this.intervaloF = intervaloF;
	}
	public int getCadencia() {
		return cadencia;
	}
	public void setCadencia(int cadencia) {
		this.cadencia = cadencia;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
}
