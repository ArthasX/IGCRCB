/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�������Ĺ���DTO
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
    
    /**�����ѯ������¼��*/
    protected int maxSearchCount;

    /**��ҳBean*/
    protected PagingDTO pagingDto;

    protected IGIAM0503Form igiam0503Form;

    /**
     * processInfosȡ��
     *
     * @return processInfos processInfos
     */
    public List<IG500Info> getProcessInfos() {
        return processInfos;
    }

    /**
     * processInfos�趨
     *
     * @param processInfos processInfos
     */
    public void setProcessInfos(List<IG500Info> processInfos) {
        this.processInfos = processInfos;
    }

    /**
     * processDefinitionListȡ��
     *
     * @return processDefinitionList processDefinitionList
     */
    public List<IG380Info> getProcessDefinitionList() {
        return processDefinitionList;
    }

    /**
     * processDefinitionList�趨
     *
     * @param processDefinitionList processDefinitionList
     */
    public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
        this.processDefinitionList = processDefinitionList;
    }

    /**
     * processTemplateListȡ��
     *
     * @return processTemplateList processTemplateList
     */
    public List<IG259Info> getProcessTemplateList() {
        return processTemplateList;
    }

    /**
     * processTemplateList�趨
     *
     * @param processTemplateList processTemplateList
     */
    public void setProcessTemplateList(List<IG259Info> processTemplateList) {
        this.processTemplateList = processTemplateList;
    }

    /**
     * �����ѯ������¼��ȡ��
     *
     * @return maxSearchCount �����ѯ������¼��
     */
    public int getMaxSearchCount() {
        return maxSearchCount;
    }

    /**
     * �����ѯ������¼���趨
     *
     * @param maxSearchCount �����ѯ������¼��
     */
    public void setMaxSearchCount(int maxSearchCount) {
        this.maxSearchCount = maxSearchCount;
    }

    /**
     * ��ҳBeanȡ��
     *
     * @return pagingDto ��ҳBean
     */
    public PagingDTO getPagingDto() {
        return pagingDto;
    }

    /**
     * ��ҳBean�趨
     *
     * @param pagingDto ��ҳBean
     */
    public void setPagingDto(PagingDTO pagingDto) {
        this.pagingDto = pagingDto;
    }

    /**
     * igiam0503Formȡ��
     *
     * @return igiam0503Form igiam0503Form
     */
    public IGIAM0503Form getIgiam0503Form() {
        return igiam0503Form;
    }

    /**
     * igiam0503Form�趨
     *
     * @param igiam0503Form igiam0503Form
     */
    public void setIgiam0503Form(IGIAM0503Form igiam0503Form) {
        this.igiam0503Form = igiam0503Form;
    }
    
    
    
}
