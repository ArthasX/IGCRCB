/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.smr.form.IGSMR0402Form;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;

/**
 * �걨����ҵ��DTO
 * 
 */
@SuppressWarnings("serial")
public class IGSMR04DTO extends BaseDTO implements Serializable{
	
	/** ʵ��ID */
	private	Integer instanceID;
		
	/** �걨����form*/
	private IGSMR0402Form igsmr0402Form;
	
	/** �걨�б� */
	protected List<BatchExamineVW> lst_Report;
	
	/** �û���Ϣ */
	protected User user;
	
	/**
	 * ʵ��IDȡ��
	 * 
	 * @return ʵ��ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * ʵ��ID�趨
	 * 
	 * @param instanceID ʵ��ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}
		
	
	/**
	 * �걨�б�ȡ��
	 * 
	 * @return �걨�б�
	 */
	public List<BatchExamineVW> getLst_Report() {
		return lst_Report;
	}

	/**
	 * �걨�б��趨
	 * 
	 * @param lst_Report �걨�б�
	 */
	public void setLst_Report(List<BatchExamineVW> lst_Report) {
		this.lst_Report = lst_Report;
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

	public IGSMR0402Form getIgsmr0402Form() {
		return igsmr0402Form;
	}

	public void setIgsmr0402Form(IGSMR0402Form igsmr0402Form) {
		this.igsmr0402Form = igsmr0402Form;
	}
	
}