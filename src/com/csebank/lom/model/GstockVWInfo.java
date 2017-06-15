/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model;


/**
 * 
 * 库存预警信息视图实体接口
 *
 */
public interface GstockVWInfo {

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
	public Double getGprice();

	/**
	 * 状态（0:停用 1:启用）取得
	 * @return 状态（0:停用 1:启用）
	 */
	public String getGstatus();

	
	/**
	 * 物品库存信息ID取得
	 * @return 物品库存信息ID
	 */
	public Integer getGsid();
	
	/**
	 * 总数量取得
	 * @return 总数量
	 */
	public Integer getGsnum();
	/**
	 * 所属机构层次码取得
	 * @return 所属机构层次码
	 */
	public String getGsorg();
	/**
	 * 采购平均价取得
	 * @return 采购平均价
	 */
	public String getGsavgprice();
	/**
	 * 冻结数量取得
	 * @return 冻结数量
	 */
	public Integer getGsfreezenum();

}
