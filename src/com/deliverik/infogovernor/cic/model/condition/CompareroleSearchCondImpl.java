/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * ����: �Աȹ����������ʵ��
  * ��������: �Աȹ����������ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public class CompareroleSearchCondImpl implements
		CompareroleSearchCond {
	
	/** �Ա����� */
	protected String crtype;
	
	/** ҵ��ϵͳid */
	protected Integer crsystemid;

	public String getCrtype() {
		return crtype;
	}

	public void setCrtype(String crtype) {
		this.crtype = crtype;
	}

	public Integer getCrsystemid() {
		return crsystemid;
	}

	public void setCrsystemid(Integer crsystemid) {
		this.crsystemid = crsystemid;
	}
	
	
	

    /** �ȶ���������� */
    protected Integer cpid;

    /** 
     * �ȶ���������� ȡ��
     * @return cpid �ȶ���������� 
     */
    public Integer getCpid() {
        return cpid;
    }

    /** 
     * �ȶ���������� �趨
     * @param cpid �ȶ���������� 
     */
    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }
    
}