/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.wkm.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_工作管理_查询Form
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

public class IGWKM0102Form extends BaseForm implements IG500SearchCond{
	
	public String getDwpType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrpdname() {
		return null;
	}

	private static final long serialVersionUID = 1L;

	/**工作编号*/
	protected Integer prid;
	
	/**工作名称*/
	protected String prtitle;
	
	/**工作状态*/
	protected String prstatus;
	
	/**流程类型*/
	protected String prtype;
	
	/**项目编号*/
	protected String pcode;
	
	/**发起者姓名*/
	protected String prusername;
	
	/**开始时间*/
	protected String propentime;
	
	/**结束时间*/
	protected String prclosetime;
	
	/**紧急程度*/
	protected String prurgency;
	
	/**是否工作*/
	protected int isWork;
	/**
	 * 流程类型数组
	 */
	protected String[] prTypeArray;
	/**
	 * 流程状态数组
	 */
	protected String[] prStatusArray;
	/**内容*/
	protected String prdesc;
	
	/**排序标识*/
	protected String order;
	
	protected String sing;
	
	/**
	 * 流程类型数组
	 */
	protected String[] prtypes;
	
	
	protected String prserialnum;
	protected String prplantime_like;
	
	protected String userid_q;
	
	/** 
	 * 个人工作的当前用户是否存在流程审批角色 
	 * 存在:1
	 */
	protected String approveflag;
	
	/** 流程参与人ID（like）*/
	protected String ppuserid_like;
	
	/** 流程参与人所属流程状态*/
	protected String ppstatus_eq;
	
	/** 流程参与人ID(和状态联动)*/
	protected String ppuserid_status_eq;
	
	/** 流程参与人角色类型(和状态联动)*/
	protected String roletype_status_eq;
	
	/** 流程参与人所属角色数组(和状态联动)*/
	protected String[] pproleid_status_in;
	
	/**
	 * 变更结果的标示(Y代表成功)取得
	 */
	public String pivarlabel;
	
	/**
	 * 事件分类
	 */
	public String pivarValue;
	
	/**
	 * 服务分类
	 */
	public String pppivarValue;
		
	/**
	 * 流程参与人所属流程状态取得
	 * @return 流程参与人所属流程状态
	 */
    public String getPpstatus_eq() {
		return ppstatus_eq;
	}
    
    /**
     * 流程参与人所属流程状态设定
     * @param ppstatus_eq 流程参与人所属流程状态
     */
	public void setPpstatus_eq(String ppstatus_eq) {
		this.ppstatus_eq = ppstatus_eq;
	}

	/**
	 * 流程参与人ID(和状态联动)取得
	 * @return 流程参与人ID(和状态联动)
	 */
	public String getPpuserid_status_eq() {
		return ppuserid_status_eq;
	}

	/**
	 * 流程参与人ID(和状态联动)设定
	 * @param ppuserid_status_eq 流程参与人ID(和状态联动)
	 */
	public void setPpuserid_status_eq(String ppuserid_status_eq) {
		this.ppuserid_status_eq = ppuserid_status_eq;
	}

	/**
	 * 流程参与人角色类型(和状态联动)取得
	 * @return 流程参与人角色类型(和状态联动)
	 */
	public String getRoletype_status_eq() {
		return roletype_status_eq;
	}

	/**
	 * 流程参与人角色类型(和状态联动)设定
	 * @param roletype_status_eq 流程参与人角色类型(和状态联动)
	 */
	public void setRoletype_status_eq(String roletype_status_eq) {
		this.roletype_status_eq = roletype_status_eq;
	}
	
	/**
	 * 流程参与人所属角色数组(和状态联动)取得
	 * @return 流程参与人所属角色数组(和状态联动)
	 */
	public String[] getPproleid_status_in() {
		return pproleid_status_in;
	}

	/**
	 * 流程参与人所属角色数组(和状态联动)设定
	 * @param pproleid_status_in 流程参与人所属角色数组(和状态联动)
	 */
	public void setPproleid_status_in(String[] pproleid_status_in) {
		this.pproleid_status_in = pproleid_status_in;
	}
	
	/**
	 * 流程参与人ID（like）取得
	 * @return 流程参与人ID（like）
	 */
	public String getPpuserid_like() {
		return ppuserid_like;
	}

	/**
	 * 流程参与人ID（like）设定
	 * @param ppuserid_like 流程参与人ID（like）
	 */
	public void setPpuserid_like(String ppuserid_like) {
		this.ppuserid_like = ppuserid_like;
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
	/**
	 * 获取工作编号
	 * @return 工作编号
	 */
	public Integer getPrid() {
		if(prid!=null && prid==0){
			return null;
		} else {
			return prid;
		}
	}

	/**
	 * 设置工作编号
	 * @param prid 工作编号
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}


	/**
	 * 获取工作名称
	 * @return 工作名称
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 设置工作名称
	 * @param prtitle 工作名称
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 获取工作状态
	 * @return 工作状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 设置工作状态
	 * @param prstatus 工作状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 获取流程类型
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 设置流程类型
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 获取项目编号
	 * @return 项目编号
	 */
	public String getPcode() {
		return pcode;
	}

	/**
	 * 设置项目编号
	 * @param pcode 项目编号
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * 获取发起者姓名
	 * @return 发起者姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 设置发起者姓名
	 * @param prusername 发起者姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * 获取开始时间
	 * @return 开始时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 设置开始时间
	 * @param propentime 开始时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 获取结束时间
	 * @return 结束时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 设置结束时间
	 * @param prclosetime 结束时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * 获取紧急程度
	 * @return 紧急程度
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * 设置紧急程度
	 * @param prurgency 紧急程度
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}

	public String getPrActive() {
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

	public String getPrduration() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrplantime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSelectMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIsWork() {
		return isWork;
	}

	public void setIsWork(int isWork) {
		this.isWork = isWork;
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
		return prStatusArray;
	}

	public void setPrStatusArray(String[] prStatusArray) {
		this.prStatusArray = prStatusArray;
	}

	public String getPrimpact() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPrpriority() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 流程审批角色标识获取
	 * @return 流程审批角色标识
	 */
	public String getApproveflag() {
		return approveflag;
	}

	/**
	 * 流程审批角色标识设定
	 * @param approveflag 流程审批角色标识
	 */
	public void setApproveflag(String approveflag) {
		this.approveflag = approveflag;
	}

	public String getPivarlabel() {
		return pivarlabel;
	}

	public void setPivarlabel(String pivarlabel) {
		this.pivarlabel = pivarlabel;
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

	/**
	 * @return the pivarValue
	 */
	public String getPivarValue() {
		return pivarValue;
	}

	/**
	 * @param pivarValue the pivarValue to set
	 */
	public void setPivarValue(String pivarValue) {
		this.pivarValue = pivarValue;
	}

	/**
	 * @return the pppivarValue
	 */
	public String getPppivarValue() {
		return pppivarValue;
	}

	/**
	 * @param pppivarValue the pppivarValue to set
	 */
	public void setPppivarValue(String pppivarValue) {
		this.pppivarValue = pppivarValue;
	}

	public String[] getVarmodes() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getPrpdidAndPpstatus_or() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPpproctime_status_active() {
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

	/* (non-Javadoc)
	 * @see com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond#getAffiliatedPerson()
	 */
	public String getAffiliatedPerson() {
		// TODO Auto-generated method stub
		return null;
	}

}
