/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程标题定义表检索条件实现
  * 功能描述: 流程标题定义表检索条件实现
  * 创建记录: 2012/03/30
  * 修改记录: 
  */
public class IG243SearchCondImpl implements
		IG243SearchCond {
	
	protected String ptdid;

	/** 流程定义ID */
	protected String pdid;

	/** 主题名称定义 */
	protected String ptitlename;

	/** 主题名称权限 0可见；1不可见 */
	protected String ptitleaccess;

	/** 描述字段名称 */
	protected String pdescname;

	/** 描述字段权限 0：可见，1不可见 */
	protected String pdescaccess;
	
	/** 主键 */
	protected String ptdid_like;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPtdid() {
		return ptdid;
	}

	/**
	 * 主键设定
	 *
	 * @param ptdid 主键
	 */
	public void setPtdid(String ptdid) {
		this.ptdid = ptdid;
	}

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 *
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 主题名称定义取得
	 *
	 * @return 主题名称定义
	 */
	public String getPtitlename() {
		return ptitlename;
	}

	/**
	 * 主题名称定义设定
	 *
	 * @param ptitlename 主题名称定义
	 */
	public void setPtitlename(String ptitlename) {
		this.ptitlename = ptitlename;
	}

	/**
	 * 主题名称权限 0可见；1不可见取得
	 *
	 * @return 主题名称权限 0可见；1不可见
	 */
	public String getPtitleaccess() {
		return ptitleaccess;
	}

	/**
	 * 主题名称权限 0可见；1不可见设定
	 *
	 * @param ptitleaccess 主题名称权限 0可见；1不可见
	 */
	public void setPtitleaccess(String ptitleaccess) {
		this.ptitleaccess = ptitleaccess;
	}

	/**
	 * 描述字段名称取得
	 *
	 * @return 描述字段名称
	 */
	public String getPdescname() {
		return pdescname;
	}

	/**
	 * 描述字段名称设定
	 *
	 * @param pdescname 描述字段名称
	 */
	public void setPdescname(String pdescname) {
		this.pdescname = pdescname;
	}

	/**
	 * 描述字段权限 0：可见，1不可见取得
	 *
	 * @return 描述字段权限 0：可见，1不可见
	 */
	public String getPdescaccess() {
		return pdescaccess;
	}

	/**
	 * 描述字段权限 0：可见，1不可见设定
	 *
	 * @param pdescaccess 描述字段权限 0：可见，1不可见
	 */
	public void setPdescaccess(String pdescaccess) {
		this.pdescaccess = pdescaccess;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPtdid_like() {
		return ptdid_like;
	}

	/**
	 * 主键设定
	 * 
	 * @param ptdid_like 主键
	 */
	public void setPtdid_like(String ptdid_like) {
		this.ptdid_like = ptdid_like;
	}
	
}