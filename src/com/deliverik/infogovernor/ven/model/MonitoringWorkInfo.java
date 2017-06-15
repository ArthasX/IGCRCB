/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;

/**
  * 概述: 监测工作填报表接口
  * 功能描述: 监测工作填报表接口
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public interface MonitoringWorkInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getMwid();

	/**
	 * 风险监测主键id取得
	 *
	 * @return 风险监测主键id
	 */
	public Integer getRmid();

	/**
	 * 风险指标id取得
	 *
	 * @return 风险指标id
	 */
	public Integer getRiid();

	/**
	 * 监测结果取得
	 *
	 * @return 监测结果
	 */
	public String getResult();

	/**
	 * 结果说明取得
	 *
	 * @return 结果说明
	 */
	public String getResultdesc();

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getMwattachkey();

	/**
	 * 风险指标信息取得
	 * @return riskIndexSearchVWInfo  风险指标信息
	 */
	public RiskIndexSearchVWInfo getRiskIndexSearchVWInfo();
	
	/**
	 * 指派工作流程id取得
	 * @return the assignprid
	 */
	public Integer getAssignprid();
}