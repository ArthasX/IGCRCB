/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 风险点查询接口
  * 功能描述: 风险点查询接口
  * 创建记录: 2014/06/30
  * 修改记录: 
  */
public interface RiskPointVMInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEiid();

	/**
	 * 资产模型ID取得
	 *
	 * @return 资产模型ID
	 */
	public String getEid();

	/**
	 * 资产名称取得
	 *
	 * @return 资产名称
	 */
	public String getEiname();

	/**
	 * 资产说明取得
	 *
	 * @return 资产说明
	 */
	public String getEidesc();

	/**
	 * 资产编号取得
	 *
	 * @return 资产编号
	 */
	public String getEilabel();

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
	 * 资产版本号取得
	 *
	 * @return 资产版本号
	 */
	public Integer getEiversion();

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
	 * 资产小版本取得
	 *
	 * @return 资产小版本
	 */
	public Integer getEismallversion();

	/**
	 * 资产所属树根节点实体标识取得
	 *
	 * @return 资产所属树根节点实体标识
	 */
	public Integer getEirootmark();

	/**
	 * 资产管理人取得
	 *
	 * @return 资产管理人
	 */
	public String getManagername();

	/**
	 * 级别取得
	 *
	 * @return 级别
	 */
	public String getLevels();

	/**
	 * 等级取得
	 *
	 * @return 等级
	 */
	public String getGrad();

	/**
	 * 风险领域名称取得
	 *
	 * @return 风险领域名称
	 */
	public String getRiskly();

	/**
	 * 风险子域名称取得
	 *
	 * @return 风险子域名称
	 */
	public String getRiskarea();

	/**
	 * 风险项称取得
	 *
	 * @return 风险项称
	 */
	public String getRiskitem();

	/**
	 * 风险点说明取得
	 */
	public String getBh(); 
	/**
	 * 可能性取得
	 * @return poss 可能性
	 */
	public String getPoss();
	/**
	 * 管理人名字取得
	 * @return mguserid 管理人名字
	 */
	public String getMguserid();
	/**
	 * 风险点标志取得
	 * @return risksign 风险点标志
	 */
	public String getRisksign();

}