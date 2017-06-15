/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.aut.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自定义流程通用查询form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGAUT0110Form extends BaseForm{
	
	/** 工单号 */
	protected String prserialnum;
	
	/** 流程类型 */
	protected String prtype;
	
	/** 流程标题 */
	protected String prtitle;
	
	/** 流程描述 */
	protected String prdesc;
	
	/** 开始时间 */
	protected String propentime;
	
	/** 结束时间 */
	protected String prclosetime;
	
	/** 发起人姓名 */
	protected String prusername;
	
	/** 排序方式 */
	protected String sing;
	
	/** 排序字段 */
	protected String order;
	
	/** 查询类型标识 */
	protected String type;
	
	/** 关联菜单 */
	protected String pdactname;

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
	 * 流程类型取得
	 * @return prtype 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程类型设定
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
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
	 * 流程描述取得
	 * @return prdesc 流程描述
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * 流程描述设定
	 * @param prdesc 流程描述
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
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
	 * 发起人姓名取得
	 * @return prusername 发起人姓名
	 */
	public String getPrusername() {
		return prusername;
	}

	/**
	 * 发起人姓名设定
	 * @param prusername 发起人姓名
	 */
	public void setPrusername(String prusername) {
		this.prusername = prusername;
	}

	/**
	 * 排序方式取得
	 * @return sing 排序方式
	 */
	public String getSing() {
		return sing;
	}

	/**
	 * 排序方式设定
	 * @param sing 排序方式
	 */
	public void setSing(String sing) {
		this.sing = sing;
	}

	/**
	 * 排序字段取得
	 * @return order 排序字段
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * 排序字段设定
	 * @param order 排序字段
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * 查询类型标识取得
	 * @return type 查询类型标识
	 */
	public String getType() {
		return type;
	}

	/**
	 * 查询类型标识设定
	 * @param type 查询类型标识
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 关联菜单取得
	 * @return pdactname 关联菜单
	 */
	public String getPdactname() {
		return pdactname;
	}

	/**
	 * 关联菜单设定
	 * @param pdactname 关联菜单
	 */
	public void setPdactname(String pdactname) {
		this.pdactname = pdactname;
	}
}
