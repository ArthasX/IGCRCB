/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 检查项查询检索条件接口
  * 功能描述: 检查项查询检索条件接口
  * 创建记录: 2014/07/01
  * 修改记录: 
  */
public interface CheckItemVWSearchCond {
	/**
	 * 风险名称取得
	 * @return einame 风险名称
	 */
	public String getEiname();

	/**
	 * 资料调阅取得
	 * @return datady 资料调阅
	 */
	public String getDatady();

	/**
	 * 访谈对象取得
	 * @return viewobj 访谈对象
	 */
	public String getViewobj();

	/**
	 * 管理人取得
	 * @return managername 管理人
	 */
	public String getManagername();

	/**
	 * eIINSDATE取得
	 * @return eIINSDATE eIINSDATE
	 */
	public String getEIINSDATE();

	/**
	 * 层次码取得
	 * @return syscoding 层次码
	 */
	public String getSyscoding();
	
	/**编号*/
	public String getBh();
	/**
	 * 开始日期取得
	 * @return startdate 开始日期
	 */
	public String getStartdate();
	/**
	 * 结束日期取得
	 * @return enddate 结束日期
	 */
	public String getEnddate();
	
	/**
	 * 检查频度取得
	 * @return checkfrequency 检查频度
	 */
	public String getCheckfrequency();
	
	/**
	 * 检查项主属性ID取得
	 * @return eiid 检查项主属性ID
	 */
	public String getEiid();
	
	public String getEiid_NotIn();
	
}