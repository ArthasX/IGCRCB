package com.deliverik.infogovernor.rdp.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.rdp.model.ExcuteResultInfo;

@SuppressWarnings("serial")
public class IGRDP01021VO extends BaseVO implements Serializable{

	protected List<ExcuteResultInfo> results;
	
	protected String log;

	public List<ExcuteResultInfo> getResults() {
		return results;
	}

	public void setResults(List<ExcuteResultInfo> results) {
		this.results = results;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}
	
}
