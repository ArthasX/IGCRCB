/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼ�ӿ�
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼ�ӿ�
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public interface PdfIg599MapVWInfo extends BaseModel {

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPrid();

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getPidid();

	/**
	 * ��ֵȡ��
	 *
	 * @return ��ֵ
	 */
	public String getPivarvalue();

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getPivarname();

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * �����ֶ�����ȡ��
	 *
	 * @return �����ֶ�����
	 */
	public String getPdfpidname();

	/**
	 * ��������Ϣȡ��
	 *
	 * @return ��������Ϣ
	 */
	public String getPdatabinding();

	/**
	 * ������Ϣȡ��
	 *
	 * @return ������Ϣ
	 */
	public String getDatabinding();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getFormtype();

}