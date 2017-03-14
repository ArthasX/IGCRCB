/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

/**
 * 
 * 接待管理实体接口
 *
 */
public interface DealAmount{

	/** 接待管理ID */
	public Integer getRid();
	
	/** 状态（1进行中，2结束） */
	public String getRstatus();

	/** 费用总额 */
	public BigDecimal getAmount();
	
	public String getRapporgname();
	
	public String getOrgsyscoding();
	
}
