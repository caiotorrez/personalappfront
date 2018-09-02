package com.personalapp.bean.user.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.personalapp.model.treino.FichaDeTreino;
import com.personalapp.model.treino.InfoExercicio;

@SuppressWarnings("serial")
public class GeradorDeInfosImpressao implements Serializable {
	
	public GeradorDeInfosImpressao() {
	}
	
	public List<InfoExercicio> buildListInfosA(FichaDeTreino ficha) {
		List<InfoExercicio> infos = new ArrayList<>();
		if (ficha != null) {
			if(ficha.getTreinoA().getInfo1() != null) {
				infos.add(ficha.getTreinoA().getInfo1());				
			}
			if(ficha.getTreinoA().getInfo2() != null) {
				infos.add(ficha.getTreinoA().getInfo2());				
			}
			if(ficha.getTreinoA().getInfo3() != null) {
				infos.add(ficha.getTreinoA().getInfo3());				
			}
			if(ficha.getTreinoA().getInfo4() != null) {
				infos.add(ficha.getTreinoA().getInfo4());				
			}
			if(ficha.getTreinoA().getInfo5() != null) {
				infos.add(ficha.getTreinoA().getInfo5());				
			}
			if(ficha.getTreinoA().getInfo6() != null) {
				infos.add(ficha.getTreinoA().getInfo6());				
			}
		}
		return infos;
	}
	
	public List<InfoExercicio> buildListInfosB(FichaDeTreino ficha) {
		List<InfoExercicio> infos = new ArrayList<>();
		if (ficha != null) {
			if(ficha.getTreinoB().getInfo1() != null) {
				infos.add(ficha.getTreinoB().getInfo1());				
			}
			if(ficha.getTreinoB().getInfo2() != null) {
				infos.add(ficha.getTreinoB().getInfo2());				
			}
			if(ficha.getTreinoB().getInfo3() != null) {
				infos.add(ficha.getTreinoB().getInfo3());				
			}
			if(ficha.getTreinoB().getInfo4() != null) {
				infos.add(ficha.getTreinoB().getInfo4());				
			}
			if(ficha.getTreinoB().getInfo5() != null) {
				infos.add(ficha.getTreinoB().getInfo5());				
			}
			if(ficha.getTreinoB().getInfo6() != null) {
				infos.add(ficha.getTreinoB().getInfo6());				
			}
		}
		return infos;
	}
	
	public List<InfoExercicio> buildListInfosC(FichaDeTreino ficha) {
		List<InfoExercicio> infos = new ArrayList<>();
		if (ficha != null) {
			if(ficha.getTreinoC().getInfo1() != null) {
				infos.add(ficha.getTreinoC().getInfo1());				
			}
			if(ficha.getTreinoC().getInfo2() != null) {
				infos.add(ficha.getTreinoC().getInfo2());				
			}
			if(ficha.getTreinoC().getInfo3() != null) {
				infos.add(ficha.getTreinoC().getInfo3());				
			}
			if(ficha.getTreinoC().getInfo4() != null) {
				infos.add(ficha.getTreinoC().getInfo4());				
			}
			if(ficha.getTreinoC().getInfo5() != null) {
				infos.add(ficha.getTreinoC().getInfo5());				
			}
			if(ficha.getTreinoC().getInfo6() != null) {
				infos.add(ficha.getTreinoC().getInfo6());				
			}
		}
		return infos;
	}
	
	public List<InfoExercicio> buildListInfosD(FichaDeTreino ficha) {
		List<InfoExercicio> infos = new ArrayList<>();
		if (ficha != null) {
			if(ficha.getTreinoD().getInfo1() != null) {
				infos.add(ficha.getTreinoD().getInfo1());				
			}
			if(ficha.getTreinoD().getInfo2() != null) {
				infos.add(ficha.getTreinoD().getInfo2());				
			}
			if(ficha.getTreinoD().getInfo3() != null) {
				infos.add(ficha.getTreinoD().getInfo3());				
			}
			if(ficha.getTreinoD().getInfo4() != null) {
				infos.add(ficha.getTreinoD().getInfo4());				
			}
			if(ficha.getTreinoD().getInfo5() != null) {
				infos.add(ficha.getTreinoD().getInfo5());				
			}
			if(ficha.getTreinoD().getInfo6() != null) {
				infos.add(ficha.getTreinoD().getInfo6());				
			}
		}
		return infos;
	}
	
	public List<InfoExercicio> buildListInfosE(FichaDeTreino ficha) {
		List<InfoExercicio> infos = new ArrayList<>();
		if (ficha != null) {
			if(ficha.getTreinoE().getInfo1() != null) {
				infos.add(ficha.getTreinoE().getInfo1());				
			}
			if(ficha.getTreinoE().getInfo2() != null) {
				infos.add(ficha.getTreinoE().getInfo2());				
			}
			if(ficha.getTreinoE().getInfo3() != null) {
				infos.add(ficha.getTreinoE().getInfo3());				
			}
			if(ficha.getTreinoE().getInfo4() != null) {
				infos.add(ficha.getTreinoE().getInfo4());				
			}
			if(ficha.getTreinoE().getInfo5() != null) {
				infos.add(ficha.getTreinoE().getInfo5());				
			}
			if(ficha.getTreinoE().getInfo6() != null) {
				infos.add(ficha.getTreinoE().getInfo6());				
			}
		}
		return infos;
	}
	

}
