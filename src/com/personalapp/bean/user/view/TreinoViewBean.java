package com.personalapp.bean.user.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.config.ExceptionHandler;
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
	private final ExternalContext externalContext;
	private Aluno aluno;
	private String email = "";
	private int i;
	private Exercicio exercicio = new Exercicio();
	private List<Exercicio> exeA;

	public List<Exercicio> getExeA() {
		return exeA;
	}

	public void setExeA(List<Exercicio> exeA) {
		this.exeA = exeA;
	}
	
	public void setI(int i) {
		this.i = i;
	}
	
	public int getI() {
		return this.i;
	}
	
	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}
	
	public Exercicio getExercicio() {
		return this.exercicio;
	}
	

	@Inject
	public TreinoViewBean(AlunoDao alunoDao, ExternalContext externalContext) {
		this.externalContext = externalContext;
		this.alunoDao = alunoDao;
		this.aluno = alunoDao.findOne("caio.torres@ccc.ufcg.edu.br");
		
	}
	
	@ExceptionHandler
//	@PostConstruct
	public void init(String username) {
		this.aluno = this.alunoDao.findAluno(username);
		this.exeA = this.listExercicioA();
	}
	
//	@PostConstruct
//	public void relist() {
//		this.exeA = this.containsTreino("A") ? listExercicioA() : null;
//	}
	
	@PostConstruct
	public void searchTreino() throws IOException {
//		if (this.email == null || this.email.trim().equals("")) {
//			this.externalContext.redirect(this.externalContext.getApplicationContextPath());
//		} else {
			this.aluno = this.alunoDao.findOne("caio.torres@ccc.ufcg.edu.br");
			this.exeA = this.listExercicioA();
//		}
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public boolean containsTreino(String letter) {
		if (this.aluno.getFichaDeTreino() == null) {
			return false;
		}
		if (letter.toUpperCase().equals("A")) {
			return this.alunoDao.findOne("caio.torres@ccc.ufcg.edu.br").getFichaDeTreino().getTreinoA() != null;
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
		this.exeA = gerador.buildListExerciciosA(this.alunoDao.findOne("caio.torres@ccc.ufcg.edu.br").getFichaDeTreino());
		return this.exeA;
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
