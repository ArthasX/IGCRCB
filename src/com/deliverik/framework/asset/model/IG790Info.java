package com.deliverik.framework.asset.model;

/**
 * 机房机柜设备统计分析信息
 * 
 *
 */
public interface IG790Info {
	/**
	 * 机房ID取得
	 * @return 机房ID
	 */
	public String getRoom_id();
	
	/**
	 * 机房名称取得
	 * @return 机房名称
	 */

	public String getRoom_name();

	/**
	 * 机柜ID取得
	 * @return 机柜ID
	 */

	public String getContainer_id();

	/**
	 * 机柜名称取得
	 * @return 机柜名称
	 */

	public String getContainer_name();

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid();

	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname();

	/**
	 * 资产编号取得
	 * @return 资产编号
	 */

	public String getEilabel();
	
	/**
	 * 资产在机柜中位置取得
	 * @return 资产在机柜中位置
	 */
	public String getPosition();
	
	/**
	 * 资产型号取得
	 * @return 资产型号
	 */
	
	public String getModel();	
	
}