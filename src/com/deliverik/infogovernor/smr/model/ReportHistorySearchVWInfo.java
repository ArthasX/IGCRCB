/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model;

import java.io.Serializable;

/**
 * ����:ͨ�ò�ѯ��ͼ�ӿ�
 * ����������ͨ�ò�ѯ��ͼ�ӿ�
 * �����ˣ�����͢
 * ������¼�� 2013-08-14
 * �޸ļ�¼��
 */
public interface ReportHistorySearchVWInfo extends Serializable{

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPrid();
	
	/**
	 * ������ ȡ��
	 *
	 * @return ������ 
	 */
	public String getPrtitle();
	
	/**
	 * ��� ȡ��
	 *
	 * @return ��� 
	 */
	public String getFillinname();
	
	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getReportapprovename();
	
	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPrusername();
	
	/**
	 *����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getPrstarttime();
	
	/**
	 *��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPrpdid();
	
	public String getPrtype();
	
}
