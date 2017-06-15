/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: EmergencyResource���������ӿ�
  * ��������: EmergencyResource���������ӿ�
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public interface EmergencyResourceSearchCond {
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getErid() ;

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErname() ;

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErdesc() ;

	/**
	 * ��Դ״̬ȡ��
	 *
	 * @return ��Դ״̬
	 */
	public String getErstatus() ;

	/**
	 * ��Դ���ȡ��
	 *
	 * @return ��Դ���
	 */
	public String getErlabel() ;
	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErcode() ;

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getErparcode() ;
	/**
	 * ¼��ʱ��ȡ��
	 *
	 * @return ¼��ʱ��
	 */
	public String getErcreatetime() ;

	/**
	 * ¼����idȡ��
	 *
	 * @return ¼����id
	 */
	public String getEruserid() ;

	/**
	 * ¼��������ȡ��
	 *
	 * @return ¼��������
	 */
	public String getErusername() ;
	
	/**
	 * @return the orderby
	 */
	public String getOrderby() ;
	/**
	 * @return the order
	 */
	public String getOrder();
	/**
	 * @return the erparcode_like
	 */
	public String getErparcode_like(); 
	/**
	 * @param ��Ӧ�ʲ���  the esyscoding to set
	 */
	public void setEsyscoding(String esyscoding);
}