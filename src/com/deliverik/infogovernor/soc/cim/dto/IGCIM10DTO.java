package com.deliverik.infogovernor.soc.cim.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0437Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0437SearchCond;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1001Form;


/**
 * 表空间伐值设定业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGCIM10DTO extends BaseDTO implements Serializable{
	
	/** 表空间伐值设定信息 */
	protected IGCIM1001Form igcim1001Form;
	
	protected SOC0437SearchCond soc0437SearchCond;
	
	protected SOC0118SearchCond soc0118SearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;
	
	protected List<SOC0437Info> soc0437InfoList;
	
	protected List<SOC0118Info> soc0118InfoList;
	
	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	public IGCIM1001Form getIgcim1001Form() {
		return igcim1001Form;
	}

	public void setIgcim1001Form(IGCIM1001Form igcim1001Form) {
		this.igcim1001Form = igcim1001Form;
	}

	public SOC0437SearchCond getSoc0437SearchCond() {
		return soc0437SearchCond;
	}

	public void setSoc0437SearchCond(SOC0437SearchCond soc0437SearchCond) {
		this.soc0437SearchCond = soc0437SearchCond;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public List<SOC0437Info> getSoc0437InfoList() {
		return soc0437InfoList;
	}

	public void setSoc0437InfoList(List<SOC0437Info> soc0437InfoList) {
		this.soc0437InfoList = soc0437InfoList;
	}

	public SOC0118SearchCond getSoc0118SearchCond() {
		return soc0118SearchCond;
	}

	public void setSoc0118SearchCond(SOC0118SearchCond soc0118SearchCond) {
		this.soc0118SearchCond = soc0118SearchCond;
	}

	public List<SOC0118Info> getSoc0118InfoList() {
		return soc0118InfoList;
	}

	public void setSoc0118InfoList(List<SOC0118Info> soc0118InfoList) {
		this.soc0118InfoList = soc0118InfoList;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
}
