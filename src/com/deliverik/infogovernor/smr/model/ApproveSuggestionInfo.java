/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���������ӿ�
  * ��������: ���������ӿ�
  * ������¼: 2013/07/22
  * �޸ļ�¼: 
  */
public interface ApproveSuggestionInfo extends BaseModel {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getId();

	/**
	 * ������IDȡ��
	 *
	 * @return ��ID
	 */
	public String getPidid();

	/**
	 * ����IDȡ��
	 *
	 * @return prid ����ID
	 */
	public Integer getPrid();
	
	/**
	 * ״̬��ʶȡ��
	 *
	 * @return ״̬��ʶ
	 */
	public String getPsdcode();

	/**
	 * ״̬����ȡ��
	 *
	 * @return ״̬����
	 */
	public String getPsdname();

	/**
	 * ���ȡ��
	 *
	 * @return ���
	 */
	public String getSuggestion();

	/**
	 * ���״̬ȡ��
	 *
	 * @return ���״̬
	 */
	public String getStatus();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getInserttime();

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getUserid();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getUsername();
	
	/**
	 * ���ʽ���к�ȡ��
	 * @return rownumber ���ʽ���к�
	 */
	public String getRownumber();

}