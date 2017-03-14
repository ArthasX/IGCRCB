/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��ƶԱȽ����Ϣ��ӿ�
  * ��������: ��ƶԱȽ����Ϣ��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditResultInfo extends BaseModel {

	/**
	 * ��ƶԱȽ��ȡ��
	 *
	 * @return ��ƶԱȽ��
	 */
	public Integer getAurid();

	/**
	 * �������IDȡ��
	 *
	 * @return �������ID
	 */
	public Integer getAutid();

	/**
	 * ���ʱ���ȡ��
	 *
	 * @return ���ʱ���
	 */
	public String getAutime();

	/**
	 * �ԱȽ������ȡ��
	 *
	 * @return �ԱȽ������
	 */
	public String getAucmptype();

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
	public String getAuflag();

	/**
	 * ��ƽ��˵��ȡ��
	 *
	 * @return ��ƽ��˵��
	 */
	public String getAuresultdesc();
	
	/**
	 * �ʲ������ȡ��
	 * 
	 * @return �ʲ������
	 */
	public String getEsyscoding();

}