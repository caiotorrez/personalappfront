package com.personalapp.bean.professor.view;

import java.io.Serializable;

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
	
	@Inject
	public ProfessorViewBean(ProfessorDao professorDao) {
		this.professorDao = professorDao;
	}
	
	public void init(String username) {
		this.professor = this.professorDao.findProfessorByUsername(username);
	}
	
	public Professor getProfessor() {
		return this.professor;
	}

}
