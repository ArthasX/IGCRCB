/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �������Ա��ӿ�
  * ��������: �������Ա��ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG481Info extends BaseModel {

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getPgdid();

	/**
	 * ��������idȡ��
	 *
	 * @return ��������id
	 */
	public String getPdid();

	/**
	 * ����ʽȡ��
	 *
	 * @return ����ʽ
	 */
	public String getCreateType();

	/**
	 * ���̰汾ȡ��
	 *
	 * @return ���̰汾
	 */
	public String getPdversion();

}