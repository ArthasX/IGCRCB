/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 每月盘点
 * 
 * @author 
 */
public interface Inventory extends BaseModel {
	
	/** ID */
	public Integer getInid();
	
	/** 类盘日期 */
	public String getInventorydate();
	
	/** 物品名称 */
	public String getGoodsname();
	
	/** 物品分类 */
	public String getGoodscategory();
	
	/** 物品编号 */
	public String getGoodscode();
	
	/** 上月存盘数量 */
	public Integer getLminventoryamount();
	
	/** 上月存盘金额 */
	public BigDecimal getLminventorymoney();
	
	/** 本月购入数量 */
	public Integer getCminputamount();
	
	/** 本月购入金额 */
	public BigDecimal getCminputmoney();
	
	/** 平均价 */
	public BigDecimal getAverage();
	
	/** 本月领用数量 */
	public Integer getCmoutamount();
	
	/** 本月领用金额 */
	public BigDecimal getCmoutmoney();
	
	/** 本月调剂数量 */
	public Integer getCmregamount();
	
	/** 本月调剂金额 */
	public BigDecimal getCmregmoney();
	
	/** 本月核销数量 */
	public Integer getCmhavoamount();
	
	/** 本月核销金额 */
	public BigDecimal getCmhavomoney();
	
	/** 本月结存数量 */
	public Integer getCmsurplusamount();
	
	/** 本月结存金额 */
	public BigDecimal getCmsurplusmoney();
	
	/** 备注 */
	public String getRemark();
	

}
