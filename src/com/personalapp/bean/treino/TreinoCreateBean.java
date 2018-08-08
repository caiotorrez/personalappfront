package com.personalapp.bean.treino;

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
import com.personalapp.model.treino.FichaDeTreino;
import com.personalapp.model.treino.InfoExercicio;
import com.personalapp.model.treino.RegiaoMuscular;
import com.personalapp.repository.AlunoDao;
import com.personalapp.repository.ExercicioDao;
import com.personalapp.repository.InfoExercicioDao;
import com.personalapp.repository.RegiaoDao;
import com.personalapp.repository.TreinoDao;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class TreinoCreateBean implements Serializable {
	
	private final TreinoDao treinoDao;
	private final AlunoDao alunoDao;
	private final ExercicioDao exercicioDao;
	private final RegiaoDao regiaoDao;
	private final InfoExercicioDao infoDao;
	private String email;
	private FichaDeTreino fichaDeTreino = new FichaDeTreino();
	private RegiaoMuscular regiaoA = new RegiaoMuscular();
	private RegiaoMuscular regiaoB = new RegiaoMuscular();
	private RegiaoMuscular regiaoC = new RegiaoMuscular();
	private RegiaoMuscular regiaoD = new RegiaoMuscular();
	private RegiaoMuscular regiaoE = new RegiaoMuscular();
	private InfoExercicio infoA1 = new InfoExercicio();
	private InfoExercicio infoA2 = new InfoExercicio();
	private InfoExercicio infoA3 = new InfoExercicio();
	private InfoExercicio infoA4 = new InfoExercicio();
	private InfoExercicio infoA5 = new InfoExercicio();
	private InfoExercicio infoA6 = new InfoExercicio();
	private InfoExercicio infoB1 = new InfoExercicio();
	private InfoExercicio infoB2 = new InfoExercicio();
	private InfoExercicio infoB3 = new InfoExercicio();
	private InfoExercicio infoB4 = new InfoExercicio();
	private InfoExercicio infoB5 = new InfoExercicio();
	private InfoExercicio infoB6 = new InfoExercicio();
	private InfoExercicio infoC1 = new InfoExercicio();
	private InfoExercicio infoC2 = new InfoExercicio();
	private InfoExercicio infoC3 = new InfoExercicio();
	private InfoExercicio infoC4 = new InfoExercicio();
	private InfoExercicio infoC5 = new InfoExercicio();
	private InfoExercicio infoC6 = new InfoExercicio();
	private InfoExercicio infoD1 = new InfoExercicio();
	private InfoExercicio infoD2 = new InfoExercicio();
	private InfoExercicio infoD3 = new InfoExercicio();
	private InfoExercicio infoD4 = new InfoExercicio();
	private InfoExercicio infoD5 = new InfoExercicio();
	private InfoExercicio infoD6 = new InfoExercicio();
	private InfoExercicio infoE1 = new InfoExercicio();
	private InfoExercicio infoE2 = new InfoExercicio();
	private InfoExercicio infoE3 = new InfoExercicio();
	private InfoExercicio infoE4 = new InfoExercicio();
	private InfoExercicio infoE5 = new InfoExercicio();
	private InfoExercicio infoE6 = new InfoExercicio();

	@Inject
	public TreinoCreateBean(TreinoDao treinoDao, AlunoDao alunoDao, ExercicioDao exercicioDao, RegiaoDao regiaoDao, InfoExercicioDao infoDao) {
		this.treinoDao = treinoDao;
		this.alunoDao = alunoDao;
		this.exercicioDao = exercicioDao;
		this.regiaoDao = regiaoDao;
		this.infoDao = infoDao;
	}
	
	@ExceptionHandler
	public String create() {
		this.build();
		if (this.email != null && !this.email.trim().equals("")) {
			Aluno aluno = this.alunoDao.findOne(this.email);
			aluno.setId(aluno.getId());
			this.fichaDeTreino.setNomeDoAlunoAssociado(aluno.getNome());
			FichaDeTreino ficha = this.treinoDao.save(this.fichaDeTreino);
			ficha.setId(ficha.getId());
			if (aluno.getFichaDeTreino() != null) {
				aluno.getHistorico().add(aluno.getFichaDeTreino());
			}
			aluno.setFichaDeTreino(ficha);
			this.alunoDao.update(aluno);
			Messages.create("O treino {0} foi criado com sucesso!", this.fichaDeTreino.getTitulo()).flash().add();
		}
		return "alunos.xhtml?faces-redirect=true";
	}
		
	
	private void build() {
		this.buildInfos();
		RegiaoMuscular R1 = this.regiaoDao.save(regiaoA);
		if (R1 != null) {
			R1.setId(R1.getId());
			this.fichaDeTreino.setTreinoA(R1);
		}
		RegiaoMuscular R2 = this.regiaoDao.save(regiaoB);
		if (R2 != null) {
			R2.setId(R2.getId());
			this.fichaDeTreino.setTreinoA(R2);
		}
		RegiaoMuscular R3 = this.regiaoDao.save(regiaoC);
		if (R3 != null) {
			R3.setId(R3.getId());
			this.fichaDeTreino.setTreinoA(R3);
		}
		RegiaoMuscular R4 = this.regiaoDao.save(regiaoD);
		if (R4 != null) {
			R4.setId(R4.getId());
			this.fichaDeTreino.setTreinoA(R4);
		}
		RegiaoMuscular R5 = this.regiaoDao.save(regiaoE);
		if (R5 != null) {
			R5.setId(R5.getId());
			this.fichaDeTreino.setTreinoA(R5);
		}		
	}
	
	public void buildInfos() {
		InfoExercicio a1 = infoDao.save(infoA1);
		if (a1 != null) {
			a1.setId(a1.getId());
			this.regiaoA.setInfo1(a1);
		}
		InfoExercicio a2 = infoDao.save(infoA2);
		if (a2 != null) {
			a2.setId(a2.getId());
			this.regiaoA.setInfo2(a2);
		}
		InfoExercicio a3 = infoDao.save(infoA3);
		if (a3 != null) {
			a3.setId(a3.getId());
			this.regiaoA.setInfo3(a3);
		}
		InfoExercicio a4 = infoDao.save(infoA4);
		if (a4 != null) {
			a4.setId(a4.getId());
			this.regiaoA.setInfo4(a4);
		}
		InfoExercicio a5 = infoDao.save(infoA5);
		if (a5 != null) {
			a2.setId(a5.getId());
			this.regiaoA.setInfo5(a5);
		}
		InfoExercicio a6 = infoDao.save(infoA6);
		if (a6 != null) {
			a6.setId(a6.getId());
			this.regiaoA.setInfo6(a6);
		}
		InfoExercicio b1 = infoDao.save(infoB1);
		if (b1 != null) {
			b1.setId(b1.getId());
			this.regiaoB.setInfo1(b1);
		}
		InfoExercicio b2 = infoDao.save(infoB2);
		if (b2 != null) {
			b2.setId(b2.getId());
			this.regiaoB.setInfo2(b2);
		}
		InfoExercicio b3 = infoDao.save(infoB3);
		if (b3 != null) {
			b3.setId(b3.getId());
			this.regiaoB.setInfo3(b3);
		}
		InfoExercicio b4 = infoDao.save(infoB4);
		if (b4 != null) {
			b4.setId(b4.getId());
			this.regiaoB.setInfo4(b4);
		}
		InfoExercicio b5 = infoDao.save(infoB5);
		if (b5 != null) {
			b5.setId(b5.getId());
			this.regiaoB.setInfo5(b5);
		}
		InfoExercicio b6 = infoDao.save(infoB6);
		if (b6 != null) {
			b6.setId(b6.getId());
			this.regiaoB.setInfo6(b6);
		}
		
		InfoExercicio c1 = infoDao.save(infoC1);
		if (c1 != null) {
			c1.setId(c1.getId());
			this.regiaoC.setInfo1(c1);
		}
		InfoExercicio c2 = infoDao.save(infoC2);
		if (c2 != null) {
			c2.setId(c2.getId());
			this.regiaoC.setInfo2(c2);
		}
		InfoExercicio c3 = infoDao.save(infoC3);
		if (c3 != null) {
			c3.setId(c3.getId());
			this.regiaoC.setInfo3(c3);
		}
		InfoExercicio c4 = infoDao.save(infoC4);
		if (c4 != null) {
			c4.setId(c4.getId());
			this.regiaoC.setInfo4(c4);
		}
		InfoExercicio c5 = infoDao.save(infoC5);
		if (c5 != null) {
			c5.setId(c5.getId());
			this.regiaoC.setInfo5(c5);
		}
		InfoExercicio c6 = infoDao.save(infoC6);
		if (c6 != null) {
			c6.setId(c6.getId());
			this.regiaoC.setInfo6(c6);
		}
		
		InfoExercicio d1 = infoDao.save(infoD1);
		if (d1 != null) {
			d1.setId(d1.getId());
			this.regiaoD.setInfo1(d1);
		}
		InfoExercicio d2 = infoDao.save(infoD2);
		if (d2 != null) {
			d2.setId(d2.getId());
			this.regiaoD.setInfo2(d2);
		}
		InfoExercicio d3 = infoDao.save(infoD3);
		if (d3 != null) {
			d3.setId(d3.getId());
			this.regiaoD.setInfo3(d3);
		}
		InfoExercicio d4 = infoDao.save(infoD4);
		if (d4 != null) {
			d4.setId(d4.getId());
			this.regiaoD.setInfo4(d4);
		}
		InfoExercicio d5 = infoDao.save(infoD5);
		if (d5 != null) {
			d5.setId(d5.getId());
			this.regiaoD.setInfo5(d5);
		}
		InfoExercicio d6 = infoDao.save(infoD6);
		if (d6 != null) {
			d1.setId(d6.getId());
			this.regiaoD.setInfo6(d6);
		}
		
		InfoExercicio e1 = infoDao.save(infoE1);
		if (e1 != null) {
			e1.setId(e1.getId());
			this.regiaoE.setInfo1(e1);
		}
		InfoExercicio e2 = infoDao.save(infoE2);
		if (e2 != null) {
			e2.setId(e2.getId());
			this.regiaoE.setInfo2(e2);
		}
		InfoExercicio e3 = infoDao.save(infoE3);
		if (e3 != null) {
			e3.setId(e3.getId());
			this.regiaoE.setInfo3(e3);
		}
		InfoExercicio e4 = infoDao.save(infoE4);
		if (e4 != null) {
			e4.setId(e4.getId());
			this.regiaoE.setInfo4(e4);
		}
		InfoExercicio e5 = infoDao.save(infoE5);
		if (e5 != null) {
			e5.setId(e5.getId());
			this.regiaoE.setInfo5(e5);
		}
		InfoExercicio e6 = infoDao.save(infoE6);
		if (e6 != null) {
			e6.setId(e6.getId());
			this.regiaoE.setInfo1(e6);
		}
	}

	public FichaDeTreino getFichaDeTreino() {
		return fichaDeTreino;
	}

	public void setFichaDeTreino(FichaDeTreino fichaDeTreino) {
		this.fichaDeTreino = fichaDeTreino;
	}
	
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setExeA1(String titulo) {
		this.regiaoA.setExcecicio1(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeA2(String titulo) {
		this.regiaoA.setExcecicio2(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeA3(String titulo) {
		this.regiaoA.setExcecicio3(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeA4(String titulo) {
		this.regiaoA.setExcecicio4(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeA5(String titulo) {
		this.regiaoA.setExcecicio5(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeA6(String titulo) {
		this.regiaoA.setExcecicio6(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeB1(String titulo) {
		this.regiaoB.setExcecicio1(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeB2(String titulo) {
		this.regiaoB.setExcecicio2(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeB3(String titulo) {
		this.regiaoB.setExcecicio3(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeB4(String titulo) {
		this.regiaoB.setExcecicio4(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeB5(String titulo) {
		this.regiaoB.setExcecicio5(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeB6(String titulo) {
		this.regiaoB.setExcecicio6(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeC1(String titulo) {
		this.regiaoC.setExcecicio1(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeC2(String titulo) {
		this.regiaoC.setExcecicio2(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeC3(String titulo) {
		this.regiaoC.setExcecicio3(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeC4(String titulo) {
		this.regiaoC.setExcecicio4(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeC5(String titulo) {
		this.regiaoC.setExcecicio5(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeC6(String titulo) {
		this.regiaoC.setExcecicio6(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeD1(String titulo) {
		this.regiaoD.setExcecicio1(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeD2(String titulo) {
		this.regiaoD.setExcecicio2(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeD3(String titulo) {
		this.regiaoD.setExcecicio3(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeD4(String titulo) {
		this.regiaoD.setExcecicio4(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeD5(String titulo) {
		this.regiaoD.setExcecicio5(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeD6(String titulo) {
		this.regiaoD.setExcecicio6(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeE1(String titulo) {
		this.regiaoE.setExcecicio1(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeE2(String titulo) {
		this.regiaoE.setExcecicio2(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeE3(String titulo) {
		this.regiaoE.setExcecicio3(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeE4(String titulo) {
		this.regiaoE.setExcecicio4(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeE5(String titulo) {
		this.regiaoE.setExcecicio5(this.exercicioDao.findOne(titulo));
	}
	
	public void setExeE6(String titulo) {
		this.regiaoE.setExcecicio6(this.exercicioDao.findOne(titulo));
	}
	
	public String getExeA1() {
		return null;
	}
	
	public String getExeA2() {
		return null;
	}
	
	public String getExeA3() {
		return null;
	}
	
	public String getExeA4() {
		return null;
	}
	
	public String getExeA5() {
		return null;
	}
	
	public String getExeA6() {
		return null;
	}
	
	public String getExeB1() {
		return null;
	}
	
	public String getExeB2() {
		return null;
	}
	
	public String getExeB3() {
		return null;
	}
	
	public String getExeB4() {
		return null;
	}
	
	public String getExeB5() {
		return null;
	}
	
	public String getExeB6() {
		return null;
	}
	
	public String getExeC1() {
		return null;
	}
	
	public String getExeC2() {
		return null;
	}
	
	public String getExeC3() {
		return null;
	}
	
	public String getExeC4() {
		return null;
	}
	
	public String getExeC5() {
		return null;
	}
	
	public String getExeC6() {
		return null;
	}
	
	public String getExeD1() {
		return null;
	}
	
	public String getExeD2() {
		return null;
	}
	
	public String getExeD3() {
		return null;
	}
	
	public String getExeD4() {
		return null;
	}
	
	public String getExeD5() {
		return null;
	}
	
	public String getExeD6() {
		return null;
	}
	
	public String getExeE1() {
		return null;
	}
	
	public String getExeE2() {
		return null;
	}
	
	public String getExeE3() {
		return null;
	}
	
	public String getExeE4() {
		return null;
	}
	
	public String getExeE5() {
		return null;
	}
	
	public String getExeE6() {
		return null;
	}

	public RegiaoMuscular getRegiaoA() {
		return regiaoA;
	}

	public void setRegiaoA(RegiaoMuscular regiaoA) {
		this.regiaoA = regiaoA;
	}

	public RegiaoMuscular getRegiaoB() {
		return regiaoB;
	}

	public void setRegiaoB(RegiaoMuscular regiaoB) {
		this.regiaoB = regiaoB;
	}

	public RegiaoMuscular getRegiaoC() {
		return regiaoC;
	}

	public void setRegiaoC(RegiaoMuscular regiaoC) {
		this.regiaoC = regiaoC;
	}

	public RegiaoMuscular getRegiaoD() {
		return regiaoD;
	}

	public void setRegiaoD(RegiaoMuscular regiaoD) {
		this.regiaoD = regiaoD;
	}

	public RegiaoMuscular getRegiaoE() {
		return regiaoE;
	}

	public void setRegiaoE(RegiaoMuscular regiaoE) {
		this.regiaoE = regiaoE;
	}

	public InfoExercicio getInfoA1() {
		return infoA1;
	}

	public void setInfoA1(InfoExercicio infoA1) {
		this.infoA1 = infoA1;
	}

	public InfoExercicio getInfoA2() {
		return infoA2;
	}

	public void setInfoA2(InfoExercicio infoA2) {
		this.infoA2 = infoA2;
	}

	public InfoExercicio getInfoA3() {
		return infoA3;
	}

	public void setInfoA3(InfoExercicio infoA3) {
		this.infoA3 = infoA3;
	}

	public InfoExercicio getInfoA4() {
		return infoA4;
	}

	public void setInfoA4(InfoExercicio infoA4) {
		this.infoA4 = infoA4;
	}

	public InfoExercicio getInfoA5() {
		return infoA5;
	}

	public void setInfoA5(InfoExercicio infoA5) {
		this.infoA5 = infoA5;
	}

	public InfoExercicio getInfoA6() {
		return infoA6;
	}

	public void setInfoA6(InfoExercicio infoA6) {
		this.infoA6 = infoA6;
	}

	public InfoExercicio getInfoB1() {
		return infoB1;
	}

	public void setInfoB1(InfoExercicio infoB1) {
		this.infoB1 = infoB1;
	}

	public InfoExercicio getInfoB2() {
		return infoB2;
	}

	public void setInfoB2(InfoExercicio infoB2) {
		this.infoB2 = infoB2;
	}

	public InfoExercicio getInfoB3() {
		return infoB3;
	}

	public void setInfoB3(InfoExercicio infoB3) {
		this.infoB3 = infoB3;
	}

	public InfoExercicio getInfoB4() {
		return infoB4;
	}

	public void setInfoB4(InfoExercicio infoB4) {
		this.infoB4 = infoB4;
	}

	public InfoExercicio getInfoB5() {
		return infoB5;
	}

	public void setInfoB5(InfoExercicio infoB5) {
		this.infoB5 = infoB5;
	}

	public InfoExercicio getInfoB6() {
		return infoB6;
	}

	public void setInfoB6(InfoExercicio infoB6) {
		this.infoB6 = infoB6;
	}

	public InfoExercicio getInfoC1() {
		return infoC1;
	}

	public void setInfoC1(InfoExercicio infoC1) {
		this.infoC1 = infoC1;
	}

	public InfoExercicio getInfoC2() {
		return infoC2;
	}

	public void setInfoC2(InfoExercicio infoC2) {
		this.infoC2 = infoC2;
	}

	public InfoExercicio getInfoC3() {
		return infoC3;
	}

	public void setInfoC3(InfoExercicio infoC3) {
		this.infoC3 = infoC3;
	}

	public InfoExercicio getInfoC4() {
		return infoC4;
	}

	public void setInfoC4(InfoExercicio infoC4) {
		this.infoC4 = infoC4;
	}

	public InfoExercicio getInfoC5() {
		return infoC5;
	}

	public void setInfoC5(InfoExercicio infoC5) {
		this.infoC5 = infoC5;
	}

	public InfoExercicio getInfoC6() {
		return infoC6;
	}

	public void setInfoC6(InfoExercicio infoC6) {
		this.infoC6 = infoC6;
	}

	public InfoExercicio getInfoD1() {
		return infoD1;
	}

	public void setInfoD1(InfoExercicio infoD1) {
		this.infoD1 = infoD1;
	}

	public InfoExercicio getInfoD2() {
		return infoD2;
	}

	public void setInfoD2(InfoExercicio infoD2) {
		this.infoD2 = infoD2;
	}

	public InfoExercicio getInfoD3() {
		return infoD3;
	}

	public void setInfoD3(InfoExercicio infoD3) {
		this.infoD3 = infoD3;
	}

	public InfoExercicio getInfoD4() {
		return infoD4;
	}

	public void setInfoD4(InfoExercicio infoD4) {
		this.infoD4 = infoD4;
	}

	public InfoExercicio getInfoD5() {
		return infoD5;
	}

	public void setInfoD5(InfoExercicio infoD5) {
		this.infoD5 = infoD5;
	}

	public InfoExercicio getInfoD6() {
		return infoD6;
	}

	public void setInfoD6(InfoExercicio infoD6) {
		this.infoD6 = infoD6;
	}

	public InfoExercicio getInfoE1() {
		return infoE1;
	}

	public void setInfoE1(InfoExercicio infoE1) {
		this.infoE1 = infoE1;
	}

	public InfoExercicio getInfoE2() {
		return infoE2;
	}

	public void setInfoE2(InfoExercicio infoE2) {
		this.infoE2 = infoE2;
	}

	public InfoExercicio getInfoE3() {
		return infoE3;
	}

	public void setInfoE3(InfoExercicio infoE3) {
		this.infoE3 = infoE3;
	}

	public InfoExercicio getInfoE4() {
		return infoE4;
	}

	public void setInfoE4(InfoExercicio infoE4) {
		this.infoE4 = infoE4;
	}

	public InfoExercicio getInfoE5() {
		return infoE5;
	}

	public void setInfoE5(InfoExercicio infoE5) {
		this.infoE5 = infoE5;
	}

	public InfoExercicio getInfoE6() {
		return infoE6;
	}

	public void setInfoE6(InfoExercicio infoE6) {
		this.infoE6 = infoE6;
	}
}