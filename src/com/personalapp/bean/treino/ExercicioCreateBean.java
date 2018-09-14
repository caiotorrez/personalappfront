package com.personalapp.bean.treino;

import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.model.Imagem;
import com.personalapp.model.treino.Exercicio;
import com.personalapp.repository.ExercicioDao;
import com.personalapp.repository.ImagemDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ExercicioCreateBean implements Serializable {
	
	private final ExercicioDao exercicioDao;
	private final ImagemDao imagemDao;
	private Exercicio exercicio = new Exercicio();
	private UploadedFile file;


	@Inject
	public ExercicioCreateBean(ExercicioDao exercicioDao, ImagemDao imagemDao) {
		this.exercicioDao = exercicioDao;
		this.imagemDao = imagemDao;
	}
	
	@ExceptionHandler
	public String create() {
		if (this.file != null) {
			Imagem imagem = new Imagem();
			imagem.setDados(this.file.getContents());
			imagem.setTamanho(this.file.getSize());
			imagem.setTitulo(file.getFileName());
			this.exercicio.setImagem(this.imagemDao.save(imagem));
		}
		this.exercicioDao.save(this.exercicio);
		Messages.create("O Exercício {0} foi criado com sucesso!", this.exercicio.getTitulo()).flash().add();
		return "index.xhtml?faces-redirect=true";
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}
	
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    
	public DefaultStreamedContent getPicture() {
		return new DefaultStreamedContent(new ByteArrayInputStream(this.file.getContents()));
	}
    
	public void fileUploadListener(FileUploadEvent e) {
		this.file = e.getFile();
	}
	
//    public StreamedContent getimg() {
//    	byte[] img = this.exercicioDao.findOne("aas").getImagem().getDados();
//    	return new DefaultStreamedContent(new ByteArrayInputStream(img));
//    }
 }
