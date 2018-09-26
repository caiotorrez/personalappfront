package com.personalapp.bean.treino;

import java.io.Serializable;

import com.personalapp.model.treino.InfoExercicio;

@SuppressWarnings("serial")
public class SuportCreateBean implements Serializable {
	
	public static InfoExercicio buildInfoSuport(InfoExercicio info) {
		if (info != null) {
			if (info.getId() == null) {
				info.setId(info.getId());
			}
			return info;
		}
		return null;
	}
}
