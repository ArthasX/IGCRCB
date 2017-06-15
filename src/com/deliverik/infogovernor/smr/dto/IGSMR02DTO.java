/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.smr.form.IGSMR0201Form;
import com.deliverik.infogovernor.smr.form.IGSMR0202Form;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;

/**
 * �������ҵ��DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSMR02DTO extends BaseDTO implements Serializable{
	
	/** �û���Ϣ */
	protected User user;
	
	/** �������Form */
	protected IGSMR0201Form igSMR0201Form;
	
	/** ���������ѯForm */
	protected IGSMR0202Form igSMR0202Form;
	
	/** ���������Ϣ */
	protected ApproveSuggestionInfo approveSuggestionInfo;
	
	/** ���������Ϣ���� */
	protected List<ApproveSuggestionInfo> lstApproveSuggestionInfo;
	
	/** ��������Ϣ */
	protected IG500Info ig500Info;

	/** ������ */
	protected String pidname;
	
	
	/**
	 * �������Formȡ��
	 *
	 * @return igSMR0201Form �������Form
	 */
	public IGSMR0201Form getIgSMR0201Form() {
		return igSMR0201Form;
	}

	/**
	 * �������Form�趨
	 *
	 * @param igSMR0201Form �������Form
	 */
	public void setIgSMR0201Form(IGSMR0201Form igSMR0201Form) {
		this.igSMR0201Form = igSMR0201Form;
	}

	/**
	 * ���������ѯFormȡ��
	 *
	 * @return igSMR0202Form ���������ѯForm
	 */
	public IGSMR0202Form getIgSMR0202Form() {
		return igSMR0202Form;
	}

	/**
	 * ���������ѯForm�趨
	 *
	 * @param igSMR0202Form ���������ѯForm
	 */
	public void setIgSMR0202Form(IGSMR0202Form igSMR0202Form) {
		this.igSMR0202Form = igSMR0202Form;
	}

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
	 * ��������Ϣȡ��
	 *
	 * @return ig500Info ��������Ϣ
	 */
	public IG500Info getIg500Info() {
		return ig500Info;
	}

	/**
	 * ��������Ϣ�趨
	 *
	 * @param ig500Info ��������Ϣ
	 */
	public void setIg500Info(IG500Info ig500Info) {
		this.ig500Info = ig500Info;
	}

	/**
	 * ������ȡ��
	 * 
	 * @return ������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * �������趨
	 * 
	 * @param pidname ������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

}