/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.vcd.model;

/**
 * 概述: 模版实体
 * 功能描述: 模版实体
 * 创建记录:
 * 修改记录:
 */
public class Template {
	
	/** vCloud配置表ID */
	protected Integer vcdid;

	/** 模版名称 */
	protected String name;
	
	/**
	 * vCloud配置表ID取得
	 * @return vCloud配置表ID
	 */
	public Integer getVcdid() {
		return vcdid;
	}

	/**
	 * vCloud配置表ID设定
	 * @param vcdid vCloud配置表ID
	 */
	public void setVcdid(Integer vcdid) {
		this.vcdid = vcdid;
	}

	/**
	 * 模版名称取得
	 * 
	 * @return 模版名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 模版名称设定
	 * 
	 * @param name 模版名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
