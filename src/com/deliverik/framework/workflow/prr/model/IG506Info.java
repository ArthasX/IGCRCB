/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ��Ա���ֵ��ӿ�
  * ��������: ��Ա���ֵ��ӿ�
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
public interface IG506Info extends BaseModel {

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPiuid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getPrid();

	/**
	 * �û�idȡ��
	 *
	 * @return �û�id
	 */
	public String getPiuserid();

	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getPiusername();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPiorgid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPiorgname();

	/**
	 * ��ɫidȡ��
	 *
	 * @return ��ɫid
	 */
	public Integer getPiroleid();

	/**
	 * ��ɫ����ȡ��
	 *
	 * @return ��ɫ����
	 */
	public String getPirolename();
	
	/**
	 * �绰ȡ��
	 * @return piphone �绰
	 */
	public String getPiphone();

}