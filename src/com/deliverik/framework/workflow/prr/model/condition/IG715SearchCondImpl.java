/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>����:���񹤵��������̲�ѯ����ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public class IG715SearchCondImpl implements IG715SearchCond {
	
	/** ����ID */
	protected Integer sprrid;
	
	/** ���񹤵�ID */
	protected Integer sprrsfid;

	/** ����ID */
	protected Integer sprrprid;

	/**
	 * ���ܣ�����IDȡ��
	 * @return sprrid ����ID
	 */
	public Integer getSprrid() {
		return sprrid;
	}

	/**
	 * ���ܣ�����IDȡ��
	 * @param sprrid ����ID
	 */
	public void setSprrid(Integer sprrid) {
		this.sprrid = sprrid;
	}

	/**
	 * ���ܣ����񹤵�IDȡ��
	 * @return sprrsfid ���񹤵�ID
	 */ 
	public Integer getSprrsfid() {
		return sprrsfid;
	}

	/**
	 * ���ܣ����񹤵�ID����
	 * @param sprrsfid ���񹤵�ID
	 */
	public void setSprrsfid(Integer sprrsfid) {
		this.sprrsfid = sprrsfid;
	}

	/**
	 * ���ܣ�����IDȡ��
	 * @return sprrprid ����ID
	 */
	public Integer getSprrprid() {
		return sprrprid;
	}

	/**
	 * ���ܣ�����ID����
	 * @param sprrprid ����ID
	 */
	public void setSprrprid(Integer sprrprid) {
		this.sprrprid = sprrprid;
	}


}
