/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * ����: �Աȶ�����ʷ���������ʵ��
  * ��������: �Աȶ�����ʷ���������ʵ��
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
public class CompareobjectHistorySearchCondImpl implements
		CompareobjectHistorySearchCond {


    /** �Աȹ������ */
    protected Integer fkCrid_eq;
    
    /**�Աȶ���id*/
    private Integer coid_eq;

    /** �Աȹ���汾 */
    protected Integer crversion_eq;
    
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
    public Integer getCrversion_eq() {
        return crversion_eq;
    }

    /** 
     * �Աȹ���汾 �趨
     * @param crversion_eq �Աȹ���汾 
     */
    public void setCrversion_eq(Integer crversion_eq) {
        this.crversion_eq = crversion_eq;
    }

	public Integer getCoid_eq() {
		return coid_eq;
	}

	public void setCoid_eq(Integer coid_eq) {
		this.coid_eq = coid_eq;
	}
    
    
    

}