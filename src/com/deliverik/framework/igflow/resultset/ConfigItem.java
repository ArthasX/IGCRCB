/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 资产属性信息
 */
public class ConfigItem implements ConfigItemInfo {
	
	/** 资产属性ID */
	private Integer ciid;
	
	/** 资产属性定义ID */
	private String cid;

	/** 资产属性名称 */
	private String name;
	
	/** 资产属性值 */
	private String value;
	
	/**
	 * 资产属性ID取得
	 * 
	 * @return 资产属性ID
	 */
	public Integer getCiid() {
		return ciid;
	}
	
	/**
	 * 资产属性定义ID取得
	 * 
	 * @return 资产属性定义ID
	 */
	public String getCid() {
		return cid;
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
	 * 资产属性ID设定
	 * 
	 * @param ciid 资产属性ID
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}
	
	/**
	 * 资产属性定义ID设定
	 * 
	 * @param cid 资产属性定义ID
	 */
	public void setCid(String cid) {
		this.cid = cid;
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
	
}
