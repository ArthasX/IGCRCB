/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model.condition;

/**
 * ����: 
 * ����������
 * �����ˣ���͢־
 * ������¼�� 2012-5-22
 * �޸ļ�¼��
 */
public class InvestUseInfoSearchCondImpl implements InvestUseInfoSearchCond{
	/** ��Ŀ����ʱ�俪ʼ */
	private String popentime_start;
	/** ��Ŀ����ʱ����� */
	private String popentime_end;
	/**
	 * ��Ŀ����ʱ�俪ʼȡ��
	 * @return popentime_start ��Ŀ����ʱ�俪ʼ
	 */
	public String getPopentime_start() {
		return popentime_start;
	}
	/**
	 * ��Ŀ����ʱ�俪ʼ�趨
	 * @param popentime_start ��Ŀ����ʱ�俪ʼ
	 */
	public void setPopentime_start(String popentime_start) {
		this.popentime_start = popentime_start;
	}
	/**
	 * ��Ŀ����ʱ�����ȡ��
	 * @return popentime_end ��Ŀ����ʱ�����
	 */
	public String getPopentime_end() {
		return popentime_end;
	}
	/**
	 * ��Ŀ����ʱ������趨
	 * @param popentime_end ��Ŀ����ʱ�����
	 */
	public void setPopentime_end(String popentime_end) {
		this.popentime_end = popentime_end;
	}
}
