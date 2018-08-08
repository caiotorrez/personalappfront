 package com.personalapp.model.treino;

import java.time.Instant;
import java.util.Date;

import com.personalapp.model.AbstractEntity;

@SuppressWarnings("serial")
public class FichaDeTreino extends AbstractEntity {

	
	private String titulo;
	private String objetivo;
	private String descricao;
	private Date inicioDoTreino;
	private Date fimDoTreino;
	private String estimulo;
	private RegiaoMuscular treinoA;
	private RegiaoMuscular treinoB;
	private RegiaoMuscular treinoC;
	private RegiaoMuscular treinoD;
	private RegiaoMuscular treinoE;
	private String status;
	private String nomeDoAlunoAssociado;

	public String getNomeDoAlunoAssociado() {
		return nomeDoAlunoAssociado;
	}

	public void setNomeDoAlunoAssociado(String nomeDoAlunoAssociado) {
		this.nomeDoAlunoAssociado = nomeDoAlunoAssociado;
	}

	public String getStatus() {
		this.status = this.fimDoTreino.toInstant().isAfter(Instant.now()) ? "Ativo" : "Inativo";
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getInicioDoTreino() {
		return inicioDoTreino;
	}
	public void setInicioDoTreino(Date inicioDoTreino) {
		this.inicioDoTreino = inicioDoTreino;
	}
	public Date getFimDoTreino() {
		return fimDoTreino;
	}
	public void setFimDoTreino(Date fimDoTreino) {
		this.fimDoTreino = fimDoTreino;
	}
	public String getEstimulo() {
		return estimulo;
	}
	public void setEstimulo(String estimulo) {
		this.estimulo = estimulo;
	}
	public RegiaoMuscular getTreinoA() {
		return treinoA;
	}
	public void setTreinoA(RegiaoMuscular treinoA) {
		this.treinoA = treinoA;
	}
	public RegiaoMuscular getTreinoB() {
		return treinoB;
	}
	public void setTreinoB(RegiaoMuscular treinoB) {
		this.treinoB = treinoB;
	}
	public RegiaoMuscular getTreinoC() {
		return treinoC;
	}
	public void setTreinoC(RegiaoMuscular treinoC) {
		this.treinoC = treinoC;
	}
	public RegiaoMuscular getTreinoD() {
		return treinoD;
	}
	public void setTreinoD(RegiaoMuscular treinoD) {
		this.treinoD = treinoD;
	}
	public RegiaoMuscular getTreinoE() {
		return treinoE;
	}
	public void setTreinoE(RegiaoMuscular treinoE) {
		this.treinoE = treinoE;
	}
}
	
