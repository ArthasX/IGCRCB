package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG126Info;

/**
 * 流程页面定义信息实体
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "IG126")
public class IG126TB extends BaseEntity implements Serializable,
		Cloneable, IG126Info {
	
	/** 流程页面定义ID */
	@Id
	protected String pjdid;

	/** 流程定义ID */
	protected String pdid;

	/** 页面类型：1-发起，2-处理，3-查看 */
	protected String pjdtype;

	/** 自定义BL名称 */
	protected String pjdblid;

	/** 页面路径 */
	protected String pjdurl;

	/**
	 * 流程页面定义ID取得
	 * 
	 * @return 流程页面定义ID
	 */
	public String getPjdid() {
		return pjdid;
	}

	/**
	 * 流程页面定义ID设定
	 * 
	 * @param pjdid流程页面定义ID
	 */
	public void setPjdid(String pjdid) {
		this.pjdid = pjdid;
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
	 * @param pdid流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 页面类型取得
	 * 
	 * @return 页面类型
	 */
	public String getPjdtype() {
		return pjdtype;
	}

	/**
	 * 页面类型设定
	 * 
	 * @param pjdtype页面类型
	 */
	public void setPjdtype(String pjdtype) {
		this.pjdtype = pjdtype;
	}

	/**
	 * 自定义BL名称取得
	 * 
	 * @return 自定义BL名称
	 */
	public String getPjdblid() {
		return pjdblid;
	}

	/**
	 * 自定义BL名称设定
	 * 
	 * @param pjdblid自定义BL名称
	 */
	public void setPjdblid(String pjdblid) {
		this.pjdblid = pjdblid;
	}

	/**
	 * 页面路径取得
	 * 
	 * @return 页面路径
	 */
	public String getPjdurl() {
		return pjdurl;
	}

	/**
	 * 页面路径设定
	 * 
	 * @param pjdurl页面路径
	 */
	public void setPjdurl(String pjdurl) {
		this.pjdurl = pjdurl;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public Serializable getPK() {
		return pjdid;
	}

	/**
	 * 比较方法
	 * 
	 * @param obj流程页面定义信息
	 * @return 比较结果
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof IG126TB))
			return false;
		IG126Info target = (IG126Info) obj;
		if (!(getPjdid() == target.getPjdid()))
			return false;
		return true;
	}

}
