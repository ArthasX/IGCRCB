/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.condition;

/**
  * ����: ͨѶ¼��������ʵ��
  * ��������: ͨѶ¼��������ʵ��
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public class RiskprojectvwSearchCondImpl implements
		RiskprojectvwSearchCond {
    /**�ƻ����*/
    protected String risknum_l;
    /**�ƻ�����*/
    protected String risktype_q;
    /**�ƻ�����*/
    protected String  title_l;
    /**�ƻ�������*/
    protected String  prusername_l;
    /**�ƻ�״̬*/
    protected String  riskstatus_q;
    /**�ƻ���ʼʱ��С��*/
    protected String  riskstart_le;
    /**�ƻ���ʼʱ�����*/
    protected String  riskstart_ge;
   
    public void setRisknum_l(String risknum_l) {
        this.risknum_l = risknum_l;
    }
    public void setRisktype_q(String risktype_q) {
        this.risktype_q = risktype_q;
    }
    public void setTitle_l(String title_l) {
        this.title_l = title_l;
    }
    public void setPrusername_l(String prusername_l) {
        this.prusername_l = prusername_l;
    }
    public void setRiskstatus_q(String riskstatus_q) {
        this.riskstatus_q = riskstatus_q;
    }
    public void setRiskstart_le(String riskstart_le) {
        this.riskstart_le = riskstart_le;
    }
    public void setRiskstart_ge(String riskstart_ge) {
        this.riskstart_ge = riskstart_ge;
    }
    public String getRisknum_l() {
        return risknum_l;
    }
    public String getRisktype_q() {
        return risktype_q;
    }
    public String getTitle_l() {
        return title_l;
    }
    public String getPrusername_l() {
        return prusername_l;
    }
    public String getRiskstatus_q() {
        return riskstatus_q;
    }
    public String getRiskstart_le() {
        return riskstart_le;
    }
    public String getRiskstart_ge() {
        return riskstart_ge;
    }
    
    
    
}