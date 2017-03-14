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
import com.deliverik.framework.workflow.prr.model.IG485Info;

/**
  * ����: �����������ϵʵ����ʵ��
  * ��������: �����������ϵʵ����ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG485PK.class)
@Table(name="IG485")
public class IG485TB extends BaseEntity implements Serializable,
		Cloneable, IG485Info {

	/** �����������ϵ���� */
	@Id
	protected String pgreid;

	/**  ������ʵ��ID */
	@Id
	protected Integer pgrid;

	/** �ο�����ʵ��ID */
	@Id
	protected Integer prid;

	/** ״̬ */
	protected String pgrrstatus;

	/** ���ʱ�� */
	protected String pgrtime;

	/**
	 * �����������ϵ����ȡ��
	 *
	 * @return �����������ϵ����
	 */
	public String getPgreid() {
		return pgreid;
	}

	/**
	 * �����������ϵ�����趨
	 *
	 * @param pgreid �����������ϵ����
	 */
	public void setPgreid(String pgreid) {
		this.pgreid = pgreid;
	}

	/**
	 *  ������ʵ��idȡ��
	 *
	 * @return  ������ʵ��id
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 *  ������ʵ��id�趨
	 *
	 * @param pgrid  ������ʵ��id
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

	/**
	 * �ο�����ʵ��IDȡ��
	 *
	 * @return �ο�����ʵ��ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * �ο�����ʵ��ID�趨
	 *
	 * @param prid �ο�����ʵ��ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getPgrrstatus() {
		return pgrrstatus;
	}

	/**
	 * ״̬�趨
	 *
	 * @param pgrrstatus ״̬
	 */
	public void setPgrrstatus(String pgrrstatus) {
		this.pgrrstatus = pgrrstatus;
	}

	/**
	 * ���ʱ��ȡ��
	 *
	 * @return ���ʱ��
	 */
	public String getPgrtime() {
		return pgrtime;
	}

	/**
	 * ���ʱ���趨
	 *
	 * @param pgrtime ���ʱ��
	 */
	public void setPgrtime(String pgrtime) {
		this.pgrtime = pgrtime;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new IG485PK(pgreid, pgrid, prid);
	}
	
	

}