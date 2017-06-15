/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.DrillplanVWInfo;

/**
  * ����: �����ƻ���Ŀʵ��
  * ��������: �����ƻ���Ŀʵ��
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
public class DrillplanVW extends BaseEntity implements Serializable,
		Cloneable, DrillplanVWInfo {

	/** �����ƻ���Ŀid */
	@Id
	protected Integer diid;

	/** �����ƻ�id */
	protected Integer did;

	/** ��������prid */
	protected Integer prid;

    /** ����״̬ ������/δ���� */
    protected String status;

    /** ����Ԥ�ڿ�ʼʱ�� */
    protected String expecttime;

    /** ����ʵ�ʿ�ʼʱ�� */
    protected String actstarttime;

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
	
	/** �����ƻ��ƶ���id */
    protected String duserid;

    /** �����ƻ�ָ������ */
    protected String dusername;

    /** ����ʱ�� */
    protected String crttime;

    /** ����ʱ�� */
    protected String judgetime;

    /** �����ƻ���� */
    protected String dserial;

    /** �����ƻ����� */
    protected String dname;

    /** ����״̬ a Ϊ����b�����У�c������� */
    protected String judgestatus;

    public Integer getDiid() {
        return diid;
    }

    public void setDiid(Integer diid) {
        this.diid = diid;
    }

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

    public String getExpecttime() {
        return expecttime;
    }

    public void setExpecttime(String expecttime) {
        this.expecttime = expecttime;
    }

    public String getActstarttime() {
        return actstarttime;
    }

    public void setActstarttime(String actstarttime) {
        this.actstarttime = actstarttime;
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

    public String getDuserid() {
        return duserid;
    }

    public void setDuserid(String duserid) {
        this.duserid = duserid;
    }

    public String getDusername() {
        return dusername;
    }

    public void setDusername(String dusername) {
        this.dusername = dusername;
    }

    public String getCrttime() {
        return crttime;
    }

    public void setCrttime(String crttime) {
        this.crttime = crttime;
    }

    public String getJudgetime() {
        return judgetime;
    }

    public void setJudgetime(String judgetime) {
        this.judgetime = judgetime;
    }

    public String getDserial() {
        return dserial;
    }

    public void setDserial(String dserial) {
        this.dserial = dserial;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getJudgestatus() {
        return judgestatus;
    }

    public void setJudgestatus(String judgestatus) {
        this.judgestatus = judgestatus;
    }

    /* 
     * <p>Title: getPK</p> 
     * <p>Description: </p> 
     * @return 
     * @see com.deliverik.framework.base.BaseEntity#getPK() 
     */
    @Override
    public Serializable getPK() {
        // TODO Auto-generated method stub
        return diid;
    }

   
}