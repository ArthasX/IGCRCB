/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: StorageEvent�ӿ�
  * ��������: StorageEvent�ӿ�
  * ������¼: 2011/06/13
  * �޸ļ�¼: 
  */
public interface StorageEventInfo extends BaseModel {

	/**
	 * ��־��¼ʱ��ȡ��
	 *
	 * @return ��־��¼ʱ��
	 */
	public String getDetectiontime();

	/**
	 * dirȡ��
	 *
	 * @return dir
	 */
	public String getDir();

	/**
	 * srcȡ��
	 *
	 * @return src
	 */
	public String getSrc();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getCategory();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getSeverity();

	/**
	 * �����ȡ��
	 *
	 * @return �����
	 */
	public String getErrornum();

	/**
	 * ��Ϣ����ȡ��
	 *
	 * @return ��Ϣ����
	 */
	public String getErrordesc();
	
	/**
	 * Eirootmark ȡ��
	 * @return eirootmark
	 */
	public String getEirootmark();
	
	/**
	 * ״̬ȡ��
	 * @return state
	 */
	public String getState();
	
	/**
	 * һ������ȡ��
	 * @return sort
	 */
	public String getSort();

	/**
	 * ��¼ʱ���ȡ��
	 *
	 * @return ��¼ʱ���
	 */
	public String getFingerprint();

}