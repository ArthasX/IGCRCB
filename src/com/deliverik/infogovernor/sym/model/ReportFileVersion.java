/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ������Ϣ�ӿ�
 * 
 */

public interface ReportFileVersion  extends BaseModel {

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getRfvid();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getRfdid();

	/**
	 * �汾��ȡ��
	 * @return �汾��
	 */
	public Integer getRfvversion();

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getRfvinstime();

}