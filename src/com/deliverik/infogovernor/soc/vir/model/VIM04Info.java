/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��־��ӿ�
  * ��������: ��־��ӿ�
  * ������¼: 2014/02/19
  * �޸ļ�¼: 
  */
public interface VIM04Info extends BaseModel {

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
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
     * ��ȡ����ʱ��
     * @return ����ʱ�� 
     */
    public String getUpdateTime();

	/**
     * ��ȡ��־��0��ʧ��1���ɹ���
     * @return ��־��0��ʧ��1���ɹ��� 
     */
    public String getFlag();
}