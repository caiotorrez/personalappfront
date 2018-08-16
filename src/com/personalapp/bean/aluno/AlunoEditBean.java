package com.personalapp.bean.aluno;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.model.Aluno;
import com.personalapp.model.treino.Exercicio;
import com.personalapp.model.treino.InfoExercicio;
import com.personalapp.repository.AlunoDao;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class AlunoEditBean implements Serializable {
	
	private final AlunoDao alunoDao;
	private Aluno aluno;
	private String email = "";
	private GeradorDeListasImpressao gerador = new GeradorDeListasImpressao();
	private GeradorDeInfosImpressao geradorInfos = new GeradorDeInfosImpressao();

	@Inject
	public AlunoEditBean(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}


	public void init() {
		this.aluno = this.alunoDao.findOne(email);
	}
	
	public boolean containsTreino(String letter) {
		if (letter.toUpperCase().equals("A")) {
			return this.aluno.getFichaDeTreino().getTreinoA() != null;
		}
		if (letter.toUpperCase().equals("B")) {
			return this.aluno.getFichaDeTreino().getTreinoB() != null;
		}
		if (letter.toUpperCase().equals("C")) {
			return this.aluno.getFichaDeTreino().getTreinoC() != null;
		}
		if (letter.toUpperCase().equals("D")) {
			return this.aluno.getFichaDeTreino().getTreinoD() != null;
		} return this.aluno.getFichaDeTreino().getTreinoE() != null;

	}

	public List<Exercicio> listExercicioA() {
		return gerador.buildListExerciciosA(this.aluno.getFichaDeTreino());
	}
	public List<Exercicio> listExercicioB() {
		List<Exercicio> lista = gerador.buildListExerciciosB(this.aluno.getFichaDeTreino());
		return lista;
	}
	public List<Exercicio> listExercicioC() {
		return gerador.buildListExerciciosC(this.aluno.getFichaDeTreino());
	}
	public List<Exercicio> listExercicioD() {
		return gerador.buildListExerciciosD(this.aluno.getFichaDeTreino());
	}
	public List<Exercicio> listExercicioE() {
		return gerador.buildListExerciciosE(this.aluno.getFichaDeTreino());
	}
	
	public List<InfoExercicio> listInfosA() {
		return geradorInfos.buildListInfosA(this.aluno.getFichaDeTreino());
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