package com.personalapp.bean.validator;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.model.ApplicationUser;
import com.personalapp.repository.AlunoDao;

@SuppressWarnings("serial")
@Named
@RequestScoped
public class ValidatorRegister implements Serializable {
	
	private final AlunoDao alunoDao;
	private String emailIsValid;
	private String dataIsValid;
	private String usernameIsValid;
	private String cepIsValid;
	private String celIsValid;

	@Inject
	public ValidatorRegister(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}
	
	public String getCelIsValid() {
		return celIsValid;
	}
	
	public String getDataIsValid() {
		return dataIsValid;
	}
	
	public String getEmailIsValid() {
		return emailIsValid;
	}

	public String getUsernameIsValid() {
		return usernameIsValid;
	}
	
	public String getCepIsValid() {
		return cepIsValid;
	}

	public void validarEmail(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		String email = (String) o;
		if (email == null || email.trim().equals("") || !email.matches(regex) || this.alunoDao.findOne(email) != null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email inválido ou já cadastrado", "");
			this.emailIsValid = "border-color:red";
			throw new ValidatorException(message);
		} this.emailIsValid = "border-color:blue";
	}
	
	public void validarData(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		String regex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";
		String data = (String) o;
		if (data == null || data.trim().equals("") || !data.matches(regex)) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data no formato inválido", "");
			this.dataIsValid = "border-color:red";
			throw new ValidatorException(message);
		} else {
			this.dataIsValid = "border-color:blue";
		}
	}
	
	public void validarCep(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		String cep = (String) o;
		if (cep == null || cep.trim().equals("") || cep.length() < 8) {
			this.cepIsValid = "border-color:red";
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cep no formato inválido", "");
			this.cepIsValid = "border-color:red";
			throw new ValidatorException(message);
		} else {
			this.cepIsValid = "border-color:blue";
		}
	}
	
	public void validarUsername(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		String username = (String) o;
		ApplicationUser user = new ApplicationUser();
		user.setUsername(username);
		if (username == null || username.trim().equals("") || this.alunoDao.check(user) != null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário inválido ou  já cadastrado", "");
			this.usernameIsValid = "border-color:red";
			throw new ValidatorException(message);
		} this.usernameIsValid = "border-color:blue";
	}
	
	public void validarCelular(FacesContext context, UIComponent component, Object o) throws ValidatorException {
		String phone = (String) o;
		if (phone == null || phone.trim().equals("") || phone.length() < 15) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Celular inválido", "");
			this.celIsValid = "border-color:red";
			throw new ValidatorException(message);
		} this.celIsValid = "border-color:blue";
	}
}
