/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 报表统计页面初始化Form
 * 功能描述: 
 * 创建记录:杨龙全 2012/07/20
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT0401Form extends BaseForm{
	protected Integer rclId;

	/** 报表类型 */
	protected String rclReportType;

	/** 对象名称 */
	protected String rclObjName;

	/** 模板名字 */
	protected String rclTemName;

	/** 模板描述 */
	protected String rclTemDesc;
	/** 模板标题*/
	protected String rclRfdTitle;
	/** 对象Eiid */
	protected Integer rclObjEiid;

	/** 对象类型 */
	protected String rclObjType;

	/** 容量Mode */
	protected String rclMode;

	/** 容量主机小类型 */
	protected String rclCaType;

	/** 菜单默认 */
	protected String rclMenuDefault;

	/** 用户帐号 */
	protected String rclUserId;

	/**
	 * 主键ID取得
	 *
	 * @return 主键ID
	 */
	public Integer getRclId() {
		return rclId;
	}

	/**
	 * 主键ID设定
	 *
	 * @param rclId 主键ID
	 */
	public void setRclId(Integer rclId) {
		this.rclId = rclId;
	}

	/**
	 * 报表类型取得
	 *
	 * @return 报表类型
	 */
	public String getRclReportType() {
		return rclReportType;
	}

	/**
	 * 报表类型设定
	 *
	 * @param rclReportType 报表类型
	 */
	public void setRclReportType(String rclReportType) {
		this.rclReportType = rclReportType;
	}

	/**
	 * 对象名称取得
	 *
	 * @return 对象名称
	 */
	public String getRclObjName() {
		return rclObjName;
	}

	/**
	 * 对象名称设定
	 *
	 * @param rclObjName 对象名称
	 */
	public void setRclObjName(String rclObjName) {
		this.rclObjName = rclObjName;
	}

	/**
	 * 模板名字取得
	 *
	 * @return 模板名字
	 */
	public String getRclTemName() {
		return rclTemName;
	}

	/**
	 * 模板名字设定
	 *
	 * @param rclTemName 模板名字
	 */
	public void setRclTemName(String rclTemName) {
		this.rclTemName = rclTemName;
	}

	/**
	 * 模板描述取得
	 *
	 * @return 模板描述
	 */
	public String getRclTemDesc() {
		return rclTemDesc;
	}

	/**
	 * 模板描述设定
	 *
	 * @param rclTemDesc 模板描述
	 */
	public void setRclTemDesc(String rclTemDesc) {
		this.rclTemDesc = rclTemDesc;
	}

	/**
	 * 对象Eiid取得
	 *
	 * @return 对象Eiid
	 */
	public Integer getRclObjEiid() {
		return rclObjEiid;
	}

	/**
	 * 对象Eiid设定
	 *
	 * @param rclObjEiid 对象Eiid
	 */
	public void setRclObjEiid(Integer rclObjEiid) {
		this.rclObjEiid = rclObjEiid;
	}

	/**
	 * 对象类型取得
	 *
	 * @return 对象类型
	 */
	public String getRclObjType() {
		return rclObjType;
	}

	/**
	 * 对象类型设定
	 *
	 * @param rclObjType 对象类型
	 */
	public void setRclObjType(String rclObjType) {
		this.rclObjType = rclObjType;
	}

	/**
	 * 容量Mode取得
	 *
	 * @return 容量Mode
	 */
	public String getRclMode() {
		return rclMode;
	}

	/**
	 * 容量Mode设定
	 *
	 * @param rclMode 容量Mode
	 */
	public void setRclMode(String rclMode) {
		this.rclMode = rclMode;
	}

	/**
	 * 容量主机小类型取得
	 *
	 * @return 容量主机小类型
	 */
	public String getRclCaType() {
		return rclCaType;
	}

	/**
	 * 容量主机小类型设定
	 *
	 * @param rclCaType 容量主机小类型
	 */
	public void setRclCaType(String rclCaType) {
		this.rclCaType = rclCaType;
	}

	/**
	 * 菜单默认取得
	 *
	 * @return 菜单默认
	 */
	public String getRclMenuDefault() {
		return rclMenuDefault;
	}

	/**
	 * 菜单默认设定
	 *
	 * @param rclMenuDefault 菜单默认
	 */
	public void setRclMenuDefault(String rclMenuDefault) {
		this.rclMenuDefault = rclMenuDefault;
	}

	/**
	 * 用户帐号取得
	 *
	 * @return 用户帐号
	 */
	public String getRclUserId() {
		return rclUserId;
	}

	/**
	 * 用户帐号设定
	 *
	 * @param rclUserId 用户帐号
	 */
	public void setRclUserId(String rclUserId) {
		this.rclUserId = rclUserId;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return rclId;
	}

	/**
	 * 模板标题取得
	 *
	 * @return rclRfdTitle 模板标题
	 */
	public String getRclRfdTitle() {
		return rclRfdTitle;
	}

	/**
	 * 模板标题设定
	 *
	 * @param rclRfdTitle 模板标题
	 */
	public void setRclRfdTitle(String rclRfdTitle) {
		this.rclRfdTitle = rclRfdTitle;
	}
	
	
}
