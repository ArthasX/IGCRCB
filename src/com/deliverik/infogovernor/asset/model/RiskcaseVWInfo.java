/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 风险事件接口
  * 功能描述: 风险事件接口
  * 创建记录: 2014/07/18
  * 修改记录: 
  */
public interface RiskcaseVWInfo extends BaseModel {

	/**
	 * 资产ID取得
	 *
	 * @return 资产ID
	 */
	public Integer getEIID();

	/**
	 * 风险事件名称取得
	 *
	 * @return 风险事件名称
	 */
	public String getFcname();

	/**
	 * 风险事件描述取得
	 *
	 * @return 风险事件描述
	 */
	public String getFcdesc();

	/**
	 * 风险事件状态取得
	 *
	 * @return 风险事件状态
	 */
	public String getEISTATUS();

	/**
	 * 风险点名称取得
	 *
	 * @return 风险点名称
	 */
	public String getFcriskname();

	/**
	 * 风险点ID 取得
	 *
	 * @return 风险点ID 
	 */
	public String getRiskid();

	/**
	 * 风险事件来源取得
	 *
	 * @return 风险事件来源
	 */
	public String getFcorigin();

	/**
	 * 风险事件所属领域取得
	 *
	 * @return 风险事件所属领域
	 */
	public String getFccategory();

	/**
	 * 相关评估工作ID 取得
	 *
	 * @return 相关评估工作ID 
	 */
	public String getRiskjobid();

	/**
	 * 风险点分类ID取得
	 *
	 * @return 风险点分类ID
	 */
	public String getRisktype();

	/**
	 * 风险严重级别名称取得
	 *
	 * @return 风险严重级别名称
	 */
	public String getFcseveritylevel();

	/**
	 * 风险发生可能性名称取得
	 *
	 * @return 风险发生可能性名称
	 */
	public String getFcpossibility();

	/**
	 * 风险级别名称取得
	 *
	 * @return 风险级别名称
	 */
	public String getFclevel();

	/**
	 * 风险识别时间取得
	 *
	 * @return 风险识别时间
	 */
	public String getRiskcatchtime();

	/**
	 * 应对任务名称取得
	 *
	 * @return 应对任务名称
	 */
	public String getFcrisktask();

	/**
	 * 应对任务描述取得
	 *
	 * @return 应对任务描述
	 */
	public String getFcrisktaskdesc();

	/**
	 * 应对策略取得
	 *
	 * @return 应对策略
	 */
	public String getFcpolicy();

	/**
	 * 应对目标 取得
	 *
	 * @return 应对目标 
	 */
	public String getFcoperatoraim();

	/**
	 * 应对部门ID取得
	 *
	 * @return 应对部门ID
	 */
	public String getRiskoperatordept();

	/**
	 * 应对部门取得
	 *
	 * @return 应对部门
	 */
	public String getFcoperatordept();

	/**
	 * 应对负责人ID取得
	 *
	 * @return 应对负责人ID
	 */
	public String getRiskoperator();

	/**
	 * 应对负责人取得
	 *
	 * @return 应对负责人
	 */
	public String getFcoperator();

	/**
	 * 抄送风控人员ID取得
	 *
	 * @return 抄送风控人员ID
	 */
	public String getRiskccoperator();

	/**
	 * 抄送风控人员取得
	 *
	 * @return 抄送风控人员
	 */
	public String getFcccoperator();

	/**
	 * 评审结果取得
	 *
	 * @return 评审结果
	 */
	public String getRiskreviewresult();
	
	/**
	 * 相关问题整改ID
	 *
	 * @return 相关问题整改ID
	 */
	public String getRiskdealid();
	
	/**
	 * 版本取得
	 * @return version 版本
	 */
	public String getVersion();

}