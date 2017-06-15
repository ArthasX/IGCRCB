/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.asset.model.IG611Info;

/**
  * ����: �ʲ�ģ������ȱʡֵʵ��
  * ��������: �ʲ�ģ������ȱʡֵʵ��
  * ������¼: 2012/07/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG611PK.class)
@Table(name="IG611")
public class IG611TB extends BaseEntity implements Serializable,
		Cloneable, IG611Info {

	/** ģ��ID */
	@Id
	protected Integer eid;

	/** ����ID */
	@Id
	protected Integer cid;

	/** ����ֵ */
	protected String cvalue;

	/**
	 * ģ��IDȡ��
	 *
	 * @return ģ��ID
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * ģ��ID�趨
	 *
	 * @param eid ģ��ID
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getCid() {
		return cid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param cid ����ID
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	/**
	 * ����ֵȡ��
	 *
	 * @return ����ֵ
	 */
	public String getCvalue() {
		return cvalue;
	}

	/**
	 * ����ֵ�趨
	 *
	 * @param cvalue ����ֵ
	 */
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG611PK(eid, cid);
	}

}