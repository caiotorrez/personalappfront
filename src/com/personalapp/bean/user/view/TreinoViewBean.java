package com.personalapp.bean.user.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.PrimeFacesContext;

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

	@Inject
	public TreinoViewBean(AlunoDao alunoDao, ExternalContext externalContext) {
		this.externalContext = externalContext;
		this.alunoDao = alunoDao;
	}
	
	@ExceptionHandler
	public void init(String username) {
		this.aluno = this.alunoDao.findAluno(username);
	}
	
	public boolean containsTreino(String letter) {
		if (this.aluno.getFichaDeTreino() == null) {
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
	
    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "What we do in life", "Echoes in eternity.");
        System.out.println(PrimeFacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap());
    }
}
