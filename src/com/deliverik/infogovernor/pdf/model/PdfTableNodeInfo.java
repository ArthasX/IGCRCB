/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: PDF����XML�б��ʽ���ڵ㶨���ӿ�
  * ��������: PDF����XML�б��ʽ���ڵ㶨���ӿ�
  * ������¼: 2013/08/02
  * �޸ļ�¼: 
  */
public interface PdfTableNodeInfo extends BaseModel {

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getDatabinding();

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getPdatabinding();

	/**
     * @return the ����ڵ����ͣ�0�̶���1�ɱ�
     */
    public String getNodetype();
}