/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.csebank.lom.model.entity.RecptionTB;
import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 接待管理实体接口
 *
 */
public interface Eentertainment extends BaseModel {

	/** 自增无意义主键 */
	public Integer getEeid();
	
	/** 接待工作ID */
	public Integer getRid();
	
	/** 主陪人 */
	public String getEeuser();
	
	/** 每桌菜价格 */
	public BigDecimal getEetableprice();
	
	/** 桌数 */
	public Integer getEetablenum();
	
	/** 酒价 */
	public BigDecimal getEedrinkprice();
	
	/** 烟价 */
	public BigDecimal getEesmokeprice();
	
	/** 其他用品价格 */
	public BigDecimal getEeotherprice();
	
	/** 日期 */
	public String getEedate();
	
	public RecptionTB getRecptionTB();

}
