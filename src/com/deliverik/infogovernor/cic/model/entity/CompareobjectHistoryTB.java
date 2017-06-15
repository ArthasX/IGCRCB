/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.CompareobjectHistoryInfo;

/**
 * ����: �Աȶ�����ʷ��ʵ�� ��������: �Աȶ�����ʷ��ʵ�� ������¼: 2014/04/24 �޸ļ�¼:
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "compareobject_h")
public class CompareobjectHistoryTB extends BaseEntity implements Serializable, Cloneable, CompareobjectHistoryInfo {

    /** ������ʷ������ */
    @Id
    @GeneratedValue(generator = "cohid")
    @GenericGenerator(name = "cohid", strategy = "sequence", parameters = { @Parameter(name = "sequence", value = "compareobject_h_seq") })
    protected Integer cohid;

    /** ��������� */
    protected Integer coid;

    /** �Աȹ������ */
    protected Integer fkCrid;

    /** ���� */
    protected String coname;
    
    /** �Ա�Դ����id */
    protected Integer cosource;

    /** �Ա�Ŀ������id */
    protected Integer cotarget;

    /** Դ����IP */
    protected String sourceIP;

    /** targetIP */
    protected String targetIP;

    /** �ȶԹ����汾 */
    protected Integer crversion;

    /**
     * ������ʷ������ȡ��
     * 
     * @return ������ʷ������
     */
    public Integer getCohid() {
        return cohid;
    }

    /**
     * ������ʷ�������趨
     * 
     * @param cohid
     *            ������ʷ������
     */
    public void setCohid(Integer cohid) {
        this.cohid = cohid;
    }

    /**
     * ���������ȡ��
     * 
     * @return ���������
     */
    public Integer getCoid() {
        return coid;
    }

    /**
     * ����������趨
     * 
     * @param coid
     *            ���������
     */
    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    /** 
     * �Աȹ������ ȡ��
     * @return fkCrid �Աȹ������ 
     */
    public Integer getFkCrid() {
        return fkCrid;
    }

    /** 
     * �Աȹ������ �趨
     * @param fkCrid �Աȹ������ 
     */
    public void setFkCrid(Integer fkCrid) {
        this.fkCrid = fkCrid;
    }

    /**
     * ����ȡ��
     * 
     * @return ����
     */
    public String getConame() {
        return coname;
    }

    /**
     * �����趨
     * 
     * @param coname
     *            ����
     */
    public void setConame(String coname) {
        this.coname = coname;
    }

    /** 
     * �Ա�Դ����id ȡ��
     * @return cosource �Ա�Դ����id 
     */
    public Integer getCosource() {
        return cosource;
    }

    /** 
     * �Ա�Դ����id �趨
     * @param cosource �Ա�Դ����id 
     */
    public void setCosource(Integer cosource) {
        this.cosource = cosource;
    }

    /**
     * �Ա�Ŀ������idȡ��
     * 
     * @return �Ա�Ŀ������id
     */
    public Integer getCotarget() {
        return cotarget;
    }

    /**
     * �Ա�Ŀ������id�趨
     * 
     * @param cotarget
     *            �Ա�Ŀ������id
     */
    public void setCotarget(Integer cotarget) {
        this.cotarget = cotarget;
    }

    /**
     * Դ����IPȡ��
     * 
     * @return Դ����IP
     */
    public String getSourceIP() {
        return sourceIP;
    }

    /**
     * Դ����IP�趨
     * 
     * @param sourceIP
     *            Դ����IP
     */
    public void setSourceIP(String sourceIP) {
        this.sourceIP = sourceIP;
    }

    /**
     * targetIPȡ��
     * 
     * @return targetIP
     */
    public String getTargetIP() {
        return targetIP;
    }

    /**
     * targetIP�趨
     * 
     * @param targetIP
     *            targetIP
     */
    public void setTargetIP(String targetIP) {
        this.targetIP = targetIP;
    }

    /**
     * �ȶԹ����汾ȡ��
     * 
     * @return �ȶԹ����汾
     */
    public Integer getCrversion() {
        return crversion;
    }

    /**
     * �ȶԹ����汾�趨
     * 
     * @param crversion
     *            �ȶԹ����汾
     */
    public void setCrversion(Integer crversion) {
        this.crversion = crversion;
    }
    
    



	/**
     * ����ȡ��
     * 
     * @return ����
     */
    @Override
	public Serializable getPK() {
        return cohid;
    }

}