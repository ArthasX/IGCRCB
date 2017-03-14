/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 风险事件检索条件实现
  * 功能描述: 风险事件检索条件实现
  * 创建记录: 2014/07/18
  * 修改记录: 
  */
public class RiskcaseVWSearchCondImpl implements
		RiskcaseVWSearchCond {
	/** 资产ID */
	protected Integer eiid;
	
	/** 资产版本 */
	protected String version;
	
	/** 风险事件描述 */
	protected String fcname;
	
	/** 风险事件来源 */
	protected String fcorigin;
	
	/** 风险事件所属领域 */
	protected String fccategory;
	
	/** 风险识别时间从 */
	protected String riskcatchtime_from;
	
	/** 风险识别时间到 */
	protected String riskcatchtime_to;
	
	/** 风险点ID */
	protected String riskid;
	
	/** 应对策略 */
	protected String fcpolicy;
	
	/** 评审结果 */
	protected String riskreviewresult;
	
	/** 风险事件状态 */
	protected String EISTATUS;

	public String getFcorigin() {
		return fcorigin;
	}

	public void setFcorigin(String fcorigin) {
		this.fcorigin = fcorigin;
	}

	public String getFccategory() {
		return fccategory;
	}

	public void setFccategory(String fccategory) {
		this.fccategory = fccategory;
	}

	public String getRiskcatchtime_from() {
		return riskcatchtime_from;
	}

	public void setRiskcatchtime_from(String riskcatchtime_from) {
		this.riskcatchtime_from = riskcatchtime_from;
	}

	public String getRiskcatchtime_to() {
		return riskcatchtime_to;
	}

	public void setRiskcatchtime_to(String riskcatchtime_to) {
		this.riskcatchtime_to = riskcatchtime_to;
	}

	public String getRiskid() {
		return riskid;
	}

	public void setRiskid(String riskid) {
		this.riskid = riskid;
	}

	public String getFcpolicy() {
		return fcpolicy;
	}

	public void setFcpolicy(String fcpolicy) {
		this.fcpolicy = fcpolicy;
	}

	public String getRiskreviewresult() {
		return riskreviewresult;
	}

	public void setRiskreviewresult(String riskreviewresult) {
		this.riskreviewresult = riskreviewresult;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	public String getFcname() {
		return fcname;
	}

	public void setFcname(String fcname) {
		this.fcname = fcname;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 风险事件状态取得
	 *
	 * @return 风险事件状态
	 */
	public String getEISTATUS() {
		return EISTATUS;
	}

	/**
	 * 风险事件状态设定
	 *
	 * @param EISTATUS 风险事件状态
	 */
	public void setEISTATUS(String EISTATUS) {
		this.EISTATUS = EISTATUS;
	}
}