package com.deliverik.infogovernor.risk.form;

import com.deliverik.framework.base.BaseForm;

public class IGRIS0614Form extends BaseForm{

	private static final long serialVersionUID = 1L;

	/**风险名称*/
	protected String einame;
	
	/**资料调阅*/
	protected String datady;
	
	/**访谈对象*/
	protected String viewobj;
	
	/**管理人*/
	protected String managername;
	
	/**登记日*/
	protected String EIINSDATE;
	
	/**层次码*/
	protected String syscoding;
	
	/**层次名*/
	protected String ename;
	
	/**管理人ID*/
	protected String mguserid;
	
	/**编号*/
	protected  String eilabel;
	
	/**检查频度*/
	protected String checkfrequency;
	
	/** 删除检查项对象 */
	protected String[] deleteEiid;
	
	protected String eiids;
	
	protected String eiversions;
	
	/**
	 * 删除检查项对象取得
	 * @return deleteEiid 删除检查项对象
	 */
	public String[] getDeleteEiid() {
		return deleteEiid;
	}

	/**
	 * 删除检查项对象设定
	 * @param deleteEiid 删除检查项对象
	 */
	public void setDeleteEiid(String[] deleteEiid) {
		this.deleteEiid = deleteEiid;
	}

	/**
	 * 管理人ID取得
	 * @return mguserid 管理人ID
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * 管理人ID设定
	 * @param mguserid 管理人ID
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
	}
	

	/**
	 * 编号取得
	 * @return eilabel 编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 编号设定
	 * @param eilabel 编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
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
	 * @return the eiids
	 */
	public String getEiids() {
		return eiids;
	}

	/**
	 * @param eiids the eiids to set
	 */
	public void setEiids(String eiids) {
		this.eiids = eiids;
	}

	/**
	 * @return the eiversions
	 */
	public String getEiversions() {
		return eiversions;
	}

	/**
	 * @param eiversions the eiversions to set
	 */
	public void setEiversions(String eiversions) {
		this.eiversions = eiversions;
	}


	/**开始日期*/
	protected String startdate;
	
	/**结束日期*/
	protected String enddate;

	/**
	 * 风险名称取得
	 * @return einame 风险名称
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * 风险名称设定
	 * @param einame 风险名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 资料调阅取得
	 * @return datady 资料调阅
	 */
	public String getDatady() {
		return datady;
	}

	/**
	 * 资料调阅设定
	 * @param datady 资料调阅
	 */
	public void setDatady(String datady) {
		this.datady = datady;
	}

	/**
	 * 访谈对象取得
	 * @return viewobj 访谈对象
	 */
	public String getViewobj() {
		return viewobj;
	}

	/**
	 * 访谈对象设定
	 * @param viewobj 访谈对象
	 */
	public void setViewobj(String viewobj) {
		this.viewobj = viewobj;
	}

	/**
	 * 管理人取得
	 * @return managername 管理人
	 */
	public String getManagername() {
		return managername;
	}

	/**
	 * 管理人设定
	 * @param managername 管理人
	 */
	public void setManagername(String managername) {
		this.managername = managername;
	}

	/**
	 * eIINSDATE取得
	 * @return eIINSDATE eIINSDATE
	 */
	public String getEIINSDATE() {
		return EIINSDATE;
	}

	/**
	 * eIINSDATE设定
	 * @param eIINSDATE eIINSDATE
	 */
	public void setEIINSDATE(String eIINSDATE) {
		EIINSDATE = eIINSDATE;
	}

	/**
	 * 层次码取得
	 * @return syscoding 层次码
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * 层次码设定
	 * @param syscoding 层次码
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * 层次名取得
	 * @return ename 层次名
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 层次名设定
	 * @param ename 层次名
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}
}
