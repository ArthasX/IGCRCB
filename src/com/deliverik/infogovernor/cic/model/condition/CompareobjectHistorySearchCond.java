/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * ����: �Աȶ�����ʷ����������ӿ�
  * ��������: �Աȶ�����ʷ����������ӿ�
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
public interface CompareobjectHistorySearchCond {

    /** 
     * �Աȹ������ ȡ��
     * @return fkCrid_eq �Աȹ������ 
     */
    public Integer getFkCrid_eq();
    
    /** 
     * �Աȹ���汾 ȡ��
     * @return crversion_eq �Աȹ���汾 
     */
    public Integer getCrversion_eq();

    /** 
     * �Ա�id ȡ��
     * @return crversion_eq �Ա�id
     */
    public Integer getCoid_eq();

}