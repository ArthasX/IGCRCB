/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 检查项查询接口
  * 功能描述: 检查项查询接口
  * 创建记录: 2014/07/01
  * 修改记录: 
  */
public interface CheckItemVWInfo extends BaseModel {

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
	 * 资料调阅取得
	 *
	 * @return 资料调阅
	 */
	public String getDatady();

	/**
	 * 编号取得
	 *
	 * @return 编号
	 */
	public String getBh();

	/**
	 * 访谈对象取得
	 *
	 * @return 访谈对象
	 */
	public String getViewobj();

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
	 * 风险向名称取得
	 *
	 * @return 风险向名称
	 */
	public String getRiskitem();
	
	/**建议检查频度*/
	public String getCheckfrequency();
	
	/**
	 * 使用范围取得
	 * @return mgrange 使用范围
	 */
	public String getMgrange();
	/**
	 * 管理人id取得
	 * @return mguserid 管理人id
	 */
	public String getMguserid();

}