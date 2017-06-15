/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
  * ����: soc0154ʵ��
  * ��������: soc0154ʵ��
  * ������¼: 2013/12/29
  * �޸ļ�¼: 
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
	 * myidȡ��
	 *
	 * @return myid
	 */
	public String getMyid() {
		return myid;
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
	 * fromidȡ��
	 *
	 * @return fromid
	 */
	public String getFromid() {
		return fromid;
	}

	/**
	 * fromid�趨
	 *
	 * @param fromid fromid
	 */
	public void setFromid(String fromid) {
		this.fromid = fromid;
	}

	/**
	 * isellipsisȡ��
	 *
	 * @return isellipsis
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
	 * aixsȡ��
	 *
	 * @return aixs
	 */
	public String getAixs() {
		return aixs;
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
	 * useridȡ��
	 *
	 * @return userid
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

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new SOC0154PK(myid, fromid, isellipsis);
	}

}