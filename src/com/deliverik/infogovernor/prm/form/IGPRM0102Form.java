package com.deliverik.infogovernor.prm.form;

import java.text.SimpleDateFormat;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prd.model.IG259Info;

public class IGPRM0102Form extends BaseForm implements IG259Info {

	private static final long serialVersionUID = 1L;

	protected Integer ptid;
	protected String ptname;
	protected String pttype;
	protected String ptstartpg;
	protected String ptpicinfo;

	protected String ptcrtdate;
	protected String ptstatus;
	
	protected String ptdetailpg;
	protected String ptqrtzflag;
	protected String ptsavepg;
	public Integer getPtid() {
		return ptid;
	}

	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	public String getPtname() {
		return ptname;
	}

	public void setPtname(String ptname) {
		this.ptname = ptname;
	}

	public String getPttype() {
		return pttype;
	}

	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

	public String getPtstartpg() {
		return ptstartpg;
	}

	public void setPtstartpg(String ptstartpg) {
		this.ptstartpg = ptstartpg;
	}

	public String getPtpicinfo() {
		return ptpicinfo;
	}

	public void setPtpicinfo(String ptpicinfo) {
		this.ptpicinfo = ptpicinfo;
	}

	public String getPtcrtdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		ptcrtdate = sdf.format(System.currentTimeMillis());
		return ptcrtdate;
	}

	public String getPtstatus() {
		return ptstatus;
	}

	public void setPtstatus(String ptstatus) {
		this.ptstatus = ptstatus;
	}

	public String getPtdetailpg() {
		return ptdetailpg;
	}

	public void setPtdetailpg(String ptdetailpg) {
		this.ptdetailpg = ptdetailpg;
	}

	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	public void setPtcrtdate(String ptcrtdate) {
		this.ptcrtdate = ptcrtdate;
	}

	public String getPtqrtzflag() {
		return ptqrtzflag;
	}

	public void setPtqrtzflag(String ptqrtzflag) {
		this.ptqrtzflag = ptqrtzflag;
	}

	public String getPtsavepg() {
		return ptsavepg;
	}

	public void setPtsavepg(String ptsavepg) {
		this.ptsavepg = ptsavepg;
	}

	public String getFirstsite() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPdsequence() {
		// TODO Auto-generated method stub
		return null;
	}

}
