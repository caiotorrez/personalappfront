package com.personalapp.bean.user.view;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.model.Imagem;
import com.personalapp.repository.ImagemDao;

@SuppressWarnings("serial")
@Named
@ApplicationScoped
public class ImagemViewBean implements Serializable {
	
	
	private final ImagemDao imagemDao;
	private Imagem imagem = new Imagem();
	
	@Inject
	public ImagemViewBean(ImagemDao imagemDao) {
		this.imagemDao = imagemDao;
	}
	
	public Imagem getImagem() {
		return imagem;
	}
	
	public void setImagem(Long id) {
		this.imagem = imagemDao.findOne(id);
	}
}
