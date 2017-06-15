/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
/**
 * 
 */
package com.deliverik.infogovernor.iam.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.iam.form.IGIAM0201Form;
import com.deliverik.infogovernor.iam.form.IGIAM0202Form;
import com.deliverik.infogovernor.iam.form.IGIAM0203Form;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;

/**
 * @author zhaomin
 *
 */
/**
 * ����: ����������
 * ��������������������
 * �����ˣ�����
 * ������¼�� 2012-7-25
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGIAM02DTO extends BaseDTO implements Serializable{

	/**
	 * ���ù��������ѯform
	 */
	private IGIAM0201Form igiam0201form;
	
	/**
	 * ���ù�����������form
	 */
	private IGIAM0202Form igiam0202form;

	/**
	 * ���ø�����
	 */
	protected IGIAM0202Form attachFile;
	
	/** 
	 * ��ҳBean 
	 */
    protected PagingDTO pagingDto;
    
    /** 
     * ��ƹ�����Ϣ����������
     */
    protected int maxSearchCount;
    
    /**
     * ������������ѯ���list
     */
    protected List<InternalauditJobInfo> internalauditJobList;
    
    /**
     * ��������ϸ��Ϣ��ʾbean
     */
	private IGIAM0203Form igiam0203form;

	/**
	 * ��������������
	 */
	private List<Attachment> attkeyList ;
	
	/**
	 * ������ɾ������ID
	 */
	private Integer attid;
	
	/**
	 * ��ȡattid
	 * @return fattid attid
	 */
	public Integer getAttid() {
		return attid;
	}

	/**
	 * ����attid
	 * @param attid  attid
	 */
	public void setAttid(Integer attid) {
		this.attid = attid;
	}

	/**
	 * ��ȡattkeyList
	 * @return fattkeyList attkeyList
	 */
	public List<Attachment> getAttkeyList() {
		return attkeyList;
	}

	/**
	 * ����attkeyList
	 * @param attkeyList  attkeyList
	 */
	public void setAttkeyList(List<Attachment> attkeyList) {
		this.attkeyList = attkeyList;
	}

	/**
	 * ������ɾ��id
	 */
	private String iajids;

	/**
	 * ��ȡiajids
	 * @return fiajids iajids
	 */
	public String getIajids() {
		return iajids;
	}

	/**
	 * ����iajids
	 * @param iajids  iajids
	 */
	public void setIajids(String iajids) {
		this.iajids = iajids;
	}

	/**
	 * ��ȡigiam0203form
	 * @return figiam0203form igiam0203form
	 */
	public IGIAM0203Form getIgiam0203form() {
		return igiam0203form;
	}

	/**
	 * ����igiam0203form
	 * @param igiam0203form  igiam0203form
	 */
	public void setIgiam0203form(IGIAM0203Form igiam0203form) {
		this.igiam0203form = igiam0203form;
	}

	/**
	 * ��ȡigiam0202form
	 * @return figiam0202form igiam0202form
	 */
	public IGIAM0202Form getIgiam0202form() {
		return igiam0202form;
	}

	/**
	 * ����igiam0202form
	 * @param igiam0202form  igiam0202form
	 */
	public void setIgiam0202form(IGIAM0202Form igiam0202form) {
		this.igiam0202form = igiam0202form;
	}

	/**
	 * ��ȡigiam0201form
	 * @return figiam0201form igiam0201form
	 */
	public IGIAM0201Form getIgiam0201form() {
		return igiam0201form;
	}

	/**
	 * ����igiam0201form
	 * @param igiam0201form  igiam0201form
	 */
	public void setIgiam0201form(IGIAM0201Form igiam0201form) {
		this.igiam0201form = igiam0201form;
	}

	/**
	 * ��ȡattachFile
	 * @return fattachFile attachFile
	 */
	public IGIAM0202Form getAttachFile() {
		return attachFile;
	}

	/**
	 * ����attachFile
	 * @param attachFile  attachFile
	 */
	public void setAttachFile(IGIAM0202Form attachFile) {
		this.attachFile = attachFile;
	}

	/**
	 * ��ȡpagingDto
	 * @return fpagingDto pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ����pagingDto
	 * @param pagingDto  pagingDto
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ��ȡinternalauditJobList
	 * @return finternalauditJobList internalauditJobList
	 */
	public List<InternalauditJobInfo> getInternalauditJobList() {
		return internalauditJobList;
	}

	/**
	 * ����internalauditJobList
	 * @param internalauditJobList  internalauditJobList
	 */
	public void setInternalauditJobList(
			List<InternalauditJobInfo> internalauditJobList) {
		this.internalauditJobList = internalauditJobList;
	}

	/**
	 * ��ȡmaxSearchCount
	 * @return fmaxSearchCount maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ����maxSearchCount
	 * @param maxSearchCount  maxSearchCount
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

}
