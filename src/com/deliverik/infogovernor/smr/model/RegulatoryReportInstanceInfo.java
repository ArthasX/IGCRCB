/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����ʵ����ӿ�
  * ��������: �����ʵ����ӿ�
  * ������¼: 2013/07/18
  * �޸ļ�¼: 
  */
public interface RegulatoryReportInstanceInfo extends BaseModel {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getInstanceID();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPrtype();

	/**
	 * ���ʶȡ��
	 *
	 * @return ���ʶ
	 */
	public String getKey();

	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getInittime();

	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getEndtime();

	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getLimittime();

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getRemark();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getStatus();
	
	/**
	 * ������ID
	 * 
	 * @return ������ID
	 */
	public String getUserid();

	/**
	 * ����������
	 * @return ����������
	 */
	public String getUsername();
	
	/**
	 * �걨˵��
	 * @return �걨˵��
	 */
	public String getReportdesc();
	
	/**
	 * ��ȡ��
	 * @return ��
	 */
	public String getYear();

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getQuarter();

}