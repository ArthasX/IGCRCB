/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程组成员表检索条件实现
  * 功能描述: 流程组成员表检索条件实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG481SearchCondImpl implements
		IG481SearchCond {
	
	/** 流程组id */
	protected String pgdid;

	/** 发起方式 */
	protected String createType;
	/**单一流程定义ID*/
	protected String pdid;
	/**单一流程定义ID模糊查询*/
	protected String pdid_like;
	/**单提流程定义ID集合*/
	protected String[] pdids_in;
	
	/**
	 * 流程组id取得
	 *
	 * @return 流程组id
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * 流程组id设定
	 *
	 * @param pgdid 流程组id
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * 发起方式取得
	 *
	 * @return 发起方式
	 */
	public String getCreateType() {
		return createType;
	}

	/**
	 * 发起方式设定
	 *
	 * @param createType 发起方式
	 */
	public void setCreateType(String createType) {
		this.createType = createType;
	}

	/**
	 * pdid   取得
	 * @return pdid pdid
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * pdid   设定
	 * @param pdid pdid
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * pdids_in   取得
	 * @return pdids_in pdids_in
	 */
	public String[] getPdids_in() {
		return pdids_in;
	}

	/**
	 * pdids_in   设定
	 * @param pdids_in pdids_in
	 */
	public void setPdids_in(String[] pdids_in) {
		this.pdids_in = pdids_in;
	}

	/**
	 * @return the 单一流程定义ID模糊查询
	 */
	public String getPdid_like() {
		return pdid_like;
	}

	/**
	 * @param 单一流程定义ID模糊查询 the pdid_like to set
	 */
	public void setPdid_like(String pdid_like) {
		this.pdid_like = pdid_like;
	}

}