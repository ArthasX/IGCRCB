/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.form;


import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;

/**
 * 概述:监控对象登记、修改form
 * 功能描述：
 * 创建记录：张楠    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT0103Form extends BaseForm implements Collect_Symmetrix_Info{
	
	/**
	 * 监控对象id
	 */
	protected String moId;
	
	/**
	 * ip地址
	 */
	protected String ip;
	
	/**
	 * 创建时间
	 */
	protected String moCreateTime;
	
	/**
	 * 监控对象状态
	 */
	protected String deleteFlag;
	
	/**
	 * 监控对象阀值状态数组
	 */
	protected String[] modDeleteFlag;
	
	/**
	 * 监控类型层次码
	 */
	protected String mtSyscoding;
	
	/**
	 * 监控类型ID
	 */
	protected String mtId;
	
	/**
	 * 监控类型名称
	 */
	protected String mtName;
	
	/**
	 * 监控对象阀值名称数组
	 */
	protected String[] modName;
	
	/**
	 * 监控对象阀值数组
	 */
	protected String[] modValue;
	
	/**
	 * 跳转页标识
	 */
	protected String flag;
	
	/**
	 * 比较符数组
	 */
	protected String[] compare;
	
	/**
	 * *主键ID
	 */
	protected Integer id;

	/**
	 *主键ID取得
	 * 
	 * @return 主键ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *主键ID设定
	 * 
	 * @param id主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 *序列号
	 */
	protected String symm_id;

	/**
	 *序列号取得
	 * 
	 * @return 序列号
	 */
	public String getSymm_id() {
		return symm_id;
	}

	/**
	 *序列号设定
	 * 
	 * @param symm_id序列号
	 */
	public void setSymm_id(String symm_id) {
		this.symm_id = symm_id;
	}

	/**
	 *型号
	 */
	protected String symm_model;

	/**
	 *型号取得
	 * 
	 * @return 型号
	 */
	public String getSymm_model() {
		return symm_model;
	}

	/**
	 *型号设定
	 * 
	 * @param symm_model型号
	 */
	public void setSymm_model(String symm_model) {
		this.symm_model = symm_model;
	}

	/**
	 *微码版本
	 */
	protected String symm_version;

	/**
	 *微码版本取得
	 * 
	 * @return 微码版本
	 */
	public String getSymm_version() {
		return symm_version;
	}

	/**
	 *微码版本设定
	 * 
	 * @param symm_version微码版本
	 */
	public void setSymm_version(String symm_version) {
		this.symm_version = symm_version;
	}

	/**
	 *缓存
	 */
	protected String symm_cachesize;

	/**
	 *缓存取得
	 * 
	 * @return 缓存
	 */
	public String getSymm_cachesize() {
		return symm_cachesize;
	}

	/**
	 *缓存设定
	 * 
	 * @param symm_cachesize缓存
	 */
	public void setSymm_cachesize(String symm_cachesize) {
		this.symm_cachesize = symm_cachesize;
	}

	public Serializable getPK() {
		return id;
	}
	
	/**
	 *存储类型
	 */
	protected String symm_type;

	/**
	 * @return 存储类型
	 */
	public String getSymm_type() {
		return symm_type;
	}

	/**
	 * @param 存储类型
	 */
	public void setSymm_type(String symm_Type) {
		symm_type = symm_Type;
	}

	/**
	 * 监控类型层次码获取
	 * @return
	 */
	public String getMtSyscoding() {
		return mtSyscoding;
	}

	/**
	 * 监控类型层次码设定
	 * @param mtSyscoding
	 */
	public void setMtSyscoding(String mtSyscoding) {
		this.mtSyscoding = mtSyscoding;
	}

	/**
	 * 创建时间获取
	 * @return
	 */
	public String getMoCreateTime() {
		return moCreateTime;
	}

	/**
	 * 创建时间设定
	 * @param moCreateTime
	 */
	public void setMoCreateTime(String moCreateTime) {
		this.moCreateTime = moCreateTime;
	}

	/**
	 * 监控对象状态获取
	 * @return
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * 监控对象状态设定
	 * @param deleteFlag
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * 监控对象阀值名称获取
	 * @return
	 */
	public String[] getModName() {
		return modName;
	}

	/**
	 * 监控对象阀值名称设定
	 * @param modName
	 */
	public void setModName(String[] modName) {
		this.modName = modName;
	}

	/**
	 * 监控对象阀值获取
	 * @return
	 */
	public String[] getModValue() {
		return modValue;
	}

	/**
	 * 监控对象阀值设定
	 * @param modValue
	 */
	public void setModValue(String[] modValue) {
		this.modValue = modValue;
	}

	/**
	 * 监控对象阀值状态数组获取
	 * @return
	 */
	public String[] getModDeleteFlag() {
		return modDeleteFlag;
	}

	/**
	 * 监控对象阀值状态数组设定
	 * @param modDeleteFlag
	 */
	public void setModDeleteFlag(String[] modDeleteFlag) {
		this.modDeleteFlag = modDeleteFlag;
	}

	/**
	 * ip地址获取
	 * @return
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * ip地址设定
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 监控类型ID获取
	 * @return
	 */
	public String getMtId() {
		return mtId;
	}

	/**
	 * 监控类型ID取得
	 * @param mtId
	 */
	public void setMtId(String mtId) {
		this.mtId = mtId;
	}

	/**
	 * 监控对象id取得
	 * @return
	 */
	public String getMoId() {
		return moId;
	}

	/**
	 * 监控对象id设定
	 * @param moId
	 */
	public void setMoId(String moId) {
		this.moId = moId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 比较符数组取得
	 * @return
	 */
	public String[] getCompare() {
		return compare;
	}

	/**
	 * 比较符数组设定
	 * @param compare
	 */
	public void setCompare(String[] compare) {
		this.compare = compare;
	}

	/**
	 * 监控类型名称取得
	 * @return
	 */
	public String getMtName() {
		return mtName;
	}

	/**
	 * 监控类型名称设定
	 * @param mtName
	 */
	public void setMtName(String mtName) {
		this.mtName = mtName;
	}
}
