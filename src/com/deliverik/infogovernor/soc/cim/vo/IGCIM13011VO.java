package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;
import com.deliverik.framework.soc.asset.model.Timer01Info;

public class IGCIM13011VO extends BaseVO implements Serializable{
	
	protected List<CicollecttaskInfo> timerTaskList;
	
	protected List<String> typeNames;
	
	private Timer01Info timer01TB;
	
	protected String xmlFlag;

	public String getXmlFlag() {
		return xmlFlag;
	}

	public void setXmlFlag(String xmlFlag) {
		this.xmlFlag = xmlFlag;
	}

	public List<String> getTypeNames() {
		return typeNames;
	}

	public void setTypeNames(List<String> typeNames) {
		this.typeNames = typeNames;
	}

	public List<CicollecttaskInfo> getTimerTaskList() {
		return timerTaskList;
	}

	public void setTimerTaskList(List<CicollecttaskInfo> timerTaskList) {
		this.timerTaskList = timerTaskList;
	}

	public void setTimer01TB(Timer01Info timer01TB) {
		this.timer01TB = timer01TB;
	}

	public Timer01Info getTimer01TB() {
		return timer01TB;
	}
	
}
