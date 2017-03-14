/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG900Info;

/**
  * 概述: 流程按钮定义表实体
  * 功能描述: 流程按钮定义表实体
  * 创建记录: 2012/04/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG900")
public class IG900TB extends BaseEntity implements Serializable,
		Cloneable, IG900Info {

	/** 主键（01更新，02确认）确认，其余已1开头 */
	@Id
	protected String pbdid;

	/** 按钮默认名称 */
	protected String pbdname;

	/** 是否系统保留按钮（1是0否） */
	protected String pbdflag;

	/** 按钮显示图片名称 */
	protected String pbdimage;

	/**
	 * 主键（01更新，02确认）确认，其余已1开头取得
	 *
	 * @return 主键（01更新，02确认）确认，其余已1开头
	 */
	public String getPbdid() {
		return pbdid;
	}

	/**
	 * 主键（01更新，02确认）确认，其余已1开头设定
	 *
	 * @param pbdid 主键（01更新，02确认）确认，其余已1开头
	 */
	public void setPbdid(String pbdid) {
		this.pbdid = pbdid;
	}

	/**
	 * 按钮默认名称取得
	 *
	 * @return 按钮默认名称
	 */
	public String getPbdname() {
		return pbdname;
	}

	/**
	 * 按钮默认名称设定
	 *
	 * @param pbdname 按钮默认名称
	 */
	public void setPbdname(String pbdname) {
		this.pbdname = pbdname;
	}

	/**
	 * 是否系统保留按钮（1是0否）取得
	 *
	 * @return 是否系统保留按钮（1是0否）
	 */
	public String getPbdflag() {
		return pbdflag;
	}

	/**
	 * 是否系统保留按钮（1是0否）设定
	 *
	 * @param pbdflag 是否系统保留按钮（1是0否）
	 */
	public void setPbdflag(String pbdflag) {
		this.pbdflag = pbdflag;
	}
	
	/**
	 * 按钮显示图片名称取得
	 * 
	 * @return 按钮显示图片名称
	 */
	public String getPbdimage() {
		return pbdimage;
	}

	/**
	 * 按钮显示图片名称设定
	 * 
	 * @param pbdimage 按钮显示图片名称
	 */
	public void setPbdimage(String pbdimage) {
		this.pbdimage = pbdimage;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pbdid;
	}

}