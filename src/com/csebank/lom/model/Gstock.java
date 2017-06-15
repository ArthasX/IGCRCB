/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 物品接口
 * 
 */
public interface Gstock extends BaseModel {

	/** 物品主键ID取得 */
	public Integer getGsid();

	/** 物品种类取得 */
	public String getGscategory();

	/** 物品名称取得 */
	public String getGsname();

	/** 物品编号取得 */
	public String getGscode();

	/** 总数量取得 */
	public Integer getGsnum();

	/** 所属机构层次码取得 */
	public String getGsorg();

	/** 采购平均价取得 */
	public BigDecimal getGsavgprice();

	/** 冻结数量取得 */
	public Integer getGsfreezenum();
	
	/** 最后一次更新人姓名 */
	public String getGsuserid();
	
	/** 最后一次更新时间 */
	public String getGsusername();
	
	/** 记录版本标识 */
	public String getGsdate();
}
