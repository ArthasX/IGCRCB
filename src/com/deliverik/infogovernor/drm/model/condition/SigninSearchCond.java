/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: ǩ������������ӿ�
  * ��������: ǩ������������ӿ�
  * ������¼: 2015/03/12
  * �޸ļ�¼: 
  */
public interface SigninSearchCond {
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getSiid() ;
	/**
	 * ��������idȡ��
	 *
	 * @return ��������id
	 */
	public Integer getDrillprid();

	/**
	 * Ӧ��ָ������idȡ��
	 *
	 * @return Ӧ��ָ������id
	 */
	public Integer getEcprid() ;

	/**
	 * ��������idȡ��
	 *
	 * @return ��������id
	 */
	public Integer getSceneprid() ;

	/**
	 * �û�idȡ��
	 *
	 * @return �û�id
	 */
	public String getSiuserid() ;
	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getSiusername();

	/**
	 * ��ɫidȡ��
	 *
	 * @return ��ɫid
	 */
	public Integer getSiroleid() ;

	/**
	 * �Ƿ�Ӧ��ָ�Ӳ�����ȡ��
	 *
	 * @return �Ƿ�Ӧ��ָ�Ӳ�����
	 */
	public Integer getWdc() ;

	/**
	 * �Ƿ񳡾�������ȡ��
	 *
	 * @return �Ƿ񳡾�������
	 */
	public Integer getWdp();

	/**
	 * �Ƿ�ǩ��ȡ��
	 *
	 * @return �Ƿ�ǩ��
	 */
	public Integer getSignined() ;

	/**
	 * ǩ��ʱ��ȡ��
	 *
	 * @return ǩ��ʱ��
	 */
	public String getSitime() ;
	/**
	 * roleidin
	 *
	 * @return ��ɫ���͵�����
	 */
	public Integer[] getRoleidin();
}