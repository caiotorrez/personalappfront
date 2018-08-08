package com.personalapp.bean.treino;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.model.treino.Exercicio;
import com.personalapp.repository.ExercicioDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ExercicioCreateBean implements Serializable {
	
	private final ExercicioDao exercicioDao;
	private Exercicio exercicio = new Exercicio();

	@Inject
	public ExercicioCreateBean(ExercicioDao exercicioDao) {
		this.exercicioDao = exercicioDao;
	}
	
	@ExceptionHandler
	public String create() {
		if (this.exercicioDao.findOne(this.exercicio.getTitulo()) == null) {
			this.exercicioDao.save(this.exercicio);
			Messages.create("O Exercicio {0} foi adcionado com sucesso!", this.exercicio.getTitulo()).flash().add();
			return "exercise.xhtml?faces-redirect=true";
		} else {
			Messages.create("O exercicio {0} já está cadastrado.", this.exercicio.getTitulo()).error().fatal().flash().add();
		} return null;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

}
