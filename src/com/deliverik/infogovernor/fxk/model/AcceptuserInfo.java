/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���չ�����ʾ���������ݱ�ӿ�
  * ��������: ���չ�����ʾ���������ݱ�ӿ�
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
public interface AcceptuserInfo extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getApid();

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getApuserid();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getApusername();

	/**
	 * ���ջ�����ȡ��
	 *
	 * @return ���ջ�����
	 */
	public String getAporgid();

	/**
	 * ���ջ�������ȡ��
	 *
	 * @return ���ջ�������
	 */
	public String getAporgname();

	/**
	 * ������ʾ����ȡ��
	 *
	 * @return ������ʾ����
	 */
	public Integer getRwid();

}