/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: EiWaitTaskTemp�ӿ�
  * ��������: EiWaitTaskTemp�ӿ�
  * ������¼: 2012/07/30
  * �޸ļ�¼: 
  */
public interface SOC0116Info extends BaseModel {

	/**
	 * ewtIdȡ��
	 *
	 * @return ewtId
	 */
	public Integer getEwtId();

	/**
	 * �ļ�����ȡ��
	 *
	 * @return �ļ�����
	 */
	public String getFileName();

	/**
	 * batNameȡ��
	 *
	 * @return userId
	 */
	public String getUserId();

	/**
	 * ʵ������ȡ��
	 *
	 * @return ʵ������
	 */
	public String getEiName();

	/**
	 * ʵ��Idȡ��
	 *
	 * @return ʵ��Id
	 */
	public String getEitId();

}