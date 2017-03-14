package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0901Form;
import com.deliverik.infogovernor.soc.vir.model.VIM05Info;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM05TB;

@SuppressWarnings("serial")
public class IGVIR09DTO extends BaseDTO implements Serializable {
	
	protected IGVIR0901Form igvir0901Form;
	
	protected List<CodeDetail> configItemList;
	
	protected PagingDTO pagingDto;
	
	protected int maxSearchCount;
	
	protected List<VIM05Info> strategies;
	
	protected VIM05TB strategyEntity;
	
	protected String strategyName_eq;

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public List<CodeDetail> getConfigItemList() {
		return configItemList;
	}

	public void setConfigItemList(List<CodeDetail> configItemList) {
		this.configItemList = configItemList;
	}

	public IGVIR0901Form getIgvir0901Form() {
		return igvir0901Form;
	}

	public void setIgvir0901Form(IGVIR0901Form igvir0901Form) {
		this.igvir0901Form = igvir0901Form;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public List<VIM05Info> getStrategies() {
		return strategies;
	}

	public void setStrategies(List<VIM05Info> strategies) {
		this.strategies = strategies;
	}

	public VIM05TB getStrategyEntity() {
		return strategyEntity;
	}

	public void setStrategyEntity(VIM05TB strategyEntity) {
		this.strategyEntity = strategyEntity;
	}

	public String getStrategyName_eq() {
		return strategyName_eq;
	}

	public void setStrategyName_eq(String strategyName_eq) {
		this.strategyName_eq = strategyName_eq;
	}

}
