/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.sta.model;


/**
 * 
 * 项目统计
 * 
 */
public interface ProjectStatistic{

    /**
     * ID取得
     *
     * @return prid ID
     */
    public Integer getPrid();
    /**
     * 项目名称取得
     *
     * @return prTitle 项目名称
     */
    public String getPrTitle();

    /**
     * 项目级别取得
     *
     * @return prjLevel 项目级别
     */
    public String getPrjLevel();

    /**
     * 项目类型取得
     *
     * @return prjCategory 项目类型
     */
    public String getPrjCategory();

    /**
     * 项目性质取得
     *
     * @return prjProperty 项目性质
     */
    public String getPrjProperty();

    /**
     * 预计开始时间取得
     *
     * @return planStartTime 预计开始时间
     */
    public String getPlanStartTime();

    /**
     * 预计完成时间取得
     *
     * @return planFinishTime 预计完成时间
     */
    public String getPlanFinishTime();

    /**
     * 项目阶段取得
     *
     * @return prjStage 项目阶段
     */
    public String getPrjStage();

    /**
     * 项目经理取得
     *
     * @return prjManager 项目经理
     */
    public String getPrjManager();

    /**
     * 项目外包商取得
     *
     * @return prjOutsourcers 项目外包商
     */
    public String getPrjOutsourcers();

    /**
     * 是否上报监管机构取得
     *
     * @return prjReport 是否上报监管机构
     */
    public String getPrjReport();

}
