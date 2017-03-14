/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 表格类表单值表实体主键
  * 功能描述: 表格类表单值表实体主键
  * 创建记录: 2013/06/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class IG898PK extends BasePK implements Serializable {

	/** 流程主键 */
	protected Integer prid;

	/** 表单定义主键 */
	protected String pidid;

	/** 列定义主键 */
	protected String pvcolpidid;

	/** 行号 */
	protected String pvrownumber;

	/**
	 * 构造函数
	 */
	public IG898PK() {

	}

	/**
	 * 构造函数
	 */
	public IG898PK(Integer prid, String pidid, String pvcolpidid, String pvrownumber) {
		super();
		this.prid = prid;
		this.pidid = pidid;
		this.pvcolpidid = pvcolpidid;
		this.pvrownumber = pvrownumber;
	}

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
	 *
	 * @return 列定义主键
	 */
	public String getPvcolpidid() {
		return pvcolpidid;
	}

	/**
	 * 列定义主键设定
	 *
	 * @param pidcolpidid 列定义主键
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

}