/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 集成告警表接口
  * 功能描述: 集成告警表接口
  * 创建记录: 2014/06/21
  * 修改记录: 
  */
public interface IgalarmInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPk();

	/**
	 * 序号取得
	 *
	 * @return 序号
	 */
	public String getSerial();

	/**
	 * 主机名称取得
	 *
	 * @return 主机名称
	 */
	public String getAppname();

	/**
	 * IP地址取得
	 *
	 * @return IP地址
	 */
	public String getIpaddr();

	/**
	 * 事件等级取得
	 *
	 * @return 事件等级
	 */
	public String getSeverity();

	/**
	 * 事件内容取得
	 *
	 * @return 事件内容
	 */
	public String getSummary();

	/**
	 * 触发/恢复时间取得
	 *
	 * @return 触发/恢复时间
	 */
	public String getLasttime();

	/**
	 * 状态(0:未处理;1:已处理)取得
	 *
	 * @return 状态(0:未处理;1:已处理)
	 */
	public String getStatus();

	/**
	 * 事件单编号取得
	 *
	 * @return 事件单编号
	 */
	public String getPedeventid();
	
	/**
	 * 恢复时间取得
	 * @return recoveryTime  恢复时间
	 */
	public String getRecoveryTime();
	
	/**
	 * 描述取得
	 * @return description  描述
	 */
	public String getDescription();

	/**
	 * 是否生成工单取得 (1:是  0:否) 
	 * @return isCreateOrder  是否生成工单
	 */
	public String getIsCreateOrder();
	
	/**
	 * 故障联系人取得
	 * @return faultContact  故障联系人
	 */
	public String getFaultContact();
	
	/**
	 * 是否显示标识取得
	 * @return isShow  是否显示标识
	 */
	public String getIsShow();
	
	
	/**
	 * 最后一次告警时间取得
	 * @return prealarmtime 最后一次告警时间
	 */
	public String getPrealarmtime();
	
	/**
	 * 该告警发生的次数取得
	 * @return alarmcount 该告警发生的次数
	 */
	public Integer getAlarmcount();
	
	/**
	 * 应急演练屏蔽状态的标识取得
	 * @return
	 */
	public String getShieldflag();
	
	/**
	 * 应急演练屏蔽描述取得
	 * @return
	 */
	public String getShielddesc();
	
	
}