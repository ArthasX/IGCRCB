/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;

import java.math.BigDecimal;

import com.deliverik.framework.base.BaseModel;

/**
 * 
 * 物品信息实体接口
 *
 */
public interface Goods extends BaseModel {

	/**
	 * 物品信息ID取得
	 * @return 物品信息ID
	 */
	public Integer getGid();

	/**
	 * 物品种类取得
	 * @return 物品种类
	 */
	public String getGcategory();
	
	/**
	 * 物品种类名称取得
	 * @return 物品种类名称
	 */
	public String getGcategoryname();
	

	/**
	 * 物品名称取得
	 * @return 物品名称
	 */
	public String getGname();

	/**
	 * 物品编号取得
	 * @return 物品编号
	 */
	public String getGcode();

	/**
	 * 预警提示数量取得
	 * @return 预警提示数量
	 */
	public Integer getGwarningnum();

	/**
	 * 物品内部转移定价（%）取得
	 * @return 物品内部转移定价（%）
	 */
	public BigDecimal getGprice();

	/**
	 * 状态（0:停用 1:启用）取得
	 * @return 状态（0:停用 1:启用）
	 */
	public String getGstatus();
	
	/**
	 * 单位取得
	 * @return 单位
	 */
	public String getGunit();
	
	/**
	 * 原因
	 * @return 原因
	 */
	public String getGreason();
}
