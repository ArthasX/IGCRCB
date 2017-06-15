/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG898Info;

/**
  * 概述: 表格类表单值表实体
  * 功能描述: 表格类表单值表实体
  * 创建记录: 2013/06/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG898PK.class)
@Table(name="IG898")
public class IG898TB extends BaseEntity implements Serializable, Cloneable, IG898Info {

	/** 流程主键 */
	@Id
	protected Integer prid;

	/** 表单定义主键 */
	@Id
	protected String pidid;

	/** 列定义主键 */
	@Id
	protected String pvcolpidid;

	/** 行号 */
	@Id
	protected String pvrownumber;

	/** 表单值 */
	protected String  pvalue;
	
	/** 表单名称 */
	protected String pidname;
	
	/** 列名 */
	protected String pvcolname;
	
	/** 附件key */
	protected String attkey;

	/**
	 * 流程主键取得
	 *
	 * @return 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 *
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 表单定义主键取得
	 *
	 * @return 表单定义主键
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义主键设定
	 *
	 * @param pidid 表单定义主键
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}
	

	/**
	 * 列定义主键取得
	 * @return pvcolpidid 列定义主键
	 */
	public String getPvcolpidid() {
		return pvcolpidid;
	}

	/**
	 * 列定义主键设定
	 * @param pvcolpidid 列定义主键
	 */
	public void setPvcolpidid(String pvcolpidid) {
		this.pvcolpidid = pvcolpidid;
	}

	/**
	 * 行号取得
	 *
	 * @return 行号
	 */
	public String getPvrownumber() {
		return pvrownumber;
	}

	/**
	 * 行号设定
	 *
	 * @param pvrownumber 行号
	 */
	public void setPvrownumber(String pvrownumber) {
		this.pvrownumber = pvrownumber;
	}

	/**
	 * 表单值取得
	 *
	 * @return 表单值
	 */
	public String getPvalue() {
		return pvalue;
	}

	/**
	 * 表单值设定
	 *
	 * @param pvalue 表单值
	 */
	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}

	/**
	 * 表单名称取得
	 * @return pidname 表单名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 表单名称设定
	 * @param pidname 表单名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 列名取得
	 * @return pvcolname 列名
	 */
	public String getPvcolname() {
		return pvcolname;
	}

	/**
	 * 列名设定
	 * @param pvcolname 列名
	 */
	public void setPvcolname(String pvcolname) {
		this.pvcolname = pvcolname;
	}

	/**
	 * 附件key取得
	 * @return attkey 附件key
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * 附件key设定
	 * @param attkey 附件key
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new IG898PK(prid, pidid, pvcolpidid, pvrownumber);
	}

}