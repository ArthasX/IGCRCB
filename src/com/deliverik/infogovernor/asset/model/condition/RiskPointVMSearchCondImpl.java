/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 风险点查询检索条件实现
  * 功能描述: 风险点查询检索条件实现
  * 创建记录: 2014/06/30
  * 修改记录: 
  */
public class RiskPointVMSearchCondImpl implements
		RiskPointVMSearchCond {
	/**风险名称*/
	protected String einame;
	
	/**风险级别*/
	protected String levels;
	
	/**风险等级*/
	protected String grad;
	
	/**管理人*/
	protected String mguserid;
	
	/**登记开始*/
	protected String startdate;
	
	/**等级结束*/
	protected String enddate;
	
	/**层次码*/
	protected String syscoding;
	/**风险标志*/
	protected String risksign;
	
	/**风险编号*/
	protected String eilabel;
	
	/**风险发生可能*/
	protected String poss;
	
	/**风险主键EIID*/
	protected String eiid;

	/**
	 * 风险主键EIID取得
	 * @return eiid 风险主键EIID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 风险主键EIID设定
	 * @param eiid 风险主键EIID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 管理人取得
	 * @return mguserid 管理人
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * 管理人设定
	 * @param mguserid 管理人
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}

	/**
	 * 登记开始取得
	 * @return startdate 登记开始
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * 登记开始设定
	 * @param startdate 登记开始
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/**
	 * 等级结束取得
	 * @return enddate 等级结束
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * 等级结束设定
	 * @param enddate 等级结束
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	/**
	 * 风险标志取得
	 * @return risksign 风险标志
	 */
	public String getRisksign() {
		return risksign;
	}

	/**
	 * 风险标志设定
	 * @param risksign 风险标志
	 */
	public void setRisksign(String risksign) {
		this.risksign = risksign;
	}

	/**
	 * 风险编号取得
	 * @return eilabel 风险编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 风险编号设定
	 * @param eilabel 风险编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 风险发生可能取得
	 * @return poss 风险发生可能
	 */
	public String getPoss() {
		return poss;
	}

	/**
	 * 风险发生可能设定
	 * @param poss 风险发生可能
	 */
	public void setPoss(String poss) {
		this.poss = poss;
	}

	/**
	 * 风险名称取得
	 * @return einame 风险名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 风险级别取得
	 * @return levels 风险级别
	 */
	public String getLevels() {
		return levels;
	}

	/**
	 * 风险等级取得
	 * @return grad 风险等级
	 */
	public String getGrad() {
		return grad;
	}


	/**
	 * 层次码取得
	 * @return syscoding 层次码
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * 风险名称设定
	 * @param einame 风险名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 风险级别设定
	 * @param levels 风险级别
	 */
	public void setLevels(String levels) {
		this.levels = levels;
	}

	/**
	 * 风险等级设定
	 * @param grad 风险等级
	 */
	public void setGrad(String grad) {
		this.grad = grad;
	}



	/**
	 * 层次码设定
	 * @param syscoding 层次码
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}
}