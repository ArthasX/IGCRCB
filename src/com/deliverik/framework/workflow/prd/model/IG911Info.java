/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ״̬�����߹����������Ͷ����ӿ�
  * ��������: ״̬�����߹����������Ͷ����ӿ�
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
public interface IG911Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPsprpid();

	/**
	 * ���̶���idȡ��
	 *
	 * @return ���̶���id
	 */
	public String getPdid();

	/**
	 * ����״̬idȡ��
	 *
	 * @return ����״̬id
	 */
	public String getPsdid();

	/**
	 * �����߽�ɫidȡ��
	 *
	 * @return �����߽�ɫid
	 */
	public Integer getRoleid();

	/**
	 * ���������̶���idȡ��
	 *
	 * @return ���������̶���id
	 */
	public String getRelevantPdid();
	
}