/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: ErRelation���������ӿ�
  * ��������: ErRelation���������ӿ�
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public interface ErRelationSearchCond {
	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getErrid() ;

	/**
	 * Ӧ����Դ����ȡ��
	 *
	 * @return Ӧ����Դ����
	 */
	public Integer getErid() ;

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
	 * �ʲ�idȡ��
	 *
	 * @return �ʲ�id
	 */
	public String getEiid() ;

	/**
	 * �ʲ�����ȡ��
	 *
	 * @return �ʲ�����
	 */
	public String getEiname();

	/**
	 * ¼��������ȡ��
	 *
	 * @return ¼��������
	 */
	public String getErrstatus();

	/**
	 * ɾ����־ȡ��
	 *
	 * @return ɾ����־
	 */
	public String getDeleteflag();
}