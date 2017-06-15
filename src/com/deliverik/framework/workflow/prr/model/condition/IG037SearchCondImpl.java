/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 流程导入日志表检索条件实现
  * 功能描述: 流程导入日志表检索条件实现
  * 创建记录: 2014/11/14
  * 修改记录: 
  */
public class IG037SearchCondImpl implements
		IG037SearchCond {

	/**	流程主键 */
	protected Integer prid;

	/**	流程导入用户ID */
	protected String iruserid;
	
	/**	流程导入部门ID */
	protected String irorgid;
	
	/**	流程导入部门ID左匹配 */
	protected String irorgid_like_l;
	
	/**
	 * 流程主键取得
	 * @return 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程导入用户ID取得
	 * @return 流程导入用户ID
	 */
	public String getIruserid() {
		return iruserid;
	}

	/**
	 * 流程导入用户ID设定
	 * @param iruserid 流程导入用户ID
	 */
	public void setIruserid(String iruserid) {
		this.iruserid = iruserid;
	}

	/**
	 * 流程导入部门ID取得
	 * @return 流程导入部门ID
	 */
	public String getIrorgid() {
		return irorgid;
	}

	/**
	 * 流程导入部门ID设定
	 * @param irorgid 流程导入部门ID
	 */
	public void setIrorgid(String irorgid) {
		this.irorgid = irorgid;
	}

	/**
	 * 流程导入部门ID左匹配取得
	 * @return 流程导入部门ID左匹配
	 */
	public String getIrorgid_like_l() {
		return irorgid_like_l;
	}

	/**
	 * 流程导入部门ID左匹配设定
	 * @param irorgid_like_l 流程导入部门ID左匹配
	 */
	public void setIrorgid_like_l(String irorgid_like_l) {
		this.irorgid_like_l = irorgid_like_l;
	}
	
}