/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����״̬��˽�б�Ĭ��ֵ��ӿ�
  * ��������: ����״̬��˽�б�Ĭ��ֵ��ӿ�
  * ������¼: 2015/02/07
  * �޸ļ�¼: 
  */
public interface IG560Info extends BaseModel {

	/**
	 * dvidȡ��
	 *
	 * @return dvid
	 */
	public Integer getDvid();

	/**
	 * ��idȡ��
	 *
	 * @return ��id
	 */
	public String getPidid();

	/**
	 * ״̬idȡ��
	 *
	 * @return ״̬id
	 */
	public String getPsdid();

	/**
	 * Ĭ��ֵȡ��
	 *
	 * @return Ĭ��ֵ
	 */
	public String getDfvalue();

	/**
	 * �Ƿ�Ӧ�õ���������T/Fȡ��
	 *
	 * @return �Ƿ�Ӧ�õ���������T/F
	 */
	public String getUsedtoall();
}