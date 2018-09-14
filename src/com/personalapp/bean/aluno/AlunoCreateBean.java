package com.personalapp.bean.aluno;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.model.Aluno;
import com.personalapp.model.ApplicationUser;
import com.personalapp.repository.AlunoDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class AlunoCreateBean implements Serializable {
	
	private final AlunoDao alunoDao;
	private Aluno aluno = new Aluno();
	private String data;
	
	@Inject
	public AlunoCreateBean(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}

	@ExceptionHandler
	public String create(boolean flag) throws ValidatorException {
		if (this.alunoDao.findOne(this.aluno.getEmail()) == null) {
			this.alunoDao.save(this.aluno);
			return flag ? "medidas.xhtml?email=" + this.aluno.getEmail().replaceAll("@", "%40") + "&nome=" + this.aluno.getNome().replaceAll(" ", "+") + "faces-redirect=true": "alunos.xhtml?faces-redirect=true";
		} 
		return null;
	}


	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


	public String getData() {
		return this.data;
	}

	public void setData(String event) throws ParseException {
		this.data = event;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse(event);
		this.aluno.setData(data);
	}
}
