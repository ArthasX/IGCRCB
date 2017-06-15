/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: IG342Info�ӿ�
  * ��������: IG342Info�ӿ�
  * ������¼: 2012/08/03
  * �޸ļ�¼: 
  */
public interface IG342Info extends BaseModel {

	/**
	 * ��λ���ȡ��
	 *
	 * @return ��λ���
	 */
	public Integer getEiid();

	/**
	 * ��λ����ȡ��
	 *
	 * @return ��λ����
	 */
	public String getEiname();

	/**
	 * ��ַȡ��
	 *
	 * @return ��ַ
	 */
	public String getAddress();

	/**
	 * ��ϵ��ȡ��
	 *
	 * @return ��ϵ��
	 */
	public String getLinkman();

	/**
	 * ��ϵ��ʽȡ��
	 *
	 * @return ��ϵ��ʽ
	 */
	public String getPhone();

	/**
	 * ע���ʽ�ȡ��
	 *
	 * @return ע���ʽ�
	 */
	public String getFund();

	/**
	 * �Ǽ�ʱ��ȡ��
	 *
	 * @return �Ǽ�ʱ��
	 */
	public String getEiinsdate();

	/**
	 * �Ƿ�������Դ��ȡ��
	 *
	 * @return �Ƿ�������Դ��
	 */
	public String getCivalue();

	/**
	 * ��˾����ȡ��
	 *
	 * @return ��˾����
	 */
	public String getAptitude();

	/**
	 * �ɹ�����ȡ��
	 *
	 * @return �ɹ�����
	 */
	public String getSucceedcase();
	
	/**
	 * �޸�ʱ��ȡ��
	 *
	 * @return �޸�ʱ��
	 */
	public String getEiupdtime();

}