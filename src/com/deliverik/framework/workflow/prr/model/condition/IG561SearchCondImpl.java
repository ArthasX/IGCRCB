/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ״̬��˽�б�ֵ��¼���������ʵ��
  * ��������: ״̬��˽�б�ֵ��¼���������ʵ��
  * ������¼: 2015/02/07
  * �޸ļ�¼: 
  */
public class IG561SearchCondImpl implements
		IG561SearchCond {
    /**����id*/
    protected String prid_q;
    /**�ڵ�id*/
    protected String psdid_l;
    /**��id*/
    protected String pidid_l;
    /**piid*/
    protected String piid_q;
    
    public String getPiid_q() {
        return piid_q;
    }
    public void setPiid_q(String piid_q) {
        this.piid_q = piid_q;
    }
    public String getPrid_q() {
        return prid_q;
    }
    public void setPrid_q(String prid_q) {
        this.prid_q = prid_q;
    }
    public String getPsdid_l() {
        return psdid_l;
    }
    public void setPsdid_l(String psdid_l) {
        this.psdid_l = psdid_l;
    }
    public String getPidid_l() {
        return pidid_l;
    }
    public void setPidid_l(String pidid_l) {
        this.pidid_l = pidid_l;
    }
    
}