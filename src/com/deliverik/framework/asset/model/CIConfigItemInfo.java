/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: CI����ʲ����Ա�ӿ�
  * ��������: CI����ʲ����Ա�ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface CIConfigItemInfo extends BaseModel {

	/**
	 * �ʲ�����IDȡ��
	 *
	 * @return �ʲ�����ID
	 */
	public Integer getCiid();

	/**
	 * �ʲ�ģ������IDȡ��
	 *
	 * @return �ʲ�ģ������ID
	 */
	public Integer getCid();

	/**
	 * �ʲ�IDȡ��
	 *
	 * @return �ʲ�ID
	 */
	public Integer getEiid();

	/**
	 * �ʲ�ģ��IDȡ��
	 *
	 * @return �ʲ�ģ��ID
	 */
	public Integer getEid();

	/**
	 * �ʲ�����ֵȡ��
	 *
	 * @return �ʲ�����ֵ
	 */
	public String getCivalue();

	/**
	 * �ʲ����Ը���ʱ��ȡ��
	 *
	 * @return �ʲ����Ը���ʱ��
	 */
	public String getCiupdtime();

	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 *
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding();

	/**
	 * �ʲ�����ʧЧʱ��ȡ��
	 *
	 * @return �ʲ�����ʧЧʱ��
	 */
	public String getCiexpire();

	/**
	 * �ʲ�����״̬ȡ��
	 *
	 * @return �ʲ�����״̬
	 */
	public String getCistatus();

	/**
	 * �ʲ����Ե�ǰ�汾��ȡ��
	 *
	 * @return �ʲ����Ե�ǰ�汾��
	 */
	public String getCicurver();

	/**
	 * �ʲ����԰汾��Ϣȡ��
	 *
	 * @return �ʲ����԰汾��Ϣ
	 */
	public String getCiverinfo();

	/**
	 * ��汾ȡ��
	 * @return ��汾
	 */
	public Integer getCiversion();

	/**
	 * С�汾ȡ��
	 * @return С�汾
	 */
	public Integer getCismallversion();

}