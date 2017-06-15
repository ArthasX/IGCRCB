/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.condition;

/**
  * 概述: 变更流程检索条件实现
  * 功能描述: 变更流程检索条件实现
  * 创建记录: 2015/01/04
  * 修改记录: 
  */
public class ChangeProcessVWSearchCondImpl implements
		ChangeProcessVWSearchCond {

	/** 流程主键*/
	protected Integer prid;
	
	/** 工单号*/
	protected String prserialnum_like;
	
	/** 流程名称 */
	protected String prtitle_like;
	
	/** 流程状态 */
	protected String prstatus;
	
	/** 流程开始时间 (起始)*/
	protected String propentime_begin;

	/** 流程开始时间 (结束)*/
	protected String propentime_end;
	
	/** 流程关闭时间(起始) */
	protected String prclosetime_begin;
	
	/** 流程关闭时间 (结束)*/
	protected String prclosetime_end;
	
	/** 变更分类 */
	protected String changeclassify;

	/** 更新平台 */
	protected String updateplatform_like;

	/** 变更类型 */
	protected String changetype_like;

	/** 变更原因 */
	protected String changereason_like;

	/** 变更类别 */
	protected String changecategory;
	
	/** 业务影响范围 */
	protected String businessscope;

	/** 是否影响业务 */
	protected String isinfluence;
	
	/** 变更内容 */
	protected String changecontent_like;

	/** 处理人 */
	protected String ppusername_like;
	
	/**
	 * 流程主键取得
	 * @return the prid
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 * @param prid the 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 工单号取得
	 * @return the prserialnum_like
	 */
	public String getPrserialnum_like() {
		return prserialnum_like;
	}

	/**
	 * 工单号设定
	 * @param prserialnum_like the 工单号
	 */
	public void setPrserialnum_like(String prserialnum_like) {
		this.prserialnum_like = prserialnum_like;
	}

	/**
	 * 流程状态取得
	 * @return the prstatus
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态设定
	 * @param prstatus the 流程状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 流程开始时间(起始)取得
	 * @return the propentime_begin
	 */
	public String getPropentime_begin() {
		return propentime_begin;
	}

	/**
	 * 流程开始时间(起始)设定
	 * @param propentime_begin the 流程开始时间(起始)
	 */
	public void setPropentime_begin(String propentime_begin) {
		this.propentime_begin = propentime_begin;
	}

	/**
	 * 流程开始时间(结束)取得
	 * @return the propentime_end
	 */
	public String getPropentime_end() {
		return propentime_end;
	}

	/**
	 * 流程开始时间(结束)设定
	 * @param propentime_end the 流程开始时间(结束)
	 */
	public void setPropentime_end(String propentime_end) {
		this.propentime_end = propentime_end;
	}

	/**
	 * 流程关闭时间(起始)取得
	 * @return the prclosetime_begin
	 */
	public String getPrclosetime_begin() {
		return prclosetime_begin;
	}

	/**
	 * 流程关闭时间(起始)设定
	 * @param prclosetime_begin the 流程关闭时间(起始)
	 */
	public void setPrclosetime_begin(String prclosetime_begin) {
		this.prclosetime_begin = prclosetime_begin;
	}

	/**
	 * 流程关闭时间(结束)取得
	 * @return the prclosetime_end
	 */
	public String getPrclosetime_end() {
		return prclosetime_end;
	}

	/**
	 * 流程关闭时间(结束)设定
	 * @param prclosetime_end the 流程关闭时间(结束)
	 */
	public void setPrclosetime_end(String prclosetime_end) {
		this.prclosetime_end = prclosetime_end;
	}

	/**
	 * 变更分类取得
	 * @return the changeclassify
	 */
	public String getChangeclassify() {
		return changeclassify;
	}

	/**
	 * 变更分类设定
	 * @param changeclassify the 变更分类
	 */
	public void setChangeclassify(String changeclassify) {
		this.changeclassify = changeclassify;
	}


	/**
	 * 更新平台取得
	 * @return the updateplatform_like
	 */
	public String getUpdateplatform_like() {
		return updateplatform_like;
	}

	/**
	 * 更新平台设定
	 * @param updateplatform_like the 更新平台
	 */
	public void setUpdateplatform_like(String updateplatform_like) {
		this.updateplatform_like = updateplatform_like;
	}

	/**
	 * 变更原因取得
	 * @return the changereason_like
	 */
	public String getChangereason_like() {
		return changereason_like;
	}

	/**
	 * 变更原因设定
	 * @param changereason_like the 变更原因
	 */
	public void setChangereason_like(String changereason_like) {
		this.changereason_like = changereason_like;
	}

	/**
	 * 变更类别取得
	 * @return the changecategory
	 */
	public String getChangecategory() {
		return changecategory;
	}

	/**
	 * 变更类别设定
	 * @param changecategory the 变更类别
	 */
	public void setChangecategory(String changecategory) {
		this.changecategory = changecategory;
	}

	/**
	 * 流程名称取得
	 * @return the prtitle_like
	 */
	public String getPrtitle_like() {
		return prtitle_like;
	}

	/**
	 * 流程名称设定
	 * @param prtitle_like the 流程名称
	 */
	public void setPrtitle_like(String prtitle_like) {
		this.prtitle_like = prtitle_like;
	}

	/**
	 * 变更类型取得
	 * @return the changetype_like
	 */
	public String getChangetype_like() {
		return changetype_like;
	}

	/**
	 * 变更类型设定
	 * @param changetype_like the 变更类型
	 */
	public void setChangetype_like(String changetype_like) {
		this.changetype_like = changetype_like;
	}

	/**
	 * 业务影响范围取得
	 * @return the businessscope
	 */
	public String getBusinessscope() {
		return businessscope;
	}

	/**
	 * 业务影响范围设定
	 * @param businessscope the 业务影响范围
	 */
	public void setBusinessscope(String businessscope) {
		this.businessscope = businessscope;
	}

	/**
	 * 是否影响业务取得
	 * @return the isinfluence
	 */
	public String getIsinfluence() {
		return isinfluence;
	}

	/**
	 * 是否影响业务设定
	 * @param isinfluence the 是否影响业务
	 */
	public void setIsinfluence(String isinfluence) {
		this.isinfluence = isinfluence;
	}

	/**
	 * 变更内容取得
	 * @return the changecontent_like
	 */
	public String getChangecontent_like() {
		return changecontent_like;
	}

	/**
	 * 变更内容设定
	 * @param changecontent_like the 变更内容
	 */
	public void setChangecontent_like(String changecontent_like) {
		this.changecontent_like = changecontent_like;
	}

	/**
	 * 处理人取得
	 * @return ppusername_like  处理人
	 */
	public String getPpusername_like() {
		return ppusername_like;
	}

	/**
	 * 处理人设定
	 * @param ppusername_like  处理人
	 */
	public void setPpusername_like(String ppusername_like) {
		this.ppusername_like = ppusername_like;
	}

}