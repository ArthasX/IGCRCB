/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.condition;

/**
  * ����: ���ռƻ���ѯCond
  * ��������: ���ռƻ���ѯCond
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public interface RiskprojectvwSearchCond {
    /**�ƻ����*/
    public String getRisknum_l() ;
    /**�ƻ�����*/
    public String getRisktype_q() ;
    /**�ƻ�����*/
    public String getTitle_l();
    /**�ƻ�������*/
    public String getPrusername_l();
    /**�ƻ�״̬*/
    public String getRiskstatus_q();
    /**�ƻ���ʼʱ��С��*/
    public String getRiskstart_le();
    /**�ƻ���ʼʱ�����*/
    public String getRiskstart_ge();
}