/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.model;


/**
  * ����: ����ԭ������������ϵ��ӿ�
  * ��������: ����ԭ������������ϵ��ӿ�
  * ������¼: 2013/04/08
  * �޸ļ�¼: 
  */
public interface CR03VWInfo{


	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getTablename();

	/**
	 * ������ʶȡ��
	 *
	 * @return ������ʶ
	 */
	public String getHost();
	
	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getStatus();

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getType();
	
	/**
	 * ��ʾʱ��ȡ��
	 * @return ��ʾʱ��
	 */
	public String getMaxshowtime();
	
	/**
	 * ��ʾʱ��ȡ��
	 * @return ��ʾʱ��
	 */
	public String getMinshowtime();
	
	/**
	 * IPȡ��
	 * @return
	 */
	public String getIp();
	
	/**
	 * ģ����ȡ��
	 * @return
	 */
	public String getImptypename();
	
	/**
	 * ��ʼ�ɼ�ʱ��ȡ��
	 * @return
	 */
	public String getMinctime();
	
	/**
	 * �ű���ȡ��
	 * @return
	 */
	public String getServername();

}