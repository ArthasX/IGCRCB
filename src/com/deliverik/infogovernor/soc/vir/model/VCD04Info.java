/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: vCloud������־�ӿ�
  * ��������: vCloud������־�ӿ�
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public interface VCD04Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * ��Ŀ����ȡ��
	 *
	 * @return ��Ŀ����
	 */
	public Integer getPid();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getVmName();

	/**
	 * ��־����ȡ��
	 *
	 * @return ��־����
	 */
	public String getContent();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getUpdateTime();

	/**
	 * ��־ȡ��
	 *
	 * @return ��־
	 */
	public String getFlag();

}