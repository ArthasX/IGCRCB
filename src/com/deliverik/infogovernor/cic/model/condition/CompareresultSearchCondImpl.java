/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * ����: �ȶԽ����������ʵ��
  * ��������: �ȶԽ����������ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public class CompareresultSearchCondImpl implements
		CompareresultSearchCond {

    /** �ȶԶ�������� */
    public Integer coid_eq ;

    /** �Ƿ��ǻ������� 1���� 0���� */
    public Integer isBase;
    
    /**�Աȹ�����id*/
    private Integer cpid_eq;
    
    private String eid;
    
    /** 
     * �ȶԶ�������� ȡ��
     * @return coid_eq �ȶԶ�������� 
     */
    public Integer getCoid_eq() {
        return coid_eq;
    }

    /** 
     * �ȶԶ�������� �趨
     * @param coid_eq �ȶԶ�������� 
     */
    public void setCoid_eq(Integer coid_eq) {
        this.coid_eq = coid_eq;
    }

    /** 
     * �Ƿ��ǻ�������1����0���� ȡ��
     * @return isBase �Ƿ��ǻ�������1����0���� 
     */
    public Integer getIsBase() {
        return isBase;
    }

    /** 
     * �Ƿ��ǻ�������1����0���� �趨
     * @param isBase �Ƿ��ǻ�������1����0���� 
     */
    public void setIsBase(Integer isBase) {
        this.isBase = isBase;
    }

	public Integer getCpid_eq() {
		return cpid_eq;
	}

	public void setCpid_eq(Integer cpid_eq) {
		this.cpid_eq = cpid_eq;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}
    
    
}