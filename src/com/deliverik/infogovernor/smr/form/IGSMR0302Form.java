/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述:年报填报查看Action 
 * 功能描述：年报填报查看Action 
 * 创建人：赵梓廷
 * 创建记录： 2013-07-29
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR0302Form extends BaseForm {

	/** 年份 */
	protected String year;
	
	/** 实例主键 */
	protected Integer instanceID;
	
	/** 选中的报表 */
	protected String prid;
	
	/** 催办信息 */
	protected String view;
	
	/**
	 * 年份取得
	 * @return 年份
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年份设定
	 * @param year 年份
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 自增ID取得
	 *
	 * @return 自增ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}





	/**
	 * 自增ID设定
	 *
	 * @param instanceID 自增ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}
	/**
	 * 选中的报表取得
	 *
	 * @return 选中的报表
	 */
	public String getPrid() {
		return prid;
	}
	/**
	 * 选中的报表设定
	 *
	 * @param prid 选中的报表
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}
	/**
	 * 催办信息取得
	 *
	 * @return 催办信息
	 */
	public String getView() {
		return view;
	}
	/**
	 * 催办信息设定
	 *
	 * @param view 催办信息
	 */
	public void setView(String view) {
		this.view = view;
	}


	
	
	
}
