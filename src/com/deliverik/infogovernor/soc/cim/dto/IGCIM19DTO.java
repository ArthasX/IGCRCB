package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0809Form;

public class IGCIM19DTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private IGCIM0809Form igcim0809Form;
	public IGCIM0809Form getIgcim0809Form() {
		return igcim0809Form;
	}
	public void setIgcim0809Form(IGCIM0809Form igcim0809Form) {
		this.igcim0809Form = igcim0809Form;
	}
}
