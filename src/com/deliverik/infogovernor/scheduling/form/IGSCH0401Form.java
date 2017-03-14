/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.form;


import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_事件管理_事件处理人FormBean
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSCH0401Form extends BaseForm implements QuartzJobs{

	/**再次提醒时间*/
	protected String[] notifyTime;
	
	/**报告上级时间*/
	protected String[] reportTime;
	
	/**预计解决时间*/
	protected String[] resolveTime;
	
	/**紧急程度种类*/
	protected String[] urgency;
	
	/**紧急程度种类名称*/
	protected String[] urgencyname;
	
	/**紧急程度种类数*/
	protected Integer urgencycount;
	
	private String qjcrttime;
	
	/**角色id*/
	private String qjcrtuser;

	/**上报时间*/
	private String qjdesc;

	private String qjendtime;

	private Integer qjid;

	/**角色名称*/
	private String qjimpluser;

	/**角色手机*/
	private String qjinfo;

	private String qjname;

	private String qjstatus;

	/**再次通知时间*/
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
	 * 获取通知时间
	 * @return 通知时间
	 */
	public String[] getNotifyTime() {
		return notifyTime;
	}

	/**
	 * 设置通知时间
	 * @param notifyTime 通知时间
	 */
	public void setNotifyTime(String[] notifyTime) {
		this.notifyTime = notifyTime;
	}

	/**
	 * 获取上报时间
	 * @return 上报时间
	 */
	public String[] getReportTime() {
		return reportTime;
	}

	/**
	 * 设置上报时间
	 * @param reportTime 上报时间
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
