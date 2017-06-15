/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG221Info;

/**
  * 概述: 参与者按钮定义信息表视图实体
  * 功能描述: 参与者按钮定义信息表视图实体
  * 创建记录: 2012/04/19
  * 修改记录: 
  */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class IG221VW extends BaseEntity implements Serializable,
		Cloneable, IG221Info {

	/** 按钮ID */
	@Id
	protected String pbdid;

	/** 默认按钮名称 */
	protected String pbdname;

	/** 按钮是否可跃迁标识（0可跃迁，1不可跃迁） */
	protected String pbdflag;
	
	//**********************IG132*******************
	/** 主键 */
	protected String ppbdid;

	/** 参与者定义ID */
	protected String ppdid;

	/** 按钮显示名称 */
	protected String ppbdname;

	/** 按钮提示信息 */
	protected String ppbddesc;

	/** 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0 */
	protected String ppbdauth;
	
	//*********************ParticipantDefaultButtonDef*******************
	/** 主键 */
	protected String pdbdid;
	
	/** 状态节点ID*/
	protected String psdid;
	
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
	 * 按钮ID取得
	 *
	 * @return 按钮ID
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * 按钮ID设定
	 *
	 * @param pbdid 按钮ID
	 */
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
	}

	/**
	 * 默认按钮名称取得
	 *
	 * @return 默认按钮名称
	 */
	public String getPbdname() {
		return pbdname;
	}

	/**
	 * 默认按钮名称设定
	 *
	 * @param pbdname 默认按钮名称
	 */
	public void setPbdname(String pbdname) {
		this.pbdname = pbdname;
	}

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

	@Override
	public Serializable getPK() {
		return pbdid;
	}

	public String getPsdid() {
		return psdid;
	}

	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public String getPdbdid() {
		return pdbdid;
	}

	public void setPdbdid(String pdbdid) {
		this.pdbdid = pdbdid;
	}

	public String getPdbdname() {
		return pdbdname;
	}

	public void setPdbdname(String pdbdname) {
		this.pdbdname = pdbdname;
	}

	public String getPdbddesc() {
		return pdbddesc;
	}

	public void setPdbddesc(String pdbddesc) {
		this.pdbddesc = pdbddesc;
	}

	public String getPdbdauth() {
		return pdbdauth;
	}

	public void setPdbdauth(String pdbdauth) {
		this.pdbdauth = pdbdauth;
	}

    /**
     * @return the 按钮是否可跃迁标识（0可跃迁，1不可跃迁）
     */
    public String getPbdflag() {
        return pbdflag;
    }

    /**
     * @param 按钮是否可跃迁标识（0可跃迁，1不可跃迁） the pbdflag to set
     */
    public void setPbdflag(String pbdflag) {
        this.pbdflag = pbdflag;
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