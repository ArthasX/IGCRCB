/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ������ֵ��ӿ�
  * ��������: ������ֵ��ӿ�
  * ������¼: 2013/06/25
  * �޸ļ�¼: 
  */
public interface IG898Info extends BaseModel {

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getPrid();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getPidid();

	/**
	 * �ж�������ȡ��
	 * @return pvcolpidid �ж�������
	 */
	public String getPvcolpidid();

	/**
	 * �к�ȡ��
	 *
	 * @return �к�
	 */
	public String getPvrownumber();

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getPvalue();
	
	/**
	 * ������ȡ��
	 * @return pidname ������
	 */
	public String getPidname();

	/**
	 * ����ȡ��
	 * @return pvcolname ����
	 */
	public String getPvcolname();
	
	/**
	 * ����keyȡ��
	 * @return attkey ����key
	 */
	public String getAttkey();

}