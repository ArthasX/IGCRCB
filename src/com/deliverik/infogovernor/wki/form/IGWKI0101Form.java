package com.deliverik.infogovernor.wki.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGWKI0101Form extends BaseForm {

	protected Integer workinfoid;
	//工作名称
	protected String workname;
	/** 工作周期 */
	protected Integer workperiod;
	//发起时间
	protected String startdate;
	/** 预计完成时间 */
	protected String estFinDate;
	/** 实际完成时间 */
	protected String actFinDate;
	/** 超时提醒时间 */
	protected Integer timeOutPeriod;
	/** 发起人ID */
	protected Integer initid;
	/** 发起人姓名 */
	protected String initname;
	/** 执行人ID */
	protected Integer execid;
	/** 执行人姓名 */
	protected String execname;
	/** 工作状态 */
	protected Integer workstatus;
	/** 备注 */
	protected String remark;
	
	//查询发起日期 上界
	protected String startdate_from;
	//查询发起日期 下界
	protected String startdate_to;
	public Integer getWorkinfoid() {
		return workinfoid;
	}
	public void setWorkinfoid(Integer workinfoid) {
		this.workinfoid = workinfoid;
	}
	public String getWorkname() {
		return workname;
	}
	public void setWorkname(String workname) {
		this.workname = workname;
	}
	public Integer getWorkperiod() {
		return workperiod;
	}
	public void setWorkperiod(Integer workperiod) {
		this.workperiod = workperiod;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEstFinDate() {
		return estFinDate;
	}
	public void setEstFinDate(String estFinDate) {
		this.estFinDate = estFinDate;
	}
	public String getActFinDate() {
		return actFinDate;
	}
	public void setActFinDate(String actFinDate) {
		this.actFinDate = actFinDate;
	}
	public Integer getTimeOutPeriod() {
		return timeOutPeriod;
	}
	public void setTimeOutPeriod(Integer timeOutPeriod) {
		this.timeOutPeriod = timeOutPeriod;
	}
	public Integer getInitid() {
		return initid;
	}
	public void setInitid(Integer initid) {
		this.initid = initid;
	}
	public String getInitname() {
		return initname;
	}
	public void setInitname(String initname) {
		this.initname = initname;
	}
	public Integer getExecid() {
		return execid;
	}
	public void setExecid(Integer execid) {
		this.execid = execid;
	}
	public String getExecname() {
		return execname;
	}
	public void setExecname(String execname) {
		this.execname = execname;
	}
	public Integer getWorkstatus() {
		return workstatus;
	}
	public void setWorkstatus(Integer workstatus) {
		this.workstatus = workstatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStartdate_from() {
		return startdate_from;
	}
	public void setStartdate_from(String startdate_from) {
		this.startdate_from = startdate_from;
	}
	public String getStartdate_to() {
		return startdate_to;
	}
	public void setStartdate_to(String startdate_to) {
		this.startdate_to = startdate_to;
	}
 
	
}
