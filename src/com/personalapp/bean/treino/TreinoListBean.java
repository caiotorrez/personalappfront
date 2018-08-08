package com.personalapp.bean.treino;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.model.treino.FichaDeTreino;
import com.personalapp.repository.TreinoDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class TreinoListBean implements Serializable {
	
	private final TreinoDao treinoDao;
	private List<FichaDeTreino> treinoList;
	private String titulo = "";

	@Inject
	public TreinoListBean(TreinoDao treinoDao) {
		this.treinoDao = treinoDao;
	}
	
	@PostConstruct
	public void init() {
		this.search();
	}
	
	public void search() {
		this.treinoList = this.treinoDao.list(this.titulo);
	}
	
	public List<FichaDeTreino> getFichaList() {
		return treinoList;
	}

	public void setTreinoList(List<FichaDeTreino> fichaList) {
		this.treinoList = fichaList;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}	
