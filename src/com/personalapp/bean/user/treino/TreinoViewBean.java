package com.personalapp.bean.user.treino;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.model.Aluno;
import com.personalapp.model.treino.Exercicio;
import com.personalapp.model.treino.FichaDeTreino;
import com.personalapp.model.treino.InfoExercicio;
import com.personalapp.repository.AlunoDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class TreinoViewBean implements Serializable {
	
	
	private GeradorDeListasImpressao gerador = new GeradorDeListasImpressao();
	private GeradorDeInfosImpressao geradorInfos = new GeradorDeInfosImpressao();
	
	private final AlunoDao alunoDao;
	private Aluno aluno;

	@Inject
	public TreinoViewBean(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}
	
	public void init(String username) {
		this.aluno = this.alunoDao.findAluno(username);
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

}
