/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 报表自定链接检索条件实现
  * 功能描述: 报表自定链接检索条件实现
  * 创建记录: 2012/07/20
  * 修改记录: 2012/08/10 将ReportCustomLinkSearchCondImpl表名修改为SOC0204SearchCondImpl
  */
public class SOC0204SearchCondImpl implements
		SOC0204SearchCond {
	/** 报表类型 */
	protected String rclReportType_eq;

	/** 对象名称 */
	protected String rclObjName_eq;

	/** 模板名字 */
	protected String rclTemName_eq;

	/** 模板描述 */
	protected String rclTemDesc_eq;
	/** 模板标题*/
	protected String rclRfdTitle_eq;
	/** 对象Eiid */
	protected Integer rclObjEiid_eq;

	/** 对象类型 */
	protected String rclObjType_eq;

	/** 容量Mode */
	protected String rclMode_eq;

	/** 容量主机小类型 */
	protected String rclCaType_eq;

	/** 菜单默认 */
	protected String rclMenuDefault_eq;

	/** 用户帐号 */
	protected String rclUserId_eq;

	/**
	 * 报表类型取得
	 *
	 * @return rclReportType_eq 报表类型
	 */
	public String getRclReportType_eq() {
		return rclReportType_eq;
	}

	/**
	 * 报表类型设定
	 *
	 * @param rclReportType_eq 报表类型
	 */
	public void setRclReportType_eq(String rclReportType_eq) {
		this.rclReportType_eq = rclReportType_eq;
	}

	/**
	 * 对象名称取得
	 *
	 * @return rclObjName_eq 对象名称
	 */
	public String getRclObjName_eq() {
		return rclObjName_eq;
	}

	/**
	 * 对象名称设定
	 *
	 * @param rclObjName_eq 对象名称
	 */
	public void setRclObjName_eq(String rclObjName_eq) {
		this.rclObjName_eq = rclObjName_eq;
	}

	/**
	 * 模板名字取得
	 *
	 * @return rclTemName_eq 模板名字
	 */
	public String getRclTemName_eq() {
		return rclTemName_eq;
	}

	/**
	 * 模板名字设定
	 *
	 * @param rclTemName_eq 模板名字
	 */
	public void setRclTemName_eq(String rclTemName_eq) {
		this.rclTemName_eq = rclTemName_eq;
	}

	/**
	 * 模板描述取得
	 *
	 * @return rclTemDesc_eq 模板描述
	 */
	public String getRclTemDesc_eq() {
		return rclTemDesc_eq;
	}

	/**
	 * 模板描述设定
	 *
	 * @param rclTemDesc_eq 模板描述
	 */
	public void setRclTemDesc_eq(String rclTemDesc_eq) {
		this.rclTemDesc_eq = rclTemDesc_eq;
	}

	/**
	 * 模板标题取得
	 *
	 * @return rclRfdTitle_eq 模板标题
	 */
	public String getRclRfdTitle_eq() {
		return rclRfdTitle_eq;
	}

	/**
	 * 模板标题设定
	 *
	 * @param rclRfdTitle_eq 模板标题
	 */
	public void setRclRfdTitle_eq(String rclRfdTitle_eq) {
		this.rclRfdTitle_eq = rclRfdTitle_eq;
	}

	/**
	 * 对象Eiid取得
	 *
	 * @return rclObjEiid_eq 对象Eiid
	 */
	public Integer getRclObjEiid_eq() {
		return rclObjEiid_eq;
	}

	/**
	 * 对象Eiid设定
	 *
	 * @param rclObjEiid_eq 对象Eiid
	 */
	public void setRclObjEiid_eq(Integer rclObjEiid_eq) {
		this.rclObjEiid_eq = rclObjEiid_eq;
	}

	/**
	 * 对象类型取得
	 *
	 * @return rclObjType_eq 对象类型
	 */
	public String getRclObjType_eq() {
		return rclObjType_eq;
	}

	/**
	 * 对象类型设定
	 *
	 * @param rclObjType_eq 对象类型
	 */
	public void setRclObjType_eq(String rclObjType_eq) {
		this.rclObjType_eq = rclObjType_eq;
	}

	/**
	 * 容量Mode取得
	 *
	 * @return rclMode_eq 容量Mode
	 */
	public String getRclMode_eq() {
		return rclMode_eq;
	}

	/**
	 * 容量Mode设定
	 *
	 * @param rclMode_eq 容量Mode
	 */
	public void setRclMode_eq(String rclMode_eq) {
		this.rclMode_eq = rclMode_eq;
	}

	/**
	 * 容量主机小类型取得
	 *
	 * @return rclCaType_eq 容量主机小类型
	 */
	public String getRclCaType_eq() {
		return rclCaType_eq;
	}

	/**
	 * 容量主机小类型设定
	 *
	 * @param rclCaType_eq 容量主机小类型
	 */
	public void setRclCaType_eq(String rclCaType_eq) {
		this.rclCaType_eq = rclCaType_eq;
	}

	/**
	 * 菜单默认取得
	 *
	 * @return rclMenuDefault_eq 菜单默认
	 */
	public String getRclMenuDefault_eq() {
		return rclMenuDefault_eq;
	}

	/**
	 * 菜单默认设定
	 *
	 * @param rclMenuDefault_eq 菜单默认
	 */
	public void setRclMenuDefault_eq(String rclMenuDefault_eq) {
		this.rclMenuDefault_eq = rclMenuDefault_eq;
	}

	/**
	 * 用户帐号取得
	 *
	 * @return rclUserId_eq 用户帐号
	 */
	public String getRclUserId_eq() {
		return rclUserId_eq;
	}

	/**
	 * 用户帐号设定
	 *
	 * @param rclUserId_eq 用户帐号
	 */
	public void setRclUserId_eq(String rclUserId_eq) {
		this.rclUserId_eq = rclUserId_eq;
	}
	
	
}