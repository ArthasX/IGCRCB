package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC1303VWInfo;

/**
 * 
 * 功能：文档统计功能伪视图
 * @author 史凯龙   2014-7-24
 */
@SuppressWarnings("serial")
@Entity
public class IGCRC1303VW implements Serializable,IGCRC1303VWInfo,Cloneable{

	@Id
	/** 主键 */
	protected String eiid;
	
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
	
	/** 存储方式 */
	protected String storageWay;
	
	/** 存放位置 */
	protected String storageLocation;
	
	/** 发起人 */
	protected String userName;
	
	/** 时间戳 */
	//protected String fingerPrint;
	
	/** eid */
	protected String eid;
	
	/** eLabel */
	protected String eLabel;
	
	/** eName */
	protected String eName;
	
	/** eiLabel */
	protected String eiLabel;
	
	/** eCategory */
	protected String eCategory;
	
	/** 版本号 */
	protected String eiVersion;

	/** 是否可下载 */
	protected String isDownload;
	/**
	 * 发起人取得
	 * @return userName 发起人
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 发起人设定
	 * @param userName 发起人
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	
	public String getFingerPrint() {
		return null;
	}

	/**
	 * eiid取得
	 * @return eiid eiid
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * eiid设定
	 * @param eiid eiid
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * eid取得
	 * @return eid eid
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * eid设定
	 * @param eid eid
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * eLabel取得
	 * @return eLabel eLabel
	 */
	public String geteLabel() {
		return eLabel;
	}

	/**
	 * eLabel设定
	 * @param eLabel eLabel
	 */
	public void seteLabel(String eLabel) {
		this.eLabel = eLabel;
	}

	/**
	 * eiLabel取得
	 * @return eiLabel eiLabel
	 */
	public String getEiLabel() {
		return eiLabel;
	}

	/**
	 * eiLabel设定
	 * @param eiLabel eiLabel
	 */
	public void setEiLabel(String eiLabel) {
		this.eiLabel = eiLabel;
	}

	/**
	 * eCategory取得
	 * @return eCategory eCategory
	 */
	public String geteCategory() {
		return eCategory;
	}

	/**
	 * eCategory设定
	 * @param eCategory eCategory
	 */
	public void seteCategory(String eCategory) {
		this.eCategory = eCategory;
	}

	/**
	 * 版本号取得
	 * @return eiVersion 版本号
	 */
	public String getEiVersion() {
		return eiVersion;
	}

	/**
	 * 版本号设定
	 * @param eiVersion 版本号
	 */
	public void setEiVersion(String eiVersion) {
		this.eiVersion = eiVersion;
	}

	/**
	 * eName取得
	 * @return eName eName
	 */
	public String geteName() {
		return eName;
	}

	/**
	 * eName设定
	 * @param eName eName
	 */
	public void seteName(String eName) {
		this.eName = eName;
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
