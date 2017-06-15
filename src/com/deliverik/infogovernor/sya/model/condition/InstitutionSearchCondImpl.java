/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sya.model.condition;

/**
  * 概述: 绩效考核检索条件实现
  * 功能描述: 绩效考核检索条件实现
  * 创建记录: 2015/01/05
  * 修改记录: 
  */
public class InstitutionSearchCondImpl implements
		InstitutionSearchCond {

	/** 制度名称  */	
	protected String inname;

	/** 时间 */
	protected String createtime_from;
	
	protected String createtime_to;
	
	protected String niuserid;
	
	/** 登记人机构名称 */
	protected String niorgname;
	
	/** 制度分类  */	
	public String intype;
	
	/**
	 * 制度名称取得
	 * @return inname  制度名称
	 */
	public String getInname() {
		return inname;
	}

	/**
	 * 制度名称设定
	 * @param inname  制度名称
	 */
	public void setInname(String inname) {
		this.inname = inname;
	}

	/**
	 * 时间取得
	 * @return createtime_from  时间
	 */
	public String getCreatetime_from() {
		return createtime_from;
	}

	/**
	 * 时间设定
	 * @param createtime_from  时间
	 */
	public void setCreatetime_from(String createtime_from) {
		this.createtime_from = createtime_from;
	}

	/**
	 * createtime_to取得
	 * @return createtime_to  createtime_to
	 */
	public String getCreatetime_to() {
		return createtime_to;
	}

	/**
	 * createtime_to设定
	 * @param createtime_to  createtime_to
	 */
	public void setCreatetime_to(String createtime_to) {
		this.createtime_to = createtime_to;
	}

	/**
	 * niuserid取得
	 * @return niuserid  niuserid
	 */
	public String getNiuserid() {
		return niuserid;
	}

	/**
	 * niuserid设定
	 * @param niuserid  niuserid
	 */
	public void setNiuserid(String niuserid) {
		this.niuserid = niuserid;
	}

	/**
	 * 登记人机构名称取得
	 * @return niorgname  登记人机构名称
	 */
	public String getNiorgname() {
		return niorgname;
	}

	/**
	 * 登记人机构名称设定
	 * @param niorgname  登记人机构名称
	 */
	public void setNiorgname(String niorgname) {
		this.niorgname = niorgname;
	}

	/**
	 * 制度分类取得
	 * @return intype  制度分类
	 */
	public String getIntype() {
		return intype;
	}

	/**
	 * 制度分类设定
	 * @param intype  制度分类
	 */
	public void setIntype(String intype) {
		this.intype = intype;
	}
	
	
}