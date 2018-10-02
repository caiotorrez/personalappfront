
package com.personalapp.bean.professor.view;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.model.Professor;
import com.personalapp.repository.ProfessorDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ProfessorViewBean implements Serializable {
	
	private final ProfessorDao professorDao;
	private Professor professor;
	private ExternalContext externalContext;
	
	@Inject
	public ProfessorViewBean(ProfessorDao professorDao, ExternalContext externalContext) {
		this.professorDao = professorDao;
		this.externalContext = externalContext;
	}
	
	public void init(String username) throws IOException {
		if (username == null || username.trim().equals("")) {
			this.externalContext.redirect(this.externalContext.getApplicationContextPath());
		}
		this.professor = this.professorDao.findProfessorByUsername(username);
		if (this.professor == null) {
			this.externalContext.invalidateSession();
		}
	}
	
	public Professor getProfessor() {
		return this.professor;
	}

}
