package com.personalapp.bean.aluno;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.personalapp.model.Aluno;
import com.personalapp.repository.AlunoDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class AlunoListBean implements Serializable {
	
	private final AlunoDao alunoDao;
	private List<Aluno> alunosList;
	private String nome = "";

	@Inject
	public AlunoListBean(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}
	
	@PostConstruct
	public void init() {
		this.search();
	}
	
	public void search() {
		this.alunosList = this.alunoDao.list(nome);
	}
	
	public List<Aluno> getAlunosList() {
		return alunosList;
	}

	public void setAlunosList(List<Aluno> alunosList) {
		this.alunosList = alunosList;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}	
