package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGASM2713Form extends BaseForm{

	/**风险名称*/
	protected String einame;
	
	/**风险级别*/
	protected String levels;
	
	/**风险等级*/
	protected String grad;
	
	/**管理人*/
	protected String managername;
	
	/**登记日*/
	protected String EIINSDATE;
	
	/**层次码*/
	protected String syscoding;
	
	/**层次名*/
	protected String ename;
	
	/**编号*/
	protected  String eilabel;
	/** 删除检查项对象 */
	protected String[] deleteEiid;
	
	/**可能性*/
	protected String poss;
	/**管理人id*/
	protected String mguserid;
	/**风险标志*/
	protected String risksign;
	/**开始时间*/
	protected String startdate;
	/**结束时间*/
	protected String enddate;

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
	 * 可能性取得
	 * @return poss 可能性
	 */
	public String getPoss() {
		return poss;
	}

	/**
	 * 可能性设定
	 * @param poss 可能性
	 */
	public void setPoss(String poss) {
		this.poss = poss;
	}

	/**
	 * 管理人id取得
	 * @return mguserid 管理人id
	 */
	public String getMguserid() {
		return mguserid;
	}

	/**
	 * 管理人id设定
	 * @param mguserid 管理人id
	 */
	public void setMguserid(String mguserid) {
		this.mguserid = mguserid;
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
	 * 风险级别取得
	 * @return levels 风险级别
	 */
	public String getLevels() {
		return levels;
	}

	/**
	 * 风险级别设定
	 * @param levels 风险级别
	 */
	public void setLevels(String levels) {
		this.levels = levels;
	}

	/**
	 * 风险等级取得
	 * @return grad 风险等级
	 */
	public String getGrad() {
		return grad;
	}

	/**
	 * 风险等级设定
	 * @param grad 风险等级
	 */
	public void setGrad(String grad) {
		this.grad = grad;
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
	 * 开始时间取得
	 * @return startdate 开始时间
	 */
	public String getStartdate() {
		return startdate;
	}

	/**
	 * 开始时间设定
	 * @param startdate 开始时间
	 */
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	/**
	 * 结束时间取得
	 * @return enddate 结束时间
	 */
	public String getEnddate() {
		return enddate;
	}

	/**
	 * 结束时间设定
	 * @param enddate 结束时间
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
}
