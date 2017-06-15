/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.condition;

/**
  * 概述: 抄阅人表检索条件实现
  * 功能描述: 抄阅人表检索条件实现
  * 创建记录: 2013/02/25
  * 修改记录: 
  */
public class CopyReadUserSearchCondImpl implements
		CopyReadUserSearchCond {

	
	/** 流程名称 */
	protected String prtitle;
	
	/** 处理人id */
	protected String pruserid ;
	
	/** 是否查看标识 */
	protected String islook;
	
	/** 流程主键 */
	protected Integer prid;
	/**
	 * 流程名称取得
	 *
	 * @return 流程名称
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * 流程名称设定
	 *
	 * @param prtitle 流程名称
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 处理人id取得
	 *
	 * @return 处理人id
	 */
	public String getPruserid () {
		return pruserid ;
	}

	/**
	 * 处理人id设定
	 *
	 * @param pruserid  处理人id
	 */
	public void setPruserid (String pruserid ) {
		this.pruserid  = pruserid ;
	}
	/**
	 * 是否查看标识取得
	 *
	 * @return 是否查看标识
	 */
	public String getIslook() {
		return islook;
	}

	/**
	 * 是否查看标识设定
	 *
	 * @param islook 是否查看标识
	 */
	public void setIslook(String islook) {
		this.islook = islook;
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
	
	
}