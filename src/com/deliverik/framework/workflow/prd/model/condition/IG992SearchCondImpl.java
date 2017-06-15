/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

import java.io.Serializable;
/**
  * 概述: 流程外部调用定义表检索条件实现
  * 功能描述: 流程外部调用定义表检索条件实现
  * 创建记录: 2012/04/20
  * 修改记录: 
  */
public class IG992SearchCondImpl implements
IG992SearchCond {

	/** 主键 */
	protected Integer pedid;

	/** 外部事件ID */
	protected String pedeventid;

	/** 外部动作 */
	protected String pedaction;

	/** 外部描述 */
	protected String peddesc;


	public Integer getPedid() {
		return pedid;
	}

	public void setPedid(Integer pedid) {
		this.pedid = pedid;
	}

	/**
	 * 外部事件取得
	 *
	 * @return 外部事件
	 */
	public String getPedeventid() {
		return pedeventid;
	}

	/**
	 * 外部事件设定
	 *
	 * @param pedeventid外部事件
	 */
	public void setPedeventid(String pedeventid) {
		this.pedeventid = pedeventid;
	}

	/**
	 * 外部动作取得
	 *
	 * @return 外部动作
	 */
	public String getPedaction() {
		return pedaction;
	}

	/**
	 * 外部动作设定
	 *
	 * @param pdid 外部动作
	 */
	public void setPedaction(String pedaction) {
		this.pedaction = pedaction;
	}

	/**
	 * 外部描述取得
	 *
	 * @return 外部描述
	 */
	public String getPeddesc() {
		return peddesc;
	}

	/**
	 * 外部描述设定
	 *
	 * @param psdid 外部描述
	 */
	public void setPeddesc(String peddesc) {
		this.peddesc = peddesc;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pedid;
	}
}