/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.vcd.model;

/**
 * 概述: 组织实体
 * 功能描述: 组织实体
 * 创建记录:
 * 修改记录:
 */
public class Org {
	
	/** vCloudID */
	protected Integer vcid;
	
	/** 组织名称 */
	protected String name;

	/**
	 * vCloudID取得
	 * @return vcid vCloudID
	 */
	public Integer getVcid() {
		return vcid;
	}

	/**
	 * vCloudID设定
	 * @param vcid vCloudID
	 */
	public void setVcid(Integer vcid) {
		this.vcid = vcid;
	}

	/**
	 * 组织名称取得
	 * @return 组织名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 组织名称设定
	 * @param name 组织名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
