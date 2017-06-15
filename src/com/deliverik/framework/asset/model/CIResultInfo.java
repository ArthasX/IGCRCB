/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: CI����ԱȽ����Ϣ��ӿ�
  * ��������: CI����ԱȽ����Ϣ��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CIResultInfo extends BaseModel {

	/**
	 * CI����ԱȽ��ȡ��
	 *
	 * @return CI����ԱȽ��
	 */
	public Integer getCirid();

	/**
	 * CI�������IDȡ��
	 *
	 * @return CI�������ID
	 */
	public Integer getCitid();

	/**
	 * CI���ʱ���ȡ��
	 *
	 * @return CI���ʱ���
	 */
	public String getCitime();

	/**
	 * �ԱȽ������ȡ��
	 *
	 * @return �ԱȽ������
	 */
	public String getCicmptype();

	/**
	 * �ʲ�IDȡ��
	 *
	 * @return �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * ��汾ȡ��
	 *
	 * @return ��汾
	 */
	public Integer getEiversion();

	/**
	 * С�汾ȡ��
	 *
	 * @return С�汾
	 */
	public Integer getEismallversion();

	/**
	 * �ʲ�����ȡ��
	 *
	 * @return �ʲ�����
	 */
	public String getEiname();

	/**
	 * ����CI��ʶȡ��
	 *
	 * @return ����CI��ʶ
	 */
	public Integer getEirootmark();

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getCiid();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getCname();

	/**
	 * ��ǰ�汾ֵȡ��
	 *
	 * @return ��ǰ�汾ֵ
	 */
	public String getCivalue();

	/**
	 * �ɼ�ֵȡ��
	 *
	 * @return �ɼ�ֵ
	 */
	public String getAuvalue();

	/**
	 * �����ʶȡ��
	 *
	 * @return �����ʶ
	 */
	public String getCiflag();

	/**
	 * CI������˵��ȡ��
	 *
	 * @return CI������˵��
	 */
	public String getCiresultdesc();
	
	/**
	 * �ʲ������ȡ��
	 * 
	 * @return �ʲ������
	 */
	public String getEsyscoding();

}