/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: CI变更资产表接口
  * 功能描述: CI变更资产表接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface CIEntityItemInfo extends BaseModel {

	/**
	 * 资产ID取得
	 *
	 * @return 资产ID
	 */
	public Integer getEiid();

	/**
	 * 资产模型ID取得
	 *
	 * @return 资产模型ID
	 */
	public Integer getEid();

	/**
	 * 资产说明取得
	 *
	 * @return 资产说明
	 */
	public String getEidesc();

	/**
	 * 资产名称取得
	 *
	 * @return 资产名称
	 */
	public String getEiname();

	/**
	 * 资产编号取得
	 *
	 * @return 资产编号
	 */
	public String getEilabel();

	/**
	 * 资产登记日取得
	 *
	 * @return 资产登记日
	 */
	public String getEiinsdate();

	/**
	 * 资产所属机构层次码取得
	 *
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding();

	/**
	 * 资产模型层次码取得
	 *
	 * @return 资产模型层次码
	 */
	public String getEsyscoding();

	/**
	 * 资产更新时间取得
	 *
	 * @return 资产更新时间
	 */
	public String getEiupdtime();

	/**
	 * 资产状态取得
	 *
	 * @return 资产状态
	 */
	public String getEistatus();

	/**
	 * 资产管理人取得
	 *
	 * @return 资产管理人
	 */
	public String getEiuserid();

	/**
	 * 资产管理人姓名取得
	 *
	 * @return 资产管理人姓名
	 */
	public String getEiusername();

	/**
	 * 顶级CI标识取得
	 *
	 * @return 顶级CI标识
	 */
	public Integer getEirootmark();
	
	/**
	 * 大版本取得
	 * @return 大版本
	 */
	public Integer getEiversion();
	
	/**
	 * 小版本取得
	 * @return 小版本
	 */
	public Integer getEismallversion();

}