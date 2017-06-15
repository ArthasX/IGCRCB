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
public class IGASM3116Form extends BaseForm{
	
	/**分类码*/
	protected String esyscoding;
	
	/**主键*/
	protected String rimid;
	
	protected String asmxml;
	/** 风险指标分类 */
	protected String RIMTYPE;

	/** 风险指标说明 */
	protected String RIMDESC;

	/** 指标维护语句 */
	protected String RIMSQL;
	
	/** 检查项ID */
	protected String eiid;
	
	/** 年份 */
	protected String year;
	
	/** 月份 */
	protected String month;
	
	/** 页面显示标识  */	
	protected boolean flag = true;
	
	/**
	 * rIMTYPE取得
	 * @return rIMTYPE rIMTYPE
	 */
	public String getRIMTYPE() {
		return RIMTYPE;
	}

	/**
	 * rIMTYPE设定
	 * @param rIMTYPE rIMTYPE
	 */
	public void setRIMTYPE(String rIMTYPE) {
		RIMTYPE = rIMTYPE;
	}

	/**
	 * rIMDESC取得
	 * @return rIMDESC rIMDESC
	 */
	public String getRIMDESC() {
		return RIMDESC;
	}

	/**
	 * rIMDESC设定
	 * @param rIMDESC rIMDESC
	 */
	public void setRIMDESC(String rIMDESC) {
		RIMDESC = rIMDESC;
	}

	/**
	 * rIMSQL取得
	 * @return rIMSQL rIMSQL
	 */
	public String getRIMSQL() {
		return RIMSQL;
	}

	/**
	 * rIMSQL设定
	 * @param rIMSQL rIMSQL
	 */
	public void setRIMSQL(String rIMSQL) {
		RIMSQL = rIMSQL;
	}

	/**
	 * asmxml取得
	 * @return asmxml asmxml
	 */
	public String getAsmxml() {
		return asmxml;
	}

	/**
	 * asmxml设定
	 * @param asmxml asmxml
	 */
	public void setAsmxml(String asmxml) {
		this.asmxml = asmxml;
	}

	/**
	 * 主键取得
	 * @return rimid 主键
	 */
	public String getRimid() {
		return rimid;
	}

	/**
	 * 主键设定
	 * @param rimid 主键
	 */
	public void setRimid(String rimid) {
		this.rimid = rimid;
	}

	/**
	 * 分类码取得
	 * @return esyscoding 分类码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 分类码设定
	 * @param esyscoding 分类码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 检查项ID取得
	 * @return eiid  检查项ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 检查项ID设定
	 * @param eiid  检查项ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * 年份取得
	 * @return year  年份
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年份设定
	 * @param year  年份
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 月份取得
	 * @return month  月份
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 月份设定
	 * @param month  月份
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 页面显示标识取得
	 * @return flag  页面显示标识
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * 页面显示标识设定
	 * @param flag  页面显示标识
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
