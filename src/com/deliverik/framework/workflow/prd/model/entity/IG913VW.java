/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.workflow.prd.model.IG913Info;

/**
 * ����ȱʡ����Ȩ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class IG913VW implements Serializable, Cloneable, IG913Info {
	
	/** �����Զ���ID */
	@Id
	protected String pdid;
	
	/** �����Զ������� */
	protected String pdname;
	
	/** ig911������� */
	protected String psprpid;
	
	/** ig931������� */
    protected String dpsprpid;

    /**
     * @return the �����Զ���ID
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * @param �����Զ���ID the pdid to set
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

    /**
     * @return the �����Զ�������
     */
    public String getPdname() {
        return pdname;
    }

    /**
     * @param �����Զ������� the pdname to set
     */
    public void setPdname(String pdname) {
        this.pdname = pdname;
    }

    /**
     * @return the ig911�������
     */
    public String getPsprpid() {
        return psprpid;
    }

    /**
     * @param ig911������� the psprpid to set
     */
    public void setPsprpid(String psprpid) {
        this.psprpid = psprpid;
    }

    /**
     * @return the ig931�������
     */
    public String getDpsprpid() {
        return dpsprpid;
    }

    /**
     * @param ig931������� the dpsprpid to set
     */
    public void setDpsprpid(String dpsprpid) {
        this.dpsprpid = dpsprpid;
    }

	
	
}
