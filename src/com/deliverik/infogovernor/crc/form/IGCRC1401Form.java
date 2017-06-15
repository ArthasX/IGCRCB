/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更变量处理查询Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1401Form extends BaseForm{

	/** 流程定义ID */
	protected String pdid;
	
	/** 流程状态码 */
	protected String prstatus;
	
	/** 流程状态定义ID */
	protected String psdid;
	
	/** 工单号 */
	protected String prserialnum;
	
	/** 流程标题 */
	protected String prtitle;
	
	/** 处理人 */
	protected String ppusername_like;
	
	/**开始时间*/
	protected String propentime;
	
	/**结束时间*/
	protected String prclosetime;
	
	/** 表单名集合 */
	protected String[] varnames;
	
	/** 表单值集合 */
	protected String[] varvalues;
	
	/** 主流程ID */
	protected Integer parprid;

	/** 更多搜索条件显示*/
	protected String showFlag; 
	
	/** 变更类型 */
	protected String changetype;
	
	/** 变更内容 */
	protected String changecontent;
	
	/** 更新平台 */
	protected String updateplatform;
	
	/** 变更类别 */
	protected String changecategory;
	
	/** 变更原因 */
	protected String changereason;
	
	/** 业务影响范围 */
	protected String businessscope;

	/** 是否影响业务 */
	protected String isinfluence;
	
	/** 变更分类 */
	protected String changeclassify;
	
	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程状态码取得
	 * @return prstatus 流程状态码
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态码设定
	 * @param prstatus 流程状态码
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 流程状态定义ID取得
	 * @return psdid 流程状态定义ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态定义ID设定
	 * @param psdid 流程状态定义ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 工单号取得
	 * @return prserialnum 工单号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * 工单号设定
	 * @param prserialnum 工单号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * 流程标题取得
	 * @return prtitle 流程标题
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 流程标题设定
	 * @param prtitle 流程标题
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 处理人取得
	 * @return ppusername_like 处理人
	 */
	public String getPpusername_like() {
		return ppusername_like;
	}

	/**
	 * 处理人设定
	 * @param ppusername_like 处理人
	 */
	public void setPpusername_like(String ppusername_like) {
		this.ppusername_like = ppusername_like;
	}

	/**
	 * 开始时间取得
	 * @return propentime 开始时间
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * 开始时间设定
	 * @param propentime 开始时间
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * 结束时间取得
	 * @return prclosetime 结束时间
	 */
	public String getPrclosetime() {
		return prclosetime;
	}

	/**
	 * 结束时间设定
	 * @param prclosetime 结束时间
	 */
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}

	/**
	 * 表单名集合取得
	 * @return varnames 表单名集合
	 */
	public String[] getVarnames() {
		return varnames;
	}

	/**
	 * 表单名集合设定
	 * @param varnames 表单名集合
	 */
	public void setVarnames(String[] varnames) {
		this.varnames = varnames;
	}

	/**
	 * 表单值集合取得
	 * @return varvalues 表单值集合
	 */
	public String[] getVarvalues() {
		return varvalues;
	}

	/**
	 * 表单值集合设定
	 * @param varvalues 表单值集合
	 */
	public void setVarvalues(String[] varvalues) {
		this.varvalues = varvalues;
	}

	/**
	 * 主流程ID取得
	 * @return parprid 主流程ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * 主流程ID设定
	 * @param parprid 主流程ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}

	/**
	 * 更多搜索条件显示取得
	 * @return the showFlag
	 */
	public String getShowFlag() {
		return showFlag;
	}

	/**
	 * 更多搜索条件显示设定
	 * @param showFlag the 更多搜索条件显示
	 */
	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}

	/**
	 * 变更内容取得
	 * @return the changecontent
	 */
	public String getChangecontent() {
		return changecontent;
	}

	/**
	 * 变更内容设定
	 * @param changecontent the 变更内容
	 */
	public void setChangecontent(String changecontent) {
		this.changecontent = changecontent;
	}

	/**
	 * 更新平台取得
	 * @return the updateplatform
	 */
	public String getUpdateplatform() {
		return updateplatform;
	}

	/**
	 * 更新平台设定
	 * @param updateplatform the 更新平台
	 */
	public void setUpdateplatform(String updateplatform) {
		this.updateplatform = updateplatform;
	}

	/**
	 * 变更类型取得
	 * @return the changetype
	 */
	public String getChangetype() {
		return changetype;
	}

	/**
	 * 变更类型设定
	 * @param changetype the 变更类型
	 */
	public void setChangetype(String changetype) {
		this.changetype = changetype;
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
	 * 变更原因取得
	 * @return the changereason
	 */
	public String getChangereason() {
		return changereason;
	}

	/**
	 * 变更原因设定
	 * @param changereason the 变更原因
	 */
	public void setChangereason(String changereason) {
		this.changereason = changereason;
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
}