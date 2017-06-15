/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;

/**
 * 概述:批量审批 
 * 功能描述：批量审批 
 * 创建人：赵梓廷
 * 创建记录： 2013-07-31
 * 修改记录：
 */
@SuppressWarnings("serial")
@Entity
public class BatchExamineVW implements BatchExamineVWInfo{

	@Id
	protected Integer prid;
	
	/** 报表名 */
	protected String prtitle;
	
	/** 填报完成时间 */
	protected String fillintime;
	
	/** 报表审批完成时间 */
	protected String examinetime;
	
	/** 填报人 */
	protected String fillinusername;
	
	/** 报表审批人 */
	protected String exanimeusername;
	
	/** 状态 */
	protected String prstatus;
	
	/** 驳回时间 */
	protected String rejecttime;
	
	/** 流程类型id */
	protected String prpdid;
	
	/** 是否报送空表标识 */
	protected String flag;
	

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPrid() {
		return prid;
	}
	/**
	 * 主键设定
	 *
	 * @param prid 主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	/**
	 * 报表名 取得
	 *
	 * @return 报表名 
	 */
	public String getPrtitle() {
		return prtitle;
	}
	/**
	 * 报表名 设定
	 *
	 * @param prtitle 报表名 
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}
	/**
	 * 填报完成时间 取得
	 *
	 * @return 填报完成时间 
	 */
	public String getFillintime() {
		return fillintime;
	}
	/**
	 * 填报完成时间设定
	 *
	 * @param fillintime 填报完成时间 
	 */
	public void setFillintime(String fillintime) {
		this.fillintime = fillintime;
	}
	/**
	 * 报表审批完成时间 取得
	 *
	 * @return 报表审批完成时间 
	 */
	public String getExaminetime() {
		return examinetime;
	}
	/**
	 * 报表审批完成时间设定
	 *
	 * @param examinetime 报表审批完成时间
	 */
	public void setExaminetime(String examinetime) {
		this.examinetime = examinetime;
	}
	/**
	 * 填报人 取得
	 *
	 * @return 填报人 
	 */
	public String getFillinusername() {
		return fillinusername;
	}
	/**
	 * 填报人 设定
	 *
	 * @param fillinusername 填报人 
	 */
	public void setFillinusername(String fillinusername) {
		this.fillinusername = fillinusername;
	}
	/**
	 * 报表审批人 取得
	 *
	 * @return 报表审批人 
	 */
	public String getExanimeusername() {
		return exanimeusername;
	}
	/**
	 * 报表审批人 设定
	 *
	 * @param exanimeusername 报表审批人 
	 */
	public void setExanimeusername(String exanimeusername) {
		this.exanimeusername = exanimeusername;
	}
	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getPrstatus() {
		return prstatus;
	}
	/**
	 * 状态设定
	 *
	 * @param prstatus 状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}
	/**
	 * 驳回时间取得
	 *
	 * @return 驳回时间
	 */
	public String getRejecttime() {
		return rejecttime;
	}
	/**
	 * 驳回时间设定
	 *
	 * @param rejecttime 驳回时间
	 */
	public void setRejecttime(String rejecttime) {
		this.rejecttime = rejecttime;
	}
	public String getPrpdid() {
		return prpdid;
	}
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	
}
