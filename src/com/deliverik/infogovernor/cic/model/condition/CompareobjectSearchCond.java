/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * ����: �Աȶ�����������ӿ�
  * ��������: �Աȶ�����������ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareobjectSearchCond {

    /** 
     * �Աȹ������ ȡ��
     * @return fkCrid_eq �Աȹ������ 
     */
    public Integer getFkCrid_eq();
    
    /** 
     * �Աȹ���汾 ȡ��
     * @return crversion_eq �Աȹ���汾 
     */
    public String getCrversion_eq();
}