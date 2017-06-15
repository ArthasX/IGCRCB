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
public class IGCRC0401Form extends BaseForm{

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
}