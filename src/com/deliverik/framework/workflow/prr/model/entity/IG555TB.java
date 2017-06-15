/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG555Info;

/**
  * 概述: 流程处理页返回配置信息实体
  * 功能描述: 流程处理页返回配置信息实体
  * 创建记录: 2013/08/29
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG555")
public class IG555TB extends BaseEntity implements Serializable,
		Cloneable, IG555Info {

	/** 标识 */
	@Id
	protected String jump;

	/** 返回路径 */
	protected String url;
	
	/** 说明 */
	protected String description;

	/**
	 * 标识取得
	 *
	 * @return 标识
	 */
	public String getJump() {
		return jump;
	}

	/**
	 * 标识设定
	 *
	 * @param jump 标识
	 */
	public void setJump(String jump) {
		this.jump = jump;
	}

	/**
	 * 返回路径取得
	 *
	 * @return 返回路径
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 返回路径设定
	 *
	 * @param url 返回路径
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return jump;
	}

	/**
	 * 说明取得
	 * @return 说明
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 说明设定
	 * @param description 说明
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}