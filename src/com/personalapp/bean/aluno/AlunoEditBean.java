package com.personalapp.bean.aluno;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.model.Aluno;
import com.personalapp.repository.AlunoDao;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class AlunoEditBean implements Serializable {
	
	private final AlunoDao alunoDao;
	private Aluno aluno;
	private String email = "";

	@Inject
	public AlunoEditBean(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}

	public void init() {
		this.aluno = this.alunoDao.findOne(email);
	}

	@ExceptionHandler
	public String update() {
		this.alunoDao.update(this.aluno);
		Messages.create("O Aluno {0} foi adcionado com sucesso!", this.aluno.getNome()).flash().add();
		return "alunos.xhtml?faces-redirect=true";
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getData() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return simpleDateFormat.format(aluno.getData());
	}
	
	public void setData(String event) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse(event);
		this.aluno.setData(data);
	}
}