package com.personalapp.bean.aluno;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.model.Aluno;
import com.personalapp.model.treino.Exercicio;
import com.personalapp.repository.AlunoDao;


@Named
@ViewScoped
public class AlunoEditBean implements Serializable {
	
	private final AlunoDao alunoDao;
	private Aluno aluno;
	private String email = "";
	private GeradorDeListasImpressao gerador = new GeradorDeListasImpressao();

	@Inject
	public AlunoEditBean(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}


	public void init() {
		this.aluno = this.alunoDao.findOne(email);
	}

	public List<Exercicio> ListExercicioA() {
		return gerador.buildListExerciciosA(this.aluno.getFichaDeTreino());
	}
	public List<Exercicio> ListExercicioB() {
		return gerador.buildListExerciciosB(this.aluno.getFichaDeTreino());
	}
	public List<Exercicio> ListExercicioC() {
		return gerador.buildListExerciciosC(this.aluno.getFichaDeTreino());
	}
	public List<Exercicio> ListExercicioD() {
		return gerador.buildListExerciciosD(this.aluno.getFichaDeTreino());
	}
	public List<Exercicio> ListExercicioE() {
		return gerador.buildListExerciciosE(this.aluno.getFichaDeTreino());
	}

	@ExceptionHandler
	public String update() {
		this.alunoDao.update(this.aluno);
		Messages.create("O Aluno {0} foi adcionado com sucesso!", this.aluno.getNome()).flash().add();
		return "alunos.xhtml?faces-redirect=true";
	}

//	public String delete() {
	//	return null;
	//}

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

}
