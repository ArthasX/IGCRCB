/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �û���Ϣʱ�䶨���ӿ�
  * ��������: �û���Ϣʱ�䶨���ӿ�
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public interface ProcessWorkTimeInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPwId();

	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserId();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPwDate();

	/**
	 * ������ʼʱ��ȡ��
	 *
	 * @return ������ʼʱ��
	 */
	public String getPwStartTime();

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getPwEndTime();

	/**
	 * ��Ϣʱ��ȡ��
	 *
	 * @return ��Ϣʱ��
	 */
	public Integer getPwSleep();

	/**
	 * �û��޸ı�־λȡ��
	 *
	 * @return �û��޸ı�־λ
	 */
	public String getPwFlg();

	/**
	 * ��Чʱ��ȡ��
	 *
	 * @return ��Чʱ��
	 */
	public Integer getFactTime();


}