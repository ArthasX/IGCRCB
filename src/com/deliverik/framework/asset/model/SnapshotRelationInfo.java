/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 快照关系表接口
  * 功能描述: 快照关系表接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SnapshotRelationInfo extends BaseModel {

	/**
	 * 逻辑主键取得
	 *
	 * @return 逻辑主键
	 */
	public Integer getSrid();

	/**
	 * DomainID取得
	 *
	 * @return DomainID
	 */
	public Integer getSrdomainid();

	/**
	 * 扩展算法类型取得
	 *
	 * @return 扩展算法类型
	 */
	public String getSrarithmetictype();

	/**
	 * Domain版本取得
	 *
	 * @return Domain版本
	 */
	public Integer getSrdomainversion();

	/**
	 * 源资产ID取得
	 *
	 * @return 源资产ID
	 */
	public Integer getSrpareiid();

	/**
	 * 源资产大版本取得
	 *
	 * @return 源资产大版本
	 */
	public Integer getSrparversion();

	/**
	 * 源资产小版本取得
	 *
	 * @return 源资产小版本
	 */
	public Integer getSrparsmallversion();

	/**
	 * 目的资产ID取得
	 *
	 * @return 目的资产ID
	 */
	public Integer getSrcldeiid();

	/**
	 * 目的资产大版本取得
	 *
	 * @return 目的资产大版本
	 */
	public Integer getSrcldversion();

	/**
	 * 目的资产小版本取得
	 *
	 * @return 目的资产小版本
	 */
	public Integer getSrcldsmallversion();

	/**
	 * 关系类型（物理/逻辑）取得
	 *
	 * @return 关系类型（物理/逻辑）
	 */
	public String getSrtype();

	/**
	 * 关系说明取得
	 *
	 * @return 关系说明
	 */
	public String getSrdes();

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getSrcreatetime();

	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag();

	/**
	 * 关联关系码取得
	 *
	 * @return 关联关系码
	 */
	public String getSrraletioncode();

	/**
	 * 资产关系项取得
	 *
	 * @return 资产关系项
	 */
	public String getSrassetrelation();
	
	/**
	 * 资产(正向)信息取得
	 * @return 资产(正向)信息
	 */
	public IG749Info getParEntityItemVW();
	
	/**
	 * 资产(反向)信息取得
	 * @return 资产(反向)信息
	 */
	public IG749Info getCldEntityItemVW();

}