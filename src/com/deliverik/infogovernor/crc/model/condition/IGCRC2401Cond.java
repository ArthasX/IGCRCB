/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.condition;

/**
 * ����: �¼�ƽ�����ʱ����������ӿ�
 */
public interface IGCRC2401Cond {
	/**
	 * ���ȡ��
	 * @return year ���
	 */
	public String getYear();
	/**
	 * �·�ȡ��
	 * @return month �·�
	 */
	public String getMonth();
	/**
	 * ����ȡ��
	 * @return dept ����
	 */
	public String getDept();
	
	/***
	 *  1.�¼���
	 *  2.�澯
	 * @return
	 */
	public String getSign();

}
