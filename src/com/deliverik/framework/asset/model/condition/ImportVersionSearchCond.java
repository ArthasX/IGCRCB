/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: �������ݰ汾�������������ӿ�
  * ��������: �������ݰ汾�������������ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface ImportVersionSearchCond {
	
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
	
	
}