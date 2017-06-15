package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2001Form;

public class IGCIM20011VO extends BaseVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public IGCIM20011VO(){
		
	}
	public IGCIM20011VO(IGCIM2001Form igcim2001Form){
		this.igcim2001Form = igcim2001Form;
	}
	
	private IGCIM2001Form igcim2001Form;

	public IGCIM2001Form getIgcim2001Form() {
		return igcim2001Form;
	}

	public void setIgcim2001Form(IGCIM2001Form igcim2001Form) {
		this.igcim2001Form = igcim2001Form;
	}
	
	

}
