package com.personalapp.bean.user.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.personalapp.model.treino.Exercicio;
import com.personalapp.model.treino.FichaDeTreino;


@SuppressWarnings("serial")
public class GeradorDeListasImpressao implements Serializable {
	
	
	public GeradorDeListasImpressao() {
	}
	
	public List<Exercicio> buildListExerciciosA(FichaDeTreino ficha) {
		List<Exercicio> exerciciosA = new ArrayList<>();
		if (ficha != null) {
			if (ficha.getTreinoA().getExcecicio1() != null) {
				exerciciosA.add(ficha.getTreinoA().getExcecicio1());				
			}
			if (ficha.getTreinoA().getExcecicio2() != null) {
				exerciciosA.add(ficha.getTreinoA().getExcecicio2());
			}
			if (ficha.getTreinoA().getExcecicio3() != null) {
				exerciciosA.add(ficha.getTreinoA().getExcecicio3());
			}
			if (ficha.getTreinoA().getExcecicio4() != null) {
				exerciciosA.add(ficha.getTreinoA().getExcecicio4());				
			}
			if (ficha.getTreinoA().getExcecicio5() != null) {
				exerciciosA.add(ficha.getTreinoA().getExcecicio5());				
			}
			if (ficha.getTreinoA().getExcecicio6() != null) {
				exerciciosA.add(ficha.getTreinoA().getExcecicio6());				
			}
		}
		return exerciciosA;
	}
	
	public List<Exercicio> buildListExerciciosB(FichaDeTreino ficha) {
		List<Exercicio> exerciciosB = new ArrayList<>();
		if (ficha != null) {
			if (ficha.getTreinoB().getExcecicio1() != null) {
				exerciciosB.add(ficha.getTreinoB().getExcecicio1());				
			}
			if (ficha.getTreinoB().getExcecicio2() != null) {
				exerciciosB.add(ficha.getTreinoB().getExcecicio2());
			}
			if (ficha.getTreinoB().getExcecicio3() != null) {
				exerciciosB.add(ficha.getTreinoB().getExcecicio3());
			}
			if (ficha.getTreinoB().getExcecicio4() != null) {
				exerciciosB.add(ficha.getTreinoB().getExcecicio4());				
			}
			if (ficha.getTreinoB().getExcecicio5() != null) {
				exerciciosB.add(ficha.getTreinoB().getExcecicio5());				
			}
			if (ficha.getTreinoB().getExcecicio6() != null) {
				exerciciosB.add(ficha.getTreinoB().getExcecicio6());				
			}
		}
		return exerciciosB;
	}
	
	public List<Exercicio> buildListExerciciosC(FichaDeTreino ficha) {
		List<Exercicio> exercicio = new ArrayList<>();
		if (ficha != null) {
			if (ficha.getTreinoC().getExcecicio1() != null) {
				exercicio.add(ficha.getTreinoC().getExcecicio1());				
			}
			if (ficha.getTreinoC().getExcecicio2() != null) {
				exercicio.add(ficha.getTreinoC().getExcecicio2());
			}
			if (ficha.getTreinoC().getExcecicio3() != null) {
				exercicio.add(ficha.getTreinoC().getExcecicio3());
			}
			if (ficha.getTreinoC().getExcecicio4() != null) {
				exercicio.add(ficha.getTreinoC().getExcecicio4());				
			}
			if (ficha.getTreinoC().getExcecicio5() != null) {
				exercicio.add(ficha.getTreinoC().getExcecicio5());				
			}
			if (ficha.getTreinoC().getExcecicio6() != null) {
				exercicio.add(ficha.getTreinoC().getExcecicio6());				
			}
		}
		return exercicio;
	}
	
	public List<Exercicio> buildListExerciciosD(FichaDeTreino ficha) {
		List<Exercicio> exercicio = new ArrayList<>();
		if (ficha != null) {
			if (ficha.getTreinoD().getExcecicio1() != null) {
				exercicio.add(ficha.getTreinoD().getExcecicio1());				
			}
			if (ficha.getTreinoD().getExcecicio2() != null) {
				exercicio.add(ficha.getTreinoD().getExcecicio2());
			}
			if (ficha.getTreinoD().getExcecicio3() != null) {
				exercicio.add(ficha.getTreinoD().getExcecicio3());
			}
			if (ficha.getTreinoD().getExcecicio4() != null) {
				exercicio.add(ficha.getTreinoD().getExcecicio4());				
			}
			if (ficha.getTreinoD().getExcecicio5() != null) {
				exercicio.add(ficha.getTreinoD().getExcecicio5());				
			}
			if (ficha.getTreinoD().getExcecicio6() != null) {
				exercicio.add(ficha.getTreinoD().getExcecicio6());				
			}
		}
		return exercicio;
	}
	
	public List<Exercicio> buildListExerciciosE(FichaDeTreino ficha) {
		List<Exercicio> exercicios = new ArrayList<>();
		if (ficha != null) {
			if (ficha.getTreinoE().getExcecicio1() != null) {
				exercicios.add(ficha.getTreinoE().getExcecicio1());				
			}
			if (ficha.getTreinoE().getExcecicio2() != null) {
				exercicios.add(ficha.getTreinoE().getExcecicio2());
			}
			if (ficha.getTreinoE().getExcecicio3() != null) {
				exercicios.add(ficha.getTreinoE().getExcecicio3());
			}
			if (ficha.getTreinoE().getExcecicio4() != null) {
				exercicios.add(ficha.getTreinoE().getExcecicio4());				
			}
			if (ficha.getTreinoE().getExcecicio5() != null) {
				exercicios.add(ficha.getTreinoE().getExcecicio5());				
			}
			if (ficha.getTreinoE().getExcecicio6() != null) {
				exercicios.add(ficha.getTreinoE().getExcecicio6());				
			}
		}
		return exercicios;
	}

}
