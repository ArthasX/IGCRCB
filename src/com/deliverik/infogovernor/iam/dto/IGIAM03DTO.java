/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: ��Ʊ������
 * ������������Ʊ������
 * �����ˣ���ӿ��
 * ������¼�� 2012-8-8
 * �޸ļ�¼��
 */
public class IGIAM03DTO extends BaseDTO implements Serializable {
	/**
	 * ��Ʊ������Form
	 */
	private IGIAM0301Form igiam0301Form ;
	
	/** 
	 * ��ҳBean 
	 */
    protected PagingDTO pagingDto;
    
    /** 
     * ��Ʊ�����Ϣ����������
     */
    protected int maxSearchCount;
    
    /**
     * ��Ʊ�����Ϣ��ѯ���List
     */
    protected List<AUDITPROJECTInfo> auditProjectInfoList;
 
    /**
	 * ��������������
	 */
	private List<Attachment> attkeyList ;
	
	/**
	 * ���ø�����
	 */
	protected IGIAM0302Form attachFile;

	/**
	 * ��Ʊ��汣��form
	 */
	private IGIAM0302Form igiam0302Form ;
	
	/**
	 * ��Ʊ���ID�� 
	 */
	private String apids ;
	
	/**
	 * ��Ʊ����޸�Form
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
