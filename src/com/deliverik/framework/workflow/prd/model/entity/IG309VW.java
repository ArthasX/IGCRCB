/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prd.model.IG309Info;

/**
  * 概述: 参与者可视按钮实体
  * 功能描述: 参与者可视按钮实体
  * 创建记录: 2012/04/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
public class IG309VW implements Serializable,
		Cloneable, IG309Info {

	/** 按钮定义ID */
	@Id
	protected String  vbid;

	/** 按钮显示名称 */
	protected String vbname;

	/** 按钮提示信息 */
	protected String vbdesc;

	/** 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0 */
	protected String vbauth;
	
	/** 图片名 */
	protected String vbimage;
	
	/** 校验表单是否必填 */
	protected String vbrequired;
	
	/** 校验记录是否必填 */
	protected String vbrecord;
	
	/** 弹出页js名称 */
	protected String vbacturl;
	
	/**
	 * 按钮定义ID取得
	 *
	 * @return 按钮定义ID
	 */
	public String getVbid() {
		return vbid;
	}

	/**
	 * 按钮定义ID设定
	 *
	 * @param vbid 按钮定义ID
	 */
	public void setVbid(String vbid) {
		this.vbid = vbid;
	}

	/**
	 * 按钮显示名称取得
	 *
	 * @return 按钮显示名称
	 */
	public String getVbname() {
		return vbname;
	}

	/**
	 * 按钮显示名称设定
	 *
	 * @param vbname 按钮显示名称
	 */
	public void setVbname(String vbname) {
		this.vbname = vbname;
	}

	/**
	 * 按钮提示信息取得
	 *
	 * @return 按钮提示信息
	 */
	public String getVbdesc() {
		return vbdesc;
	}

	/**
	 * 按钮提示信息设定
	 *
	 * @param vbdesc 按钮提示信息
	 */
	public void setVbdesc(String vbdesc) {
		this.vbdesc = vbdesc;
	}

	/**
	 * 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0取得
	 *
	 * @return 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0
	 */
	public String getVbauth() {
		return vbauth;
	}

	/**
	 * 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0设定
	 *
	 * @param vbauth 提交权限（0同角色所有人提交跃迁，1同角色有一人提交跃迁）默认0
	 */
	public void setVbauth(String vbauth) {
		this.vbauth = vbauth;
	}

	/**
	 * 图片名取得
	 * 
	 * @return 图片名
	 */
	public String getVbimage() {
		return vbimage;
	}

	/**
	 * 图片名设定
	 * 
	 * @param pbdimage 图片名
	 */
	public void setVbimage(String vbimage) {
		this.vbimage = vbimage;
	}

	/**
	 *校验表单是否必填取得
	 */
	public String getVbrequired() {
		return vbrequired;
	}

	/**
	 *校验表单是否必填设定
	 */
	public void setVbrequired(String vbrequired) {
		this.vbrequired = vbrequired;
	}

	/**
	 *校验记录是否必填取得
	 */
	public String getVbrecord() {
		return vbrecord;
	}

	/**
	 *校验记录是否必填设定
	 */
	public void setVbrecord(String vbrecord) {
		this.vbrecord = vbrecord;
	}

	/**
	 *弹出页js名称取得
	 */
	public String getVbacturl() {
		return vbacturl;
	}

	/**
	 *弹出页js名称设定
	 */
	public void setVbacturl(String vbacturl) {
		this.vbacturl = vbacturl;
	}
	
	
	
}