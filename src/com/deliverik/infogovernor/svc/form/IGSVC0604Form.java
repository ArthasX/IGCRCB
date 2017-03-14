/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.svc.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;

@SuppressWarnings("serial")
public class IGSVC0604Form extends BaseForm implements IG500SearchCond, IG677SearchCond {
	protected Integer prassetid;
	protected String prassetcategory;
	protected Integer prid;
	protected String prtitle;
	protected String prstatus;
	protected String prtype;
	protected String propentime;
	protected String prclosetime;
	protected String ppusername;
	protected String prurgency;
	protected String ppinittime;
	protected String ppproctime;
	protected Integer pproleid;
	protected String ppuserid;
	protected String mode;
	protected String ppstatus;
	protected String prActive;
	protected boolean todo;
	protected String pcode;
	protected String prplantime;
	protected String prduration;
	protected int isWork;
	protected String prserialnum;
	protected Integer modes;
	protected String prplantime_like;
	/** 内容 */
	protected String prdesc;

	/** 排序标识 */
	protected String order;

	protected String sing;

	protected String prpdid;

	/**
	 * 流程类型数组
	 */
	protected String[] prtypes;
	/**
	 * 流程类型数组
	 */
	protected String[] prTypeArray;

	public Integer getModes() {
		return modes;
	}

	public void setModes(Integer modes) {
		this.modes = modes;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	public int getIsWork() {
		return isWork;
	}

	public void setIsWork(int isWork) {
		this.isWork = isWork;
	}

	public Integer getPrassetid() {
		return prassetid;
	}

	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	public String getPrassetcategory() {
		return prassetcategory;
	}

	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	public Integer getPrid() {
		if (prid != null && prid == 0) {
			return null;
		} else {
			return prid;
		}
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	public String getPrstatus() {
		return prstatus;
	}

	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	public String getPropentime() {
		return propentime;
	}

	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	public String getPrclosetime() {
		return prclosetime;
	}

	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	public String getPpusername() {
		return ppusername;
	}

	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	public String getPrurgency() {
		return prurgency;
	}

	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	public String getPpinittime() {
		return ppinittime;
	}

	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	public String getPpproctime() {
		return ppproctime;
	}

	public void setPpproctime(String ppproctime) {
		this.ppproctime = ppproctime;
	}

	public Integer getPproleid() {
		return pproleid;
	}

	public void setPproleid(Integer pproleid) {
		this.pproleid = pproleid;
	}

	public String getPpuserid() {
		return ppuserid;
	}

	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getPpstatus() {
		return ppstatus;
	}

	public void setPpstatus(String ppstatus) {
		this.ppstatus = ppstatus;
	}

	public String getPrActive() {
		return prActive;
	}

	public void setPrActive(String prActive) {
		this.prActive = prActive;
	}

	public boolean isTodo() {
		return todo;
	}

	public void setTodo(boolean todo) {
		this.todo = todo;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPrplantime() {
		return prplantime;
	}

	public void setPrplantime(String prplantime) {
		this.prplantime = prplantime;
	}

	public String getPrduration() {
		return prduration;
	}

	public void setPrduration(String prduration) {
		this.prduration = prduration;
	}

	public String getSelectMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPrroleid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPruserid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrusername() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isToImplement() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getPrsubstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getPridNotInList() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getPrserialnumNotInList() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpproctime_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpproctime_to() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrplantime_like() {
		return prplantime_like;
	}

	public void setPrplantime_like(String prplantime_like) {
		this.prplantime_like = prplantime_like;
	}

	public String[] getPrTypeArray() {
		return prTypeArray;
	}

	public void setPrTypeArray(String[] prTypeArray) {
		this.prTypeArray = prTypeArray;
	}

	public String getUserid_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrdesc() {
		return prdesc;
	}

	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSing() {
		return sing;
	}

	public void setSing(String sing) {
		this.sing = sing;
	}

	public String[] getPrtypes() {
		return prtypes;
	}

	public void setPrtypes(String[] prtypes) {
		this.prtypes = prtypes;
	}

	public String[] getPrStatusArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrimpact() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrpriority() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getApproveflag() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDsstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getPrpdid_like_or() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getVarnames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getVarvalues() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpusername_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProrgid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getPrserialnum_likeArr() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrstatus_ne() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPropentime_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLctype() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getProrgid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrassetname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPdactname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrpdid() {
		return prpdid;
	}

	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	public List<Integer> getPrroleid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getPrroleid_not_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPsdid_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPporgid_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrclosetime_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getVarvalues_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getVarnames_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getAlarm_Is() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpbacktime_isNull() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getVarmodes() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpuserid_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getPrpdidAndPpstatus_or() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpstatus_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpproctime_status_active() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpuserid_status_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRoletype_status_eq() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getPproleid_status_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPivarlabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPivarValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPppivarValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLeaderFlag() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOrgID() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFlag() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond#
	 * getAffiliatedPerson()
	 */
	public String getAffiliatedPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDwpType() {
		// TODO Auto-generated method stub
		return null;
	}

}
