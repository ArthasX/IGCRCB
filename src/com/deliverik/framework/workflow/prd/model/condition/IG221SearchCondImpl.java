/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * 概述: 参与者按钮定义信息表视图检索条件实现
  * 功能描述: 参与者按钮定义信息表视图检索条件实现
  * 创建记录: 2012/04/19
  * 修改记录: 
  */
public class IG221SearchCondImpl implements
		IG221SearchCond {
	
	protected String pbdname;
	
	/** 主键 */
	protected String ppbdid;

	/** 参与者定义ID */
	protected String ppdid;

	/** 按钮定义ID */
	protected String pbdid;

	/** 按钮显示名称 */
	protected String ppbdname;

	/** 按钮提示信息 */
	protected String ppbddesc;

	/** 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0 */
	protected String ppbdauth;

	protected String psdid;
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPpbdid() {
		return ppbdid;
	}

	/**
	 * 主键设定
	 *
	 * @param ppbdid 主键
	 */
	public void setPpbdid(String ppbdid) {
		this.ppbdid = ppbdid;
	}

	/**
	 * 参与者定义ID取得
	 *
	 * @return 参与者定义ID
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * 参与者定义ID设定
	 *
	 * @param ppdid 参与者定义ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * 按钮定义ID取得
	 *
	 * @return 按钮定义ID
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * 按钮定义ID设定
	 *
	 * @param pbdid 按钮定义ID
	 */
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
	}

	/**
	 * 按钮显示名称取得
	 *
	 * @return 按钮显示名称
	 */
	public String getPpbdname() {
		return ppbdname;
	}

	/**
	 * 按钮显示名称设定
	 *
	 * @param ppbdname 按钮显示名称
	 */
	public void setPpbdname(String ppbdname) {
		this.ppbdname = ppbdname;
	}

	/**
	 * 按钮提示信息取得
	 *
	 * @return 按钮提示信息
	 */
	public String getPpbddesc() {
		return ppbddesc;
	}

	/**
	 * 按钮提示信息设定
	 *
	 * @param ppbddesc 按钮提示信息
	 */
	public void setPpbddesc(String ppbddesc) {
		this.ppbddesc = ppbddesc;
	}

	/**
	 * 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0取得
	 *
	 * @return 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0
	 */
	public String getPpbdauth() {
		return ppbdauth;
	}

	/**
	 * 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0设定
	 *
	 * @param ppbdauth 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0
	 */
	public void setPpbdauth(String ppbdauth) {
		this.ppbdauth = ppbdauth;
	}

	public String getPbdname() {
		return pbdname;
	}

	public void setPbdname(String pbdname) {
		this.pbdname = pbdname;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

}