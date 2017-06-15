/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.asset.model.condition.EiDomainDetailMaxVWSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 域CI查询画面FORM
 * 功能描述: 域CI查询画面FORM
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public class IGASM2013Form extends BaseForm implements EiDomainDetailMaxVWSearchCond{
	private static final long serialVersionUID = 1L;
	
	/** 域ID */
	protected String eiddid;
	
	/** 查询类型 */
	protected String typeId;
	
	protected String eilabel;
	
	/** 版本 */
	protected String eiddversion;
	
	protected String einame;
	
	protected String eiid;
	
	
	/**
	 * 域ID取得
	 * @return 域ID
	 */
	public String getEiddid() {
		return eiddid;
	}

	/**
	 * 域ID设定
	 * @param eiddid域ID
	 */
	public void setEiddid(String eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * 查询类型取得
	 * @return 查询类型
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * 查询类型设定
	 * @param typeId查询类型
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getEilabel() {
		return eilabel;
	}
	
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	public String getEiddversion() {
		return eiddversion;
	}

	public void setEiddversion(String eiddversion) {
		this.eiddversion = eiddversion;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}

	public String getEiid() {
		return eiid;
	}

	public void setEiid(String eiid) {
		this.eiid = eiid;
	}



	
}
