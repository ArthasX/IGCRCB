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
public interface PdfIg898MapVWInfo extends BaseModel {

	/**
	 * ����idȡ��
	 *
	 * @return ����id
	 */
	public Integer getPrid();

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getPidid();

	/**
	 * ���ʽ����IDȡ��
	 *
	 * @return ���ʽ����ID
	 */
	public String getPvcolpidid();

	/**
	 * ���ʽ��ֵ�к�ȡ��
	 *
	 * @return ���ʽ��ֵ�к�
	 */
	public String getPvrownumber();

	/**
	 * ���ʽ��ֵȡ��
	 *
	 * @return ���ʽ��ֵ
	 */
	public String getPvalue();

	/**
	 * ���ʽ��������ȡ��
	 *
	 * @return ���ʽ��������
	 */
	public String getPvcolname();

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getAttkey();

	/**
	 * ���ʽ����������ȡ��
	 *
	 * @return ���ʽ����������
	 */
	public String getPidname();

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