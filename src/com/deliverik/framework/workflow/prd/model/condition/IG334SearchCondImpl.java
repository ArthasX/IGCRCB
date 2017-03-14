/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 通知策略基本信息检索条件实现
  * 功能描述: 通知策略基本信息检索条件实现
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public class IG334SearchCondImpl implements IG334SearchCond {

	/** 流程类型ID模糊查询 */
	protected String pdid_like;

	/** 流程类型ID等值查询 */
	private String pdid_eq;

	/** 流程表单ID(完全匹配) */
	protected String pidid_eq;

	/** 流程表单ID(模糊匹配) */
	protected String pidid_like;

	/**
	 * 流程类型ID模糊查询取得
	 *
	 * @return pdid_like 流程类型ID模糊查询
	 */
	public String getPdid_like() {
		return pdid_like;
	}

	/**
	 * 流程类型ID模糊查询设定
	 *
	 * @param pdid_like 流程类型ID模糊查询
	 */
	public void setPdid_like(String pdid_like) {
		this.pdid_like = pdid_like;
	}

	/**
	 * 获取流程类型ID
	 */
	public String getPdid_eq() {
		return pdid_eq;
	}

	/**
	 * 流程表单ID(完全匹配)设定
	 * @param pidid_eq
	 */
	public void setPidid_eq(String pidid_eq) {
		this.pidid_eq = pidid_eq;
	}

	/**
	 * 设定流程类型ID等值查询
	 * @param pdid_eq
	 */
	public void setPdid_eq(String pdid_eq) {
		this.pdid_eq = pdid_eq;
	}

	/**
	 * 流程表单ID(完全匹配)取得
	 * @return pidid_eq 流程表单ID(完全匹配)
	 */
	public String getPidid_eq() {
		return pidid_eq;
	}

	/**
	 * 流程表单ID(模糊匹配)取得
	 * @return pidid_like 流程表单ID(模糊匹配)
	 */
	public String getPidid_like() {
		return pidid_like;
	}
	
}