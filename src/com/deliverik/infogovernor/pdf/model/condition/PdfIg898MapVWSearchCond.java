/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.condition;

/**
 * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼ���������ӿ� 
 * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼ���������ӿ� 
 * ������¼: 2013/07/31
 * �޸ļ�¼:
 */
public interface PdfIg898MapVWSearchCond {
    /**
     * @return the ��������
     */
    public Integer getPrid();

    /**
     * @return the ������
     */
    public String getPidname();

    /**
     * @return the ������ID
     */
    public String getPidid();
    
    /**
     * @return the �����ֶ�
     */
    public String getPdatabinding() ;
    
    /**
     * @return the ��������
     */
    public String getOrderby();
    /**
	 * @return the ���ʽ��ֵ�к�
	 */
	public String getPvrownumber();

}