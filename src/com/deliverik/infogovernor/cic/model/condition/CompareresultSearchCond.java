/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.condition;

/**
  * ����: �ȶԽ�����������ӿ�
  * ��������: �ȶԽ�����������ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface CompareresultSearchCond {
    
    /** 
     * �ȶԶ�������� ȡ��
     * @return coid_eq �ȶԶ�������� 
     */
    public Integer getCoid_eq();
    
    /** 
     * �Ƿ��ǻ�������1����0���� ȡ��
     * @return isBase �Ƿ��ǻ�������1����0���� 
     */
    public Integer getIsBase();
    /**
     * �Աȹ�������ȡ��
     * @return
     */
    public Integer getCpid_eq();
    
    public String getEid();
}