/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����ⲿ���ö����ӿ�
  * ��������: �����ⲿ���ö����ӿ�
  * ������¼: 2012/04/20
  * �޸ļ�¼: 
  */
public interface IG992Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPedid();

	/**
	 * �¼�IDȡ��
	 *
	 * @return �¼�ID
	 */
	public String getPedeventid();

	/**
	 * ����BLȡ��
	 *
	 * @return ����BL
	 */
	public String getPedaction();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPeddesc();

}