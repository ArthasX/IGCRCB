/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.condition;

/**
  * 概述: 集成告警表检索条件接口
  * 功能描述: 集成告警表检索条件接口
  * 创建记录: 2014/06/21
  * 修改记录: 
  */
public interface IgalarmSearchCond {
	/**
	 * 比对集成告警表序号 取得 
	 * @return 比对集成告警表序号
	 */
	public String getSerial();
	
	/**
	 * 比对集成告警表开始时间 取得 
	 * @return 比对集成告警表开始时间
	 */
	public String getStartDate();

	/**
	 * 比对集成告警表结束时间 取得 
	 * @return 比对集成告警表结束时间
	 */
	public String getEndDate();

	/**
	 * 比对集成告警表主机名称 取得 
	 * @return 比对集成告警表主机名称
	 */
	public String getAppname();

	/**
	 * 比对集成告警表事件内容 取得 
	 * @return 比对集成告警表事件内容
	 */
	public String getSummary();

	/**
	 * 比对集成告警表id组 取得 
	 * @return 比对集成告警表id组
	 */
	public String[] getAlarmIds();
	
	/**
	 * 状态(0:告警;1:恢复;2:关闭)取得
	 * @return status  状态(0:告警;1:恢复;2:关闭)
	 */
	public String getStatus();
	
	/**
	 * 触发/恢复时间取得
	 *
	 * @return 触发/恢复时间
	 */
	public String getLasttime();
	
	/**
	 * 是否显示标识(0显示，1不显示)取得
	 * @return isShow  是否显示标识
	 */
	public String getIsShow();
	
	/**
	 * 事件单编号取得
	 *
	 * @return 事件单编号
	 */
	public String getPedeventid();
	
	public String getIpaddr();

	public String getShieldflag();
	
	/**
	 * 触发时间排序状态码(1为降序 2为升序)取得
	 * 
	 * @return 触发时间排序状态码(1为降序 2为升序)
	 */
	public String getLasttimestatus();
	
	/**
	 * ip地址排序状态码(1为降序 2为升序)取得
	 * 
	 * @return ip地址排序状态码(1为降序 2为升序)
	 */
	public String getIpaddrstatus();
	
	/**
	 * 主机名称排序状态码(1为降序 2为升序)取得
	 * 
	 * @return 主机名称排序状态码
	 */
	public String getAppnamestatus();
	
	/**
	 * 恢复时间排序状态码(1为降序 2为升序)取得
	 * 
	 * @return 恢复时间排序状态码(1为降序 2为升序)
	 */
	public String getRecoverytimestatus();
	
	
	
	
	
}