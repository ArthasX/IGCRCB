/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * ����: �������ݰ汾�������������ӿ�
  * ��������: �������ݰ汾�������������ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0120SearchCond {
	
	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag_eq();
	
	/**
	 * ʵ����ȡ��
	 *
	 * @return ʵ����
	 */
	public String getImpeiname_eq();
	
	/**
	 * ʵ����(ģ����ѯ)ȡ��
	 * @return ʵ����(ģ����ѯ)
	 */
	public String getImpeiname_like();
	
	/**
	 * �汾��ȡ��
	 * @return �汾��
	 */
	public Integer getImpversion();
	
	/**
	 * ʵ����ȡ��
	 * @return ʵ����
	 */
	public String getImpeiname();
	
	/**
	 * �豸ģ����ȡ��
	 * @return �豸ģ����
	 */
	public String getEsyscoding();
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getImpcreatetime_s();
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getImpcreatetime_e();
}