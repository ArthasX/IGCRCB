/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.IG622Info;

/**
  * 概述: 首页跳转URL定义实体
  * 功能描述: 首页跳转URL定义实体
  * 创建记录: 2012/07/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG622")
public class IG622TB extends BaseEntity implements Serializable,
		Cloneable, IG622Info {

	/** 首页ID */
	@Id
	protected String hpid;

	/** 首页描述 */
	protected String hplabel;
	
	/** 首页显示名称 */
	protected String hptitle;

	/** 首页URL */
	protected String hpurl;

	/**
	 * 首页ID取得
	 *
	 * @return 首页ID
	 */
	public String getHpid() {
		return hpid;
	}

	/**
	 * 首页ID设定
	 *
	 * @param hpid 首页ID
	 */
	public void setHpid(String hpid) {
		this.hpid = hpid;
	}

	/**
	 * 首页描述取得
	 *
	 * @return 首页描述
	 */
	public String getHplabel() {
		return hplabel;
	}

	/**
	 * 首页描述设定
	 *
	 * @param hplabel 首页描述
	 */
	public void setHplabel(String hplabel) {
		this.hplabel = hplabel;
	}

	/**
	 * 首页显示名称取得
	 *
	 * @return 首页显示名称
	 */
	public String getHptitle() {
		return hptitle;
	}

	/**
	 * 首页显示名称设定
	 *
	 * @param hptitle 首页显示名称
	 */
	public void setHptitle(String hptitle) {
		this.hptitle = hptitle;
	}

	/**
	 * 首页URL取得
	 *
	 * @return 首页URL
	 */
	public String getHpurl() {
		return hpurl;
	}

	/**
	 * 首页URL设定
	 *
	 * @param hpurl 首页URL
	 */
	public void setHpurl(String hpurl) {
		this.hpurl = hpurl;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return hpid;
	}

}