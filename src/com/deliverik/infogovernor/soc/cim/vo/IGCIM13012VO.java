package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.Timer02Info;

import java.util.*;

public class IGCIM13012VO extends BaseVO implements Serializable{
	
	protected List<Timer02Info> historyList;

	public List<Timer02Info> getHistoryList() {
		return historyList;
	}

	public void setHistoryList(List<Timer02Info> historyList) {
		this.historyList = historyList;
	}
	
}
