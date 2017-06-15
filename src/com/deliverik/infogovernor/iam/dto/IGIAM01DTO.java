/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.iam.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.infogovernor.iam.form.IGIAM0101Form;
import com.deliverik.infogovernor.iam.form.IGIAM0102Form;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;
/**
 * 审计管理DTO
 * 
 * @author 
 */
@SuppressWarnings("serial")
public class IGIAM01DTO extends BaseDTO implements Serializable {
	
	/** 审计管理Form */
	protected IGIAM0101Form igIAM0101Form;
	
	/** 审计管理查询Form */
	protected IGIAM0102Form igIAM0102Form;
	
	/** 分页Bean */
    protected PagingDTO pagingDto;
    
    /** 邮寄信息List */
    protected List<IGIAM0101Form> internalauditprjInfoList;
    
    /** 审计管理信息最大检索件数 */
    protected int maxSearchCount;
    
    /** 内审工作登记页内审项目弹出页List*/
    protected List<InternalauditprjInfo> helpSearchList;
    
    /** 设置附件 */
	protected IGIAM0101Form attachFile;
    
	/** 内审工作附件集合 */
	protected List<Attachment> attkeyList;

	protected String[] pdid;
	
    /** 流程类型id */
    protected String ptid;
    
    /** 流程类型集合 */
    protected List<IG380Info> ig380List;
    
    /**工作定义集合*/
    private Map<IG259Info,List<IG380Info>> templateDefinitionMap;
    
    /**
     * ptid取得
     */
    public String getPtid() {
        return ptid;
    }

    /**
     * ptid设定
     */
    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    /**
     * ig380List取得
     */
    public List<IG380Info> getIg380List() {
        return ig380List;
    }

    /**
     * ig380List设定
     */
    public void setIg380List(List<IG380Info> ig380List) {
        this.ig380List = ig380List;
    }

    /**
     * templateDefinitionMap取得
     */
    public Map<IG259Info, List<IG380Info>> getTemplateDefinitionMap() {
        return templateDefinitionMap;
    }

    /**
     * templateDefinitionMap设定
     */
    public void setTemplateDefinitionMap(
            Map<IG259Info, List<IG380Info>> templateDefinitionMap) {
        this.templateDefinitionMap = templateDefinitionMap;
    }
	/**
     * pdid取得
     *
     * @return pdid pdid
     */
    public String[] getPdid() {
        return pdid;
    }
    /**
     * pdid设定
     *
     * @param pdid pdid
     */
    public void setPdid(String[] pdid) {
        this.pdid = pdid;
    }
    /**
	 * maxSearchCount取得
	 *
	 * @return maxSearchCount maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}
	/**
	 * maxSearchCount设定
	 *
	 * @param maxSearchCount maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	/**
	 * igIAM0101Form取得
	 *
	 * @return igIAM0101Form igIAM0101Form
	 */
	public IGIAM0101Form getIgIAM0101Form() {
		return igIAM0101Form;
	}
	/**
	 * igIAM0101Form设定
	 *
	 * @param igIAM0101Form igIAM0101Form
	 */
	public void setIgIAM0101Form(IGIAM0101Form igIAM0101Form) {
		this.igIAM0101Form = igIAM0101Form;
	}
	/**
	 * igIAM0102Form取得
	 *
	 * @return igIAM0102Form igIAM0102Form
	 */
	public IGIAM0102Form getIgIAM0102Form() {
		return igIAM0102Form;
	}
	/**
	 * igIAM0102Form设定
	 *
	 * @param igIAM0102Form igIAM0102Form
	 */
	public void setIgIAM0102Form(IGIAM0102Form igIAM0102Form) {
		this.igIAM0102Form = igIAM0102Form;
	}
	/**
	 * pagingDto取得
	 *
	 * @return pagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	/**
	 * pagingDto设定
	 *
	 * @param pagingDto pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	/**
	 * 获取helpSearchList
	 * @return fhelpSearchList helpSearchList
	 */
	public List<InternalauditprjInfo> getHelpSearchList() {
		return helpSearchList;
	}
	/**
	 * 设置helpSearchList
	 * @param helpSearchList  helpSearchList
	 */
	public void setHelpSearchList(List<InternalauditprjInfo> helpSearchList) {
		this.helpSearchList = helpSearchList;
	}
	/**
	 * attachFile取得
	 *
	 * @return attachFile attachFile
	 */
	public IGIAM0101Form getAttachFile() {
		return attachFile;
	}
	/**
	 * attachFile设定
	 *
	 * @param attachFile attachFile
	 */
	public void setAttachFile(IGIAM0101Form attachFile) {
		this.attachFile = attachFile;
	}
	/**
	 * attkeyList取得
	 *
	 * @return attkeyList attkeyList
	 */
	public List<Attachment> getAttkeyList() {
		return attkeyList;
	}
	/**
	 * attkeyList设定
	 *
	 * @param attkeyList attkeyList
	 */
	public void setAttkeyList(List<Attachment> attkeyList) {
		this.attkeyList = attkeyList;
	}
	public List<IGIAM0101Form> getInternalauditprjInfoList() {
		return internalauditprjInfoList;
	}
	public void setInternalauditprjInfoList(
			List<IGIAM0101Form> internalauditprjInfoList) {
		this.internalauditprjInfoList = internalauditprjInfoList;
	}
    
}