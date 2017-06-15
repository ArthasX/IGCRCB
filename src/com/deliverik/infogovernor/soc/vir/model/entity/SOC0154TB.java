/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.vir.model.SOC0154Info;

/**
  * 概述: soc0154实体
  * 功能描述: soc0154实体
  * 创建记录: 2013/12/29
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0154PK.class)
@Table(name="soc0154")
public class SOC0154TB extends BaseEntity implements Serializable,
		Cloneable, SOC0154Info {

	/** myid */
	@Id
	protected String myid;

	/** fromid */
	@Id
	protected String fromid;

	/** isellipsis */
	@Id
	protected String isellipsis;

	/** aixs */
	protected String aixs;

	/** userid */
	protected String userid;

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

	/**
	 * aixs取得
	 *
	 * @return aixs
	 */
	public String getAixs() {
		return aixs;
	}

	/**
	 * aixs设定
	 *
	 * @param aixs aixs
	 */
	public void setAixs(String aixs) {
		this.aixs = aixs;
	}

	/**
	 * userid取得
	 *
	 * @return userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * userid设定
	 *
	 * @param userid userid
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new SOC0154PK(myid, fromid, isellipsis);
	}

}