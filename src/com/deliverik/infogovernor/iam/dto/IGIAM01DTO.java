/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
 * ��ƹ���DTO
 * 
 * @author 
 */
@SuppressWarnings("serial")
public class IGIAM01DTO extends BaseDTO implements Serializable {
	
	/** ��ƹ���Form */
	protected IGIAM0101Form igIAM0101Form;
	
	/** ��ƹ����ѯForm */
	protected IGIAM0102Form igIAM0102Form;
	
	/** ��ҳBean */
    protected PagingDTO pagingDto;
    
    /** �ʼ���ϢList */
    protected List<IGIAM0101Form> internalauditprjInfoList;
    
    /** ��ƹ�����Ϣ���������� */
    protected int maxSearchCount;
    
    /** �������Ǽ�ҳ������Ŀ����ҳList*/
    protected List<InternalauditprjInfo> helpSearchList;
    
    /** ���ø��� */
	protected IGIAM0101Form attachFile;
    
	/** �������������� */
	protected List<Attachment> attkeyList;

	protected String[] pdid;
	
    /** ��������id */
    protected String ptid;
    
    /** �������ͼ��� */
    protected List<IG380Info> ig380List;
    
    /**�������弯��*/
    private Map<IG259Info,List<IG380Info>> templateDefinitionMap;
    
    /**
     * ptidȡ��
     */
    public String getPtid() {
        return ptid;
    }

    /**
     * ptid�趨
     */
    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    /**
     * ig380Listȡ��
     */
    public List<IG380Info> getIg380List() {
        return ig380List;
    }

    /**
     * ig380List�趨
     */
    public void setIg380List(List<IG380Info> ig380List) {
        this.ig380List = ig380List;
    }

    /**
     * templateDefinitionMapȡ��
     */
    public Map<IG259Info, List<IG380Info>> getTemplateDefinitionMap() {
        return templateDefinitionMap;
    }

    /**
     * templateDefinitionMap�趨
     */
    public void setTemplateDefinitionMap(
            Map<IG259Info, List<IG380Info>> templateDefinitionMap) {
        this.templateDefinitionMap = templateDefinitionMap;
    }
	/**
     * pdidȡ��
     *
     * @return pdid pdid
     */
    public String[] getPdid() {
        return pdid;
    }
    /**
     * pdid�趨
     *
     * @param pdid pdid
     */
    public void setPdid(String[] pdid) {
        this.pdid = pdid;
    }
    /**
	 * maxSearchCountȡ��
	 *
	 * @return maxSearchCount maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}
	/**
	 * maxSearchCount�趨
	 *
	 * @param maxSearchCount maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	/**
	 * igIAM0101Formȡ��
	 *
	 * @return igIAM0101Form igIAM0101Form
	 */
	public IGIAM0101Form getIgIAM0101Form() {
		return igIAM0101Form;
	}
	/**
	 * igIAM0101Form�趨
	 *
	 * @param igIAM0101Form igIAM0101Form
	 */
	public void setIgIAM0101Form(IGIAM0101Form igIAM0101Form) {
		this.igIAM0101Form = igIAM0101Form;
	}
	/**
	 * igIAM0102Formȡ��
	 *
	 * @return igIAM0102Form igIAM0102Form
	 */
	public IGIAM0102Form getIgIAM0102Form() {
		return igIAM0102Form;
	}
	/**
	 * igIAM0102Form�趨
	 *
	 * @param igIAM0102Form igIAM0102Form
	 */
	public void setIgIAM0102Form(IGIAM0102Form igIAM0102Form) {
		this.igIAM0102Form = igIAM0102Form;
	}
	/**
	 * pagingDtoȡ��
	 *
	 * @return pagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}
	/**
	 * pagingDto�趨
	 *
	 * @param pagingDto pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	/**
	 * ��ȡhelpSearchList
	 * @return fhelpSearchList helpSearchList
	 */
	public List<InternalauditprjInfo> getHelpSearchList() {
		return helpSearchList;
	}
	/**
	 * ����helpSearchList
	 * @param helpSearchList  helpSearchList
	 */
	public void setHelpSearchList(List<InternalauditprjInfo> helpSearchList) {
		this.helpSearchList = helpSearchList;
	}
	/**
	 * attachFileȡ��
	 *
	 * @return attachFile attachFile
	 */
	public IGIAM0101Form getAttachFile() {
		return attachFile;
	}
	/**
	 * attachFile�趨
	 *
	 * @param attachFile attachFile
	 */
	public void setAttachFile(IGIAM0101Form attachFile) {
		this.attachFile = attachFile;
	}
	/**
	 * attkeyListȡ��
	 *
	 * @return attkeyList attkeyList
	 */
	public List<Attachment> getAttkeyList() {
		return attkeyList;
	}
	/**
	 * attkeyList�趨
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