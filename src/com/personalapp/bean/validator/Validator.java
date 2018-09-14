package com.personalapp.bean.validator;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.model.Aluno;
import com.personalapp.model.ApplicationUser;
import com.personalapp.repository.AlunoDao;
import com.personalapp.repository.ExercicioDao;
import com.personalapp.repository.LoginDao;
import com.personalapp.repository.MedidasDao;
import com.personalapp.repository.TreinoDao;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class Validator implements Serializable {
	
	private final AlunoDao alunoDao;
	private final MedidasDao medidasDao;
	private final TreinoDao treinoDao;
	private final ExercicioDao exercicioDao;
	private final LoginDao loginDao;
	
	@Inject
	public Validator(AlunoDao alunoDao, MedidasDao medidasDao, TreinoDao treinoDao, ExercicioDao exercicioDao,
			LoginDao loginDao) {
		super();
		this.alunoDao = alunoDao;
		this.medidasDao = medidasDao;
		this.treinoDao = treinoDao;
		this.exercicioDao = exercicioDao;
		this.loginDao = loginDao;
	}
	
	public void validarEmail(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		String email = (String) o;
		if (email == null || !email.matches(regex) || this.alunoDao.findOne(email) != null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email inválido ou já cadastrado", "");
			throw new ValidatorException(message);
		}
	}
	
	public void validarData(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		String regex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
		String data = (String) o;
		if (data == null || !data.matches(regex)) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data no formato inválido", "");
			throw new ValidatorException(message);
		}
	}
	
	public void validarUsername(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		String username = (String) o;
		ApplicationUser user = new ApplicationUser();
		user.setUsername(username);
		if (username == null ||  this.alunoDao.check(user) != null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário já cadastrado | Reajuste o Nome Completo do Aluno.", "");
			throw new ValidatorException(message);
		}
	}
	
	public void validarNomeExercicio(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		String titulo = (String) o;
		if (titulo == null || this.exercicioDao.findOne(titulo.trim()) != null) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exercício já cadastrado", ""));
		}
	}
	
	public void validarUrlsExercicio(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		String url = (String) o;
		url = url.trim();
		if (url == null || !url.contains("http://") ||!url.contains("https://")) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "URL Inválido", ""));
		}
	}
	
	

}
