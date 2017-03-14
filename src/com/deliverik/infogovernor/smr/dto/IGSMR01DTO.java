/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.form.IGSMR0101Form;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;

/**
 * �걨�ҵ��DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSMR01DTO extends BaseDTO implements Serializable{
	
	/** �û���Ϣ */
	protected User user;
	
	/** �걨����Form */
	protected IGSMR0101Form igSMR0101Form;
	
	/** ���������Ϣ */
	protected ApproveSuggestionInfo approveSuggestionInfo;
	
	/** ���������Ϣ���� */
	protected List<ApproveSuggestionInfo> lstApproveSuggestionInfo;
	
	/**
	 * ���������Ϣ����ȡ��
	 *
	 * @return lstApproveSuggestionInfo ���������Ϣ����
	 */
	public List<ApproveSuggestionInfo> getLstApproveSuggestionInfo() {
		return lstApproveSuggestionInfo;
	}

	/**
	 * ���������Ϣ�����趨
	 *
	 * @param lstApproveSuggestionInfo ���������Ϣ����
	 */
	public void setLstApproveSuggestionInfo(
			List<ApproveSuggestionInfo> lstApproveSuggestionInfo) {
		this.lstApproveSuggestionInfo = lstApproveSuggestionInfo;
	}

	/**
	 * ���������Ϣȡ��
	 *
	 * @return approveSuggestionInfo ���������Ϣ
	 */
	public ApproveSuggestionInfo getApproveSuggestionInfo() {
		return approveSuggestionInfo;
	}

	/**
	 * ���������Ϣ�趨
	 *
	 * @param approveSuggestionInfo ���������Ϣ
	 */
	public void setApproveSuggestionInfo(ApproveSuggestionInfo approveSuggestionInfo) {
		this.approveSuggestionInfo = approveSuggestionInfo;
	}

	/**
	 * �û���Ϣȡ��
	 * 
	 * @return �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û���Ϣ�趨
	 * 
	 * @param user �û���Ϣ
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * �걨����Formȡ��
	 * 
	 * @return �걨����Form
	 */
	public IGSMR0101Form getIgSMR0101Form() {
		return igSMR0101Form;
	}

	/**
	 * �걨����Form�趨
	 * 
	 * @param igSMR0101Form �걨����Form
	 */
	public void setIgSMR0101Form(IGSMR0101Form igSMR0101Form) {
		this.igSMR0101Form = igSMR0101Form;
	}
	
}