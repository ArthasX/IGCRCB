/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��Ϣʱ��ģ�嶨���ӿ�
  * ��������: ��Ϣʱ��ģ�嶨���ӿ�
  * ������¼: 2011/10/08
  * �޸ļ�¼: 
  */
public interface ProcessWorkTimeTemplateInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPwtId();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPwtDate();

	/**
	 * ������ʼʱ��ȡ��
	 *
	 * @return ������ʼʱ��
	 */
	public String getPwtStartTime();

	/**
	 * ��������ʱ��ȡ��
	 *
	 * @return ��������ʱ��
	 */
	public String getPwtEndTime();

	/**
	 * ��Ϣʱ��ȡ��
	 *
	 * @return ��Ϣʱ��
	 */
	public Integer getPwtSleepTime();

	/**
	 * ��Чʱ��ȡ��
	 *
	 * @return ��Чʱ��
	 */
	public Integer getFactTime();

}