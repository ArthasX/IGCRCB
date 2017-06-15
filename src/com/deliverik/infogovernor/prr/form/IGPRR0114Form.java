/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述:抄阅人 
 * 功能描述：抄阅人
 * 创建人：赵梓廷
 * 创建记录： 2013-02-25
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGPRR0114Form extends BaseForm {

	
	protected Integer cruid;
	/** 流程id */
	protected String prid;

	/** 流程编号 */
	protected String prserialnum;

	/** 流程名称 */
	protected String prtitle;

	/** 流程类型 */
	protected String prpdname ;

	/** 开始时间 */
	protected String propentime ;

	/** 处理人角色 */
	protected String prrolename;

	/** 处理人姓名 */
	protected String prusername ;

	/** 处理状态 */
	protected String crustatus ;

	/** 分派时间 */
	protected String prassigntime;

	/** 查看时间 */
	protected String prlooktime;

	/** 是否查看标识 */
	protected String islook;

	/** 处理人id */
	protected String pruserid ;
    
	/**添加抄阅人集合*/
	protected String[] userid;

	/**姓名查询条件*/
	protected String username_q;
	
	/**机构码查询条件*/
	protected String orgid_q;
	
	/**机构码查询条件*/
	protected String orgname_q;
	/**
	 * 无意义自增主键取得
	 *
	 * @return 无意义自增主键
	 */
	public Integer getCruid() {
		return cruid;
	}

	/**
	 * 无意义自增主键设定
	 *
	 * @param cruid 无意义自增主键
	 */
	public void setCruid(Integer cruid) {
		this.cruid = cruid;
	}

	/**
	 * 流程id取得
	 *
	 * @return 流程id
	 */
	public String getPrid() {
		return prid;
	}

	/**
	 * 流程id设定
	 *
	 * @param prid 流程id
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}

	/**
	 * 流程编号取得
	 *
	 * @return 流程编号
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * 流程编号设定
	 *
	 * @param prserialnum 流程编号
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

	/**
	 * 流程名称取得
	 *
	 * @return 流程名称
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 流程名称设定
	 *
	 * @param prtitle 流程名称
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrpdname () {
		return prpdname ;
	}

	/**
	 * 流程类型设定
	 *
	 * @param prpdname  流程类型
	 */
	public void setPrpdname (String prpdname ) {
		this.prpdname  = prpdname ;
	}

	/**
	 * 开始时间取得
	 *
	 * @return 开始时间
	 */
	public String getPropentime () {
		return propentime ;
	}

	/**
	 * 开始时间设定
	 *
	 * @param propentime  开始时间
	 */
	public void setPropentime (String propentime ) {
		this.propentime  = propentime ;
	}

	/**
	 * 处理人角色取得
	 *
	 * @return 处理人角色
	 */
	public String getPrrolename() {
		return prrolename;
	}

	/**
	 * 处理人角色设定
	 *
	 * @param prrolename 处理人角色
	 */
	public void setPrrolename(String prrolename) {
		this.prrolename = prrolename;
	}

	/**
	 * 处理人姓名取得
	 *
	 * @return 处理人姓名
	 */
	public String getPrusername () {
		return prusername ;
	}

	/**
	 * 处理人姓名设定
	 *
	 * @param prusername  处理人姓名
	 */
	public void setPrusername (String prusername ) {
		this.prusername  = prusername ;
	}

	/**
	 * 处理状态取得
	 *
	 * @return 处理状态
	 */
	public String getCrustatus () {
		return crustatus ;
	}

	/**
	 * 处理状态设定
	 *
	 * @param crustatus  处理状态
	 */
	public void setCrustatus (String crustatus ) {
		this.crustatus  = crustatus ;
	}

	/**
	 * 分派时间取得
	 *
	 * @return 分派时间
	 */
	public String getPrassigntime() {
		return prassigntime;
	}

	/**
	 * 分派时间设定
	 *
	 * @param prassigntime 分派时间
	 */
	public void setPrassigntime(String prassigntime) {
		this.prassigntime = prassigntime;
	}

	/**
	 * 查看时间取得
	 *
	 * @return 查看时间
	 */
	public String getPrlooktime() {
		return prlooktime;
	}

	/**
	 * 查看时间设定
	 *
	 * @param prlooktime 查看时间
	 */
	public void setPrlooktime(String prlooktime) {
		this.prlooktime = prlooktime;
	}

	/**
	 * 是否查看标识取得
	 *
	 * @return 是否查看标识
	 */
	public String getIslook() {
		return islook;
	}

	/**
	 * 是否查看标识设定
	 *
	 * @param islook 是否查看标识
	 */
	public void setIslook(String islook) {
		this.islook = islook;
	}

	/**
	 * 处理人id取得
	 *
	 * @return 处理人id
	 */
	public String getPruserid () {
		return pruserid ;
	}

	/**
	 * 处理人id设定
	 *
	 * @param pruserid  处理人id
	 */
	public void setPruserid (String pruserid ) {
		this.pruserid  = pruserid ;
	}
	/**
	 * 添加抄阅人集合取得
	 *
	 * @return 添加抄阅人集合
	 */
	public String[] getUserid() {
		return userid;
	}
	/**
	 * 添加抄阅人集合设定
	 *
	 * @param userid  添加抄阅人集合
	 */
	public void setUserid(String[] userid) {
		this.userid = userid;
	}

	public String getUsername_q() {
		return username_q;
	}

	public void setUsername_q(String username_q) {
		this.username_q = username_q;
	}

	public String getOrgid_q() {
		return orgid_q;
	}

	public void setOrgid_q(String orgid_q) {
		this.orgid_q = orgid_q;
	}

	public String getOrgname_q() {
		return orgname_q;
	}

	public void setOrgname_q(String orgname_q) {
		this.orgname_q = orgname_q;
	}

	
}
