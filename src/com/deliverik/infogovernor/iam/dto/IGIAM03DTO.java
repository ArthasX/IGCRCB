/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.iam.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.iam.form.IGIAM0301Form;
import com.deliverik.infogovernor.iam.form.IGIAM0302Form;
import com.deliverik.infogovernor.iam.form.IGIAM0303Form;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;

/**
 * 概述: 审计报告管理
 * 功能描述：审计报告管理
 * 创建人：惠涌智
 * 创建记录： 2012-8-8
 * 修改记录：
 */
public class IGIAM03DTO extends BaseDTO implements Serializable {
	/**
	 * 审计报告管理Form
	 */
	private IGIAM0301Form igiam0301Form ;
	
	/** 
	 * 分页Bean 
	 */
    protected PagingDTO pagingDto;
    
    /** 
     * 审计报告信息最大检索件数
     */
    protected int maxSearchCount;
    
    /**
     * 审计报告信息查询结果List
     */
    protected List<AUDITPROJECTInfo> auditProjectInfoList;
 
    /**
	 * 内审工作附件集合
	 */
	private List<Attachment> attkeyList ;
	
	/**
	 * 设置附件用
	 */
	protected IGIAM0302Form attachFile;

	/**
	 * 审计报告保存form
	 */
	private IGIAM0302Form igiam0302Form ;
	
	/**
	 * 审计报告ID串 
	 */
	private String apids ;
	
	/**
	 * 审计报告修改Form
	 */
	private IGIAM0303Form igiam0303Form ;
	
	public IGIAM0303Form getIgiam0303Form() {
		return igiam0303Form;
	}

	public void setIgiam0303Form(IGIAM0303Form igiam0303Form) {
		this.igiam0303Form = igiam0303Form;
	}

	public String getApids() {
		return apids;
	}

	public void setApids(String apids) {
		this.apids = apids;
	}

	public IGIAM0302Form getIgiam0302Form() {
		return igiam0302Form;
	}

	public void setIgiam0302Form(IGIAM0302Form igiam0302Form) {
		this.igiam0302Form = igiam0302Form;
	}

	public IGIAM0302Form getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(IGIAM0302Form attachFile) {
		this.attachFile = attachFile;
	}

	public List<Attachment> getAttkeyList() {
		return attkeyList;
	}

	public void setAttkeyList(List<Attachment> attkeyList) {
		this.attkeyList = attkeyList;
	}

	public IGIAM0301Form getIgiam0301Form() {
		return igiam0301Form;
	}

	public void setIgiam0301Form(IGIAM0301Form igiam0301Form) {
		this.igiam0301Form = igiam0301Form;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public List<AUDITPROJECTInfo> getAuditProjectInfoList() {
		return auditProjectInfoList;
	}

	public void setAuditProjectInfoList(List<AUDITPROJECTInfo> auditProjectInfoList) {
		this.auditProjectInfoList = auditProjectInfoList;
	}
}
