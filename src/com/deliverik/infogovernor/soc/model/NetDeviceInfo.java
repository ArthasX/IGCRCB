/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����豸�˿ڽӿ�
  * ��������: �����豸�˿ڽӿ�
  * ������¼: 2013/12/30
  * �޸ļ�¼: 
  */
public interface NetDeviceInfo extends BaseModel{
	/**
	 * eiidȡ��
	 *
	 * @return eiid eiid
	 */
	public String getEiid();

	/**
	 * eilabelȡ��
	 *
	 * @return eilabel eilabel
	 */
	public String getEilabel();

	/**
	 * civalueȡ��
	 *
	 * @return civalue civalue
	 */
	public String getCivalue();

	/**
	 * eiupdtimeȡ��
	 *
	 * @return eiupdtime eiupdtime
	 */
	public String getEiupdtime();
}