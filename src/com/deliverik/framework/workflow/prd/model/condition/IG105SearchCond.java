/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
 * ����: ���̲����趨��Ϣ���������ӿ�
 * �������������̲����趨��Ϣ���������ӿ�
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
public interface IG105SearchCond {
	
	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public String getPdid();
	
	/**
	 * ���԰汾ȡ��
	 * 
	 * @return ���԰汾
	 */
	public Integer getPsdversion();
	
	/**
	 * ����״̬ȡ��
	 * 
	 * @return ����״̬
	 */
	public String getPrstatus();

	/**
	 * �����̶�ȡ��
	 * 
	 * @return �����̶�
	 */
	public String getPrurgency();
}
