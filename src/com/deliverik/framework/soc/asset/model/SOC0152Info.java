/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;

/**
  * ����: �ʲ���ϵ��ӿ�
  * ��������: �ʲ���ϵ��ӿ�
  * ������¼: ����ȫ 2013/05/27
  * �޸ļ�¼: 
  */
public interface SOC0152Info extends BaseModel {

	/**
	 * ��ϵ��ȡ��
	 *
	 * @return ��ϵ��
	 */
	public String getRlnCode();

	/**
	 * ��ʼģ������ȡ��
	 *
	 * @return ��ʼģ������
	 */
	public String getFromModelName();

	/**
	 * ��ʼģ��IDȡ��
	 *
	 * @return ��ʼģ��ID
	 */
	public String getFromModelEid();

	/**
	 * ��ģ������ȡ��
	 *
	 * @return ��ģ������
	 */
	public String getToModelName();

	/**
	 * ��ģ��IDȡ��
	 *
	 * @return ��ģ��ID
	 */
	public String getToModelEid();

	/**
	 * ��ϵ����ȡ��
	 *
	 * @return ��ϵ����
	 */
	public String getRlnDesc();

	/**
	 * Ԥ���ֶ�1ȡ��
	 *
	 * @return Ԥ���ֶ�1
	 */
	public String getRlnKey1();

	/**
	 * Ԥ���ֶ�2ȡ��
	 *
	 * @return Ԥ���ֶ�2
	 */
	public String getRlnKey2();
	
	/**
	 * ��ϵ���ȡ��
	 *
	 * @return rlnType ��ϵ���
	 */
	
	public String getRlnType();
	
	/**
	 * ��ϵ��ģ��ȡ��
	 * @return
	 */
	public SOC0117TB getFrom0117TB();
	
	/**
	 * ��ϵ��ģ��ȡ��
	 * @return
	 */
	public SOC0117TB getTo0117TB();

}