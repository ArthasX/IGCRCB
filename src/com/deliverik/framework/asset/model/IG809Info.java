/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * �ʲ���ϵͼ�ļ���Ϣ
 *
 */
public interface IG809Info extends BaseModel{

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getEirfid();
	
	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public Integer getEiid();
	
	/**
	 * ��ϵͼ����ȡ��
	 * @return ��ϵͼ����
	 */
	public String getEirftype();
	
	/**
	 * ��ϵͼ�ļ���ȡ��
	 * @return ��ϵͼ�ļ���
	 */
	public String getEirfname();
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getEirfupdtime();
	
}
