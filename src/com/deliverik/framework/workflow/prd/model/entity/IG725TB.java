/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG725Info;

/**
  * 概述: 缺省参与者按钮定义表实体
  * 功能描述: 缺省参与者按钮定义表实体
  * 创建记录: 2012/04/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG725")
public class IG725TB extends BaseEntity implements Serializable,
		Cloneable, IG725Info {

	/** 主键 */
	@Id
	protected String pdbdid;

	/** 外键状态ID */
	protected String psdid;

	/** 按钮定义ID */
	protected String pbdid;

	/** 按钮显示名称 */
	protected String pdbdname;

	/** 按钮提示信息 */
	protected String pdbddesc;

	/** 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0 */
	protected String pdbdauth;
	
	/** 是否校验表单必填项 0不校验 1校验 */
	protected String checkrequired;
	
	/** 是否处理记录必填 */
	protected String checkrecord;
	
	/** 弹出页js名称 */
	protected String acturl;
	
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPdbdid() {
		return pdbdid;
	}

	/**
	 * 主键设定
	 *
	 * @param pdbdid 主键
	 */
	public void setPdbdid(String pdbdid) {
		this.pdbdid = pdbdid;
	}

	/**
	 * 外键状态ID取得
	 *
	 * @return 外键状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 外键状态ID设定
	 *
	 * @param psdid 外键状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
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
	public String getPdbdname() {
		return pdbdname;
	}

	/**
	 * 按钮显示名称设定
	 *
	 * @param pdbdname 按钮显示名称
	 */
	public void setPdbdname(String pdbdname) {
		this.pdbdname = pdbdname;
	}

	/**
	 * 按钮提示信息取得
	 *
	 * @return 按钮提示信息
	 */
	public String getPdbddesc() {
		return pdbddesc;
	}

	/**
	 * 按钮提示信息设定
	 *
	 * @param pdbddesc 按钮提示信息
	 */
	public void setPdbddesc(String pdbddesc) {
		this.pdbddesc = pdbddesc;
	}

	/**
	 * 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0取得
	 *
	 * @return 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0
	 */
	public String getPdbdauth() {
		return pdbdauth;
	}

	/**
	 * 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0设定
	 *
	 * @param pdbdauth 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0
	 */
	public void setPdbdauth(String pdbdauth) {
		this.pdbdauth = pdbdauth;
	}
	

	/**
	 *是否校验表单必填项0不校验1校验取得
	 */
	public String getCheckrequired() {
		return checkrequired;
	}

	/**
	 *是否校验表单必填项0不校验1校验设定
	 */
	public void setCheckrequired(String checkrequired) {
		this.checkrequired = checkrequired;
	}

	/**
	 *是否处理记录必填取得
	 */
	public String getCheckrecord() {
		return checkrecord;
	}

	/**
	 *是否处理记录必填设定
	 */
	public void setCheckrecord(String checkrecord) {
		this.checkrecord = checkrecord;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pdbdid;
	}

	/** 按钮定义 */
	@OneToOne
	@JoinColumn(name="pbdid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG900TB processButtonDefTB;

	public IG900TB getProcessButtonDefTB() {
		return processButtonDefTB;
	}

	public void setProcessButtonDefTB(IG900TB processButtonDefTB) {
		this.processButtonDefTB = processButtonDefTB;
	}

	/**
	 *弹出页js名称取得
	 */
	public String getActurl() {
		return acturl;
	}

	/**
	 *弹出页js名称设定
	 */
	public void setActurl(String acturl) {
		this.acturl = acturl;
	}
	
}