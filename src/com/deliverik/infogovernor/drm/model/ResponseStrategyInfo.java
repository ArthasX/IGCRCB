/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������Ӧ���Խӿ�
  * ��������: ������Ӧ���Խӿ�
  * ������¼: 2016/09/20
  * �޸ļ�¼: 
  */
public interface ResponseStrategyInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRsid();

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getSenceid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getStrategyDesc();

	/**
	 * �ؼ���ȡ��
	 *
	 * @return �ؼ���
	 */
	public String getKeyword();

	/**
	 * ���⴦����ȡ��
	 *
	 * @return ���⴦����
	 */
	public String getHandleBL();
	
	/**
	 * ���⴦��BL�Ĳ���
	 * @return
	 */
	public String getRsargs();

}