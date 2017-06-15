/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dbm.model.TOPOXMLInfo;

/**
  * 概述: TOPOXML实体
  * 功能描述: TOPOXML实体
  * 创建记录: 2012/10/31
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="TOPOXML")
@IdClass(TOPOXMLTBPK.class)
public class TOPOXMLTB extends BaseEntity implements Serializable,
		Cloneable, TOPOXMLInfo {

	/** address */
	@Id
	private String myid;
	@Id
	private String isellipsis;
	/** aixs */
	private String aixs;
	/** userid */
	private String userid;
	


	/**
	 * myid取得
	 *
	 * @return myid myid
	 */
	public String getMyid() {
		return myid;
	}


	/**
	 * aixs取得
	 *
	 * @return aixs aixs
	 */
	public String getAixs() {
		return aixs;
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
	 * aixs设定
	 *
	 * @param aixs aixs
	 */
	public void setAixs(String aixs) {
		this.aixs = aixs;
	}


	/**
	 * isellipsis取得
	 *
	 * @return isellipsis isellipsis
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
	 * userid取得
	 *
	 * @return userid userid
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

	public Serializable getPK() {
		return new TOPOXMLTBPK(myid,isellipsis);
	}

}