/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 风险点查询检索条件接口
  * 功能描述: 风险点查询检索条件接口
  * 创建记录: 2014/06/30
  * 修改记录: 
  */
public interface RiskPointVMSearchCond {
	/**
	 * 风险名称取得
	 */
	public String getEiname();

	/**
	 * 风险级别取得
	 */
	public String getLevels();

	/**
	 * 风险等级取得*/
	public String getGrad() ;



	/**
	 * 层次码取得
	 */
	public String getSyscoding();
	
	/**
	 * 管理人取得
	 * @return mguserid 管理人
	 */
	public String getMguserid();
	/**
	 * 登记开始取得
	 * @return startdate 登记开始
	 */
	public String getStartdate();

	/**
	 * 等级结束取得
	 * @return enddate 等级结束
	 */
	public String getEnddate();
	/**
	 * 风险标志取得
	 * @return risksign 风险标志
	 */
	public String getRisksign();
	/**
	 * 风险编号取得
	 * @return eilabel 风险编号
	 */
	public String getEilabel();
	/**
	 * 风险发生可能取得
	 * @return poss 风险发生可能
	 */
	public String getPoss();
	/**
	 * 风险主键EIID取得
	 * @return eiid 风险主键EIID
	 */
	public String getEiid();
}