/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.condition;

/**
  * ����: PDF���������̱�ӳ����������ʵ��
  * ��������: PDF���������̱�ӳ����������ʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public class PdfFieldMapSearchCondImpl implements
		PdfFieldMapSearchCond {
    
    /** ���̶���id*/ 
    String pdid;

    /** ������*/ 
    String formtype;
    
    /**
     * @return the pdid
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * @param pdid the pdid to set
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

    /**
     * @return the ������
     */
    public String getFormtype() {
        return formtype;
    }

    /**
     * @param ������ the formtype to set
     */
    public void setFormtype(String formtype) {
        this.formtype = formtype;
    }
    
}