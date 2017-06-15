/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import java.io.Serializable;

/**
  * 概述: 合同资产信息视图接口
  * 功能描述: 合同资产信息视图接口
  * 创建记录: 2012/04/10
  * 修改记录: 
  */
public interface IG499Info extends Serializable{

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
	 * 资产变更时间取得
	 *
	 * @return 资产变更时间
	 */
	public String getEiupdtime();

	/**
	 * 资产状态取得
	 *
	 * @return 资产状态
	 */
	public String getEistatus();

	/**
	 * 资产模型名称取得
	 *
	 * @return 资产模型名称
	 */
	public String getEname();

	/**
	 * 资产模型编号取得
	 *
	 * @return 资产模型编号
	 */
	public String getElabel();

	/**
	 * 资产模型说明取得
	 *
	 * @return 资产模型说明
	 */
	public String getEdesc();

	/**
	 * 资产模型状态取得
	 *
	 * @return 资产模型状态
	 */
	public String getEstatus();

	/**
	 * 资产模型分类取得
	 *
	 * @return 资产模型分类
	 */
	public String getEcategory();

	/**
	 * 资产模型一级子类取得
	 *
	 * @return 资产模型一级子类
	 */
	public String getEkey1();

	/**
	 * 资产模型二级子类取得
	 *
	 * @return 资产模型二级子类
	 */
	public String getEkey2();

	/**
	 * 资产模型三级子类取得
	 *
	 * @return 资产模型三级子类
	 */
	public String getEkey3();

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
	 * 资产所属机构取得
	 *
	 * @return 资产所属机构
	 */
	public String getEiorgsyscoding();

	/**
	 * 资产模型取得
	 *
	 * @return 资产模型
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
	 * 服务商取得
	 *
	 * @return 服务商
	 */
	public String getFacilitator();

	/**
	 * 签订时间取得
	 *
	 * @return 签订时间
	 */
	public String getCondudetime();

	/**
	 * 经手人取得
	 *
	 * @return 经手人
	 */
	public String getOperator();

	/**
	 * 合同类别取得
	 *
	 * @return 合同类别
	 */
	public String getCompacttype();

	/**
	 * 合同款取得
	 *
	 * @return 合同款
	 */
	public String getContractpayment();

	/**
	 * 已付款取得
	 *
	 * @return 已付款
	 */
	public String getCountmoney();

	/**
	 * 最后付款日取得
	 *
	 * @return 最后付款日
	 */
	public String getLastdatetime();
	
	/**
	 * 本期预付款取得
	 * @return 本期预付款
	 */
	public String getImprest();

}