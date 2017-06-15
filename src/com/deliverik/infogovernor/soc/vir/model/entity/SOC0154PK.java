/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: soc0154实体主键
  * 功能描述: soc0154实体主键
  * 创建记录: 2013/12/29
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class SOC0154PK extends BasePK implements Serializable {

	/** myid */
	protected String myid;

	/** fromid */
	protected String fromid;

	/** isellipsis */
	protected String isellipsis;

	/**
	 * 构造函数
	 */
	public SOC0154PK() {

	}

	/**
	 * 构造函数
	 */
	public SOC0154PK(String myid, String fromid, String isellipsis) {
		super();
		this.myid = myid;
		this.fromid = fromid;
		this.isellipsis = isellipsis;
	}

	/**
	 * myid取得
	 *
	 * @return myid
	 */
	public String getMyid() {
		return myid;
	}

	/**
	 * myid设定
	 *
	 * @param myid myid
	 */
	public void setMyid(String myid) {
		this.myid = myid;
	}

	/**
	 * fromid取得
	 *
	 * @return fromid
	 */
	public String getFromid() {
		return fromid;
	}

	/**
	 * fromid设定
	 *
	 * @param fromid fromid
	 */
	public void setFromid(String fromid) {
		this.fromid = fromid;
	}

	/**
	 * isellipsis取得
	 *
	 * @return isellipsis
	 */
	public String getIsellipsis() {
		return isellipsis;
	}

	/**
	 * isellipsis设定
	 *
	 * @param isellipsis isellipsis
	 */
	public void setIsellipsis(String isellipsis) {
		this.isellipsis = isellipsis;
	}

}