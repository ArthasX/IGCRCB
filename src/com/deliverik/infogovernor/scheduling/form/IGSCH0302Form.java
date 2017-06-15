package com.deliverik.infogovernor.scheduling.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;

public class IGSCH0302Form extends BaseForm implements QuartzProcessRecord,QuartzJobs {

	private static final long serialVersionUID = 1L;

	protected Integer qprid;
	protected String qprtype;
	protected String qprsubtype;
	protected String qprstatus;
	protected String qprsubstatus;
	protected String qprtitle;
	protected String qprdesc;
	protected String qpropentime;
	protected String qprclosetime;
	protected String qprplantime;
	protected String qprduration;
	protected String qprurgency;
	protected String qprimpact;
	protected Integer qprassetid;
	protected String qprassetname;
	protected String qprbusiness;
	protected String qprimplplan;
	protected String qprbackplan;
	protected String qprvfyplan;
	protected Integer qpid;
	protected String qpcode;
	protected String qpname;
	protected String qprinfo;
	protected Integer qprcorid;
	protected String qprcortype;
	protected String qprcortitle;
	protected String qprassetcategory;
	protected String qpruserid;
	protected String qprusername;
	protected Integer qprroleid;
	protected String qprrolename;
	protected String qprpdid;
	protected String qprpdname;
	
	protected String qprorgid;
	protected String qprorgname;
	
	
	protected Integer qjid;
	protected String qjname;
	protected String qjdesc;
	protected String qjtriname;
	protected String qjtrigrp;
	protected String qjcrtuser;
	protected String qjimpluser;
	protected String qjcrttime;
	protected String qjendtime;
	protected String qjtype;
	protected String qjstatus;
	protected String qjinfo;
	protected String qjtricron;

	private int qjimplroleid;
	private String qjimplrole;
	private String qjimplrolename;
	protected String qjcrtusername;
	protected String qjimplusername;
	protected String qjperiodinfo;
	protected String qjorgid;
	protected String qjorgname;
	
	/**流程变量参数值*/
	protected String[] pivarvalue;
	
	/**流程变量参数标识*/
	protected String[] pivarname;
	
	/**流程变量参数名称*/
	protected String[] pivarlabel;
	
	/**流程变量参数类型*/
	protected String[] pivartype;
	
	/**流程变量参数ID*/
	protected String[] piid;
	
	/** 流程变量参数值最大字节数 */
	private static final int MAX_BYTE = 256;
	protected String qjassetid;
	protected String qjassettypeid;
	protected String qprattkey;
	
	protected String qjdtime;
	
	public String getQjdtime() {
		return qjdtime;
	}

