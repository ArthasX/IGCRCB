/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 食堂工作餐信息实体接口
 *
 */
public interface EworkingLunch extends BaseModel {

	/** 自增无意义主键 */
	public Integer getEwlid();
	
	/** 日期 */
	public String getEwldate();
	
	public String getLunchcardname();
	
	public Integer getLunchcardnum();
	
	public BigDecimal getLunchcardprince();
	
	public Integer getIcid();

}
