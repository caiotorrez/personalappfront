package bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.personalapp.repository.LoginDao;
import com.personalapp.repository.ProfessorDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class IndexBean implements Serializable {
	
	private final LoginDao loginDao;
	private final ProfessorDao professorDao;
	private String message = "Seja Bem Vindo ";
	
	@Inject
	public IndexBean(LoginDao loginDao, ProfessorDao professorDao) {
		this.loginDao = loginDao;
		this.professorDao = professorDao;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void getProfessor() {
		this.professorDao.getProfessorById(1L);
	}
	


}
