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
public class IG484PK extends BasePK implements Serializable {
	
	/** ������ʵ��ID */
	protected Integer pgrid;
	
	/** ����ʵ��ID */
	protected Integer prid;
	
	public IG484PK() {}
	
	public IG484PK(Integer pgrid, Integer prid) {
		super();
		this.pgrid = pgrid;
		this.prid = prid;
	}

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

}