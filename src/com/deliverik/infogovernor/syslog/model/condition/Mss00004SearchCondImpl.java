/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

import java.util.List;

/**
  * 概述: 告警规则模板表检索条件实现
  * 功能描述: 告警规则模板表检索条件实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public class Mss00004SearchCondImpl implements
		Mss00004SearchCond {
	/** 规则模板id */
	protected Integer ruletempid;

	/** 设备类型 */
	protected String typeid;
	
	/** 规则条件 */
	protected Integer rulecondition;
	
	/** 模板状态 */
	protected Integer tempstate;
	
	/** 创建时间 */
	protected String createtime;
	
	/** 模板名称 */
	protected String ruletempname;
	
	protected String[] deleteId;
	
	/** 备注 */
	protected String tempdesc;
	
	/** 查询条件模板状态 */
	protected Integer tempstates;
	
	/** 模板id列表 */
	protected List<Integer> tempidList;
	
	/** 描述 */
	protected String summary;
	
	
	/**
	 * 规则模板id取得
	 */
	public Integer getRuletempid() {
		return ruletempid;
	}

	/**
	 * 规则模板id设定
	 */
	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}



	/**
	 * 设备类型取得
	 */
	public String getTypeid() {
		return typeid;
	}

	/**
	 * 设备类型设定
	 */
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	/**
	 * 规则条件取得
	 */
	public Integer getRulecondition() {
		return rulecondition;
	}

	/**
	 * 规则条件设定
	 */
	public void setRulecondition(Integer rulecondition) {
		this.rulecondition = rulecondition;
	}

	/**
	 * 模板状态取得
	 */
	public Integer getTempstate() {
		return tempstate;
	}

	/**
	 * 模板状态设定
	 */
	public void setTempstate(Integer tempstate) {
		this.tempstate = tempstate;
	}

	/**
	 * 创建时间取得
	 */
	public String getCreatetime() {
		return createtime;
	}

	/**
	 * 创建时间设定
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * 模板名称取得
	 */
	public String getRuletempname() {
		return ruletempname;
	}

	/**
	 * 模板名称设定
	 */
	public void setRuletempname(String ruletempname) {
		this.ruletempname = ruletempname;
	}

	/**
	 * deleteId取得
	 */
	public String[] getDeleteId() {
		return deleteId;
	}

	/**
	 * deleteId设定
	 */
	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}

	/**
	 * 描述取得
	 */
	public String getTempdesc() {
		return tempdesc;
	}

	/**
	 * 描述设定
	 */
	public void setTempdesc(String tempdesc) {
		this.tempdesc = tempdesc;
	}

	/**
	 * 查询条件模板状态取得
	 */
	public Integer getTempstates() {
		return tempstates;
	}

	/**
	 * 查询条件模板状态设定
	 */
	public void setTempstates(Integer tempstates) {
		this.tempstates = tempstates;
	}

	public List<Integer> getTempidList() {
		return tempidList;
	}

	public void setTempidList(List<Integer> tempidList) {
		this.tempidList = tempidList;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
}