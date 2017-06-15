/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.scheduling.form;


import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�¼�����_�¼�������FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSCH0401Form extends BaseForm implements QuartzJobs{

	/**�ٴ�����ʱ��*/
	protected String[] notifyTime;
	
	/**�����ϼ�ʱ��*/
	protected String[] reportTime;
	
	/**Ԥ�ƽ��ʱ��*/
	protected String[] resolveTime;
	
	/**�����̶�����*/
	protected String[] urgency;
	
	/**�����̶���������*/
	protected String[] urgencyname;
	
	/**�����̶�������*/
	protected Integer urgencycount;
	
	private String qjcrttime;
	
	/**��ɫid*/
	private String qjcrtuser;

	/**�ϱ�ʱ��*/
	private String qjdesc;

	private String qjendtime;

	private Integer qjid;

	/**��ɫ����*/
	private String qjimpluser;

	/**��ɫ�ֻ�*/
	private String qjinfo;

	private String qjname;

	private String qjstatus;

	/**�ٴ�֪ͨʱ��*/
	private String qjtricron;

	private String qjtrigrp;

	private String qjtriname;

	private String qjtype;
	
	protected String qjcrtusername;
	protected String qjimplusername;
	protected String qjperiodinfo;
	protected String qjorgid;
	protected String qjorgname;
	protected String qjassetid;
	protected String qjassettypeid;
	protected String definitioned;
	
	protected String qjdtime;
	
	public String getQjdtime() {
		return qjdtime;
	}

	public void setQjdtime(String qjdtime) {
		this.qjdtime = qjdtime;
	}
	
	public String getQjassetid() {
		return qjassetid;
	}
	public void setQjassetid(String qjassetid) {
		this.qjassetid = qjassetid;
	}
	public String getQjassettypeid() {
		return qjassettypeid;
	}
	public void setQjassettypeid(String qjassettypeid) {
		this.qjassettypeid = qjassettypeid;
	}
	public String getQjcrtusername() {
		return qjcrtusername;
	}
	public void setQjcrtusername(String qjcrtusername) {
		this.qjcrtusername = qjcrtusername;
	}
	public String getQjimplusername() {
		return qjimplusername;
	}
	public void setQjimplusername(String qjimplusername) {
		this.qjimplusername = qjimplusername;
	}
	public String getQjperiodinfo() {
		return qjperiodinfo;
	}
	public void setQjperiodinfo(String qjperiodinfo) {
		this.qjperiodinfo = qjperiodinfo;
	}
	
	/**
	 * ��ȡ֪ͨʱ��
	 * @return ֪ͨʱ��
	 */
	public String[] getNotifyTime() {
		return notifyTime;
	}

	/**
	 * ����֪ͨʱ��
	 * @param notifyTime ֪ͨʱ��
	 */
	public void setNotifyTime(String[] notifyTime) {
		this.notifyTime = notifyTime;
	}

	/**
	 * ��ȡ�ϱ�ʱ��
	 * @return �ϱ�ʱ��
	 */
	public String[] getReportTime() {
		return reportTime;
	}

	/**
	 * �����ϱ�ʱ��
	 * @param reportTime �ϱ�ʱ��
	 */
	public void setReportTime(String[] reportTime) {
		this.reportTime = reportTime;
	}

	public String getQjcrttime() {
		return qjcrttime;
	}

	public void setQjcrttime(String qjcrttime) {
		this.qjcrttime = qjcrttime;
	}

	public String getQjcrtuser() {
		return qjcrtuser;
	}

	public void setQjcrtuser(String qjcrtuser) {
		this.qjcrtuser = qjcrtuser;
	}

	public String getQjdesc() {
		return qjdesc;
	}

	public void setQjdesc(String qjdesc) {
		this.qjdesc = qjdesc;
	}

	public String getQjendtime() {
		return qjendtime;
	}

	public void setQjendtime(String qjendtime) {
		this.qjendtime = qjendtime;
	}

	public Integer getQjid() {
		return qjid;
	}

	public void setQjid(Integer qjid) {
		this.qjid = qjid;
	}

	public String getQjimpluser() {
		return qjimpluser;
	}

	public void setQjimpluser(String qjimpluser) {
		this.qjimpluser = qjimpluser;
	}

	public String getQjinfo() {
		return qjinfo;
	}

	public void setQjinfo(String qjinfo) {
		this.qjinfo = qjinfo;
	}

	public String getQjname() {
		return qjname;
	}

	public void setQjname(String qjname) {
		this.qjname = qjname;
	}

	public String getQjstatus() {
		return qjstatus;
	}

	public void setQjstatus(String qjstatus) {
		this.qjstatus = qjstatus;
	}

	public String getQjtricron() {
		return qjtricron;
	}

	public void setQjtricron(String qjtricron) {
		this.qjtricron = qjtricron;
	}

	public String getQjtrigrp() {
		return qjtrigrp;
	}

	public void setQjtrigrp(String qjtrigrp) {
		this.qjtrigrp = qjtrigrp;
	}

	public String getQjtriname() {
		return qjtriname;
	}

	public void setQjtriname(String qjtriname) {
		this.qjtriname = qjtriname;
	}

	public String getQjtype() {
		return qjtype;
	}

	public void setQjtype(String qjtype) {
		this.qjtype = qjtype;
	}

	public String getQjorgid() {
		return qjorgid;
	}
	public void setQjorgid(String qjorgid) {
		this.qjorgid = qjorgid;
	}
	public String getQjorgname() {
		return qjorgname;
	}
	public void setQjorgname(String qjorgname) {
		this.qjorgname = qjorgname;
	}
	public String[] getResolveTime() {
		return resolveTime;
	}
	public void setResolveTime(String[] resolveTime) {
		this.resolveTime = resolveTime;
	}
	public String[] getUrgency() {
		return urgency;
	}
	public void setUrgency(String[] urgency) {
		this.urgency = urgency;
	}
	public Integer getUrgencycount() {
		return urgencycount;
	}
	public void setUrgencycount(Integer urgencycount) {
		this.urgencycount = urgencycount;
	}
	public String[] getUrgencyname() {
		return urgencyname;
	}
	public void setUrgencyname(String[] urgencyname) {
		this.urgencyname = urgencyname;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	public String getDefinitioned() {
		return definitioned;
	}
	public void setDefinitioned(String definitioned) {
		this.definitioned = definitioned;
	}
	
}
