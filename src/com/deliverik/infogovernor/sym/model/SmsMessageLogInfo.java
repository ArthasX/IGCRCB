/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������־��Ϣ��ӿ�
  * ��������: ������־��Ϣ��ӿ�
  * ������¼: 2012/02/20
  * �޸ļ�¼: 
  */
public interface SmsMessageLogInfo extends BaseModel {

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public Integer getMid();

	/**
	 * �ֻ�����ȡ��
	 *
	 * @return �ֻ�����
	 */
	public String getTelephone();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getMessage();

	/**
	 * ҵ��ϵͳ����ȡ��
	 *
	 * @return ҵ��ϵͳ����
	 */
	public String getPlatformInfo();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getSendtime();

	/**
	 * ���Ͷ���IP��ַȡ��
	 *
	 * @return ���Ͷ���IP��ַ
	 */
	public String getSendIP();

}