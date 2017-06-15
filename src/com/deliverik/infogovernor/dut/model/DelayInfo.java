/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��ʱ������Ϣ��ӿ�
  * ��������: ��ʱ������Ϣ��ӿ�
  * ������¼: 2012/04/05
  * �޸ļ�¼: 
  */
public interface DelayInfo extends BaseModel {

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getId();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getDatetime();

	/**
	 * ���뵥λȡ��
	 *
	 * @return ���뵥λ
	 */
	public String getOrgname();

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getTitle();
	
	/**
	 * �г�����ȡ��
	 * @return
	 */
	public String getHzname();

	/**
	 * �г��绰ȡ��
	 *
	 * @return �г��绰
	 */
	public String getHztel();
	
	/**
	 * ��������ȡ��
	 * @return
	 */
	public String getJlname();

	/**
	 * ����绰ȡ��
	 *
	 * @return ����绰
	 */
	public String getJltel();

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getRemark();

	/**
	 * ��ʼʱ��ȡ��
	 *
	 * @return ��ʼʱ��
	 */
	public String getStarttime();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getEndtime();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getOperater();
	
	/**
	 * ����ʱ��ȡ��
	 * @return
	 */
	public String getUnlocktime();

}