package com.personalapp.bean.aluno;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.primefaces.event.SelectEvent;

import com.personalapp.config.ExceptionHandler;
import com.personalapp.model.Aluno;
import com.personalapp.repository.AlunoDao;


@SuppressWarnings("serial")
@Named
@ViewScoped
public class AlunoCreateBean implements Serializable {
	
	private final AlunoDao alunoDao;
	private Aluno aluno = new Aluno();
	
	@Inject
	public AlunoCreateBean(AlunoDao alunoDao) {
		this.alunoDao = alunoDao;
	}

	@ExceptionHandler
	public String create() {
		if (this.alunoDao.findOne(this.aluno.getEmail()) == null) {
			this.alunoDao.save(this.aluno);
			Messages.create("O Aluno {0} foi adcionado com sucesso!", this.aluno.getNome()).flash().add();
			return "alunos.xhtml?faces-redirect=true";
		} else {
			Messages.create("O email {0} ja está em uso.", this.aluno.getEmail()).error().fatal().flash().add();
		} return null;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
}
