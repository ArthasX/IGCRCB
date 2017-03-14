package com.deliverik.infogovernor.syslog.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.Mss00003Info;

@SuppressWarnings("serial")
public class IGLOG0022VO extends BaseVO implements Serializable{
	
	/** 自定义规则模板列表 */
	protected List<Mss00003Info> myTempList;
	
	protected Mss00001Info mss00001TB;
	
	protected String priority;
	
	protected String couldReturn;
	
	protected String alarmmsg;
	
	
	public String getAlarmmsg() {
		return alarmmsg;
	}

	public void setAlarmmsg(String alarmmsg) {
		this.alarmmsg = alarmmsg;
	}

	public String getCouldReturn() {
		return couldReturn;
	}

	public void setCouldReturn(String couldReturn) {
		this.couldReturn = couldReturn;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	public Mss00001Info getMss00001TB() {
		return mss00001TB;
	}

	public void setMss00001TB(Mss00001Info mss00001TB) {
		this.mss00001TB = mss00001TB;
	}

	/**
	 * 自定义规则模板列表取得
	 */
	public List<Mss00003Info> getMyTempList() {
		return myTempList;
	}

	/**
	 * 自定义规则模板列表设定
	 */
	public void setMyTempList(List<Mss00003Info> myTempList) {
		this.myTempList = myTempList;
	}

}
