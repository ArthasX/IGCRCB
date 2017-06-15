/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

/**
 * 
 * 资产相关流程查询接口实现
 *
 */
public class SOC0600SearchCondImpl implements SOC0600SearchCond {
	
	/** 资产id*/
	protected String eiid;
	
	/** 流程类型集合*/
	protected List<String> prpdid_in;
	
	/** 流程类型*/
	protected String prpdid_eq;

	/**
	 * 资产id设定
	 * @param eiid 资产id
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 流程类型集合设定
	 * @param prpdid_in 流程类型集合
	 */
	public void setPrpdid_in(List<String> prpdid_in) {
		this.prpdid_in = prpdid_in;
	}

	/**
	 * 流程类型设定
	 * @param prpdid_eq 流程类型
	 */
	public void setPrpdid_eq(String prpdid_eq) {
		this.prpdid_eq = prpdid_eq;
	}

	/**
	 * 资产id取得
	 * @return eiid 资产id
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 流程类型集合取得
	 * @return prpdid_in 流程类型集合
	 */
	public List<String> getPrpdid_in() {
		return prpdid_in;
	}

	/**
	 * 流程类型取得
	 * @return prpdid_eq 流程类型
	 */
	public String getPrpdid_eq() {
		return prpdid_eq;
	}
}