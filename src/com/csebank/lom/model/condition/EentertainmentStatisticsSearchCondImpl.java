/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ʳ���д�����ͳ�ƽӿ�ʵ��
 *
 */
public class EentertainmentStatisticsSearchCondImpl implements EentertainmentStatisticsSearchCond {
	
	/**
	 * ��ѯ����
	 */
	public String ewhere;
	
	/**
	 * ʳ���д�����ͳ�ƿ�ʼʱ���ѯ
	 */
	public String etime_from;
	
	/**
	 * ʳ���д�����ͳ�ƽ���ʱ���ѯ
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
	 * ʳ���д�����ͳ�ƿ�ʼʱ���ѯ�趨
	 * @param etime_from ʳ���д�����ͳ�ƿ�ʼʱ���ѯ
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}

	/**
	 * ʳ���д�����ͳ�ƽ���ʱ���ѯȡ��
	 * @return ʳ���д�����ͳ�ƽ���ʱ���ѯ
	 */
	public String getEtime_to() {
		return etime_to;
	}

	/**
	 * ʳ���д�����ͳ�ƽ���ʱ���ѯ�趨
	 * @param etime_to ʳ���д�����ͳ�ƽ���ʱ���ѯ
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}
	
	/**
	 * ��ѯ����
	 * @return ��ѯ����
	 */
	public String getEwhere() {
		return ewhere;
	}
	
	/**
	 * ��ѯ����
	 * @param ewhere ��ѯ����
	 */
	public void setEwhere(String ewhere) {
		this.ewhere = ewhere;
	}

}
