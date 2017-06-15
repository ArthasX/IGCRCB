/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:流程查询显示列宽度设置Form 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD0146Form extends BaseForm{

	/** 流程定义ID */
	protected String pdid;
	
	/** 查询显示列定义ID */
	protected String[] sid;
	
	/** 宽度 */
	protected Integer[] columnWidth;

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 查询显示列定义ID取得
	 * @return sid 查询显示列定义ID
	 */
	public String[] getSid() {
		return sid;
	}

	/**
	 * 查询显示列定义ID设定
	 * @param sid 查询显示列定义ID
	 */
	public void setSid(String[] sid) {
		this.sid = sid;
	}

	/**
	 * 宽度取得
	 * @return columnWidth 宽度
	 */
	public Integer[] getColumnWidth() {
		return columnWidth;
	}

	/**
	 * 宽度设定
	 * @param columnWidth 宽度
	 */
	public void setColumnWidth(Integer[] columnWidth) {
		this.columnWidth = columnWidth;
	}
}
