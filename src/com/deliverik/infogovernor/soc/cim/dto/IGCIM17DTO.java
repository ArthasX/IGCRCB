package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.SOC0153Info;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1701Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1702Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1703Form;

/**
 * 人员配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCIM17DTO extends BaseDTO implements Serializable{

	
	private IGCIM1701Form igcim1701Form;
	private IGCIM1702Form igcim1702Form;
	private IGCIM1703Form igcim1703Form;
	private List<SOC0113Info> soc0113List;
	private String formName;
	private List<SOC0153Info> soc0153List;
	private SOC0153Info soc0153Info;

	/** 检索最大件数 */
	protected int maxSearchCount;
	/** 翻页用DTO */
	protected PagingDTO pagingDto;
	
	private String warnType;
	
	private String esyscoding;
	
	
	public String getFormName() {
		return formName;
	}
	public void setFormName(String formName) {
		this.formName = formName;
	}
	public String getWarnType() {
		return warnType;
	}
	public void setWarnType(String warnType) {
		this.warnType = warnType;
	}
	public int getMaxSearchCount() {
		return maxSearchCount;
	}
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	public IGCIM1701Form getIgcim1701Form() {
		return igcim1701Form;
	}
	public void setIgcim1701Form(IGCIM1701Form igcim1701Form) {
		this.igcim1701Form = igcim1701Form;
	}
	public List<SOC0153Info> getSoc0153List() {
		return soc0153List;
	}
	public void setSoc0153List(List<SOC0153Info> soc0153List) {
		this.soc0153List = soc0153List;
	}
	public SOC0153Info getSoc0153Info() {
		return soc0153Info;
	}
	public void setSoc0153Info(SOC0153Info soc0153Info) {
		this.soc0153Info = soc0153Info;
	}
	public IGCIM1702Form getIgcim1702Form() {
		return igcim1702Form;
	}
	public void setIgcim1702Form(IGCIM1702Form igcim1702Form) {
		this.igcim1702Form = igcim1702Form;
	}
	public IGCIM1703Form getIgcim1703Form() {
		return igcim1703Form;
	}
	public void setIgcim1703Form(IGCIM1703Form igcim1703Form) {
		this.igcim1703Form = igcim1703Form;
	}
	public List<SOC0113Info> getSoc0113List() {
		return soc0113List;
	}
	public void setSoc0113List(List<SOC0113Info> soc0113List) {
		this.soc0113List = soc0113List;
	}
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	
	
	
	
}


