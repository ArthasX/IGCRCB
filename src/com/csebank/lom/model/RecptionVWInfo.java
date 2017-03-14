/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 接待统计实体接口
 *
 */
public interface RecptionVWInfo extends BaseModel {

	
	/** 月份 */
	public String getMonth();
	
	/** 接待数量 */
	public Integer getRnum();
	
	/** 费用总额 */
	public BigDecimal getAmount();

}
