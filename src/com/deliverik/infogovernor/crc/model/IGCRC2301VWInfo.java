/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ���ܣ����򿪷�ͳ��
 * @author yukexin 2014-8-12 10:57:37
 */
public interface IGCRC2301VWInfo extends BaseModel{
	
	/**
	 * ����ȡ��
	 * @return userID  ����
	 */
	public String getUserID();
	
	/**
	 * ��Ա����ȡ��
	 * @return userName  ��Ա����
	 */
	public String getUserName();
	/**
	 * ��������ȡ��
	 * @return disposeNum  ��������
	 */
	public Integer getDisposeNum();
	/**
	 * ���Ը��²��ش���ȡ��
	 * @return testUpdateRejectNum  ���Ը��²��ش���
	 */
	public int getTestUpdateRejectNum();
	/**
	 * ���Բ��ش���ȡ��
	 * @return testRejectNum  ���Բ��ش���
	 */
	public int getTestRejectNum();
	/**
	 * ȷ�ϲ��ش���ȡ��
	 * @return confirmRejectNum  ȷ�ϲ��ش���
	 */
	public int getConfirmRejectNum();
	
	
}
