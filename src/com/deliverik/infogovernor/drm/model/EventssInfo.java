/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �¼������ӿ�
  * ��������: �¼������ӿ�
  * ������¼: 2015/03/18
  * �޸ļ�¼: 
  */
public interface EventssInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEventid();

	/**
	 * �¼�����ȡ��
	 *
	 * @return �¼�����
	 */
	public String getEventname();

	/**
	 * �¼��ȼ�ȡ��
	 *
	 * @return �¼��ȼ�
	 */
	public Integer getLabels();
	
	/**
	 * �¼�����ȡ��
	 *
	 * @return �¼�����
	 */
	public String getEventdes();

}