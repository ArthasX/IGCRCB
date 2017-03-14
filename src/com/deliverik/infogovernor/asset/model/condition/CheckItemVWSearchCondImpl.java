/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 检查项查询检索条件实现
  * 功能描述: 检查项查询检索条件实现
  * 创建记录: 2014/07/01
  * 修改记录: 
  */
public class CheckItemVWSearchCondImpl implements
		CheckItemVWSearchCond {

	/**风险名称*/
	protected String einame;
	
	/**资料调阅*/
	protected String datady;
	
	/**访谈对象*/
	protected String viewobj;
	
	/**管理人*/
	protected String managername;
	
	/**编号*/
	protected String bh;
	
	/**开始日期*/
	protected String startdate;
	/**结束日期 */
	protected String enddate;
	
	/**检查频度*/
	protected String checkfrequency;
	
	/**检查项主属性ID*/
	protected String eiid;
	
	protected String eiid_NotIn;
	
	/**
	 * 检查项主属性ID取得
	 * @return eiid 检查项主属性ID
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * 检查项主属性ID设定
	 * @param eiid 检查项主属性ID
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * 检查频度取得
	 * @return checkfrequency 检查频度
	 */
	public String getCheckfrequency() {
		return checkfrequency;
	}

	/**
	 * 检查频度设定
	 * @param checkfrequency 检查频度
	 */
	public void setCheckfrequency(String checkfrequency) {
		this.checkfrequency = checkfrequency;
	}

	/**
	 * 开始日期取得
	 * @return startdate 开始日期
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * 开始日期设定
	 * @param startdate 开始日期
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/**
	 * 结束日期取得
	 * @return enddate 结束日期
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * 结束日期设定
	 * @param enddate 结束日期
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	/**
	 * 编号取得
	 * @return bh 编号
	 */
	public String getBh() {
		return bh;
	}

	/**
	 * 编号设定
	 * @param bh 编号
	 */
	public void setBh(String bh) {
		this.bh = bh;
	}

	/**
	 * 风险名称设定
	 * @param einame 风险名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 资料调阅设定
	 * @param datady 资料调阅
	 */
	public void setDatady(String datady) {
		this.datady = datady;
	}

	/**
	 * 访谈对象设定
	 * @param viewobj 访谈对象
	 */
	public void setViewobj(String viewobj) {
		this.viewobj = viewobj;
	}

	/**
	 * 管理人设定
	 * @param managername 管理人
	 */
	public void setManagername(String managername) {
		this.managername = managername;
	}

	/**
	 * eIINSDATE设定
	 * @param eIINSDATE eIINSDATE
	 */
	public void setEIINSDATE(String eIINSDATE) {
		EIINSDATE = eIINSDATE;
	}

	/**
	 * 层次码设定
	 * @param syscoding 层次码
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**登记日*/
	protected String EIINSDATE;
	
	/**层次码*/
	protected String syscoding;

	/**
	 * 风险名称取得
	 * @return einame 风险名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 资料调阅取得
	 * @return datady 资料调阅
	 */
	public String getDatady() {
		return datady;
	}

	/**
	 * 访谈对象取得
	 * @return viewobj 访谈对象
	 */
	public String getViewobj() {
		return viewobj;
	}

	/**
	 * 管理人取得
	 * @return managername 管理人
	 */
	public String getManagername() {
		return managername;
	}

	/**
	 * eIINSDATE取得
	 * @return eIINSDATE eIINSDATE
	 */
	public String getEIINSDATE() {
		return EIINSDATE;
	}

	/**
	 * 层次码取得
	 * @return syscoding 层次码
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * @return the eiid_NotIn
	 */
	public String getEiid_NotIn() {
		return eiid_NotIn;
	}

	/**
	 * @param eiid_NotIn the eiid_NotIn to set
	 */
	public void setEiid_NotIn(String eiid_NotIn) {
		this.eiid_NotIn = eiid_NotIn;
	}


	
	
}