	public void setQjdtime(String qjdtime) {
		this.qjdtime = qjdtime;
	}
	public String getQprattkey() {
		return qprattkey;
	}
	public void setQprattkey(String qprattkey) {
		this.qprattkey = qprattkey;
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
	public static int getMAX_BYTE() {
		return MAX_BYTE;
	}
	public String[] getPivarvalue() {
		return pivarvalue;
	}
	public void setPivarvalue(String[] pivarvalue) {
		this.pivarvalue = pivarvalue;
	}
	public String[] getPivarname() {
		return pivarname;
	}
	public void setPivarname(String[] pivarname) {
		this.pivarname = pivarname;
	}
	public String[] getPivarlabel() {
		return pivarlabel;
	}
	public void setPivarlabel(String[] pivarlabel) {
		this.pivarlabel = pivarlabel;
	}
	public String[] getPivartype() {
		return pivartype;
	}
	public void setPivartype(String[] pivartype) {
		this.pivartype = pivartype;
	}
	public String[] getPiid() {
		return piid;
	}
	public void setPiid(String[] piid) {
		this.piid = piid;
	}
	public String getQjcrtusername() {
		return qjcrtusername;
	}
	public void setQjcrtusername(String qjcrtusername) {
		this.qjcrtusername = qjcrtusername;
	}
	public String getQjperiodinfo() {
		return qjperiodinfo;
	}
	public void setQjperiodinfo(String qjperiodinfo) {
		this.qjperiodinfo = qjperiodinfo;
	}

	public String getQjimplrolename() {
		return qjimplrolename;
	}

	public void setQjimplrolename(String qjimplrolename) {
		this.qjimplrolename = qjimplrolename;
	}

	public int getQjimplroleid() {
		return qjimplroleid;
	}

	public void setQjimplroleid(int qjimplroleid) {
		this.qjimplroleid = qjimplroleid;
	}

	public String getQjimplrole() {
		return qjimplrole;
	}

	public void setQjimplrole(String qjimplrole) {
		this.qjimplrole = qjimplrole;
	}



	public String getQjimplusername() {
		return qjimplusername;
	}

	public void setQjimplusername(String qjimplusername) {
		this.qjimplusername = qjimplusername;
	}

	public Integer getQjid() {
		return qjid;
	}

	public void setQjid(Integer qjid) {
		this.qjid = qjid;
	}

	public String getQjname() {
		return qjname;
	}

	public void setQjname(String qjname) {
		this.qjname = qjname;
	}

	public String getQjdesc() {
		return qjdesc;
	}

	public void setQjdesc(String qjdesc) {
		this.qjdesc = qjdesc;
	}

	public String getQjtriname() {
		return qjtriname;
	}

	public void setQjtriname(String qjtriname) {
		this.qjtriname = qjtriname;
	}

	public String getQjtrigrp() {
		return qjtrigrp;
	}

	public void setQjtrigrp(String qjtrigrp) {
		this.qjtrigrp = qjtrigrp;
	}

	public String getQjcrtuser() {
		return qjcrtuser;
	}

	public void setQjcrtuser(String qjcrtuser) {
		this.qjcrtuser = qjcrtuser;
	}

	public String getQjimpluser() {
		return qjimpluser;
	}

	public void setQjimpluser(String qjimpluser) {
		this.qjimpluser = qjimpluser;
	}

	public String getQjcrttime() {
		return qjcrttime;
	}

	public void setQjcrttime(String qjcrttime) {
		this.qjcrttime = qjcrttime;
	}

	public String getQjendtime() {
		return qjendtime;
	}

	public void setQjendtime(String qjendtime) {
		this.qjendtime = qjendtime;
	}

	public String getQjtype() {
		return qjtype;
	}

	public void setQjtype(String qjtype) {
		this.qjtype = qjtype;
	}

	public String getQjstatus() {
		return qjstatus;
	}

	public void setQjstatus(String qjstatus) {
		this.qjstatus = qjstatus;
	}

	public String getQjinfo() {
		return qjinfo;
	}

	public void setQjinfo(String qjinfo) {
		this.qjinfo = qjinfo;
	}

	public String getQjtricron() {
		return qjtricron;
	}

	public void setQjtricron(String qjtricron) {
		this.qjtricron = qjtricron;
	}

	public Integer getQprid() {
		return qprid;
	}

	public void setQprid(Integer qprid) {
		this.qprid = qprid;
	}

	public String getQprtype() {
		return qprtype;
	}

	public void setQprtype(String qprtype) {
		this.qprtype = qprtype;
	}

	public String getQprsubtype() {
		return qprsubtype;
	}

	public void setQprsubtype(String qprsubtype) {
		this.qprsubtype = qprsubtype;
	}

	public String getQprstatus() {
		return qprstatus;
	}

	public void setQprstatus(String qprstatus) {
		this.qprstatus = qprstatus;
	}

	public String getQprsubstatus() {
		return qprsubstatus;
	}

	public void setQprsubstatus(String qprsubstatus) {
		this.qprsubstatus = qprsubstatus;
	}

	public String getQprtitle() {
		return qprtitle;
	}

	public void setQprtitle(String qprtitle) {
		this.qprtitle = qprtitle;
	}

	public String getQprdesc() {
		return qprdesc;
	}

	public void setQprdesc(String qprdesc) {
		this.qprdesc = qprdesc;
	}

	public String getQpropentime() {
		return qpropentime;
	}

	public void setQpropentime(String qpropentime) {
		this.qpropentime = qpropentime;
	}

	public String getQprclosetime() {
		return qprclosetime;
	}

	public void setQprclosetime(String qprclosetime) {
		this.qprclosetime = qprclosetime;
	}

	public String getQprplantime() {
		return qprplantime;
	}

	public void setQprplantime(String qprplantime) {
		this.qprplantime = qprplantime;
	}

	public String getQprduration() {
		return qprduration;
	}

	public void setQprduration(String qprduration) {
		this.qprduration = qprduration;
	}

	public String getQprurgency() {
		return qprurgency;
	}

	public void setQprurgency(String qprurgency) {
		this.qprurgency = qprurgency;
	}

	public String getQprimpact() {
		return qprimpact;
	}

	public void setQprimpact(String qprimpact) {
		this.qprimpact = qprimpact;
	}

	public Integer getQprassetid() {
		return qprassetid;
	}

	public void setQprassetid(Integer qprassetid) {
		this.qprassetid = qprassetid;
	}

	public String getQprassetname() {
		return qprassetname;
	}

	public void setQprassetname(String qprassetname) {
		this.qprassetname = qprassetname;
	}

	public String getQprbusiness() {
		return qprbusiness;
	}

	public void setQprbusiness(String qprbusiness) {
		this.qprbusiness = qprbusiness;
	}

	public String getQprimplplan() {
		return qprimplplan;
	}

	public void setQprimplplan(String qprimplplan) {
		this.qprimplplan = qprimplplan;
	}

	public String getQprbackplan() {
		return qprbackplan;
	}

	public void setQprbackplan(String qprbackplan) {
		this.qprbackplan = qprbackplan;
	}

	public String getQprvfyplan() {
		return qprvfyplan;
	}

	public void setQprvfyplan(String qprvfyplan) {
		this.qprvfyplan = qprvfyplan;
	}

	public Integer getQpid() {
		return qpid;
	}

	public void setQpid(Integer qpid) {
		this.qpid = qpid;
	}

	public String getQpcode() {
		return qpcode;
	}

	public void setQpcode(String qpcode) {
		this.qpcode = qpcode;
	}

	public String getQpname() {
		return qpname;
	}

	public void setQpname(String qpname) {
		this.qpname = qpname;
	}

	public String getQprinfo() {
		return qprinfo;
	}

	public void setQprinfo(String qprinfo) {
		this.qprinfo = qprinfo;
	}

	public Integer getQprcorid() {
		return qprcorid;
	}

	public void setQprcorid(Integer qprcorid) {
		this.qprcorid = qprcorid;
	}

	public String getQprcortype() {
		return qprcortype;
	}

	public void setQprcortype(String qprcortype) {
		this.qprcortype = qprcortype;
	}

	public String getQprcortitle() {
		return qprcortitle;
	}

	public void setQprcortitle(String qprcortitle) {
		this.qprcortitle = qprcortitle;
	}

	public String getQprassetcategory() {
		return qprassetcategory;
	}

	public void setQprassetcategory(String qprassetcategory) {
		this.qprassetcategory = qprassetcategory;
	}

	public String getQpruserid() {
		return qpruserid;
	}

	public void setQpruserid(String qpruserid) {
		this.qpruserid = qpruserid;
	}

	public String getQprusername() {
		return qprusername;
	}

	public void setQprusername(String qprusername) {
		this.qprusername = qprusername;
	}

	public Integer getQprroleid() {
		return qprroleid;
	}

	public void setQprroleid(Integer qprroleid) {
		this.qprroleid = qprroleid;
	}

	public String getQprrolename() {
		return qprrolename;
	}

	public void setQprrolename(String qprrolename) {
		this.qprrolename = qprrolename;
	}

	public String getQprpdid() {
		return qprpdid;
	}

	public void setQprpdid(String qprpdid) {
		this.qprpdid = qprpdid;
	}

	public String getQprpdname() {
		return qprpdname;
	}

	public void setQprpdname(String qprpdname) {
		this.qprpdname = qprpdname;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getQprorgid() {
		return qprorgid;
	}
	public void setQprorgid(String qprorgid) {
		this.qprorgid = qprorgid;
	}
	public String getQprorgname() {
		return qprorgname;
	}
	public void setQprorgname(String qprorgname) {
		this.qprorgname = qprorgname;
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

	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
}
