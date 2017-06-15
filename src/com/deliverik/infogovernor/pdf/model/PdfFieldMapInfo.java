/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: PDF���������̱�ӳ���ӿ�
  * ��������: PDF���������̱�ӳ���ӿ�
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public interface PdfFieldMapInfo extends BaseModel {

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * ���̱�����IDȡ��
	 *
	 * @return ���̱�����ID
	 */
	public String getPidid();

	/**
	 * ���̱�����ȡ��
	 *
	 * @return ���̱�����
	 */
	public String getPidname();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPdatabinding();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getDatabinding();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getFormtype();

}