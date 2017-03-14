/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.sta.model;

/**
 * 
 * �������ͳ��ʵ��ӿ�
 * 
 */
public interface ProcessRecordSummary{
	
	/**
	 * ����ȡ��
	 * @return ����
	 */	
	public Integer getPrsid();
	/**
	 * ������������ȡ��
	 * @return ������������
	 */	
	public String getPname();
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
     * �ȴ��ƶ��ƻ�����ȡ��
     *
     * @return initials �ȴ��ƶ��ƻ�����
     */
    public Integer getInitials();
	
	/**
	 * �ȴ������ƻ�����ȡ��
	 * @return �ȴ������ƻ�����
	 */	
	public Integer getAppoval();
	
	/**
	 * �ȴ�����ִ������ȡ��
	 * @return �ȴ�����ִ������
	 */	
	public Integer getImplement();
	
	/**
	 * �ȴ���֤����ȡ��
	 * @return �ȴ���֤����
	 */	
	public Integer getVerify();
	
	/**
	 * �ر�����ȡ��
	 * @return �ر�����
	 */	
	public Integer getClose();	

	/**
	 * �ȴ��ƶ��ƻ�����ȡ��
	 * @return �ȴ��ƶ��ƻ�����
	 */
	public Integer getDispatch();
}
