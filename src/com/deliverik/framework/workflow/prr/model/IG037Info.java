/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���̵�����־��ӿ�
  * ��������: ���̵�����־��ӿ�
  * ������¼: 2014/11/14
  * �޸ļ�¼: 
  */
public interface IG037Info extends BaseModel {

	/**
	 * ���̵�������ȡ��
	 *
	 * @return ���̵�������
	 */
	public Integer getIrid();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getPrid();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getIrtime();

	/**
	 * �����û�IDȡ��
	 *
	 * @return �����û�ID
	 */
	public String getIruserid();

	/**
	 * �����û�����ȡ��
	 *
	 * @return �����û�����
	 */
	public String getIrusername();

	/**
	 * ���벿��idȡ��
	 *
	 * @return ���벿��id
	 */
	public String getIrorgid();

	/**
	 * ���벿������ȡ��
	 *
	 * @return ���벿������
	 */
	public String getIrorgname();

	/**
	 * ������־����ȡ��
	 *
	 * @return ������־����
	 */
	public String getIrdesc();

	/**
	 * ������־����ȡ��
	 *
	 * @return ������־����
	 */
	public String getIrcomment();

}