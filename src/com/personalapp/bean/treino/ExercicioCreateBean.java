package com.personalapp.bean.treino;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FilenameUtils;
import org.omnifaces.util.Messages;
import org.primefaces.model.UploadedFile;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.model.treino.Exercicio;
import com.personalapp.repository.ExercicioDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ExercicioCreateBean implements Serializable {
	
	private final ExercicioDao exercicioDao;
	private Exercicio exercicio = new Exercicio();
	private UploadedFile imagem;

	@Inject
	public ExercicioCreateBean(ExercicioDao exercicioDao) {
		this.exercicioDao = exercicioDao;
	}
	
	@ExceptionHandler
	public String create() throws IOException {
		if (this.exercicioDao.findOne(this.exercicio.getTitulo()) == null) {
			if (this.getImagem() != null) {
				this.exercicio.setImagem_data(getImagem().getContents());
			}
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
	

	public UploadedFile getImagem() {
		return imagem;
	}

	public void setImagem(UploadedFile imagem) {
		this.imagem = imagem;
	}
}
