/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: �������Աʵ������
  * ��������: �������Աʵ������
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class IG485PK extends BasePK implements Serializable {

	/** �����������ϵ���� */
	protected String pgreid;

	/**  ������ʵ��ID */
	protected Integer pgrid;

	/** �ο�����ʵ��ID */
	protected Integer prid;
	
	public IG485PK() {}
	
	public IG485PK(String pgreid, Integer pgrid, Integer prid) {
		super();
		this.pgreid = pgreid;
		this.pgrid = pgrid;
		this.prid = prid;
	}

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

}