/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;

/**	
 * 概述:部门 查询用伪视图
 * 创建记录：yukexin    2014-8-15 下午3:27:32	
 * 修改记录：null
 */	
@SuppressWarnings("serial")
@Entity
public class IGCRC2102VW implements Serializable,IGCRC2102VWInfo{
	/** 主键  */	
	@Id
	protected String id;

	/** 名称  */	
	protected String label;

	/** 值  */	
	protected String value;
	
	public IGCRC2102VW() {
		super();
	}
	public String getLabel() {
		return label;
	}

	public IGCRC2102VW(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
	
	public String getFingerPrint() {
		return null;
	}
	/**
	 * 主键取得
	 * @return id  主键
	 */
	public String getId() {
		return id;
	}
	/**
	 * 主键设定
	 * @param id  主键
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 值取得
	 * @return value  值
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 值设定
	 * @param value  值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 名称设定
	 * @param label  名称
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
