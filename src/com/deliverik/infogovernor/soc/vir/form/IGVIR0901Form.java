package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

public class IGVIR0901Form extends BaseForm {

	private static final long serialVersionUID = 1L;
	
	protected String[] values;
	
	protected String strategyName;
	
	protected String[] configItemCids;
	
	protected String strategyName_eq;
	
	protected String[] delids;
	
	protected Integer strid;

	public String[] getValues() {
		return values;
	}

	public void setValues(String[] values) {
		this.values = values;
	}

	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public String[] getConfigItemCids() {
		return configItemCids;
	}

	public void setConfigItemCids(String[] configItemCids) {
		this.configItemCids = configItemCids;
	}

	public String getStrategyName_eq() {
		return strategyName_eq;
	}

	public void setStrategyName_eq(String strategyName_eq) {
		this.strategyName_eq = strategyName_eq;
	}

	public String[] getDelids() {
		return delids;
	}

	public void setDelids(String[] delids) {
		this.delids = delids;
	}

	public Integer getStrid() {
		return strid;
	}

	public void setStrid(Integer strid) {
		this.strid = strid;
	}
	
}
