/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.sta.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.sta.model.ProjectStatistic;

/**
 * 
 * ��Ŀͳ��ʵ��
 * 
 */
@SuppressWarnings("serial")
@Entity
public class ProjectStatisticVW implements Serializable,Cloneable,ProjectStatistic{

	/** ID */
	@Id
	protected Integer prid;
	
	/** ��Ŀ���� */
	protected String prTitle;
	
	/** ��Ŀ���� */
	protected String prjLevel;
	
	/** ��Ŀ���� */
	protected String prjCategory;
	
	/** ��Ŀ���� */
	protected String prjProperty;
	
	/** Ԥ�ƿ�ʼʱ�� */
	protected String planStartTime;
	
	/** Ԥ�����ʱ��  */
	protected String planFinishTime;

	/** ��Ŀ�׶�  */
	protected String prjStage;

	/** ��Ŀ����  */
	protected String prjManager;

	/** ��Ŀ�����  */
	protected String prjOutsourcers;
	
	/** �Ƿ��ϱ���ܻ���  */
	protected String prjReport;

    /**
     * IDȡ��
     *
     * @return prid ID
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * ��Ŀ����ȡ��
     *
     * @return prTitle ��Ŀ����
     */
    public String getPrTitle() {
        return prTitle;
    }

    /**
     * ��Ŀ����ȡ��
     *
     * @return prjLevel ��Ŀ����
     */
    public String getPrjLevel() {
        return prjLevel;
    }

    /**
     * ��Ŀ����ȡ��
     *
     * @return prjCategory ��Ŀ����
     */
    public String getPrjCategory() {
        return prjCategory;
    }

    /**
     * ��Ŀ����ȡ��
     *
     * @return prjProperty ��Ŀ����
     */
    public String getPrjProperty() {
        return prjProperty;
    }

    /**
     * Ԥ�ƿ�ʼʱ��ȡ��
     *
     * @return planStartTime Ԥ�ƿ�ʼʱ��
     */
    public String getPlanStartTime() {
        return planStartTime;
    }

    /**
     * Ԥ�����ʱ��ȡ��
     *
     * @return planFinishTime Ԥ�����ʱ��
     */
    public String getPlanFinishTime() {
        return planFinishTime;
    }

    /**
     * ��Ŀ�׶�ȡ��
     *
     * @return prjStage ��Ŀ�׶�
     */
    public String getPrjStage() {
        return prjStage;
    }

    /**
     * ��Ŀ����ȡ��
     *
     * @return prjManager ��Ŀ����
     */
    public String getPrjManager() {
        return prjManager;
    }

    /**
     * ��Ŀ�����ȡ��
     *
     * @return prjOutsourcers ��Ŀ�����
     */
    public String getPrjOutsourcers() {
        return prjOutsourcers;
    }

    /**
     * �Ƿ��ϱ���ܻ���ȡ��
     *
     * @return prjReport �Ƿ��ϱ���ܻ���
     */
    public String getPrjReport() {
        return prjReport;
    }

    /**
     * ID�趨
     *
     * @param prid ID
     */
    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    /**
     * ��Ŀ�����趨
     *
     * @param prTitle ��Ŀ����
     */
    public void setPrTitle(String prTitle) {
        this.prTitle = prTitle;
    }

    /**
     * ��Ŀ�����趨
     *
     * @param prjLevel ��Ŀ����
     */
    public void setPrjLevel(String prjLevel) {
        this.prjLevel = prjLevel;
    }

    /**
     * ��Ŀ�����趨
     *
     * @param prjCategory ��Ŀ����
     */
    public void setPrjCategory(String prjCategory) {
        this.prjCategory = prjCategory;
    }

    /**
     * ��Ŀ�����趨
     *
     * @param prjProperty ��Ŀ����
     */
    public void setPrjProperty(String prjProperty) {
        this.prjProperty = prjProperty;
    }

    /**
     * Ԥ�ƿ�ʼʱ���趨
     *
     * @param planStartTime Ԥ�ƿ�ʼʱ��
     */
    public void setPlanStartTime(String planStartTime) {
        this.planStartTime = planStartTime;
    }

    /**
     * Ԥ�����ʱ���趨
     *
     * @param planFinishTime Ԥ�����ʱ��
     */
    public void setPlanFinishTime(String planFinishTime) {
        this.planFinishTime = planFinishTime;
    }

    /**
     * ��Ŀ�׶��趨
     *
     * @param prjStage ��Ŀ�׶�
     */
    public void setPrjStage(String prjStage) {
        this.prjStage = prjStage;
    }

    /**
     * ��Ŀ�����趨
     *
     * @param prjManager ��Ŀ����
     */
    public void setPrjManager(String prjManager) {
        this.prjManager = prjManager;
    }

    /**
     * ��Ŀ������趨
     *
     * @param prjOutsourcers ��Ŀ�����
     */
    public void setPrjOutsourcers(String prjOutsourcers) {
        this.prjOutsourcers = prjOutsourcers;
    }

    /**
     * �Ƿ��ϱ���ܻ����趨
     *
     * @param prjReport �Ƿ��ϱ���ܻ���
     */
    public void setPrjReport(String prjReport) {
        this.prjReport = prjReport;
    }
}
