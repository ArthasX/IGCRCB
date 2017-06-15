/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.asset.model.entity.IG749VW;
import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 配置所属关系表接口
  * 功能描述: 配置所属关系表接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface EiBelongRelationInfo extends BaseModel {

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getBrid();

	/**
	 * 源资产ID取得
	 *
	 * @return 源资产ID
	 */
	public Integer getBrpareiid();

	/**
	 * 源资产大版本取得
	 *
	 * @return 源资产大版本
	 */
	public Integer getBrparversion();

	/**
	 * 源资产小版本取得
	 *
	 * @return 源资产小版本
	 */
	public Integer getBrparsmallversion();

	/**
	 * 目的资产ID取得
	 *
	 * @return 目的资产ID
	 */
	public Integer getBrcldeiid();

	/**
	 * 目的资产大版本取得
	 *
	 * @return 目的资产大版本
	 */
	public Integer getBrcldversion();

	/**
	 * 目的资产小版本取得
	 *
	 * @return 目的资产小版本
	 */
	public Integer getBrcldsmallversion();

	/**
	 * 关系类型（物理/逻辑）取得
	 *
	 * @return 关系类型（物理/逻辑）
	 */
	public String getBrtype();

	/**
	 * 关系说明取得
	 *
	 * @return 关系说明
	 */
	public String getBrdes();

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getBrcreatetime();

	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag();
	
	/**
	 * 源资产取得
	 *
	 * @return 源资产
	 */
	public IG749VW getParEntityItemVW();
	
	/**
	 * 目的资产取得
	 *
	 * @return 目的资产
	 */
	public IG749VW getCldEntityItemVW();
	
	/**
	 * 关联关系码取得
	 *
	 * @return 关联关系码
	 */
	public String getBrraletioncode();
	
	/**
	 * 资产关系项取得
	 *
	 * @return 资产关系项
	 */
	public String getBrassetrelation();
	
	/**
	 * 资产所属树根节点实体标识取得
	 * @return 资产所属树根节点实体标识
	 */
	public Integer getEirootmark();

}