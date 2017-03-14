/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_事件管理_查询Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 * 
 *          modify-xd protected String prpdid; //Integer -> String
 */

@SuppressWarnings("serial")
public class IGSRV0201Form extends BaseForm implements IG500SearchCond {

	/** 事件编号 */
	protected Integer prid;

	/** 事件名称 */
	protected String prtitle;

	/** 事件状态 */
	protected String prstatus;

	/** 流程类型 */
	protected String prtype;

	/** 项目编号 */
	protected String pcode;

	/** 发起者姓名 */
	protected String prusername;

	/** 开始时间 */
	protected String propentime;

	/** 结束时间 */
	protected String prclosetime;

	/** 紧急程度 */
	protected String prurgency;

	/** 发起者ID */
	protected String pruserid;

	/** 是否关闭 */
	public String prActive;

	/** 发起者角色ID */
	public Integer prroleid;
	protected String prplantime_like;

	/**
	 * 流程类型ID
	 */
	protected String pdid;

	/**
	 * 获取事件编号
	 * 
	 * @return 事件编号
	 */

	protected String prserialnum;
	/**
	 * 流程类型数组
	 */
	protected String[] prTypeArray;

	/**
	 * 流程类型ID
	 */
	protected String prpdid;

	protected String userid_q;

	protected String isAdmin;

	/** 删除的事件记录ID */
	protected Integer delprid;

	/**
	 * 归类排序字段
	 */
	protected String psort;

	/**
	 * 保存归类字段的升降排序
	 */
	protected String psort_order;

	/**
	 * 排序字段
	 */
	protected String porder;

	public String getPorder() {
		return porder;
	}

	public void setPorder(String porder) {
		this.porder = porder;
	}

	public Integer getDelprid() {
		return delprid;
	}

	public void setDelprid(Integer delprid) {
		this.delprid = delprid;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserid_q() {
		return userid_q;
	}

	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	public String getPrserialnum() {
		return prserialnum;
	}

	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	public Integer getPrid() {
		if (prid != null && prid == 0) {
			return null;
		} else {
			return prid;
		}
	}

	/**
	 * 设置事件编号
	 * 
	 * @param prid
	 *            事件编号
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 获取事件名称
	 * 
	 * @return 事件名称
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 设置事件名称
	 * 
	 * @param prtitle
	 *            事件名称
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 获取事件状态
	 * 
	 * @return 事件状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 设置事件状态
	 * 
	 * @param prstatus
	 *            事件状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 获取流程类型
	 * 
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 设置流程类型
	 * 
	 * @param prtype
	 *            流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 获取项目编号
	 * 
	 * @return 项目编号
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * 设置项目编号
	 * 
	 * @param pcode
	 *            项目编号
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * 获取发起者姓名
	 * 
	 * @return 发起者姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 设置发起者姓名
	 * 
	 * @param prusername
	 *            发起者姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * 获取开始时间
	 * 
	 * @return 开始时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 设置开始时间
	 * 
	 * @param propentime
	 *            开始时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 获取结束时间
	 * 
	 * @return 结束时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 设置结束时间
	 * 
	 * @param prclosetime
	 *            结束时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * 获取紧急程度
	 * 
	 * @return 紧急程度
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * 设置紧急程度
	 * 
	 * @param prurgency
	 *            紧急程度
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	public String getPruserid() {
		return pruserid;
	}

	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}

	public String getPrActive() {
		return prActive;
	}

	public void setPrActive(String prActive) {
		this.prActive = prActive;
	}

	public Integer getPrroleid() {
		return prroleid;
	}

	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	public String getPrduration() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrplantime() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIsWork() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getSelectMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrassetcategory() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getPrassetid() {
		// TODO Auto-generated method stub
		return null;
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

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public String getPrpdid() {
		return prpdid;
	}

	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	public String getPsort() {
		return psort;
	}

	public void setPsort(String psort) {
		this.psort = psort;
	}

	public String getPsort_order() {
		return psort_order;
	}

	public void setPsort_order(String psort_order) {
		this.psort_order = psort_order;
	}

	/*
	 * (non-Jsdoc) override
	 */
	public String[] getPrtypes() {
		//
		return null;
	}

	/*
	 * (non-Jsdoc) override
	 */
	public String[] getPrStatusArray() {
		//
		return null;
	}

	/*
	 * (non-Jsdoc) override
	 */
	public String getPrdesc() {
		//
		return null;
	}

	/*
	 * (non-Jsdoc) override
	 */
	public String getOrder() {
		//
		return null;
	}

	/*
	 * (non-Jsdoc) override
	 */
	public String getSing() {
		//
		return null;
	}

	/*
	 * (non-Jsdoc) override
	 */
	public String getPrimpact() {
		//
		return null;
	}

	/*
	 * (non-Jsdoc) override
	 */
	public String getPrpriority() {
		//
		return null;
	}

	/*
	 * (non-Jsdoc) override
	 */
	public String getApproveflag() {
		//
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

	public String getPpuserid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpstatus() {
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
