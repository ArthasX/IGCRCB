/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: �����ƻ���Ŀ��������ʵ��
  * ��������: �����ƻ���Ŀ��������ʵ��
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
public class DrillplanitemSearchCondImpl implements
		DrillplanitemSearchCond {
    
    /** �����ƻ�id */
    protected Integer did;

    /** ��������prid */
    protected Integer prid;

    /** ����״̬ ������/δ���� */
    protected String status;

    /** ����Ԥ�ڿ�ʼʱ�� */
    protected String expecttimestart;
    
    /** ����Ԥ�ڿ�ʼʱ�� */
    protected String expecttimeend;

    /** �������� */
    protected String diname;

    /** �������� */
    protected String dicontant;

    /** ����Ŀ�� */
    protected String didestination;

    /** �������� */
    protected String discene;

    /** Ӱ�췶Χ */
    protected String discope;

    /** ���������� */
    protected String didutyorg;

    /** ���벿�� */
    protected String partorg;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getPrid() {
        return prid;
    }

    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExpecttimestart() {
        return expecttimestart;
    }

    public void setExpecttimestart(String expecttimestart) {
        this.expecttimestart = expecttimestart;
    }

    public String getExpecttimeend() {
        return expecttimeend;
    }

    public void setExpecttimeend(String expecttimeend) {
        this.expecttimeend = expecttimeend;
    }

    public String getDiname() {
        return diname;
    }

    public void setDiname(String diname) {
        this.diname = diname;
    }

    public String getDicontant() {
        return dicontant;
    }

    public void setDicontant(String dicontant) {
        this.dicontant = dicontant;
    }

    public String getDidestination() {
        return didestination;
    }

    public void setDidestination(String didestination) {
        this.didestination = didestination;
    }

    public String getDiscene() {
        return discene;
    }

    public void setDiscene(String discene) {
        this.discene = discene;
    }

    public String getDiscope() {
        return discope;
    }

    public void setDiscope(String discope) {
        this.discope = discope;
    }

    public String getDidutyorg() {
        return didutyorg;
    }

    public void setDidutyorg(String didutyorg) {
        this.didutyorg = didutyorg;
    }

    public String getPartorg() {
        return partorg;
    }

    public void setPartorg(String partorg) {
        this.partorg = partorg;
    }
    
    
}