/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 文档查询Form
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1301Form extends BaseForm{
	/** 文档编号 */
	protected String eiNumber;
	
	/** 文档名称 */
	protected String eiName;
	
	/** 文档类型 */
	protected String eiType;
	
	/** 文档分类 */
	protected String eiSort;
	
	/** 文档密级 */
	protected String eiDense;
	
	/** 部门 */
	protected String department;
	
	/** 管理人 */
	protected String managermentPerson;
	
	/** 内容 */
	protected String content;

	/** 发起者 */
	protected String userName;
	
	/** 是否可下载 */
	protected String isDownload;
	
	/**
	 * 发起者取得
	 * @return userName 发起者
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 发起者设定
	 * @param userName 发起者
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 文档编号取得
	 * @return eiNumber 文档编号
	 */
	public String getEiNumber() {
		return eiNumber;
	}

	/**
	 * 文档编号设定
	 * @param eiNumber 文档编号
	 */
	public void setEiNumber(String eiNumber) {
		this.eiNumber = eiNumber;
	}

	/**
	 * 文档名称取得
	 * @return eiName 文档名称
	 */
	public String getEiName() {
		return eiName;
	}

	/**
	 * 文档名称设定
	 * @param eiName 文档名称
	 */
	public void setEiName(String eiName) {
		this.eiName = eiName;
	}

	/**
	 * 文档类型取得
	 * @return eiType 文档类型
	 */
	public String getEiType() {
		return eiType;
	}

	/**
	 * 文档类型设定
	 * @param eiType 文档类型
	 */
	public void setEiType(String eiType) {
		this.eiType = eiType;
	}

	/**
	 * 文档分类取得
	 * @return eiSort 文档分类
	 */
	public String getEiSort() {
		return eiSort;
	}

	/**
	 * 文档分类设定
	 * @param eiSort 文档分类
	 */
	public void setEiSort(String eiSort) {
		this.eiSort = eiSort;
	}

	/**
	 * 文档密级取得
	 * @return eiDense 文档密级
	 */
	public String getEiDense() {
		return eiDense;
	}

	/**
	 * 文档密级设定
	 * @param eiDense 文档密级
	 */
	public void setEiDense(String eiDense) {
		this.eiDense = eiDense;
	}

	/**
	 * 部门取得
	 * @return department 部门
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 部门设定
	 * @param department 部门
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * 管理人取得
	 * @return managermentPerson 管理人
	 */
	public String getManagermentPerson() {
		return managermentPerson;
	}

	/**
	 * 管理人设定
	 * @param managermentPerson 管理人
	 */
	public void setManagermentPerson(String managermentPerson) {
		this.managermentPerson = managermentPerson;
	}

	/**
	 * 内容取得
	 * @return content 内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 内容设定
	 * @param content 内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 是否可下载取得
	 * @return isDownload 是否可下载
	 */
	public String getIsDownload() {
		return isDownload;
	}

	/**
	 * 是否可下载设定
	 * @param isDownload 是否可下载
	 */
	public void setIsDownload(String isDownload) {
		this.isDownload = isDownload;
	}
	
	
}
