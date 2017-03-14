/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.iam.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.iam.form.IGIAM0503Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_问题整改管理DTO
 * </p>
 * 
 * @author huiyongzhi
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGIAM05DTO extends BaseDTO implements Serializable {
    
    protected List<IG500Info> processInfos;

    protected List<IG380Info> processDefinitionList;

    protected List<IG259Info> processTemplateList;
    
    /**允许查询的最大记录数*/
    protected int maxSearchCount;

    /**分页Bean*/
    protected PagingDTO pagingDto;

    protected IGIAM0503Form igiam0503Form;

    /**
     * processInfos取得
     *
     * @return processInfos processInfos
     */
    public List<IG500Info> getProcessInfos() {
        return processInfos;
    }

    /**
     * processInfos设定
     *
     * @param processInfos processInfos
     */
    public void setProcessInfos(List<IG500Info> processInfos) {
        this.processInfos = processInfos;
    }

    /**
     * processDefinitionList取得
     *
     * @return processDefinitionList processDefinitionList
     */
    public List<IG380Info> getProcessDefinitionList() {
        return processDefinitionList;
    }

    /**
     * processDefinitionList设定
     *
     * @param processDefinitionList processDefinitionList
     */
    public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
        this.processDefinitionList = processDefinitionList;
    }

    /**
     * processTemplateList取得
     *
     * @return processTemplateList processTemplateList
     */
    public List<IG259Info> getProcessTemplateList() {
        return processTemplateList;
    }

    /**
     * processTemplateList设定
     *
     * @param processTemplateList processTemplateList
     */
    public void setProcessTemplateList(List<IG259Info> processTemplateList) {
        this.processTemplateList = processTemplateList;
    }

    /**
     * 允许查询的最大记录数取得
     *
     * @return maxSearchCount 允许查询的最大记录数
     */
    public int getMaxSearchCount() {
        return maxSearchCount;
    }

    /**
     * 允许查询的最大记录数设定
     *
     * @param maxSearchCount 允许查询的最大记录数
     */
    public void setMaxSearchCount(int maxSearchCount) {
        this.maxSearchCount = maxSearchCount;
    }

    /**
     * 分页Bean取得
     *
     * @return pagingDto 分页Bean
     */
    public PagingDTO getPagingDto() {
        return pagingDto;
    }

    /**
     * 分页Bean设定
     *
     * @param pagingDto 分页Bean
     */
    public void setPagingDto(PagingDTO pagingDto) {
        this.pagingDto = pagingDto;
    }

    /**
     * igiam0503Form取得
     *
     * @return igiam0503Form igiam0503Form
     */
    public IGIAM0503Form getIgiam0503Form() {
        return igiam0503Form;
    }

    /**
     * igiam0503Form设定
     *
     * @param igiam0503Form igiam0503Form
     */
    public void setIgiam0503Form(IGIAM0503Form igiam0503Form) {
        this.igiam0503Form = igiam0503Form;
    }
    
    
    
}
