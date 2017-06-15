package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.infogovernor.asset.form.IGASM3201Form;
import com.deliverik.infogovernor.asset.form.IGASM3202Form;
import com.deliverik.infogovernor.asset.model.RiskcaseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskcaseVWSearchCondImpl;


/**
 * 文档配置管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM32DTO extends BaseDTO implements Serializable{

	protected IGASM3201Form igasm3201Form;
	
	protected IGASM3202Form igasm3202Form;
	
	protected SOC0118TB entityItem;
	
	protected SOC0118Info entityInfo;
	
	protected Integer eiid;
	
	/** 风险事件应对策略历史记录 */
	protected String riskPolicy;
	
	protected List<RiskcaseVWInfo> riskcaseVWList;
	
	protected RiskcaseVWSearchCondImpl RiskcaseVWSearchCond;
	
	/** 检索最大件数 */
	protected int maxSearchCount;

	/** 翻页用DTO */
	protected PagingDTO pagingDto;

	public IGASM3202Form getIgasm3202Form() {
		return igasm3202Form;
	}

	public void setIgasm3202Form(IGASM3202Form igasm3202Form) {
		this.igasm3202Form = igasm3202Form;
	}

	public SOC0118TB getEntityItem() {
		return entityItem;
	}

	public void setEntityItem(SOC0118TB entityItem) {
		this.entityItem = entityItem;
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

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public IGASM3201Form getIgasm3201Form() {
		return igasm3201Form;
	}

	public void setIgasm3201Form(IGASM3201Form igasm3201Form) {
		this.igasm3201Form = igasm3201Form;
	}

	public List<RiskcaseVWInfo> getRiskcaseVWList() {
		return riskcaseVWList;
	}

	public void setRiskcaseVWList(List<RiskcaseVWInfo> riskcaseVWList) {
		this.riskcaseVWList = riskcaseVWList;
	}

	public RiskcaseVWSearchCondImpl getRiskcaseVWSearchCond() {
		return RiskcaseVWSearchCond;
	}

	public void setRiskcaseVWSearchCond(
			RiskcaseVWSearchCondImpl riskcaseVWSearchCond) {
		RiskcaseVWSearchCond = riskcaseVWSearchCond;
	}

	public String getRiskPolicy() {
		return riskPolicy;
	}

	public void setRiskPolicy(String riskPolicy) {
		this.riskPolicy = riskPolicy;
	}

	public SOC0118Info getEntityInfo() {
		return entityInfo;
	}

	public void setEntityInfo(SOC0118Info entityInfo) {
		this.entityInfo = entityInfo;
	}

}


