/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.condition;

/**
  * ����: PDF����XML�б��ʽ���ڵ㶨�����������ӿ�
  * ��������: PDF����XML�б��ʽ���ڵ㶨�����������ӿ�
  * ������¼: 2013/08/02
  * �޸ļ�¼: 
  */
public interface PdfTableNodeSearchCond {
    /**
     * @return the pdid
     */
    public String getPdid();
    /**
	 * @return the ������
	 */
	public String getDatabinding();

	/**
	 * @return the ��������
	 */
	public String getPdatabinding();

	/**
	 * @return the ����ڵ����ͣ�0�̶���1�ɱ�
	 */
	public String getNodetype();
}