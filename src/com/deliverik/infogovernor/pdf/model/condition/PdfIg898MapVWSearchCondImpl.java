/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.condition;


/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼ��������ʵ��
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼ��������ʵ��
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
public class PdfIg898MapVWSearchCondImpl implements
		PdfIg898MapVWSearchCond {
    
    /** �������� */
    protected Integer prid;
    
    /** ������ */
    protected String pidname;
    
    /** ������ID */
    protected String pidid;

    /** �����ֶ� */
    protected String pdatabinding;
    
    /** �������� */
    protected String orderby;
    /** ���ʽ��ֵ�к� */
	
	protected String pvrownumber;
	
    /**
	 * @return the ���ʽ��ֵ�к�
	 */
	public String getPvrownumber() {
		return pvrownumber;
	}

	/**
	 * @param ���ʽ��ֵ�к� the pvrownumber to set
	 */
	public void setPvrownumber(String pvrownumber) {
		this.pvrownumber = pvrownumber;
	}

	/**
     * @return the ��������
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * @param �������� the prid to set
     */
    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    /**
     * @return the ������
     */
    public String getPidname() {
        return pidname;
    }

    /**
     * @param ������ the pidname to set
     */
    public void setPidname(String pidname) {
        this.pidname = pidname;
    }

    /**
     * @return the ������ID
     */
    public String getPidid() {
        return pidid;
    }

    /**
     * @param ������ID the pidid to set
     */
    public void setPidid(String pidid) {
        this.pidid = pidid;
    }

    /**
     * @return the �����ֶ�
     */
    public String getPdatabinding() {
        return pdatabinding;
    }

    /**
     * @param �����ֶ� the pdatabinding to set
     */
    public void setPdatabinding(String pdatabinding) {
        this.pdatabinding = pdatabinding;
    }

    /**
     * @return the ��������
     */
    public String getOrderby() {
        return orderby;
    }

    /**
     * @param �������� the orderby to set
     */
    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

}