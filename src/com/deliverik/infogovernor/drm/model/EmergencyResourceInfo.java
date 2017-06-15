/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: EmergencyResource�ӿ�
  * ��������: EmergencyResource�ӿ�
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public interface EmergencyResourceInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getErid();

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErname();

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErdesc();

	/**
	 * ��Դ״̬ȡ��
	 *
	 * @return ��Դ״̬
	 */
	public String getErstatus();

	/**
	 * ��Դ���ȡ��
	 *
	 * @return ��Դ���
	 */
	public String getErlabel();

	/**
	 * ��Դ����ȡ��
	 *
	 * @return ��Դ����
	 */
	public String getErcode();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getErparcode();

	/**
	 * ¼��ʱ��ȡ��
	 *
	 * @return ¼��ʱ��
	 */
	public String getErcreatetime();

	/**
	 * ¼����idȡ��
	 *
	 * @return ¼����id
	 */
	public String getEruserid();

	/**
	 * ¼��������ȡ��
	 *
	 * @return ¼��������
	 */
	public String getErusername();
	
	/**
	 * @param ��Ӧ�ʲ���  
	 */
	public String getEsyscoding();
	
	/**
	 * @return the ��Ӧ�ʲ�����cid
	 */
	public String getErcids() ;

}