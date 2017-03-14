/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.prj.model.Pbsummary;

/**
 * 概述:项目查询vo 
 * 功能描述：项目查询vo
 * 创建人：王廷志
 * 创建记录： 2012-5-21
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGPRJ01011VO extends BaseVO{
	/** 项目id */
	private Integer pid;
	/** 项目名称 */
	private String pname;
	/** 项目金额 */
	private Double plimit;
	/** 项目编号 */
	private String pcode;
	/** 是否使用预算 */
	private String isUseBudget;
	/** 项目开始时间 */
	private String popentime;
	/** 项目结束时间 */
	private String pclosetime;
	/** 项目状态 */
	private String pstatus;
	/** 项目预算关系视图集合 */
	private List<Pbsummary> pbsummaryList;
	/**
	 * 项目id取得
	 * @return pid 项目id
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 项目id设定
	 * @param pid 项目id
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 项目名称取得
	 * @return pname 项目名称
	 */
	public String getPname() {
		return pname;
	}
	/**
	 * 项目名称设定
	 * @param pname 项目名称
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}
	/**
	 * 项目金额取得
	 * @return plimit 项目金额
	 */
	public Double getPlimit() {
		return plimit;
	}
	/**
	 * 项目金额设定
	 * @param plimit 项目金额
	 */
	public void setPlimit(Double plimit) {
		this.plimit = plimit;
	}
	/**
	 * 项目编号取得
	 * @return pcode 项目编号
	 */
	public String getPcode() {
		return pcode;
	}
	/**
	 * 项目编号设定
	 * @param pcode 项目编号
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	/**
	 * 是否使用预算取得
	 * @return isUseBudget 是否使用预算
	 */
	public String getIsUseBudget() {
		return isUseBudget;
	}
	/**
	 * 是否使用预算设定
	 * @param isUseBudget 是否使用预算
	 */
	public void setIsUseBudget(String isUseBudget) {
		this.isUseBudget = isUseBudget;
	}
	/**
	 * 项目开始时间取得
	 * @return popentime 项目开始时间
	 */
	public String getPopentime() {
		return popentime;
	}
	/**
	 * 项目开始时间设定
	 * @param popentime 项目开始时间
	 */
	public void setPopentime(String popentime) {
		this.popentime = popentime;
	}
	/**
	 * 项目结束时间取得
	 * @return pclosetime 项目结束时间
	 */
	public String getPclosetime() {
		return pclosetime;
	}
	/**
	 * 项目结束时间设定
	 * @param pclosetime 项目结束时间
	 */
	public void setPclosetime(String pclosetime) {
		this.pclosetime = pclosetime;
	}
	/**
	 * 项目状态取得
	 * @return pstatus 项目状态
	 */
	public String getPstatus() {
		return pstatus;
	}
	/**
	 * 项目状态设定
	 * @param pstatus 项目状态
	 */
	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}
	/**
	 * 项目预算关系视图集合取得
	 * @return pbsummaryList 项目预算关系视图集合
	 */
	public List<Pbsummary> getPbsummaryList() {
		return pbsummaryList;
	}
	/**
	 * 项目预算关系视图集合设定
	 * @param pbsummaryList 项目预算关系视图集合
	 */
	public void setPbsummaryList(List<Pbsummary> pbsummaryList) {
		this.pbsummaryList = pbsummaryList;
	}
}
