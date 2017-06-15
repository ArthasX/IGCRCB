/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;


/**
 * 
 * 部门接待统计接口
 *
 */
public interface RecptionOrg {
	
	/** 接待数量 */
	public Integer getRnum();
	
	/** 费用总额 */
	public BigDecimal getAmount();
	
	/** 主要申请部门层次码 */
	public String getRapporgid();

	/** 部门 */
	public String getRapporgname();
	
	/** 结束数量 */
	public Integer getDisnum();
	
	/** 未结束数量 */
	public Integer getEnnum();
	
}
