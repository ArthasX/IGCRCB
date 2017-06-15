/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����ӦBL��ģ���������ñ�ӿ�
  * ��������: �����ӦBL��ģ���������ñ�ӿ�
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public interface PdfConfigrationInfo extends BaseModel {

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid();

	/**
	 * �������BL����ȡ��
	 *
	 * @return �������BL����
	 */
	public String getPdfbl();

	/**
	 * PDF����ģ������ȡ��
	 *
	 * @return PDF����ģ������
	 */
	public String getTemplatename();
	
	/**
     * @return the PDF�������ļ�����
     */
    public String getExportname() ;
    
    /**
     * @return the PDF����XML�ļ�����
     */
    public String getXmlname();

}