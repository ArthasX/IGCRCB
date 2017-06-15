/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: SOC0107VW�ӿ�
  * ��������: SOC0107VW�ӿ�
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
public interface SOC0107VWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public Integer getCiid();

	/**
	 * �ʲ�ģ������ID�������ȡ��
	 *
	 * @return �ʲ�ģ������ID�������
	 */
	public String getCid();

	/**
	 * �ʲ�ID�������ȡ��
	 *
	 * @return �ʲ�ID�������
	 */
	public Integer getEiid();

	/**
	 * �ʲ�ģ��IDȡ��
	 *
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

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
	 * �ʲ����԰汾��ȡ��
	 *
	 * @return �ʲ����԰汾��
	 */
	public String getCiversion();

	/**
	 * �ʲ����԰汾��Ϣȡ��
	 *
	 * @return �ʲ����԰汾��Ϣ
	 */
	public String getCiverinfo();
	/**
	 * �ʲ�ģ��������Ϣȡ��
	 * @return �ʲ�ģ��������Ϣ
	 */
	public SOC0109VWInfo getConfiguration();
}