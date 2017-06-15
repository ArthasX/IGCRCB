/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程组定义表检索条件实现
  * 功能描述: 流程组定义表检索条件实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG480SearchCondImpl implements
		IG480SearchCond {
	

	/** 流程组定义ID */
	protected String pgdid_like;
	/** 名称 */
	protected String pgdname_like;

	/** 描述 */
	protected String pgddesc;

	/** 状态 */
	protected String pgdstatus;

	/** 模板类型 */
	protected Integer ptid;

	/**
	 * pgdname   取得
	 * @return pgdname pgdname
	 */
	public String getPgdname_like() {
		return pgdname_like;
	}

	/**
	 * pgdname   设定
	 * @param pgdname pgdname
	 */
	public void setPgdname_like(String pgdname_like) {
		this.pgdname_like = pgdname_like;
	}

	/**
	 * pgddesc   取得
	 * @return pgddesc pgddesc
	 */
	public String getPgddesc() {
		return pgddesc;
	}

	/**
	 * pgddesc   设定
	 * @param pgddesc pgddesc
	 */
	public void setPgddesc(String pgddesc) {
		this.pgddesc = pgddesc;
	}

	/**
	 * pgdstatus   取得
	 * @return pgdstatus pgdstatus
	 */
	public String getPgdstatus() {
		return pgdstatus;
	}

	/**
	 * pgdstatus   设定
	 * @param pgdstatus pgdstatus
	 */
	public void setPgdstatus(String pgdstatus) {
		this.pgdstatus = pgdstatus;
	}

	/**
	 * ptid   取得
	 * @return ptid ptid
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ptid   设定
	 * @param ptid ptid
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}
	
	/**
	 * 流程组定义ID取得
	 * @return 流程组定义ID
	 */
	public String getPgdid_like() {
		return pgdid_like;
	}

	/**
	 * 流程组定义ID设定
	 * @param pgdid_like 流程组定义ID
	 */
	public void setPgdid_like(String pgdid_like) {
		this.pgdid_like = pgdid_like;
	}


}