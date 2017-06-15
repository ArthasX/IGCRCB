/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-26新建 
 * 			
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGASM3115Form extends BaseForm{
	
	/***/
	protected String esyscoding;

	/** 条数 */
	protected String risknum;

	/** 风险整体 */
	protected String risk;

	/** 风险领域 */
	protected String riskly;

	/** 风险子域 */
	protected String riskarea;

	/** 风险项 */
	protected String riskitem;

	/**
	 * 取得
	 * @return esyscoding 
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 设定
	 * @param esyscoding 
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 条数取得
	 * @return risknum 条数
	 */
	public String getRisknum() {
		return risknum;
	}

	/**
	 * 条数设定
	 * @param risknum 条数
	 */
	public void setRisknum(String risknum) {
		this.risknum = risknum;
	}

	/**
	 * 风险整体取得
	 * @return risk 风险整体
	 */
	public String getRisk() {
		return risk;
	}

	/**
	 * 风险整体设定
	 * @param risk 风险整体
	 */
	public void setRisk(String risk) {
		this.risk = risk;
	}

	/**
	 * 风险领域取得
	 * @return riskly 风险领域
	 */
	public String getRiskly() {
		return riskly;
	}

	/**
	 * 风险领域设定
	 * @param riskly 风险领域
	 */
	public void setRiskly(String riskly) {
		this.riskly = riskly;
	}

	/**
	 * 风险子域取得
	 * @return riskarea 风险子域
	 */
	public String getRiskarea() {
		return riskarea;
	}

	/**
	 * 风险子域设定
	 * @param riskarea 风险子域
	 */
	public void setRiskarea(String riskarea) {
		this.riskarea = riskarea;
	}

	/**
	 * 风险项取得
	 * @return riskitem 风险项
	 */
	public String getRiskitem() {
		return riskitem;
	}

	/**
	 * 风险项设定
	 * @param riskitem 风险项
	 */
	public void setRiskitem(String riskitem) {
		this.riskitem = riskitem;
	}
}
