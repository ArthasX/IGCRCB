/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG258Info;

/**
  * ����: ����״̬�����ߵ���ʵ��
  * ��������: ����״̬�����ߵ���ʵ��
  * ������¼: 2012/05/09
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG258")
public class IG258TB extends BaseEntity implements Serializable,
		Cloneable, IG258Info {

	/** ���� */
	@Id
	protected String pspcdid;

	/** ��ǰ״̬ID */
	protected String psdid;

	/** �ɸı�״̬id */
	protected String pspcdpsdid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPspcdid() {
		return pspcdid;
	}

	/**
	 * �����趨
	 *
	 * @param pspcdid ����
	 */
	public void setPspcdid(String pspcdid) {
		this.pspcdid = pspcdid;
	}

	/**
	 * ��ǰ״̬IDȡ��
	 *
	 * @return ��ǰ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ��ǰ״̬ID�趨
	 *
	 * @param psdid ��ǰ״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �ɸı�״̬idȡ��
	 *
	 * @return �ɸı�״̬id
	 */
	public String getPspcdpsdid() {
		return pspcdpsdid;
	}

	/**
	 * �ɸı�״̬id�趨
	 *
	 * @param pspcdpsdid �ɸı�״̬id
	 */
	public void setPspcdpsdid(String pspcdpsdid) {
		this.pspcdpsdid = pspcdpsdid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pspcdid;
	}

}