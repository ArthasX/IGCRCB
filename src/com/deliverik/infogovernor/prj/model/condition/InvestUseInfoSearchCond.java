/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model.condition;

/**
 * ����:Ͷ��ʹ����ϸ��ѯ�����ӿ� 
 * ����������Ͷ��ʹ����ϸ��ѯ�����ӿ�
 * �����ˣ���͢־
 * ������¼�� 2012-5-22
 * �޸ļ�¼��
 */
public interface InvestUseInfoSearchCond {
	/**
	 * ��Ŀ����ʱ�俪ʼȡ��
	 * @return popentime_start ��Ŀ����ʱ�俪ʼ
	 */
	public String getPopentime_start();
	/**
	 * ��Ŀ����ʱ�����ȡ��
	 * @return popentime_end ��Ŀ����ʱ�����
	 */
	public String getPopentime_end();
}
