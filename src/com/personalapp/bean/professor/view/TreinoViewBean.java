package com.personalapp.bean.professor.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.bean.service.GeradorDeInfosImpressao;
import com.personalapp.bean.service.GeradorDeListasImpressao;
import com.personalapp.model.Aluno;
import com.personalapp.model.treino.Exercicio;
import com.personalapp.model.treino.InfoExercicio;
import com.personalapp.repository.AlunoDao;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class TreinoViewBean implements Serializable {
	
	private GeradorDeListasImpressao gerador = new GeradorDeListasImpressao();
	private GeradorDeInfosImpressao geradorInfos = new GeradorDeInfosImpressao();
	
	private final AlunoDao alunoDao;
	private Aluno aluno;
	private String email;
	private Exercicio exercicio = new Exercicio();

	@Inject
	public TreinoViewBean(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}

	public void searchTreino() {
		this.aluno = this.alunoDao.findOne(this.email);
	}
	
	public void setEmail(String email) {
		this.email = email;
		this.searchTreino();
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}
	
	public Exercicio getExercicio() {
		return this.exercicio;
	}
	
	public boolean containsTreino(String letter) {
		if (this.aluno == null || this.aluno.getFichaDeTreino() == null) {
			return false;
		}
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
	
	public String getObs(String letter) {
		if (letter.equalsIgnoreCase("A")) {
			return this.aluno.getFichaDeTreino().getTreinoA().getObs().trim();
		}
		else if (letter.equalsIgnoreCase("B")) {
			return this.aluno.getFichaDeTreino().getTreinoB().getObs().trim();
		}
		else if (letter.equalsIgnoreCase("C")) {
			return this.aluno.getFichaDeTreino().getTreinoC().getObs().trim();
		}
		else if (letter.equalsIgnoreCase("D")) {
			return this.aluno.getFichaDeTreino().getTreinoD().getObs().trim();
		}
		else {
			return this.aluno.getFichaDeTreino().getTreinoE().getObs().trim();
		}
	}

	public List<Exercicio> listExercicioA() {
		return gerador.buildListExerciciosA(this.aluno.getFichaDeTreino());
	}
	public List<Exercicio> listExercicioB() {
		return gerador.buildListExerciciosB(this.aluno.getFichaDeTreino());
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
	
}
