/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.sya.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sya.form.IGSYA0101Form;
import com.deliverik.infogovernor.sya.form.IGSYA0102Form;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;


@SuppressWarnings("serial")
public class IGSYA01DTO extends BaseDTO implements Serializable {
    
	public IGSYA0101Form igSYA0101Form;
	
	public IGSYA0102Form igSYA0102Form;
	
	
	/** �û���Ϣ */
	protected User user;
	
	/**
	 * ���ø�����
	 */
	protected IGSYA0102Form attachFile;
	
	/**��ѯ�������*/
    protected List<InstitutionInfo> institutionList;
	
	public IGSYA0102Form getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(IGSYA0102Form attachFile) {
		this.attachFile = attachFile;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ��ҳBean
	 */
	
	protected PagingDTO pagingDto;

	/**
	 * �����ѯ������¼��
	 */
	
	protected int maxSearchCount;
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	public IGSYA0101Form getIgSYA0101Form() {
		return igSYA0101Form;
	}

	public void setIgSYA0101Form(IGSYA0101Form igSYA0101Form) {
		this.igSYA0101Form = igSYA0101Form;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public IGSYA0102Form getIgSYA0102Form() {
		return igSYA0102Form;
	}

	public void setIgSYA0102Form(IGSYA0102Form igSYA0102Form) {
		this.igSYA0102Form = igSYA0102Form;
	}

	/**
	 * ��ѯ�������ȡ��
	 * @return institutionList  ��ѯ�������
	 */
	public List<InstitutionInfo> getInstitutionList() {
		return institutionList;
	}

	/**
	 * ��ѯ��������趨
	 * @param institutionList  ��ѯ�������
	 */
	public void setInstitutionList(List<InstitutionInfo> institutionList) {
		this.institutionList = institutionList;
	}

}