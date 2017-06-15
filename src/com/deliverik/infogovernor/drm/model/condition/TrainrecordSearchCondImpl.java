/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 培训记录检索条件实现
  * 功能描述: 培训记录检索条件实现
  * 创建记录: 2015/04/13
  * 修改记录: 
  */
public class TrainrecordSearchCondImpl implements TrainrecordSearchCond {

	protected Integer trid;

	/** 培训名称 */
	protected String trname;

	/** 培训计划id */
	protected Integer tpid;

	/** 培训计划名称 */
	protected String tpname;

	/** 培训内容 */
	protected String tpcontent;

	/** 培训开始时间 */
	protected String trstime;

	/** 培训结束时间 */
	protected String tretime;

	/** 培训地点 */
	protected String trside;

	/** 讲师 */
	protected String trlecturer;

	/** 附件 */
	protected String tratt;
	
	/** 培训开始时间起始 */
	protected String trstimeFrom;
	
	/** 培训开始时间终止 */
	protected String trstimeTo;

	/**  
	 * 获取trid  
	 * @return trid trid  
	 */
	
	public Integer getTrid() {
		return trid;
	}

	/**  
	 * 设置trid  
	 * @param trid trid  
	 */
	
	public void setTrid(Integer trid) {
		this.trid = trid;
	}

	/**  
	 * 设置培训名称  
	 * @param trname 培训名称  
	 */
	
	public void setTrname(String trname) {
		this.trname = trname;
	}

	/**  
	 * 设置培训计划id  
	 * @param tpid 培训计划id  
	 */
	
	public void setTpid(Integer tpid) {
		this.tpid = tpid;
	}

	/**  
	 * 设置培训计划名称  
	 * @param tpname 培训计划名称  
	 */
	
	public void setTpname(String tpname) {
		this.tpname = tpname;
	}

	/**  
	 * 设置培训内容  
	 * @param tpcontent 培训内容  
	 */
	
	public void setTpcontent(String tpcontent) {
		this.tpcontent = tpcontent;
	}

	/**  
	 * 设置培训开始时间  
	 * @param trstime 培训开始时间  
	 */
	
	public void setTrstime(String trstime) {
		this.trstime = trstime;
	}

	/**  
	 * 设置培训结束时间  
	 * @param tretime 培训结束时间  
	 */
	
	public void setTretime(String tretime) {
		this.tretime = tretime;
	}

	/**  
	 * 设置培训地点  
	 * @param trside 培训地点  
	 */
	
	public void setTrside(String trside) {
		this.trside = trside;
	}

	/**  
	 * 设置讲师  
	 * @param trlecturer 讲师  
	 */
	
	public void setTrlecturer(String trlecturer) {
		this.trlecturer = trlecturer;
	}

	/**  
	 * 设置附件  
	 * @param tratt 附件  
	 */
	
	public void setTratt(String tratt) {
		this.tratt = tratt;
	}

	/**  
	 * 获取培训名称  
	 * @return trname 培训名称  
	 */
	
	public String getTrname() {
		return trname;
	}

	/**  
	 * 获取培训计划id  
	 * @return tpid 培训计划id  
	 */
	
	public Integer getTpid() {
		return tpid;
	}

	/**  
	 * 获取培训计划名称  
	 * @return tpname 培训计划名称  
	 */
	
	public String getTpname() {
		return tpname;
	}

	/**  
	 * 获取培训内容  
	 * @return tpcontent 培训内容  
	 */
	
	public String getTpcontent() {
		return tpcontent;
	}

	/**  
	 * 获取培训开始时间  
	 * @return trstime 培训开始时间  
	 */
	
	public String getTrstime() {
		return trstime;
	}

	/**  
	 * 获取培训结束时间  
	 * @return tretime 培训结束时间  
	 */
	
	public String getTretime() {
		return tretime;
	}

	/**  
	 * 获取培训地点  
	 * @return trside 培训地点  
	 */
	
	public String getTrside() {
		return trside;
	}

	/**  
	 * 获取讲师  
	 * @return trlecturer 讲师  
	 */
	
	public String getTrlecturer() {
		return trlecturer;
	}

	/**  
	 * 获取附件  
	 * @return tratt 附件  
	 */
	
	public String getTratt() {
		return tratt;
	}

	/**  
	 * 获取培训开始时间起始  
	 * @return trstimeFrom 培训开始时间起始  
	 */
	
	public String getTrstimeFrom() {
		return trstimeFrom;
	}

	/**  
	 * 设置培训开始时间起始  
	 * @param trstimeFrom 培训开始时间起始  
	 */
	
	public void setTrstimeFrom(String trstimeFrom) {
		this.trstimeFrom = trstimeFrom;
	}

	/**  
	 * 获取培训开始时间终止  
	 * @return trstimeTo 培训开始时间终止  
	 */
	
	public String getTrstimeTo() {
		return trstimeTo;
	}

	/**  
	 * 设置培训开始时间终止  
	 * @param trstimeTo 培训开始时间终止  
	 */
	
	public void setTrstimeTo(String trstimeTo) {
		this.trstimeTo = trstimeTo;
	}

}