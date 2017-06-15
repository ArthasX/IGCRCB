/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 资产域明细表检索条件实现
  * 功能描述: 资产域明细表检索条件实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class EiDomainDetailSearchCondImpl implements
		EiDomainDetailSearchCond {
	/**资产域ID**/
	private Integer eiddid;
	/**资产域版本**/
	private Integer eiddversion;
	
	/** 逻辑删除标识 */
	protected String deleteflag;
	
	/**获取资产域ID**/
	public Integer getEiddid() {
		return eiddid;
	}
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}
	/**获取资产域版本**/
	public Integer getEiddversion() {
		return eiddversion;
	}
	public void setEiddversion(Integer eiddversion) {
		this.eiddversion = eiddversion;
	}
	public String getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

}