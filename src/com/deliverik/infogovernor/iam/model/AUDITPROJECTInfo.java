/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��Ʊ����ӿ�
  * ��������: ��Ʊ����ӿ�
  * ������¼: 2012/08/08
  * �޸ļ�¼: 
  */
public interface AUDITPROJECTInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getApid();

	/**
	 * ��Ʊ�������ȡ��
	 *
	 * @return ��Ʊ�������
	 */
	public String getApreporttype();

	/**
	 * �����ĿIDȡ��
	 *
	 * @return �����ĿID
	 */
	public Integer getApprojectid();

	/**
	 * ��Ŀ����ȡ��
	 *
	 * @return ��Ŀ����
	 */
	public String getApprojectname();

	/**
	 * ��Ŀ���ȡ��
	 *
	 * @return ��Ŀ���
	 */
	public String getApprojectyear();

	/**
	 * ��Ʊ��渽��KEYȡ��
	 *
	 * @return ��Ʊ��渽��KEY
	 */
	public String getApattkey();

}