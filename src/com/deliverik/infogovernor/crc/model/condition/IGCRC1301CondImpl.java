/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.condition;

import com.deliverik.infogovernor.crc.form.IGCRC1301Form;

/**
 * 概述: 文档视图检索条件实现
 * 功能描述: 文档视图检索条件实现
 * 创建记录: 2014/07/15
 * 修改记录: 
 */
public class IGCRC1301CondImpl implements IGCRC1301Cond {

	public IGCRC1301CondImpl(){
		super();
	}
	
	public IGCRC1301CondImpl(IGCRC1301Form form){
		
	}
	
	/** 文档编号 */
	private String eiNumber;
	
	/** 文档名称 */
	private String eiName;
	
	/** 文档类型 */
	private String eiType;
	
	/** 文档分类 */
	private String eiSort;
	
	/** 文档密级 */
	private String eiDense;
	
	/** 部门 */
	private String department;
	
	/** 管理人 */
	private String managermentPerson;
	
	/** 内容 */
	private String content;
	
	/** 存储方式 */
	private String storageWay;
	
	/** 存放位置 */
	private String storageLocation;
	
	/** 是否可下载 */
	protected String isDownload;

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
	 * 存储方式取得
	 * @return storageWay 存储方式
	 */
	public String getStorageWay() {
		return storageWay;
	}

	/**
	 * 存储方式设定
	 * @param storageWay 存储方式
	 */
	public void setStorageWay(String storageWay) {
		this.storageWay = storageWay;
	}

	/**
	 * 存放位置取得
	 * @return storageLocation 存放位置
	 */
	public String getStorageLocation() {
		return storageLocation;
	}

	/**
	 * 存放位置设定
	 * @param storageLocation 存放位置
	 */
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
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
