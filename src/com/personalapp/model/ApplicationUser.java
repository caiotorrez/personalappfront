package com.personalapp.model;


@SuppressWarnings("serial")
public class ApplicationUser extends AbstractEntity {
	
	private String username;
	private String password;
	private Professor professor;
	private Aluno Aluno;

	public ApplicationUser() {
		
	}
	
	public ApplicationUser(ApplicationUser applicationUser) {
		this.username = applicationUser.username;
		this.password = applicationUser.password;
		this.professor = applicationUser.professor;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Aluno getAluno() {
		return Aluno;
	}

	public void setAluno(Aluno aluno) {
		Aluno = aluno;
	}
}
