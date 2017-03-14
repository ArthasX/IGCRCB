/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.model;

import com.deliverik.framework.base.BaseModel;

/**
 * SOC关系实体接口
 * 
 */
public interface SocRelation  extends BaseModel {
	
	/**
	 * 资产信息实体
	 * @return 资产信息实体
	 */
	//public EntityItemTB getEntityItemTB();
	
	/**
	 * 主键ID
	 * @return 主键ID
	 */
	public Integer getSrid();

	/**
	 * 资产label
	 * @return 资产label
	 */
	public String getSreilabel();
	
	/**
	 * 关联资产label
	 * @return 关联资产label
	 */
	public String getSrpareilabel();

	/**
	 * 关联资产coding
	 * @return 关联资产coding
	 */
	public String getSresycoding();

	/**
	 * 关联资产类型名称
	 * @return 关联资产类型名称
	 */
	public String getSrename();

	/**
	 * 预留1
	 * @return 预留1
	 */
	public String getSrkey1();

	/**
	 * 预留2
	 * @return 预留2
	 */
	public String getSrkey2();
	
	/**
	 * 版本号
	 * @return 版本号
	 */
	public Integer getVersion();
}