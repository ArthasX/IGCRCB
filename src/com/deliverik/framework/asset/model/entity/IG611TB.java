/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.asset.model.IG611Info;

/**
  * 概述: 资产模型属性缺省值实体
  * 功能描述: 资产模型属性缺省值实体
  * 创建记录: 2012/07/20
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG611PK.class)
@Table(name="IG611")
public class IG611TB extends BaseEntity implements Serializable,
		Cloneable, IG611Info {

	/** 模型ID */
	@Id
	protected Integer eid;

	/** 属性ID */
	@Id
	protected Integer cid;

	/** 属性值 */
	protected String cvalue;

	/**
	 * 模型ID取得
	 *
	 * @return 模型ID
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * 模型ID设定
	 *
	 * @param eid 模型ID
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	/**
	 * 属性ID取得
	 *
	 * @return 属性ID
	 */
	public Integer getCid() {
		return cid;
	}

	/**
	 * 属性ID设定
	 *
	 * @param cid 属性ID
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	/**
	 * 属性值取得
	 *
	 * @return 属性值
	 */
	public String getCvalue() {
		return cvalue;
	}

	/**
	 * 属性值设定
	 *
	 * @param cvalue 属性值
	 */
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new IG611PK(eid, cid);
	}

}