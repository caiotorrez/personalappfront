package com.personalapp.bean.treino;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.model.treino.Exercicio;
import com.personalapp.repository.ExercicioDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ExercicioListBean implements Serializable {
	
	private final ExercicioDao exercicioDao;
	private List<Exercicio> exercicioList;
	private Exercicio exercicio;
	private String titulo = "";

	@Inject
	public ExercicioListBean(ExercicioDao exercicioDao) {
		this.exercicioDao = exercicioDao;
	}
	
	@PostConstruct
	public void init() {
		this.search();
	}
	
	public void search() {
		this.exercicioList = this.exercicioDao.list(this.titulo);
	}
	
	public List<Exercicio> getExercicioList() {
		return exercicioList;
	}

	public void setExercicioList(List<Exercicio> exercicioList) {
		this.exercicioList = exercicioList;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

}
