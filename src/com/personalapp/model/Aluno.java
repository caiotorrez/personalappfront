package com.personalapp.model;

import java.util.Date;
import java.util.List;

import org.springframework.lang.NonNull;

import com.personalapp.model.treino.FichaDeTreino;

@SuppressWarnings("serial")
public class Aluno extends BaseEntity {
	

	private String nome;
	private String email;
	private String academia;
	private Date data;
	private char genero;
	private String cel;
	private FichaDeTreino fichaDeTreino;
	private MedidasCorporais medidasCorporais;
	private List<FichaDeTreino> historico;
	private List<MedidasCorporais> medidasHistorico;
	private String cep;
	
	public List<FichaDeTreino> getHistorico() {
		return historico;
	}
	public void setHistorico(List<FichaDeTreino> historico) {
		this.historico = historico;
	}
	public FichaDeTreino getFichaDeTreino() {
		return fichaDeTreino;
	}
	public void setFichaDeTreino(FichaDeTreino fichaDeTreino) {
		this.fichaDeTreino = fichaDeTreino;
	}
	public String getAcademia() {
		return academia;
	}
	public void setAcademia(String academia) {
		this.academia = academia;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public MedidasCorporais getMedidasCorporais() {
		return medidasCorporais;
	}
	public void setMedidasCorporais(MedidasCorporais medidasCorporais) {
		this.medidasCorporais = medidasCorporais;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public List<MedidasCorporais> getMedidasHistorico() {
		return medidasHistorico;
	}
	public void setMedidasHistorico(List<MedidasCorporais> medidasHistorico) {
		this.medidasHistorico = medidasHistorico;
	}
}