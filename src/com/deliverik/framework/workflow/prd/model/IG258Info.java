/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ����״̬�����ߵ����ӿ�
  * ��������: ����״̬�����ߵ����ӿ�
  * ������¼: 2012/05/09
  * �޸ļ�¼: 
  */
public interface IG258Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPspcdid();

	/**
	 * ��ǰ״̬IDȡ��
	 *
	 * @return ��ǰ״̬ID
	 */
	public String getPsdid();

	/**
	 * �ɸı�״̬idȡ��
	 *
	 * @return �ɸı�״̬id
	 */
	public String getPspcdpsdid();

}