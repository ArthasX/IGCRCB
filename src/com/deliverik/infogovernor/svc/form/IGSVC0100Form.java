/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.svc.form;

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
 */

@SuppressWarnings("serial")
public class IGSVC0100Form extends BaseForm implements IG500SearchCond {

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
	 * 获取事件编号
	 * 
	 * @return 事件编号
	 */

	protected String prserialnum;
	/**
	 * 流程类型数组
	 */
	protected String[] prTypeArray;
	// 查询用
	/** 内容 */
	protected String prdesc;

	/** 排序标识 */
	protected String order;

	protected String sing;

	/**
	 * 流程类型数组
	 */
	protected String[] prtypes;
	protected List<Integer> pridNotInList;// 已进入知识库的流程ID

	protected String userid_q;

	protected List<String> prserialnumNotInList;// 已进入知识库的流程工单号

	/** 流程定义ID */
	protected String prpdid;

	public List<String> getPrserialnumNotInList() {
		return prserialnumNotInList;
	}

	public void setPrserialnumNotInList(List<String> prserialnumNotInList) {
		this.prserialnumNotInList = prserialnumNotInList;
	}

	public List<Integer> getPridNotInList() {
		return pridNotInList;
	}

	public void setPridNotInList(List<Integer> pridNotInList) {
		this.pridNotInList = pridNotInList;
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

	/**
	 * userid_q设定
	 * 
	 * @param userid_q
	 *            userid_q
	 */
	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	public String getUserid_q() {
		// TODO Auto-generated method stub
		return this.userid_q;
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

	/**
	 * 流程定义ID取得
	 * 
	 * @return prpdid 流程定义ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * 流程定义ID设定
	 * 
	 * @param prpdid
	 *            流程定义ID
	 */
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
