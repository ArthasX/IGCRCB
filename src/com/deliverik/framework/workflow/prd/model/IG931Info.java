/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ȱʡ״̬�����߹����������Ͷ����ӿ�
  * ��������: ȱʡ״̬�����߹����������Ͷ����ӿ�
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
public interface IG931Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getDpsprpid();

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
	 * ���������̶���idȡ��
	 *
	 * @return ���������̶���id
	 */
	public String getRelevantPdid();

}