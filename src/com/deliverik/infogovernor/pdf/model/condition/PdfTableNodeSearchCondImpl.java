/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.condition;


/**
  * ����: PDF����XML�б��ʽ���ڵ㶨����������ʵ��
  * ��������: PDF����XML�б��ʽ���ڵ㶨����������ʵ��
  * ������¼: 2013/08/02
  * �޸ļ�¼: 
  */
public class PdfTableNodeSearchCondImpl implements
		PdfTableNodeSearchCond {
    
    /** ���̶���id*/ 
    String pdid;
    /** ������ */
	protected String databinding;
	/** �������� */
	protected String pdatabinding;
	/**  ����ڵ����ͣ�0�̶���1�ɱ�*/
	protected String nodetype;
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
	public String getDatabinding() {
		return databinding;
	}

	/**
	 * @param ������ the databinding to set
	 */
	public void setDatabinding(String databinding) {
		this.databinding = databinding;
	}

	/**
	 * @return the ��������
	 */
	public String getPdatabinding() {
		return pdatabinding;
	}

	/**
	 * @param �������� the pdatabinding to set
	 */
	public void setPdatabinding(String pdatabinding) {
		this.pdatabinding = pdatabinding;
	}

	/**
	 * @return the ����ڵ����ͣ�0�̶���1�ɱ�
	 */
	public String getNodetype() {
		return nodetype;
	}

	/**
	 * @param ����ڵ����ͣ�0�̶���1�ɱ� the nodetype to set
	 */
	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}
    
    
}