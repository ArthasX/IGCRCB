/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
  * ����: ����ԭ������������ϵ����������ӿ�
  * ��������: ����ԭ������������ϵ����������ӿ�
  * ������¼: 2013/04/08
  * �޸ļ�¼: 
  */
public interface CR03SearchCond {
	
	/**
	 * �豸��ʶȡ��
	 * @return �豸��ʶ
	 */
	public String getHost();
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getTablename();
	
	/**
	 * �ɼ�ʱ��ȡ��
	 *
	 * @return �ɼ�ʱ��
	 */
	public String getCollecttime();
	
	/**
	 * �����ʶȡ��
	 * @return �����ʶ
	 */
	public String getOrderFlag();
	
	/**
	 * ��ʷ�汾��ʼʱ��ȡ��
	 * @return ��ʷ�汾��ʼʱ��
	 */
	public String getCollecttimeFrom();

	/**
	 * ��ʷ�汾����ʱ��ȡ��
	 * @return ��ʷ�汾����ʱ��
	 */
	public String getCollecttimeTo();
	
	/**
	 * ��ѯesyscodingȡ��
	 * @return esyscoding ��ѯesyscoding
	 */
	
	public String getEsyscoding();
	
	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getStatus();
	
	/**
	 * IPȡ��
	 * @return
	 */
	public String getIp();
	
	/**
	 * server����ȡ��
	 * @return
	 */
	public String getType();
	
	/**
	 * �ű���ȡ��
	 * @return
	 */
	public String getServername();
}