/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.form;

import com.deliverik.framework.soc.asset.model.condition.SOC0130SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0131SearchCond;

/**
 * 概述: 设备关系信息FORM
 * 功能描述: 设备关系信息FORM
 * 创建记录: 2011/05/13
 * 修改记录: 
 */
public class IGCOM0319Form extends IGCOM0318Form implements SOC0130SearchCond,SOC0131SearchCond{
	private static final long serialVersionUID = 1L;
	
	protected String srname;
	
	/** FsLvVgInfo中被筛选的属性名称 */
	protected String attrName;
	
	/** FsLvVgInfo中被筛选的属性值 */
	protected String attrValue;
	
	/** FsLvVgInfo中被筛选的属性名称 */
	protected String parName;
	
	/** FsLvVgInfo中被筛选的属性值 */
	protected String parValue;
	
	/** FS-LV-VG排序列 */
	protected String soltName;
	/** VG-PV-META排序列*/
	protected String soltNameVg;
	
	/** 排序方式 0升序 1降序 */
	protected Integer soltType;
	
	/** 分辨率 */
	protected Integer screenWidth;

	
	
	

	/**
	 *  FS-LV-VG排序列取得
	 * @return  FS-LV-VG排序列
	 */
	public String getSoltName() {
		return soltName;
	}

	/**
	 *  FS-LV-VG排序列设定
	 * @param soltName FS-LV-VG排序列
	 */
	public void setSoltName(String soltName) {
		this.soltName = soltName;
	}

	/**
	 * 排序方式 0升序 1降序取得
	 * @return 排序方式 0升序 1降序
	 */
	public Integer getSoltType() {
		return soltType;
	}

	/**
	 * 排序方式 0升序 1降序设定
	 * @param soltType排序方式 0升序 1降序
	 */
	public void setSoltType(Integer soltType) {
		this.soltType = soltType;
	}

	/**
	 * 分辨率取得
	 * @return 分辨率
	 */
	public Integer getScreenWidth() {
		return screenWidth;
	}

	/**
	 * 分辨率设定
	 * @param screenWidth分辨率
	 */
	public void setScreenWidth(Integer screenWidth) {
		this.screenWidth = screenWidth;
	}

	public String getSrname() {
		return srname;
	}

	public void setSrname(String srname) {
		this.srname = srname;
	}

	/**
	 * FsLvVgInfo中被筛选的属性名称取得
	 * @return FsLvVgInfo中被筛选的属性名称
	 */
	public String getAttrName() {
		return attrName;
	}

	/**
	 * FsLvVgInfo中被筛选的属性名称设定
	 * @param attrNameFsLvVgInfo中被筛选的属性名称
	 */
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	/**
	 * FsLvVgInfo中被筛选的属性值取得
	 * @return FsLvVgInfo中被筛选的属性值
	 */
	public String getAttrValue() {
		return attrValue;
	}

	/**
	 * FsLvVgInfo中被筛选的属性值设定
	 * @param attrValueFsLvVgInfo中被筛选的属性值
	 */
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	/**
	 * FsLvVgInfo中被筛选的属性名称取得
	 * @return FsLvVgInfo中被筛选的属性名称
	 */
	public String getParName() {
		return parName;
	}

	/**
	 * FsLvVgInfo中被筛选的属性名称设定
	 * @param parNameFsLvVgInfo中被筛选的属性名称
	 */
	public void setParName(String parName) {
		this.parName = parName;
	}

	/**
	 * FsLvVgInfo中被筛选的属性值取得
	 * @return FsLvVgInfo中被筛选的属性值
	 */
	public String getParValue() {
		return parValue;
	}

	/**
	 * FsLvVgInfo中被筛选的属性值设定
	 * @param parValueFsLvVgInfo中被筛选的属性值
	 */
	public void setParValue(String parValue) {
		this.parValue = parValue;
	}

	/**
	 * VG-PV-META排序列取得
	 * @return VG-PV-META排序列
	 */
	public String getSoltNameVg() {
		return soltNameVg;
	}

	/**
	 * VG-PV-META排序列设定
	 * @param soltNameVg VG-PV-META排序列
	 */
	public void setSoltNameVg(String soltNameVg) {
		this.soltNameVg = soltNameVg;
	}
	
	
	
}
