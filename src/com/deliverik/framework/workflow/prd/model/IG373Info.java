/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���̱���ʼ���¼������ӿ�
  * ��������: ���̱���ʼ���¼������ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 
  */
public interface IG373Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPiidid();

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * ״̬IDȡ��
	 *
	 * @return ״̬ID
	 */
	public String getPsdid();

	/**
	 * BL����ȡ��
	 *
	 * @return BL����
	 */
	public String getPiidblid();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPiiddec();
	
	/**
	 * ����״̬��Ϣȡ��
	 * 
	 * @return ����״̬��Ϣ
	 */
	public IG333Info getIg333Info();

}