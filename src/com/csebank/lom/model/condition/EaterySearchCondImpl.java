/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ʳ�óɱ���Ϣ��ѯ�ӿ�ʵ��
 *
 */
public class EaterySearchCondImpl implements EaterySearchCond {
	
	/**
	 * ʳ�óɱ���Ϣ��ʼʱ���ѯ
	 */
	public String etime_from;
	
	/**
	 * ʳ�óɱ���Ϣ����ʱ���ѯ
	 */
	public String etime_to;

	/**
	 * ʳ�óɱ���Ϣʱ���ѯȡ��
	 * @return ʳ�óɱ���Ϣ��ʼʱ���ѯ
	 */
	public String getEtime_from() {
		return etime_from;
	}

	/**
	 * ʳ�óɱ���Ϣ��ʼʱ���ѯ�趨
	 * @param etime_from ʳ�óɱ���Ϣ��ʼʱ���ѯ
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}

	/**
	 * ʳ�óɱ���Ϣ����ʱ���ѯȡ��
	 * @return ʳ�óɱ���Ϣ����ʱ���ѯ
	 */
	public String getEtime_to() {
		return etime_to;
	}

	/**
	 * ʳ�óɱ���Ϣ����ʱ���ѯ�趨
	 * @param etime_to ʳ�óɱ���Ϣ����ʱ���ѯ
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}

}
