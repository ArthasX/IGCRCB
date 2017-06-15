/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

import java.util.List;

/**
  * 概述: CRM08检索条件实现
  * 功能描述: CRM08检索条件实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public class CRM08SearchCondImpl implements
		CRM08SearchCond {
		/** 模板名称 */
	protected String ruletempname;
	
	/** 模板状态 */
	protected Integer tempstate;
	
	/** 模板类型ccid */
	protected String typeccid_eq;
	
	/** 模板类型cid */
	protected String typecid_eq;
	
	protected List<Integer> ruletempids;


	public List<Integer> getRuletempids() {
		return ruletempids;
	}

	public void setRuletempids(List<Integer> ruletempids) {
		this.ruletempids = ruletempids;
	}
	
	public String getRuletempname() {
		return ruletempname;
	}

	public void setRuletempname(String ruletempname) {
		this.ruletempname = ruletempname;
	}

	public Integer getTempstate() {
		return tempstate;
	}

	public void setTempstate(Integer tempstate) {
		this.tempstate = tempstate;
	}

	public String getTypeccid_eq() {
		return typeccid_eq;
	}

	public void setTypeccid_eq(String typeccid_eq) {
		this.typeccid_eq = typeccid_eq;
	}

	public String getTypecid_eq() {
		return typecid_eq;
	}

	public void setTypecid_eq(String typecid_eq) {
		this.typecid_eq = typecid_eq;
	}

}