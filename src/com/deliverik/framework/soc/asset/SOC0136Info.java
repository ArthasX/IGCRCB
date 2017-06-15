/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset;

import com.deliverik.framework.base.BaseModel;

/**
 * 概述: 域明细信息接口（影响CI）
 * 功能描述: 域明细信息接口（影响CI）
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public interface SOC0136Info extends BaseModel {
	
	public Integer getDomainid();
	
	public Integer getDomainversion() ;
	
	public String getName();
	
	public String getEiname() ;
	
	public Integer getEiversion() ;
	
	public String getEiupdtime() ;
	
	public Integer getEiid() ;
	
	public String getEircount();

}
