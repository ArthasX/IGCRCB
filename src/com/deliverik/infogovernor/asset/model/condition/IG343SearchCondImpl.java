/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: EntityItemRelationVW��������ʵ��
  * ��������: EntityItemRelationVW��������ʵ��
  * ������¼: 2012/07/12
  * �޸ļ�¼: 
  */
public class IG343SearchCondImpl implements
IG343SearchCond {

	/** ���������� */
	protected String einame_like;
	
	/** �����¼��ʼʱ�� */
	protected String beginTime_q;
	
	/** �����¼����ʱ�� */
	protected String endTime_q;


	/**
	 * ��ȡ����������
	 * @return einame_like
	 */
	public String getEiname_like() {
		return einame_like;
	}

	/**
	 * ���÷���������
	 * @param einame_like
	 */
	public void setEiname_like(String einame_like) {
		this.einame_like = einame_like;
	}

	/**
	 * ��ȡ�����¼��ʼʱ��
	 * @return beginTime_q
	 */
	public String getBeginTime_q() {
		return beginTime_q;
	}

	/**
	 * ���÷����¼��ʼʱ��
	 * @param beginTime_q
	 */
	public void setBeginTime_q(String beginTime_q) {
		this.beginTime_q = beginTime_q;
	}

	/**
	 * ��ȡ�����¼����ʱ��
	 * @return endTime_q
	 */
	public String getEndTime_q() {
		return endTime_q;
	}

	/**
	 * ���÷����¼����ʱ��
	 * @param endTime_q
	 */
	public void setEndTime_q(String endTime_q) {
		this.endTime_q = endTime_q;
	}
	
}