/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 风险指标查询检索条件接口
  * 功能描述: 风险指标查询检索条件接口
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public interface RiskIndexSearchVWSearchCond {
	
	/**
	 * 指标名称 取得
	 */
	public String getEiname();
	
	/**
	 * 指标编号 取得
	 */
	public String getEilabel() ;
	
	/**
	 * 指标分类取得
	 */
	public String getSyscoding();
	
	/**
	 * 指标用途取得
	 */
	public String getIndexused();
	
	/**
	 * 阀值取得
	 */
	public String getZbfz();
	
	/**
	 * 指标责任人取得
	 */
	public String getDutyuser();
	
	/**
	 * 指标责任部门 取得
	 */
	public String getDutydepartment();
	
	/**
	 * 是否关键指标 取得
	 */
	public String getKeyindex();
	
	/**
	 * 指标管理人 取得
	 */
	public String getMguserid();
	
	/**
	 * 登记日期 从时间取得
	 */
	public String getEiStartDate();

	/**
	 * 登记日期 到时见取得
	 */
	public String getEiEndDate();

	/**
	 * 更新时间 从时间取得
	 */
	public String getEuStartDate();

	/**
	 * 更新时间 到时间取得
	 */
	public String getEuEndDate();

	
	/**
	 * 指标主键EIID 取得
	 */
	public String getEiid();

	/**
	 *  eiid排除集合获取
	 * @return the eiid_NotIn
	 */
	public String getEiid_NotIn();
	
	/**
	 * eiid集合获取
	 * @return eiid_In
	 */
	public String getEiid_In();
}