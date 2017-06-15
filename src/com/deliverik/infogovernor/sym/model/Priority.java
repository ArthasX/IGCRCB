/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.model;
/**
 * 概述:实体接口
 * 功能描述：优先级priority接口
 * 创建记录：fangyunlong@deliverik.com    2010/12/14
 */
public interface Priority {

	/***
	 * 优先级KEY
	 */
	public String getPvalue() ;

	/***
	 * 紧急程度KEY
	 */
	public String getUvalue() ;

	/***
	 * 影响度KEY	
	 */
	public String getIvalue() ;
	/***
	 * 对应流程类型
	 */
	public String getPprtype();
}
