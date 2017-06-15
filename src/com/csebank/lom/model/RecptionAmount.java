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
public interface RecptionAmount{

	/** 接待管理ID */
	public Integer getRid();
	
	/** 接待工作名称 */
	public String getRname();
	
	/** 接待人数规模 */
	public String getRscale();
	
	/** 接待标准 */
	public String getRstandard();
	
	/** 状态（1进行中，2结束） */
	public String getRstatus();

	/** 费用总额 */
	public BigDecimal getAmount();
	
	/** 所属机构名称 */
	public String getRapporgname();
	
	/** 所属机构ID */
	public String getOrgsyscoding();
	
	/** 接待工作开始日期 */
	public String getRstime();
	
	/** 接待工作结束日期 */
	public String getRetime();
	
}
