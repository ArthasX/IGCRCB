/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * ����: �Աȶ����������ʵ��
  * ��������: �Աȶ����������ʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public class CompareobjectSearchCondImpl implements
		CompareobjectSearchCond {

    /** �Աȹ������ */
    protected Integer fkCrid_eq;

    /** �Աȹ���汾 */
    protected String crversion_eq;
    
    /** 
     * �Աȹ������ ȡ��
     * @return fkCrid_eq �Աȹ������ 
     */
    public Integer getFkCrid_eq() {
        return fkCrid_eq;
    }

    /** 
     * �Աȹ������ �趨
     * @param fkCrid_eq �Աȹ������ 
     */
    public void setFkCrid_eq(Integer fkCrid_eq) {
        this.fkCrid_eq = fkCrid_eq;
    }

    /** 
     * �Աȹ���汾 ȡ��
     * @return crversion_eq �Աȹ���汾 
     */
    public String getCrversion_eq() {
        return crversion_eq;
    }

    /** 
     * �Աȹ���汾 �趨
     * @param crversion_eq �Աȹ���汾 
     */
    public void setCrversion_eq(String crversion_eq) {
        this.crversion_eq = crversion_eq;
    }
    
    
}