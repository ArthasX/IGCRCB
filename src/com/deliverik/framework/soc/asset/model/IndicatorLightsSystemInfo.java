/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �澯ϵͳ��ʾ��Ϣ��ӿ�
  * ��������: �澯ϵͳ��ʾ��Ϣ��ӿ�
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public interface IndicatorLightsSystemInfo extends BaseModel {

	/**
	 * ����˼����ȡ��
	 *
	 * @return ����˼����
	 */
	public Integer getIlsid();

	/**
	 * ϵͳ����ȡ��
	 *
	 * @return ϵͳ����
	 */
	public String getIlsname();

	/**
	 * λ��Xȡ��
	 *
	 * @return λ��X
	 */
	public Integer getIlsplacex();

	/**
	 * λ��Yȡ��
	 *
	 * @return λ��Y
	 */
	public Integer getIlsplacey();

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getIlsstatus();

}