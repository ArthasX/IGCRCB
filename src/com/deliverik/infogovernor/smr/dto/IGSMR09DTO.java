package com.deliverik.infogovernor.smr.dto;

import java.io.Serializable;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.smr.form.IGSMR0901Form;
import com.deliverik.infogovernor.smr.form.IGSMR0902Form;
import com.deliverik.infogovernor.smr.form.IGSMR0903Form;

@SuppressWarnings("serial")
public class IGSMR09DTO extends BaseDTO implements Serializable{
	
	protected IGSMR0901Form igsmr0901Form;//季报表单
	
	protected IGSMR0902Form igsmr0902Form;//年报表单
	
	protected IGSMR0903Form igsmr0903Form;//信息项目科技分析表单
	
	protected String result;//交易笔数合计#交易金额合计
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public IGSMR0901Form getIgsmr0901Form() {
		return igsmr0901Form;
	}

	public void setIgsmr0901Form(IGSMR0901Form igsmr0901Form) {
		this.igsmr0901Form = igsmr0901Form;
	}

	public IGSMR0902Form getIgsmr0902Form() {
		return igsmr0902Form;
	}

	public void setIgsmr0902Form(IGSMR0902Form igsmr0902Form) {
		this.igsmr0902Form = igsmr0902Form;
	}

	public IGSMR0903Form getIgsmr0903Form() {
		return igsmr0903Form;
	}

	public void setIgsmr0903Form(IGSMR0903Form igsmr0903Form) {
		this.igsmr0903Form = igsmr0903Form;
	}

}
