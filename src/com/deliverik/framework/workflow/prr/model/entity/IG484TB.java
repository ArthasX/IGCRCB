/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG484Info;

/**
  * ����: �������Աʵ��ʵ��
  * ��������: �������Աʵ��ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG484PK.class)
@Table(name="IG484")
public class IG484TB extends BaseEntity implements Serializable,
		Cloneable, IG484Info {

	/** ������ʵ��ID */
	@Id
	protected Integer pgrid;
	
	/** ����ʵ��ID */
	@Id
	protected Integer prid;
	
	/** ���̶���ID */
	protected String pdid;

	/**
	 * ������ʵ��IDȡ��
	 * @return ������ʵ��ID
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 * ������ʵ��ID�趨
	 * @param pgrid ������ʵ��ID
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

	/**
	 * ����ʵ��IDȡ��
	 * @return ����ʵ��ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ʵ��ID�趨
	 * @param prid ����ʵ��ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * ���̶���IDȡ��
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG484PK(pgrid, prid);
	}

}