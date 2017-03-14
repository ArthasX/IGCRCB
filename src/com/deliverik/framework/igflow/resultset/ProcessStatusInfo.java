/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;


/**
 * ����״̬������Ϣ
 */
public interface ProcessStatusInfo {
	
	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid();
	
	/**
	 * ���̶���IDȡ��
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsdname();
	
	/**
	 * ����״̬��ʶȡ��
	 * @return ����״̬��ʶ
	 */
	public String getPsdcode();
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getBysequence();

	/**
	 * �ϼ�״̬IDȡ��
	 * @return �ϼ�״̬ID
	 */
	public String getPpsdid();

	/**
	 * ״̬��ʼʱ��ȡ��
	 * @return ״̬��ʼʱ��
	 */
	public String getOpentime();

	/**
	 * ״̬����ʱ��ȡ��
	 * @return ״̬����ʱ��
	 */
	public String getClosetime();

	/**
	 * ״̬��֧���ȡ��
	 * @return ״̬��֧���
	 */
	public String getStatusnum();
	
	/**
	 * ʱ���ȡ��
	 * @return fingerPrint ʱ���
	 */
	public String getFingerPrint();

}
