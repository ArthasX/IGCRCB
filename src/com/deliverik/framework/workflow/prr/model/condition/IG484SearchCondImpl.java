/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: �������Աʵ����������ʵ��
  * ��������: �������Աʵ����������ʵ��
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public class IG484SearchCondImpl implements
		IG484SearchCond {
	
	/** ������ID */
	protected Integer pgrid;
	
	/** ����ID */
	protected Integer prid;

	
	/**
	 * @return the prid
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * @param prid the prid to set
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ������IDȡ��
	 * @return ������ID
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 * ������ID�趨
	 * @param pgrid ������ID
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

}