/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.svc.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;

@SuppressWarnings("serial")
public class IGSVC0601Form extends BaseForm implements IG500SearchCond {

	/**
	 * 查询年份
	 */

	protected String pryear;

	/**
	 * 类型
	 */
	protected String prkind;

	/**
	 * 名称
	 */
	protected String prname;

	protected String prtype;

	protected String prserialnum;
	protected String prplantime_like;
	/**
	 * 流程类型数组
	 */
	protected String[] prTypeArray;
	/** 内容 */
	protected String prdesc;

	/** 排序标识 */
	protected String order;

	protected String sing;

	/**
	 * 流程类型数组
	 */
	protected String[] prtypes;

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	public String getPrname() {
		return prname;
	}

	public void setPrname(String prname) {
		this.prname = prname;
	}

	public String getPrtype() {
		return prtype;
	}

	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 返回数据xml
	 */
	private String svcxml;

	/**
	 * 开始时间(事件、变更)
	 */

	protected String propentime;

	/**
	 * 结束时间(事件、变更)
	 */

	protected String prclosetime;

	protected String mode;

	/**
	 * 事件发生时间从(柱形图显示条件)
	 */

	protected String prplantime;

	/**
	 * 事件发生时间至(柱形图显示条件)
	 */

	protected String prduration;

	protected String selectMode;

	public String getSelectMode() {
		return selectMode;
	}

	public void setSelectMode(String selectMode) {
		this.selectMode = selectMode;
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

	public String getSvcxml() {
		return svcxml;
	}

	public void setSvcxml(String svcxml) {
		this.svcxml = svcxml;
	}

	public String getPryear() {
		return pryear;
	}

	public void setPryear(String pryear) {
		this.pryear = pryear;
	}

	public String getPrkind() {
		return prkind;
	}

	public void setPrkind(String prkind) {
		this.prkind = prkind;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getPcode() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpinittime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpproctime() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPproleid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpuserid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpusername() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrActive() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPrid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrtitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrurgency() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isTodo() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getPrassetcategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPrassetid() {
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

	public int getIsWork() {
		// TODO Auto-generated method stub
		return 0;
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

	public String getPrpdid() {
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

	public List<Integer> getPrroleid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getPrroleid_not_in() {
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
