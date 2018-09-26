package com.personalapp.bean.validator;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.repository.ExercicioDao;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class ValidatorExercicioBuild implements Serializable {
	
	private final ExercicioDao exercicioDao;
	private String exercicioNomeIsValid;
	private String urlIsValid;
	
	@Inject
	public ValidatorExercicioBuild(ExercicioDao exercicioDao) {
		this.exercicioDao = exercicioDao;
	}
	
	public String getExercicioNomeIsValid() {
		return exercicioNomeIsValid;
	}

	public String getUrlIsValid() {
		return urlIsValid;
	}
	
	public void validarNomeExercicio(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		String titulo = (String) o;
		if (titulo == null || titulo.trim().equals("") || this.exercicioDao.findOne(titulo.trim()) != null) {
			this.exercicioNomeIsValid = "border-color:red";
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exercício já cadastrado", ""));
		} this.exercicioNomeIsValid = "border-color:blue";
	}
	
	public void validarUrlsExercicio(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		String url = (String) o;
		url = url.trim();
		if (url == null || url.trim().equals("") || !(url.contains("http://") || url.contains("https://"))) {
			this.urlIsValid = "border-color:red";
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "URL Inválido - verifique se falta o 'http://' ", ""));
		} this.urlIsValid = "border-color:blue";
	}
}
