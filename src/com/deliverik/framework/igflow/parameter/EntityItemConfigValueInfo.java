/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;

import org.apache.struts.upload.FormFile;

/**
 * �ʲ�������Ϣ
 */
public interface EntityItemConfigValueInfo {
	
	/**
	 * �ʲ�IDȡ��
	 * 
	 * @return �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * �ʲ���������ȡ��
	 * 
	 * @return �ʲ���������
	 */
	public String getName();
	
	/**
	 * �ʲ�����ֵȡ��
	 * 
	 * @return �ʲ�����ֵ
	 */
	public String getValue();

	/**
	 * ������Ϣȡ��
	 * @return file ������Ϣ
	 */
	public FormFile getFile();
}
