/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.sta.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.sta.model.Contract;

/**
 * 
 * ��ͬͳ��ʵ��
 * 
 */
@SuppressWarnings("serial")
@Entity
public class ContractVW implements Serializable,Cloneable, Contract{

	/** ID */
	@Id
	protected String eid;
	
	/** ��ͬ���� */
	protected String ename;
	
	/** ��ͬ������ */
	protected String esyscoding;
	
	/** ��ǰ���ͬ���ܼ� */
	protected String currentinvestment;
	
	/** ǰһ���ͬ���ܼ�*/
	protected String lastinvestment;
	
	/** �����ͬ��� */
	protected String diff;

    /**
     * IDȡ��
     *
     * @return eid ID
     */
    public String getEid() {
        return eid;
    }

    /**
     * ��ͬ����ȡ��
     *
     * @return ename ��ͬ����
     */
    public String getEname() {
        return ename;
    }

    /**
     * ��ǰ���ͬ���ܼ�ȡ��
     *
     * @return currentinvestment ��ǰ���ͬ���ܼ�
     */
    public String getCurrentinvestment() {
        return currentinvestment;
    }

    /**
     * ǰһ���ͬ���ܼ�ȡ��
     *
     * @return lastinvestment ǰһ���ͬ���ܼ�
     */
    public String getLastinvestment() {
        return lastinvestment;
    }

    /**
     * �����ͬ���ȡ��
     *
     * @return diff �����ͬ���
     */
    public String getDiff() {
        return diff;
    }

    /**
     * ID�趨
     *
     * @param eid ID
     */
    public void setEid(String eid) {
        this.eid = eid;
    }

    /**
     * ��ͬ�����趨
     *
     * @param ename ��ͬ����
     */
    public void setEname(String ename) {
        this.ename = ename;
    }

    /**
     * ��ǰ���ͬ���ܼ��趨
     *
     * @param currentinvestment ��ǰ���ͬ���ܼ�
     */
    public void setCurrentinvestment(String currentinvestment) {
        this.currentinvestment = currentinvestment;
    }

    /**
     * ǰһ���ͬ���ܼ��趨
     *
     * @param lastinvestment ǰһ���ͬ���ܼ�
     */
    public void setLastinvestment(String lastinvestment) {
        this.lastinvestment = lastinvestment;
    }

    /**
     * �����ͬ����趨
     *
     * @param diff �����ͬ���
     */
    public void setDiff(String diff) {
        this.diff = diff;
    }

    /**
     * ��ͬ������ȡ��
     *
     * @return esyscoding ��ͬ������
     */
    public String getEsyscoding() {
        return esyscoding;
    }

    /**
     * ��ͬ�������趨
     *
     * @param esyscoding ��ͬ������
     */
    public void setEsyscoding(String esyscoding) {
        this.esyscoding = esyscoding;
    }
	

}
