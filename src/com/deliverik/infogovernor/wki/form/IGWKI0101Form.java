package com.deliverik.infogovernor.wki.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGWKI0101Form extends BaseForm {

	protected Integer workinfoid;
	//��������
	protected String workname;
	/** �������� */
	protected Integer workperiod;
	//����ʱ��
	protected String startdate;
	/** Ԥ�����ʱ�� */
	protected String estFinDate;
	/** ʵ�����ʱ�� */
	protected String actFinDate;
	/** ��ʱ����ʱ�� */
	protected Integer timeOutPeriod;
	/** ������ID */
	protected Integer initid;
	/** ���������� */
	protected String initname;
	/** ִ����ID */
	protected Integer execid;
	/** ִ�������� */
	protected String execname;
	/** ����״̬ */
	protected Integer workstatus;
	/** ��ע */
	protected String remark;
	
	//��ѯ�������� �Ͻ�
	protected String startdate_from;
	//��ѯ�������� �½�
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
