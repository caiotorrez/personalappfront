package com.personalapp.bean.aluno;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.model.Aluno;
import com.personalapp.model.Imagem;
import com.personalapp.model.MedidasCorporais;
import com.personalapp.repository.AlunoDao;
import com.personalapp.repository.ImagemDao;
import com.personalapp.repository.MedidasDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class MedidasCreateBean implements Serializable {

	private Aluno aluno;
	private MedidasCorporais medidas = new MedidasCorporais();
	private String email;
	private String nome;
	private final AlunoDao alunoDao;
	private final MedidasDao medidasDao;
	private final ImagemDao imagemDao;
	private Date dataAvaliativa = new Date().from(Instant.now());
	private UploadedFile file1;
	private UploadedFile file2;
	
	@Inject
	public MedidasCreateBean(AlunoDao alunoDao, MedidasDao medidasDao, ImagemDao imagemDao) {
		this.alunoDao = alunoDao;
		this.medidasDao = medidasDao;
		this.imagemDao = imagemDao;
	}
	
	@ExceptionHandler
	public String build() {
		this.aluno = this.alunoDao.findOne(this.email);
		this.medidas.setDataDaAvaliacao(this.dataAvaliativa);
		this.buildImages();
		MedidasCorporais medidas = this.medidasDao.save(this.medidas);
		if(this.aluno.getMedidasCorporais() != null) {
			this.aluno.getMedidasHistorico().add(this.aluno.getMedidasCorporais());
		}
		this.aluno.setMedidasCorporais(medidas);
		this.alunoDao.update(this.aluno);
		return "alunos.xhtml?faces-redirect=true";
	}
	
	@ExceptionHandler
	private void buildImages() {
		if (this.file1 != null) {
			Imagem imagem = new Imagem();
			imagem.setDados(this.file1.getContents());
			imagem.setTamanho(this.file1.getSize());
			imagem.setTitulo(this.file1.getFileName());
			Imagem novaImagem = this.imagemDao.save(imagem);
			this.medidas.setFrontal(novaImagem);
		}
		if (this.file2 != null) {
			Imagem imagem = new Imagem();
			imagem.setDados(this.file2.getContents());
			imagem.setTamanho(this.file2.getSize());
			imagem.setTitulo(this.file2.getFileName());
			this.medidas.setPosterior(this.imagemDao.save(imagem));
		}
	}
	
	public void fileUploadListener(FileUploadEvent e) {
		if (this.file1 == null) {
			this.file1 = e.getFile();
		} else {
			this.file2 = e.getFile();
		}
	}
	
	public UploadedFile getFile1() {
		return file1;
	}

	public void setFile1(UploadedFile file1) {
		this.file1 = file1;
	}

	public UploadedFile getFile2() {
		return file2;
	}

	public void setFile2(UploadedFile file2) {
		this.file2 = file2;
	}

	public MedidasCorporais getMedidas() {
		return medidas;
	}
	public void setMedidas(MedidasCorporais medidas) {
		this.medidas = medidas;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataAvaliativa() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDateTime.now().format(formato);
	}
}
