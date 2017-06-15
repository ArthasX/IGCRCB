/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.sta.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.sta.model.ProjectStatistic;

/**
 * 
 * 项目统计实体
 * 
 */
@SuppressWarnings("serial")
@Entity
public class ProjectStatisticVW implements Serializable,Cloneable,ProjectStatistic{

	/** ID */
	@Id
	protected Integer prid;
	
	/** 项目名称 */
	protected String prTitle;
	
	/** 项目级别 */
	protected String prjLevel;
	
	/** 项目类型 */
	protected String prjCategory;
	
	/** 项目性质 */
	protected String prjProperty;
	
	/** 预计开始时间 */
	protected String planStartTime;
	
	/** 预计完成时间  */
	protected String planFinishTime;

	/** 项目阶段  */
	protected String prjStage;

	/** 项目经理  */
	protected String prjManager;

	/** 项目外包商  */
	protected String prjOutsourcers;
	
	/** 是否上报监管机构  */
	protected String prjReport;

    /**
     * ID取得
     *
     * @return prid ID
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * 项目名称取得
     *
     * @return prTitle 项目名称
     */
    public String getPrTitle() {
        return prTitle;
    }

    /**
     * 项目级别取得
     *
     * @return prjLevel 项目级别
     */
    public String getPrjLevel() {
        return prjLevel;
    }

    /**
     * 项目类型取得
     *
     * @return prjCategory 项目类型
     */
    public String getPrjCategory() {
        return prjCategory;
    }

    /**
     * 项目性质取得
     *
     * @return prjProperty 项目性质
     */
    public String getPrjProperty() {
        return prjProperty;
    }

    /**
     * 预计开始时间取得
     *
     * @return planStartTime 预计开始时间
     */
    public String getPlanStartTime() {
        return planStartTime;
    }

    /**
     * 预计完成时间取得
     *
     * @return planFinishTime 预计完成时间
     */
    public String getPlanFinishTime() {
        return planFinishTime;
    }

    /**
     * 项目阶段取得
     *
     * @return prjStage 项目阶段
     */
    public String getPrjStage() {
        return prjStage;
    }

    /**
     * 项目经理取得
     *
     * @return prjManager 项目经理
     */
    public String getPrjManager() {
        return prjManager;
    }

    /**
     * 项目外包商取得
     *
     * @return prjOutsourcers 项目外包商
     */
    public String getPrjOutsourcers() {
        return prjOutsourcers;
    }

    /**
     * 是否上报监管机构取得
     *
     * @return prjReport 是否上报监管机构
     */
    public String getPrjReport() {
        return prjReport;
    }

    /**
     * ID设定
     *
     * @param prid ID
     */
    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    /**
     * 项目名称设定
     *
     * @param prTitle 项目名称
     */
    public void setPrTitle(String prTitle) {
        this.prTitle = prTitle;
    }

    /**
     * 项目级别设定
     *
     * @param prjLevel 项目级别
     */
    public void setPrjLevel(String prjLevel) {
        this.prjLevel = prjLevel;
    }

    /**
     * 项目类型设定
     *
     * @param prjCategory 项目类型
     */
    public void setPrjCategory(String prjCategory) {
        this.prjCategory = prjCategory;
    }

    /**
     * 项目性质设定
     *
     * @param prjProperty 项目性质
     */
    public void setPrjProperty(String prjProperty) {
        this.prjProperty = prjProperty;
    }

    /**
     * 预计开始时间设定
     *
     * @param planStartTime 预计开始时间
     */
    public void setPlanStartTime(String planStartTime) {
        this.planStartTime = planStartTime;
    }

    /**
     * 预计完成时间设定
     *
     * @param planFinishTime 预计完成时间
     */
    public void setPlanFinishTime(String planFinishTime) {
        this.planFinishTime = planFinishTime;
    }

    /**
     * 项目阶段设定
     *
     * @param prjStage 项目阶段
     */
    public void setPrjStage(String prjStage) {
        this.prjStage = prjStage;
    }

    /**
     * 项目经理设定
     *
     * @param prjManager 项目经理
     */
    public void setPrjManager(String prjManager) {
        this.prjManager = prjManager;
    }

    /**
     * 项目外包商设定
     *
     * @param prjOutsourcers 项目外包商
     */
    public void setPrjOutsourcers(String prjOutsourcers) {
        this.prjOutsourcers = prjOutsourcers;
    }

    /**
     * 是否上报监管机构设定
     *
     * @param prjReport 是否上报监管机构
     */
    public void setPrjReport(String prjReport) {
        this.prjReport = prjReport;
    }
}
