/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 变更流程接口
  * 功能描述: 变更流程接口
  * 创建记录: 2015/01/04
  * 修改记录: 
  */
public interface ChangeProcessVWInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPrid();

	/**
	 * 工单号取得
	 * @return the prserialnum
	 */
	public String getPrserialnum();
	
	/**
	 * 工单说明取得
	 * @return the prdesc
	 */
	public String getPrdesc();
	
	/**
	 * 流程状态取得
	 *
	 * @return 流程状态
	 */
	public String getPrstatus();

	/**
	 * 流程名称取得
	 *
	 * @return 流程名称
	 */
	public String getPrtitle();

	/**
	 * 流程开始时间取得
	 *
	 * @return 流程开始时间
	 */
	public String getPropentime();

	/**
	 * 流程关闭时间取得
	 *
	 * @return 流程关闭时间
	 */
	public String getPrclosetime();

	/**
	 * 流程发起人取得
	 * @return the prusername
	 */
	public String getPrusername();
	
	/**
	 * 变更分类取得
	 *
	 * @return 变更分类
	 */
	public String getChangeclassify();

	/**
	 * 更新平台取得
	 *
	 * @return 更新平台
	 */
	public String getUpdateplatform();

	/**
	 * 变更类型取得
	 *
	 * @return 变更类型
	 */
	public String getChangetype();

	/**
	 * 变更原因取得
	 *
	 * @return 变更原因
	 */
	public String getChangereason();

	/**
	 * 变更类别取得
	 *
	 * @return 变更类别
	 */
	public String getChangecategory();

	/**
	 * 业务影响范围取得
	 *
	 * @return 业务影响范围
	 */
	public String getBusinessscope();

	/**
	 * 是否影响业务取得
	 *
	 * @return 是否影响业务
	 */
	public String getIsinfluence();

	/**
	 * 变更内容取得
	 *
	 * @return 变更内容
	 */
	public String getChangecontent();

	/**
	 * 流程状态名称取得
	 *
	 * @return 流程状态名称
	 */
	public String getOrderstatus();

}