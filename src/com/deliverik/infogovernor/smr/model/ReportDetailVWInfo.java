/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model;


/**
  * ����: ��ر�����ϸҳ��ͼ�ӿ�
  * ��������: ��ر�����ϸҳ��ͼ�ӿ�
  * ������¼: 2013/09/04
  * �޸ļ�¼: 
  */
public interface ReportDetailVWInfo  {

	
	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getId();
	
	/**
	 * �û�IDȡ��
	 *
	 * @return �û�ID
	 */
	public String getUserid();

	/**
	 * �û�����ȡ��
	 *
	 * @return �û�����
	 */
	public String getUsername();

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public String getOrgid();

	/**
	 * ���ƣ��걨��ȡ��
	 *
	 * @return ���ƣ��걨��
	 */
	public String getName_y();

	/**
	 * �Ƿ�ʱ���걨��0-��ʱ 1-����ʱ ȡ��
	 *
	 * @return �Ƿ�ʱ���걨��0-��ʱ 1-����ʱ
	 */
	public String getOntime_y();

	/**
	 * �Ƿ�׼ȷ���걨������1��׼ȷ ȡ��
	 *
	 * @return �Ƿ�׼ȷ���걨������1��׼ȷ
	 */
	public String getCon_y();

	/**
	 * ���ƣ�������ȡ��
	 *
	 * @return ���ƣ�������
	 */
	public String getName_m();

	/**
	 * �Ƿ�ʱ��������0-��ʱ 1-����ʱ ȡ��
	 *
	 * @return �Ƿ�ʱ��������0-��ʱ 1-����ʱ
	 */
	public String getOntime_m();

	/**
	 * �Ƿ�׼ȷ������������1��׼ȷ ȡ��
	 *
	 * @return �Ƿ�׼ȷ������������1��׼ȷ
	 */
	public String getCon_m();

	/**
	 * ���ƣ������ڣ�ȡ��
	 *
	 * @return ���ƣ������ڣ�
	 */
	public String getName_z();

	/**
	 * �Ƿ�ʱ�������ڣ�0-��ʱ 1-����ʱ ȡ��
	 *
	 * @return �Ƿ�ʱ�������ڣ�0-��ʱ 1-����ʱ
	 */
	public String getOntime_z();

	/**
	 * �Ƿ�׼ȷ�������ڣ�����1��׼ȷ ȡ��
	 *
	 * @return �Ƿ�׼ȷ�������ڣ�����1��׼ȷ
	 */
	public String getCon_z();

}