/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ʳ�óɱ���Ϣ��ѯ�ӿ�ʵ��
 *
 */
public class EworkingLunchSearchCondImpl implements EworkingLunchSearchCond {
	
	/**
	 * ʳ�ù�������Ϣ��ѯʱ�俪ʼ
	 */
	public String ewltime_from;
	
	/**
	 * ʳ�ù�������Ϣ��ѯʱ�����
	 */
	public String ewltime_to;

	/**
	 * ʳ�ù�������Ϣ��ѯʱ�俪ʼ
	 * @return ʳ�ù�������Ϣ��ѯʱ�俪ʼ
	 */
	public String getEwltime_from() {
		return ewltime_from;
	}

	/**
	 * ʳ�ù�������Ϣ��ѯʱ�俪ʼ
	 * @param etime_from ʳ�ù�������Ϣ��ѯʱ�俪ʼ
	 */
	public void setEwltime_from(String ewltime_from) {
		this.ewltime_from = ewltime_from;
	}

	/**
	 * ʳ�ù�������Ϣ��ѯʱ�����
	 * @return ʳ�ù�������Ϣ��ѯʱ�����
	 */
	public String getEwltime_to() {
		return ewltime_to;
	}

	/**
	 * ʳ�ù�������Ϣ��ѯʱ�����
	 * @param etime_to ʳ�ù�������Ϣ��ѯʱ�����
	 */
	public void setEwltime_to(String ewltime_to) {
		this.ewltime_to = ewltime_to;
	}

}
