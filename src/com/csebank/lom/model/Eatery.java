/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 接待管理实体接口
 *
 */
public interface Eatery extends BaseModel {

	/** 自增无意义主键 */
	public Integer getEid();
	
	/** 日期 */
	public String getEdate();
	
	/** 采购原料成本 */
	public BigDecimal getEstaplecost();
	
	/** 调味品成本 */
	public BigDecimal getEflavouringcost();
	
	/** 其他成本 */
	public BigDecimal getEothercost();

}
