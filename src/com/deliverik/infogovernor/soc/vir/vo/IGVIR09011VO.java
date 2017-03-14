package com.deliverik.infogovernor.soc.vir.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.soc.vir.model.VIM05Info;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM05TB;

@SuppressWarnings("serial")
public class IGVIR09011VO extends BaseVO implements Serializable {

	protected List<CodeDetail> configItemList;
	
	protected List<VIM05Info> strategies;
	
	protected VIM05TB strategyEntity;

	public List<CodeDetail> getConfigItemList() {
		return configItemList;
	}

	public void setConfigItemList(List<CodeDetail> configItemList) {
		this.configItemList = configItemList;
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
}
