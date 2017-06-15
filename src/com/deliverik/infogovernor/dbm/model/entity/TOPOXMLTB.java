/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
  * ����: TOPOXMLʵ��
  * ��������: TOPOXMLʵ��
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
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
	 * myidȡ��
	 *
	 * @return myid myid
	 */
	public String getMyid() {
		return myid;
	}


	/**
	 * aixsȡ��
	 *
	 * @return aixs aixs
	 */
	public String getAixs() {
		return aixs;
	}


	/**
	 * myid�趨
	 *
	 * @param myid myid
	 */
	public void setMyid(String myid) {
		this.myid = myid;
	}


	/**
	 * aixs�趨
	 *
	 * @param aixs aixs
	 */
	public void setAixs(String aixs) {
		this.aixs = aixs;
	}


	/**
	 * isellipsisȡ��
	 *
	 * @return isellipsis isellipsis
	 */
	public String getIsellipsis() {
		return isellipsis;
	}


	/**
	 * isellipsis�趨
	 *
	 * @param isellipsis isellipsis
	 */
	public void setIsellipsis(String isellipsis) {
		this.isellipsis = isellipsis;
	}


	/**
	 * useridȡ��
	 *
	 * @return userid userid
	 */
	public String getUserid() {
		return userid;
	}


	/**
	 * userid�趨
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