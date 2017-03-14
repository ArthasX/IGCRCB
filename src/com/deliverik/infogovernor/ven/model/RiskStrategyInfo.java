/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 风险策略表接口
  * 功能描述: 风险策略表接口
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public interface RiskStrategyInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRsid();

	/**
	 * 风险策略名称取得
	 *
	 * @return 风险策略名称
	 */
	public String getRsname();

	/**
	 * 风险策略描述取得
	 *
	 * @return 风险策略描述
	 */
	public String getRsdesc();

	/**
	 * 策略开始时间取得
	 *
	 * @return 策略开始时间
	 */
	public String getRsstartdate();

	/**
	 * 策略结束时间取得
	 *
	 * @return 策略结束时间
	 */
	public String getRsenddate();

	/**
	 * 状态(1.启用2.停用)取得
	 *
	 * @return 状态(1.启用2.停用)
	 */
	public String getRsstatus();

	/**
	 * 风险监测频率取得
	 *
	 * @return 风险监测频率
	 */
	public String getRsfrequency();

	/**
	 * 风险检查频率内容取得
	 *
	 * @return 风险检查频率内容
	 */
	public String getRsfrequencydesc();

	/**
	 * 风险策略指标关系表id取得
	 *
	 * @return 风险策略指标关系表id
	 */
	public Integer getSirid();

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getRsattachkey();

}