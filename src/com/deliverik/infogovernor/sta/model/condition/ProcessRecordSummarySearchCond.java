/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.sta.model.condition;

/**
 * �������ͳ�Ʋ�ѯ�����ӿ�
 */
public interface ProcessRecordSummarySearchCond {
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */	
	public String getPcode();
	
	/**
	 * ������Դȡ��
	 * @return ������Դ
	 */
	public String getPrassetname();
	
	/**
	 * �������ķ�������formȡ��
	 * @return �������ķ�������form
	 */	
	public String getPropentime_from();
	
	/**
	 * �������ķ�������toȡ��
	 * @return �������ķ�������to
	 */	
	public String getPropentime_to();
	
	/**
	 * ͳ������ȡ��
	 * @return ͳ������
	 */	
	public String getStatistictype();

}
