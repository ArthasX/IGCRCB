/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������Ϣ��ӿ�
  * ��������: ������Ϣ��ӿ�
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public interface RemindInfoInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRiid();


	/**
	 * �û�idȡ��
	 *
	 * @return �û�id
	 */
	public String getRiuseid();

	/**
	 * ������Ϣȡ��
	 *
	 * @return ������Ϣ
	 */
	public String getRiinfo();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getRistatus();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRitype();

}