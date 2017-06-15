/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: SOC0117VW�ӿ�
  * ��������: SOC0117VW�ӿ�
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
public interface SOC0117VWInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId();

	/**
	 * �ʲ�����idȡ��
	 *
	 * @return �ʲ�����id
	 */
	public String getEid();

	/**
	 * �ʲ���������ȡ��
	 *
	 * @return �ʲ���������
	 */
	public String getEname();

	/**
	 * ϵͳԤ��ģ�ͱ�ʶȡ��
	 *
	 * @return ϵͳԤ��ģ�ͱ�ʶ
	 */
	public String getElabel();

	/**
	 * �ʲ�ģ�͵�˵��ȡ��
	 *
	 * @return �ʲ�ģ�͵�˵��
	 */
	public String getEdesc();

	/**
	 * �ʲ�ģ��״̬ȡ��
	 *
	 * @return �ʲ�ģ��״̬
	 */
	public String getEstatus();

	/**
	 * �ʲ�ģ�͵ķ���ȡ��
	 *
	 * @return �ʲ�ģ�͵ķ���
	 */
	public String getEcategory();

	/**
	 * �ʲ�ģ��һ������ȡ��
	 *
	 * @return �ʲ�ģ��һ������
	 */
	public String getEkey1();

	/**
	 * �ʲ�ģ�Ͷ�������ȡ��
	 *
	 * @return �ʲ�ģ�Ͷ�������
	 */
	public String getEkey2();

	/**
	 * �ʲ�ģ����������ȡ��
	 *
	 * @return �ʲ�ģ����������
	 */
	public String getEkey3();

	/**
	 * �ʲ�ģ�͵Ĳ����ȡ��
	 *
	 * @return �ʲ�ģ�͵Ĳ����
	 */
	public String getEsyscoding();

	/**
	 * �ʲ�ģ�͵��ϼ�ģ�Ͳ����ȡ��
	 *
	 * @return �ʲ�ģ�͵��ϼ�ģ�Ͳ����
	 */
	public String getEparcoding();

	/**
	 * �ʲ�ģ�����ȡ��
	 * @return �ʲ�ģ�����
	 */
	public String getEmodeltype();

}