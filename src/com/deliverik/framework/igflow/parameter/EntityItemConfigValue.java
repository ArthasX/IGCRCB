/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;

import org.apache.struts.upload.FormFile;

/**
 * 资产属性信息
 */
public class EntityItemConfigValue implements EntityItemConfigValueInfo {
	
	/** 资产ID */
	private Integer eiid;

	/** 资产属性名称 */
	private String name;
	
	/** 资产属性值 */
	private String value;
	
	/** 附件信息 */
	private FormFile file;

	/**
	 * 资产ID取得
	 * 
	 * @return 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产属性名称取得
	 * 
	 * @return 资产属性名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 资产属性值取得
	 * 
	 * @return 资产属性值
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 资产ID设定
	 * 
	 * @param eiid 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产属性名称设定
	 * 
	 * @param name 资产属性名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 资产属性值设定
	 * 
	 * @param value 资产属性值
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 附件信息取得
	 * @return file 附件信息
	 */
	public FormFile getFile() {
		return file;
	}

	/**
	 * 附件信息设定
	 * @param file 附件信息
	 */
	public void setFile(FormFile file) {
		this.file = file;
	}
	
}
