/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
  * 概述: 检查策略检索条件接口
  * 功能描述: 检查策略检索条件接口
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
public interface CheckStrategySearchCond {

	
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCsid();

	/**
	 * 检查名称取得
	 *
	 * @return 检查名称
	 */
	public String getCsname();

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getCsdesc();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getCsstatus();

	/**
	 * 开始日期取得
	 *
	 * @return 开始日期
	 */
	public String getCsstartdate();

	/**
	 * 结束日期取得
	 *
	 * @return 结束日期
	 */
	public String getCsenddate();

	/**
	 * 频率取得
	 *
	 * @return 频率
	 */
	public String getCsfrequency();

	/**
	 * 策略执行表达式取得
	 *
	 * @return 策略执行表达式
	 */
	public String getCscron();

	/**
	 * 责任人ID取得
	 *
	 * @return 责任人ID
	 */
	public String getCsuserid();

	/**
	 * 责任人姓名取得
	 *
	 * @return 责任人姓名
	 */
	public String getCsusername();

	/**
	 * 责任组角色ID取得
	 *
	 * @return 责任组角色ID
	 */
	public String getCsroleid();

	/**
	 * 责任组角色名称取得
	 *
	 * @return 责任组角色名称
	 */
	public String getCsrolename();

	/**
	 * 合作责任人id取得
	 *
	 * @return 合作责任人id
	 */
	public String getCsasset();

	/**
	 * 合作责任人姓名取得
	 *
	 * @return 合作责任人姓名
	 */
	public String getCsassetname();

	/**
	 * 附件取得
	 *
	 * @return 附件
	 */
	public String getCsattch ();

	/**
	 * 选项取得
	 *
	 * @return 选项
	 */
	public String getCsoption ();
	
	public String getCstype();
	
	public String getCsrtestmode();
	
	public String getCsassetorgname();
	
	public String getCsassetorgid();
}