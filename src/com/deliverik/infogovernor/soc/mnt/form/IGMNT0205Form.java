/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.mnt.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;

/**
 * 概述: 容量监控管理Form
 * 功能描述: 容量监控管理Form
 * 创建记录: 2012-8-2
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGMNT0205Form extends BaseForm implements SOC0423Info{
	//预留
	//private String[] delArr;
	/**更新标示*/
	protected String[] selArr;

	protected Integer id;

	/** 名称 */
	protected String name;

	/** 对象类型 */
	protected String objectType;

	/** 对象名称 */
	protected String objectName;
	
	/** 错误代码 */
	protected Integer errorNum;
	
	/** 告警代码 */
	protected Integer warningNum;
	
	/** 状态 */
	protected Integer status;
	
	/** 更新错误代码数组 */
	protected Integer[] errorNums;
	/** 更新告警代码数组 */
	protected Integer[] warningNums;
	/** 更新id数组 */
	protected String[] ids;
	/** 更新name数组 */
	protected String[] names;
	/** 对象名称数组 */
	protected String[] objectNames;
	/** 对象类型数组 */
	protected String[] objectTypes;
	
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 名称取得
	 *
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名称设定
	 *
	 * @param name 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 对象类型取得
	 *
	 * @return 对象类型
	 */
	public String getObjectType() {
		return objectType;
	}

	/**
	 * 对象类型设定
	 *
	 * @param objectType 对象类型
	 */
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	/**
	 * 对象名称取得
	 *
	 * @return 对象名称
	 */
	public String getObjectName() {
		return objectName;
	}

	/**
	 * 对象名称设定
	 *
	 * @param objectName 对象名称
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return id;
	}

	/**
	 * 错误代码取得
	 *
	 * @return errorNum 错误代码
	 */
	public Integer getErrorNum() {
		return errorNum;
	}

	/**
	 * 错误代码设定
	 *
	 * @param errorNum 错误代码
	 */
	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}

	/**
	 * 告警代码取得
	 *
	 * @return warningNum 告警代码
	 */
	public Integer getWarningNum() {
		return warningNum;
	}

	/**
	 * 告警代码设定
	 *
	 * @param warningNum 告警代码
	 */
	public void setWarningNum(Integer warningNum) {
		this.warningNum = warningNum;
	}

	/**
	 * 状态取得
	 *
	 * @return status 状态
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * 状态设定
	 *
	 * @param status 状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	//
	public String getFingerPrint() {
		//
		return null;
	}

	/**
	 * 预留p取得
	 *
	 * @return selArr 预留p
	 */
	public String[] getSelArr() {
		return selArr;
	}

	/**
	 * 预留p设定
	 *
	 * @param selArr 预留p
	 */
	public void setSelArr(String[] selArr) {
		this.selArr = selArr;
	}

	/**
	 * 更新错误代码数组取得
	 *
	 * @return errorNums 更新错误代码数组
	 */
	public Integer[] getErrorNums() {
		return errorNums;
	}

	/**
	 * 更新错误代码数组设定
	 *
	 * @param errorNums 更新错误代码数组
	 */
	public void setErrorNums(Integer[] errorNums) {
		this.errorNums = errorNums;
	}

	/**
	 * 更新告警代码数组取得
	 *
	 * @return warningNums 更新告警代码数组
	 */
	public Integer[] getWarningNums() {
		return warningNums;
	}

	/**
	 * 更新告警代码数组设定
	 *
	 * @param warningNums 更新告警代码数组
	 */
	public void setWarningNums(Integer[] warningNums) {
		this.warningNums = warningNums;
	}

	/**
	 * 更新id数组取得
	 *
	 * @return ids 更新id数组
	 */
	public String[] getIds() {
		return ids;
	}

	/**
	 * 更新id数组设定
	 *
	 * @param ids 更新id数组
	 */
	public void setIds(String[] ids) {
		this.ids = ids;
	}

	/**
	 * 更新name数组取得
	 *
	 * @return names 更新name数组
	 */
	public String[] getNames() {
		return names;
	}

	/**
	 * 更新name数组设定
	 *
	 * @param names 更新name数组
	 */
	public void setNames(String[] names) {
		this.names = names;
	}

	/**
	 * 对象名称数组取得
	 *
	 * @return objectNames 对象名称数组
	 */
	public String[] getObjectNames() {
		return objectNames;
	}

	/**
	 * 对象名称数组设定
	 *
	 * @param objectNames 对象名称数组
	 */
	public void setObjectNames(String[] objectNames) {
		this.objectNames = objectNames;
	}

	/**
	 * 对象类型数组取得
	 *
	 * @return objectTypes 对象类型数组
	 */
	public String[] getObjectTypes() {
		return objectTypes;
	}

	/**
	 * 对象类型数组设定
	 *
	 * @param objectTypes 对象类型数组
	 */
	public void setObjectTypes(String[] objectTypes) {
		this.objectTypes = objectTypes;
	}

}
